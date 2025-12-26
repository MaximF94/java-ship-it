package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel{

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay, int parcelNum) {
        super(description, weight, deliveryAddress, sendDay, parcelNum);
    }

    @Override
    public int calculateDeliveryCost() {
         return getWeight() * Parcel.STANDARD_PRICE;
    }
}
