package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {

    protected final int STANDARD_PRICE = 2;

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay, int parcelNum) {
        super(description, weight, deliveryAddress, sendDay, parcelNum);
    }

    @Override
    public int getBaseCost() {
        return STANDARD_PRICE;
    }

    @Override
    public String toString() {
        return "StandardParcel{" +
                "description='" + description + '\'' +
                ", weight=" + weight +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", sendDay=" + sendDay +
                ", parcelNum=" + parcelNum +
                '}';
    }
}
