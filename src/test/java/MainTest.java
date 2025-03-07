import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

class MainTest {

    @Test
    @Timeout(value = 22, unit = TimeUnit.SECONDS)
    @Disabled("Отключено для ускорения тестирования")
    void testMethodShouldNotExceed22Seconds() {
        // Имитация выполнения метода
        try {
            Thread.sleep(21000); // 21 секунда, тест пройдет
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        assertTrue(true);
    }
}
