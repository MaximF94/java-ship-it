package ru.yandex.practicum.delivery;

//Скоропортящееся посылка
public class PerishableParcel extends Parcel {

    protected final int PERISHABLE_PRICE = 3;

    protected int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int parcelNum, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay, parcelNum);
        this.timeToLive = timeToLive;
    }

    @Override
    public int getBaseCost() {
        return PERISHABLE_PRICE;
    }

    public boolean isExpired(int currentDay) {
        int parcelLife = timeToLive + sendDay;

        return parcelLife < currentDay;
    }

    @Override
    public String toString() {
        return "PerishableParcel{" +
                "timeToLive=" + timeToLive +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", sendDay=" + sendDay +
                ", parcelNum=" + parcelNum +
                '}';
    }
}
