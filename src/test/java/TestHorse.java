import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockStatic;


public class TestHorse {

    @Test
    void constructorTestOfHorse() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Horse(null, 40)
        );
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n"})
    void parametricTestOfHorse(String name) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Horse(name, 40)
        );
        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    void IfSecondParametrsIsNegative() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Horse("Test", -1, 20)
        );
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    void IfThirdParametrsIsNegative() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Horse("Test", 40, -1)
        );
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @Test
    void getNameTest() {
        Horse horse = new Horse("Pegas", 40);
        assertEquals("Pegas", horse.getName());
    }

    @Test
    void getSpeedTest() {
        Horse horse = new Horse("Pegas", 40);
        assertEquals(40, horse.getSpeed());
    }

    @Test
    void getDistanceTest() {
        Horse horse = new Horse("Pegas", 40, 20);
        assertEquals(20, horse.getDistance());
    }

    @Test
    void getDistance0Test() {
        Horse horse = new Horse("Pegas", 40);
        assertEquals(0, horse.getDistance());
    }

    @Test
    void getRandomDoubleTest() {
        try (MockedStatic<Horse> horseMockedStatic = mockStatic(Horse.class)) {
            new Horse("Pegas", 40).move();
            horseMockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }
    }
}

