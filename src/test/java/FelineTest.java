import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

public class FelineTest {

    Feline feline = new Feline();

    @Test
    void eatMeatReturnsCorrectFood() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    void getFamilyReturnsCorrectFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittensReturnsCorrectCount() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    void getKittensReturnsCorrectCountWithParameter() {
        assertEquals(3, feline.getKittens(3));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 10}) // Параметры для проверки метода с разными значениями
    void getKittensReturnsCorrectCountWithMultipleParameters(int kittensCount) {
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}