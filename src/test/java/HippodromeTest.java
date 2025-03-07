import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class HippodromeTest {
    @Test
    void HippodromeConstructorTest(){
        IllegalArgumentException exception= assertThrows(IllegalArgumentException.class,()->
                new Hippodrome(null));
        assertEquals("Horses cannot be null.",exception.getMessage());
    }
    @Test
    void HippodromeConstructorIsEmptyTest(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,()->
                new Hippodrome(new ArrayList<>())
        );
        assertEquals("Horses cannot be empty.",exception.getMessage());
    }
    @Test
    void getHorsesTest(){
        List<Horse> horses=new ArrayList<>();
        for (int i = 1; i <31 ; i++) {
            horses.add(new Horse("Horse "+ i,i));
        }
        Hippodrome hippodrome= new Hippodrome(horses);

        assertEquals(horses,hippodrome.getHorses());
    }
    @Test
    void moveTest(){
        List<Horse> horses= new ArrayList<>();
        for (int i = 0; i <50 ; i++) {
            horses.add(mock(Horse.class));
        }
        Hippodrome hippodrome= new Hippodrome(horses);

        hippodrome.move();

        for (Horse hors : horses) {
            verify(hors).move();
        }
    }
    @Test
    void getWinnerTest(){
        Horse horse1= mock(Horse.class);
        Horse horse2= mock(Horse.class);
        Horse horse3= mock(Horse.class);

        when(horse1.getDistance()).thenReturn(10.0);
        when(horse2.getDistance()).thenReturn(15.5);
        when(horse3.getDistance()).thenReturn(24.04_2004);

        Hippodrome hippodrome= new Hippodrome(List.of(horse1,horse2,horse3));

        assertEquals(horse3,hippodrome.getWinner());

    }
}
