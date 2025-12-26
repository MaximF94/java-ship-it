package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static HashMap<Integer,Trackable> trackableParcels = new HashMap<>();
    private static ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(20);
    private static ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(20);
    private static ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(20);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    addReportStatus();
                    break;
                case 5:
                    showParcelsInBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Изменить статус доставки");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    private static void showParcelTypes() {
        System.out.println("Выберите типы посылки:");
        System.out.println("1 — Стандартная посылка");
        System.out.println("2 — Скоропортящееся посылка");
        System.out.println("3 — Хрупкая посылка");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        int timeToLive = 0;
        showParcelTypes();
        int parcelType = Integer.parseInt(scanner.nextLine());
        if(parcelType <= 0 || parcelType > 3) {
            System.out.println("Выбран неверный тип посылки");
            return;
        }
        System.out.println("Введите дату отправки:");
        int sendDay = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите вес посылки:");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите адрес отправки:");
        String deliveryAddress = scanner.nextLine();
        System.out.println("Введите описание посылки:");
        String description = scanner.nextLine();
        System.out.println("Введите номер посылки:");
        int parcelNum = Integer.parseInt(scanner.nextLine());
        if(parcelType == 2) {
            System.out.println("Введите срок годности:");
            timeToLive = Integer.parseInt(scanner.nextLine());
        }
        switch(parcelType) {
            case 1:
                StandardParcel standardParcel = new StandardParcel(description,weight,deliveryAddress,
                        sendDay,parcelNum);
                allParcels.add(standardParcel);
                standardParcelBox.addParcel(standardParcel);
                break;
            case 2:
                PerishableParcel perishableParcel = new PerishableParcel(description,weight,deliveryAddress,sendDay,
                        timeToLive,parcelNum);
                allParcels.add(perishableParcel);
                perishableParcelBox.addParcel(perishableParcel);
                break;
            case 3:
                FragileParcel fragileParcel = new FragileParcel(description,weight,deliveryAddress,sendDay,parcelNum);
                allParcels.add(fragileParcel);
                trackableParcels.put(parcelNum, fragileParcel);
                fragileParcelBox.addParcel(fragileParcel);
                break;
            default:
                System.out.println("Неверный выбор.");
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        if(allParcels.isEmpty()) {
            System.out.println("Список посылок пуст");
            return;
        }
        for(Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
            if(allParcels.size() > 1) {
                System.out.println("-".repeat(50));
            }
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int deliveryCost = 0;
        for(Parcel parcel : allParcels) {
            deliveryCost += parcel.calculateDeliveryCost();
        }
        System.out.println("Стоимость всех доставок составляет: " + deliveryCost);
    }

    private static void addReportStatus() {

        if(trackableParcels.isEmpty()) {
            System.out.println("Список посылок со статусами пуст");
            return;
        }

        Trackable parcel;
        System.out.println("Введите номер номер посылки для изменения статуса");
        int parcelNum = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите новый статус для посылки");
        String status = scanner.nextLine();
        parcel = trackableParcels.get(parcelNum);
        parcel.reportStatus(status);
    }


    private static void showParcelsInBox() {
        showParcelTypes();
        int parcelType = Integer.parseInt(scanner.nextLine());
        if(parcelType <= 0 || parcelType > 3) {
            System.out.println("Выбран неверный тип посылки");
            return;
        }

        switch(parcelType) {
            case 1:
                standardParcelBox.getAllParcels();
                break;
            case 2:
                perishableParcelBox.getAllParcels();
                break;
            case 3:
                fragileParcelBox.getAllParcels();
                break;
            default:
                System.out.println("Неверный выбор.");
        }

    }

}

