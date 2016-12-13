package guava;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by kicsen on 2016. 12. 01..
 */
public class TestGuavaTasks {

    private Car car = new Car(1, "Audi", 52642, "A4");
    private GuavaTasks guavaTasks = new GuavaTasks();

    @Test
    public void testCarToStringWasNotModified() throws Exception {
        assertTrue(car.toString().contains("@"));
        assertFalse(car.toString().contains("{"));
        assertFalse(car.toString().contains("}"));
        assertFalse(car.toString().contains(","));
        assertFalse(car.toString().contains("="));
    }

    @Test
    public void testGuavaTasksInitialization() throws Exception {
        assertNotNull(guavaTasks.cars);
        assertFalse(guavaTasks.cars.isEmpty());
        assertNotNull(guavaTasks.carTitles);
        assertFalse(guavaTasks.carTitles.isEmpty());
    }

    @Test
    public void testPrintCar() throws Exception {
        String carStr = guavaTasks.printCar(car);
        assertEquals("Car{id=1, name=Audi, price=52642, model=A4}", carStr);
    }

    @Test
    public void testGenerateCarTitles() throws Exception {
        Collection<String> carTitles = guavaTasks.generateCarTitles();
        String carTitlesStr = Joiner.on(", ").join(carTitles);
        assertEquals("Audi (A4), Mercedes (), Skoda (null), Volvo (XC90), Volvo (V40)", carTitlesStr);
    }

    @Test
    public void testConcatCarTitles() throws Exception {
        Collection<String> carTitles = guavaTasks.generateCarTitles();
        assertEquals("Audi (A4), Mercedes (), Skoda (null), Volvo (XC90), Volvo (V40)", guavaTasks.concatCarTitles(carTitles));
    }

    @Test
    public void testGenerateCarTitlesWithoutEmpty() throws Exception {
        Collection<String> carTitles = guavaTasks.generateCarTitlesWithoutEmpty(guavaTasks.cars);
        assertEquals("Audi (A4), Mercedes, Skoda, Volvo (XC90), Volvo (V40)", guavaTasks.concatCarTitles(carTitles));
    }

    @Test
    public void testFindCar() throws Exception {
        Collection<Car> volvos = guavaTasks.findCar("Volvo", 30000);
        assertFalse(volvos.isEmpty());
        assertEquals(2, volvos.size());
        for (Car volvo : volvos) {
            assertTrue(volvo.getName().contains("Volvo"));
            assertTrue(volvo.getPrice() <= 30000);
        }
    }

}
