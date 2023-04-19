import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LnTest {


    @ParameterizedTest
    @CsvFileSource(resources = "/test/ln.csv")
    void integrationTestForLog5(double x, double result) {
        Ln ln = new Ln();

        assertEquals(result, ln.ln(x, 0.1));
    }

    public static Ln mock(double eps) throws IOException {
        Ln ln = Mockito.mock(Ln.class);

        CsvFileConsumer.consume("/test/ln.csv", (x, result) -> {
            Mockito.when(ln.ln(x, eps)).thenReturn(result);
        });

        return ln;
    }
}
