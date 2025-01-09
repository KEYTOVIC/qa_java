import com.example.Feline;
import org.junit.jupiter.api.Test;
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
}
