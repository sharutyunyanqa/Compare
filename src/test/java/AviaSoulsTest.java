import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void shouldTestSortTickets() {
        AviaSouls ticket = new AviaSouls();
        Ticket ticket1 = new Ticket("EVN", "MSQ", 900, 15, 16);
        Ticket ticket2 = new Ticket("EVN", "MSK", 2200, 15, 16);
        Ticket ticket3 = new Ticket("NYC", "SPB", 3000, 15, 22);
        Ticket ticket4 = new Ticket("MSK", "ATH", 1200, 7, 18);
        Ticket ticket5 = new Ticket("EVN", "MSK", 800, 15, 18);
        Ticket ticket6 = new Ticket("EVN", "MSK", 1000, 15, 18);
        Ticket ticket7 = new Ticket("NYC", "ТYO", 3400, 16, 21);
        Ticket ticket8 = new Ticket("EVN", "MSK", 2200, 15, 16);
        Ticket ticket9 = new Ticket("EVN", "MSK", 1500, 15, 16);

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);
        ticket.add(ticket6);
        ticket.add(ticket7);
        ticket.add(ticket8);
        ticket.add(ticket9);



        Ticket[] expected = {ticket5, ticket6, ticket9, ticket2, ticket8,};
        Ticket[] actual = ticket.search("EVN", "MSK");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTestSortTicketsEmpty() {
        AviaSouls ticket = new AviaSouls();
        Ticket ticket1 = new Ticket("EVN", "MSQ", 900, 15, 16);
        Ticket ticket2 = new Ticket("EVN", "MSK", 2200, 15, 16);
        Ticket ticket3 = new Ticket("NYC", "SPB", 3000, 15, 22);
        Ticket ticket4 = new Ticket("MSK", "ATH", 1200, 7, 18);
        Ticket ticket5 = new Ticket("ЕVN", "MSK", 800, 15, 18);
        Ticket ticket6 = new Ticket("ЕVN", "MSK", 1000, 15, 18);
        Ticket ticket7 = new Ticket("NYC", "ТYO", 3400, 16, 21);
        Ticket ticket8 = new Ticket("ЕVN", "MSK", 2200, 15, 16);
        Ticket ticket9 = new Ticket("ЕVN", "MSK", 1500, 15, 16);

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);
        ticket.add(ticket6);
        ticket.add(ticket7);
        ticket.add(ticket8);
        ticket.add(ticket9);
        Ticket[] expected = {};
        Ticket[] actual = ticket.search("EVN", "NYC");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTestSortTicketsOne() {
        AviaSouls ticket = new AviaSouls();
        Ticket ticket1 = new Ticket("ЕVN", "MSQ", 900, 15, 16);
        Ticket ticket2 = new Ticket("ЕVN", "MSK", 2200, 15, 16);
        Ticket ticket3 = new Ticket("NYC", "SPB", 3000, 15, 22);
        Ticket ticket4 = new Ticket("MSK", "ATH", 1200, 7, 18);
        Ticket ticket5 = new Ticket("ЕVN", "MSK", 800, 15, 18);
        Ticket ticket6 = new Ticket("ЕVN", "MSK", 1000, 15, 18);
        Ticket ticket7 = new Ticket("NYC", "ТYO", 3400, 16, 21);
        Ticket ticket8 = new Ticket("ЕVN", "MSK", 2200, 15, 16);
        Ticket ticket9 = new Ticket("ЕVN", "MSK", 1500, 15, 16);

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);
        ticket.add(ticket6);
        ticket.add(ticket7);
        ticket.add(ticket8);
        ticket.add(ticket9);
        Ticket[] expected = {ticket3};
        Ticket[] actual = ticket.search("NYC", "SPB");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTestSortByTimeOne() {
        AviaSouls ticket = new AviaSouls();
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("ЕVN", "MSQ", 900, 15, 19);
        Ticket ticket2 = new Ticket("ЕVN", "MSK", 2200, 7, 10);
        Ticket ticket3 = new Ticket("NYC", "SPB", 3000, 10, 21);
        Ticket ticket4 = new Ticket("MSK", "ATH", 1200, 7, 13);
        Ticket ticket5 = new Ticket("ЕVN", "MSK", 800, 12, 16);
        Ticket ticket6 = new Ticket("ЕVN", "MSK", 1000, 5, 9);
        Ticket ticket7 = new Ticket("NYC", "ТYO", 3400, 3, 14);
        Ticket ticket8 = new Ticket("ЕVN", "MSK", 2200, 12, 22);
        Ticket ticket9 = new Ticket("ЕVN", "MSK", 1500, 6, 12);

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);
        ticket.add(ticket6);
        ticket.add(ticket7);
        ticket.add(ticket8);
        ticket.add(ticket9);
        Ticket[] expected = {ticket3};
        Ticket[] actual = ticket.search("NYC", "SPB", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldTestSortByTimeEmpty() {
        AviaSouls ticket = new AviaSouls();
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("ЕVN", "MSQ", 900, 15, 19);
        Ticket ticket2 = new Ticket("ЕVN", "MSK", 2200, 7, 10);
        Ticket ticket3 = new Ticket("NYC", "SPB", 3000, 10, 21);
        Ticket ticket4 = new Ticket("MSK", "ATH", 1200, 7, 13);
        Ticket ticket5 = new Ticket("ЕVN", "MSK", 800, 12, 16);
        Ticket ticket6 = new Ticket("ЕVN", "MSK", 1000, 5, 9);
        Ticket ticket7 = new Ticket("NYC", "ТYO", 3400, 3, 14);
        Ticket ticket8 = new Ticket("ЕVN", "MSK", 2200, 12, 22);
        Ticket ticket9 = new Ticket("ЕVN", "MSK", 1500, 6, 12);

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);
        ticket.add(ticket6);
        ticket.add(ticket7);
        ticket.add(ticket8);
        ticket.add(ticket9);
        Ticket[] expected = {};
        Ticket[] actual = ticket.search("NYC", "EVN", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldTestSortByTime() {
        AviaSouls ticket = new AviaSouls();
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("EVN", "MSQ", 900, 15, 19);
        Ticket ticket2 = new Ticket("EVN", "MSK", 2200, 7, 10); // 3
        Ticket ticket3 = new Ticket("NYC", "SPB", 3000, 10, 21);
        Ticket ticket4 = new Ticket("MSK", "ATH", 1200, 7, 13);
        Ticket ticket5 = new Ticket("EVN", "MSK", 800, 12, 16); // 4
        Ticket ticket6 = new Ticket("EVN", "MSK", 1000, 5, 9); // 4
        Ticket ticket7 = new Ticket("NYC", "ТYO", 3400, 3, 14);
        Ticket ticket8 = new Ticket("EVN", "MSK", 2200, 12, 22); // 10
        Ticket ticket9 = new Ticket("EVN", "MSK", 1500, 6, 12); // 6

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);
        ticket.add(ticket6);
        ticket.add(ticket7);
        ticket.add(ticket8);
        ticket.add(ticket9);
        Ticket[] expected = {ticket2, ticket5, ticket6, ticket9, ticket8,};
        Ticket[] actual = ticket.search("EVN", "MSK", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}
