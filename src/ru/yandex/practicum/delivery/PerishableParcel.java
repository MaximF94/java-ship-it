package ru.yandex.practicum.delivery;

//Скоропортящееся посылка
public class PerishableParcel extends Parcel {

    private int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int parcelNum, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay, parcelNum);
        this.timeToLive = timeToLive;
    }

    @Override
    public int calculateDeliveryCost() {
        return getWeight() * Parcel.PERISHABLE_PRICE;
    }

    public boolean isExpired(int currentDay) {
        int parcelLife = timeToLive + getSendDay();

        if (parcelLife >= currentDay) {
            return false;
        }
        return true;
    }
}
