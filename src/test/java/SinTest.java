import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/test/sin.csv")
    void integrationTest(double x, double result) {
        Sin sin = new Sin();
        assertEquals(result, sin.sin(x, 0.1));
    }

    public static Sin mock(double eps) throws IOException {
        Sin sin = Mockito.mock(Sin.class);

        CsvFileConsumer.consume("/test/sin.csv", (x, result) -> {
            Mockito.when(sin.sin(x, eps)).thenReturn(result);
        });

        return sin;
    }
}
