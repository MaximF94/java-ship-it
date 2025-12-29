package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

public class PerishableParcelExpiredTest {

    static PerishableParcel perishableParcel;

    @BeforeAll
    public static void createPerishableParcel() {
        perishableParcel = new PerishableParcel("Тест",0,"адрес",10,
                123343,12);
    }

    @Test
    public void shouldBeNegativeWhenPerishableParcelIsExpired() {
        Assertions.assertTrue(perishableParcel.isExpired(25));
    }

    @Test
    public void shouldBePositiveWhenPerishableParcelIsExpired() {
        Assertions.assertFalse(perishableParcel.isExpired(10));
    }

    @Test
    public void shouldBePositiveWhenPerishableParcelIsBorder() {
        Assertions.assertFalse(perishableParcel.isExpired(22));
    }
}
