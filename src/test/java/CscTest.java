import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CscTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/test/csc.csv")
    void integrationTest(double x, double result) {
        Sin sin = new Sin();
        Csc csc = new Csc(sin);
        assertEquals(result, csc.csc(x, 0.1));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "test/csc.csv")
    void mockedTest(double x, double result) throws IOException {
        Sin sin = SinTest.mock(0.1);
        Csc csc = new Csc(sin);

        assertEquals(result, csc.csc(x, 0.1));
    }

    public static Csc mock(double eps) throws IOException {
        Csc csc = Mockito.mock(Csc.class);

        CsvFileConsumer.consume("/test/csc.csv", (x, result) -> {
            Mockito.when(csc.csc(x, eps)).thenReturn(result);
        });

        return csc;
    }
}
