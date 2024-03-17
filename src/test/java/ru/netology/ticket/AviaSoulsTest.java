package ru.netology.ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    AviaSouls manager = new AviaSouls();
    TicketTimeComparator comparator = new TicketTimeComparator();

    Ticket ticket1 = new Ticket("Москва", "Сочи", 1_437, 20, 23);
    Ticket ticket2 = new Ticket("Москва", "Уфа", 3_445, 20, 22);
    Ticket ticket3 = new Ticket("Москва", "Сочи", 1_510, 14, 19);
    Ticket ticket4 = new Ticket("Казань", "Москва", 3_609, 7, 4);
    Ticket ticket5 = new Ticket("Казань", "Москва", 5_588, 20, 22);
    Ticket ticket6 = new Ticket("Казань", "Москва", 5_588, 8, 4);
    Ticket ticket7 = new Ticket("Москва", "Сочи", 2_110, 12, 16);
    Ticket ticket8 = new Ticket("Москва", "Сочи", 2_405, 6, 7);

    // возвращает 1, если цена одного билета выше цены другого билета
    @Test
    public void testCompareToReturnsOneForHigherPriceTicket() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        int expected = 1;
        int actual = ticket8.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    // возвращает -1, если цена одного билета ниже цены другого билета
    @Test
    public void testCompareToReturnsMinusOneForLowerPriceTicket() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        int expected = -1;
        int actual = ticket2.compareTo(ticket4);

        Assertions.assertEquals(expected, actual);
    }

    // возвращает 0, если цена одного билета равна цене другого билета
    @Test
    public void testCompareToReturnsZeroForEqualPriceTickets() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        int expected = 0;
        int actual = ticket6.compareTo(ticket5);

        Assertions.assertEquals(expected, actual);
    }

    // сортирует в порядке возрастания цены
    // при совпадении аэропорта вылета и аэропорта прилёта
    @Test
    public void testSearchReturnsTicketsSortedByPrice() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket1, ticket3, ticket7, ticket8};
        Ticket[] actual = manager.search("Москва", "Сочи");

        Assertions.assertArrayEquals(expected, actual);
    }

    // возвращает единственный подходящий билет
    @Test
    public void testSearchReturnsSingleMatchingTicket() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.search("Москва", "Уфа");

        Assertions.assertArrayEquals(expected, actual);
    }

    // возвращает пустой массив, если не найдено подходящих билетов
    @Test
    public void testSearchReturnsEmptyArrayWhenNoMatchingTicketsFound() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Краснодар", "Уфа");

        Assertions.assertArrayEquals(expected, actual);
    }

    // сортирует в порядке возрастания времени полёта
    // при совпадении аэропорта вылета и аэропорта прилёта
    @Test
    public void testSearchAndSortByReturnsTicketsSortedByFlightTime() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket5, ticket6, ticket4};
        Ticket[] actual = manager.searchAndSortBy("Казань", "Москва", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
