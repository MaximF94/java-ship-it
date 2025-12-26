package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.*;

public class DeliveryCostTest {
    @Test
    public void shouldBePositiveWhenParcelWeightIs5Kg() {
        StandardParcel standardParcel = new StandardParcel("Тест",5,"адрес",10,
                123343);
        FragileParcel fragileParcel = new FragileParcel("Тест",5,"адрес",10,
                123343);

        PerishableParcel perishableParcel = new PerishableParcel("Тест",5,"адрес",10,
                123343,12);

        Assertions.assertEquals(10,standardParcel.calculateDeliveryCost());
        Assertions.assertEquals(20,fragileParcel.calculateDeliveryCost());
        Assertions.assertEquals(15,perishableParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldBePositiveWhenParcelWeightIs0Kg() {
        StandardParcel standardParcel = new StandardParcel("Тест",0,"адрес",10,
                123343);
        FragileParcel fragileParcel = new FragileParcel("Тест",0,"адрес",10,
                123343);

        PerishableParcel perishableParcel = new PerishableParcel("Тест",0,"адрес",10,
                123343,12);

        Assertions.assertEquals(2,standardParcel.calculateDeliveryCost());
        Assertions.assertEquals(4,fragileParcel.calculateDeliveryCost());
        Assertions.assertEquals(3,perishableParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldBePositiveWhenPerishableParcelIsExpired() {
        PerishableParcel perishableParcel = new PerishableParcel("Тест",0,"адрес",10,
                123343,12);

        Assertions.assertTrue(perishableParcel.isExpired(25));
    }

    @Test
    public void shouldBeNegativeWhenPerishableParcelIsExpired() {
        PerishableParcel perishableParcel = new PerishableParcel("Тест",0,"адрес",10,
                123343,12);

        Assertions.assertFalse(perishableParcel.isExpired(10));
    }

    @Test
    public void shouldBeAddInBoxWhenParcelIsLittlerThanBox() {
        PerishableParcel perishableParcel = new PerishableParcel("Тест",0,"адрес",10,
                123343,12);
        ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(10);
        perishableParcelBox.addParcel(perishableParcel);

        Assertions.assertEquals(1,perishableParcelBox.getCountParcelsInBox());
    }

    @Test
    public void shouldNotBeAddInBoxWhenParcelIsLittlerThanBox() {
        PerishableParcel perishableParcel = new PerishableParcel("Тест",11,"адрес",10,
                123343,12);
        ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(10);
        perishableParcelBox.addParcel(perishableParcel);

        Assertions.assertEquals(0,perishableParcelBox.getCountParcelsInBox());
    }
}
