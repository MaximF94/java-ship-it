package ru.yandex.practicum.delivery;

//Хрупкая посылка
public class FragileParcel extends Parcel implements Trackable{

    private String location;

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay, int parcelNum) {
        super(description, weight, deliveryAddress, sendDay, parcelNum);
    }

    @Override
    public int calculateDeliveryCost() {
        return getWeight() * Parcel.FRAGILE_PRICE;
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + getParcelNum() + " обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    public void reportStatus(String newLocation) {
        this.location = newLocation;
        System.out.println("Хрупкая посылка <<" + getDescription() + ">> изменила местоположение на " + newLocation);
    }

    public String getLocation() {
        return location;
    }
}
