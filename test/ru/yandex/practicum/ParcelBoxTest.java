package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.PerishableParcel;

public class ParcelBoxTest {

    static ParcelBox<PerishableParcel> perishableParcelBox;// = new ParcelBox<>(10);

    @BeforeEach
    public void createParcelBox() {
        perishableParcelBox = new ParcelBox<>(10);
    }

    @Test
    public void shouldBeAddInBoxWhenParcelIsLittlerThanBox() {
        PerishableParcel perishableParcel = new PerishableParcel("Тест",0,"адрес",10,
                123343,12);

        perishableParcelBox.addParcel(perishableParcel);

        Assertions.assertEquals(1,perishableParcelBox.getCountParcelsInBox());
    }

    @Test
    public void shouldNotBeAddInBoxWhenParcelIsHavierThanBox() {
        PerishableParcel perishableParcel = new PerishableParcel("Тест",11,"адрес",10,
                123343,12);

        perishableParcelBox.addParcel(perishableParcel);

        Assertions.assertEquals(0,perishableParcelBox.getCountParcelsInBox());
    }

    @Test
    public void shouldBeAddInBoxWhenParcelIsEquallyBox() {
        PerishableParcel perishableParcel = new PerishableParcel("Тест",10,"адрес",10,
                123343,12);

        perishableParcelBox.addParcel(perishableParcel);

        Assertions.assertEquals(1,perishableParcelBox.getCountParcelsInBox());
    }
}
