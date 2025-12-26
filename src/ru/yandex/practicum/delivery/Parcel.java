package ru.yandex.practicum.delivery;

public abstract class Parcel {
    //Пока не понял правильно ли создавать такие константы. По задаче написано "Создать константы для каждого типа"
    static final int STANDARD_PRICE = 2;
    static final int PERISHABLE_PRICE = 3;
    static final int FRAGILE_PRICE = 4;

    private String description;
    private int weight;
    private String deliveryAddress;
    private int sendDay;
    private int parcelNum;

    public Parcel(String description, int weight, String deliveryAddress, int sendDay, int parcelNum) {
        this.description = description;
        if (weight <= 0) {
            this.weight = 1;
        } else {
            this.weight = weight;
        }
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
        this.parcelNum = parcelNum;
    }

    //доставить
    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress);
    }

    //вычислить стоимость доставки
    public abstract int calculateDeliveryCost();

    //упаковать посылку
    public void packageItem() {
        System.out.println("Посылка " + parcelNum + " упакована");
    }

    public int getWeight() {
        return weight;
    }

    public int getSendDay() {
        return sendDay;
    }

    public int getParcelNum() {
        return parcelNum;
    }

    public String getDescription() {
        return description;
    }
}
