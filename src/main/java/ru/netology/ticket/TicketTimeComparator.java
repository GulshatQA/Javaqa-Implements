package ru.netology.ticket;
import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    // Компаратор должен сравнивать два билета так,
    // что первый считался бы меньше, чем второй,
    // если его время полёта меньше чем время полёта второго
    @Override
    public int compare(Ticket t1, Ticket t2) {
        if (t1.flightTime() < t2.flightTime()) {
            return -1;
        } else if (t1.flightTime() > t2.getTimeTo()) {
            return  1;
        } else {
            return 0;
        }
    }
}
