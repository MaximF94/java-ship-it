package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    private int weightBox;
    private ArrayList<T> box;


    public ParcelBox(int weightBox) {
        this.weightBox = weightBox;
        box = new ArrayList<>();
    }

    public int getWeightBox() {
        return weightBox;
    }

    public void addParcel(T parcel) {
        int currentWeight = 0;
        int availableWeight = 0;
        for (T parcelWeight : box) {
            currentWeight += parcelWeight.getWeight();
        }
        availableWeight = weightBox - currentWeight;

        if(parcel.getWeight() > availableWeight) {
            System.out.println("Посылка с весом " + parcel.getWeight() +
                    " не может быть добавлена в коробку! Доступный вес: " + availableWeight);
            return;
        }

        box.add(parcel);
    }

    public void getAllParcels() {

        if(box.isEmpty()){
            System.out.println("Коробка пуста!");
            return;
        }

        for (T parcel : box) {
            System.out.println(parcel.getDescription());
        }
    }

    public int getCountParcelsInBox() {
        return box.size();
    }
}
