import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LionTest {

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void doesHaveManeReturnsCorrectValue(String sex, boolean expectedHasMane) throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, feline);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test
    void throwsExceptionForInvalidSex() {
        Feline feline = Mockito.mock(Feline.class);
        Exception exception = assertThrows(Exception.class, () -> new Lion("Другой", feline));
        assertEquals("Используйте допустимые значения пола животного - Самец или Самка", exception.getMessage());
    }

    @Test
    void getKittensReturnsCorrectCount() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Mockito.when(feline.getKittens()).thenReturn(3); // Настраиваем мок

        Lion lion = new Lion("Самец", feline);
        assertEquals(3, lion.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    void getFoodReturnsCorrectFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", feline);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());

        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }
}