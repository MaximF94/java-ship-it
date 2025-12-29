package ru.yandex.practicum.delivery;

//Хрупкая посылка
public class FragileParcel extends Parcel implements Trackable{

    protected static final int FRAGILE_PRICE = 4;

    protected String location;

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay, int parcelNum) {
        super(description, weight, deliveryAddress, sendDay, parcelNum);
    }

    @Override
    public int getBaseCost() {
        return FRAGILE_PRICE;
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

    @Override
    public String toString() {
        return "FragileParcel{" +
                "location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", sendDay=" + sendDay +
                ", parcelNum=" + parcelNum +
                '}';
    }
}
