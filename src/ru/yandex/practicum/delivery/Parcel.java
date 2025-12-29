package ru.yandex.practicum.delivery;

public abstract class Parcel {

    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;
    protected int parcelNum;

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

    //получить базовую стоимость
    public abstract int getBaseCost();

    //вычислить стоимость доставки
    public int calculateDeliveryCost() {
        return weight * getBaseCost();
    }

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

    @Override
    public String toString() {
        return "Parcel{" +
                "description='" + description + '\'' +
                ", weight=" + weight +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", sendDay=" + sendDay +
                ", parcelNum=" + parcelNum +
                '}';
    }
}
