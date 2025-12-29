package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.*;

public class DeliveryCostTest {

    @Test
    public void shouldBePositiveWhenStandardParcelWeightIs5Kg() {
        StandardParcel standardParcel = new StandardParcel("Тест", 5, "адрес",
                                                            10, 123343);

        Assertions.assertEquals(10,standardParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldBePositiveWhenFragileParcelWeightIs5Kg() {
        FragileParcel fragileParcel = new FragileParcel("Тест",5,"адрес",10,
                123343);

        Assertions.assertEquals(20,fragileParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldBePositiveWhenPerishableParcelWeightIs5Kg() {
        PerishableParcel perishableParcel = new PerishableParcel("Тест",5,"адрес",
                10,123343,12);

        Assertions.assertEquals(15,perishableParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldBePositiveWhenStandardParcelWeightIs0Kg() {
        StandardParcel standardParcel = new StandardParcel("Тест",0,"адрес",10,
                123343);

        Assertions.assertEquals(2,standardParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldBePositiveWhenFragileParcelWeightIs0Kg() {
        FragileParcel fragileParcel = new FragileParcel("Тест",0,"адрес",10,
                123343);

        Assertions.assertEquals(4,fragileParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldBePositiveWhenPerishableParcelWeightIs0Kg() {
        PerishableParcel perishableParcel = new PerishableParcel("Тест",0,"адрес",10,
                123343,12);

        Assertions.assertEquals(3,perishableParcel.calculateDeliveryCost());
    }

}
