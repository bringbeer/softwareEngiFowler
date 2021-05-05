import Movie.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestingRefac {
    @Test
    void testingMovie() {
        var m = new Movie("The fall of my grades", 1);
        Assertions.assertEquals("The fall of my grades", m.getTitle());
        Assertions.assertEquals(1, m.getPriceCode());
    }

    @Test
    void testingRental() {
        var m = new Movie("Will there be an end?!", 2);
        var r = new Rental(m, 30);
        Assertions.assertEquals(30, r.getDaysRented());
        Assertions.assertEquals("Will there be an end?!", r.getMovie().getTitle());
        Assertions.assertEquals(2, r.getMovie().getPriceCode());
    }

    @Test
    void testingCustomer() {
        var m1 = new Movie("I guess not", 1);
        var m2 = new Movie("Down we go", 0);
        var r1 = new Rental(m1, 5);
        var r2 = new Rental(m2, 5);
        var c = new Customer("Huibu");
        c.addRental(r1);
        c.addRental(r2);
        Assertions.assertEquals("Huibu", c.getName());
        Assertions.assertEquals(15, m1.getCharge(5));
        Assertions.assertEquals(4.5, m2.getCharge(5));
        Assertions.assertTrue(c.statement().contains("Huibu"));
        Assertions.assertTrue(c.statement().contains("19.5"));
    }
}
