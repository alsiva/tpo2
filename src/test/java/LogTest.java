import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/test/log5.csv")
    void integrationTestForLog5(double x, double result) {
        Ln ln = new Ln();
        Log log = new Log(ln);

        assertEquals(result, log.log(5, x, 0.1));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "test/log5.csv")
    void mockedTestForLog5(double x, double result) throws IOException {
        Ln ln = LnTest.mock(0.1);
        Log log = new Log(ln);

        assertEquals(result, log.log(5, x, 0.1));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test/log10.csv")
    void integrationTestForLog10(double x, double result) {
        Ln ln = new Ln();
        Log log = new Log(ln);

        assertEquals(result, log.log(10, x, 0.1));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "test/log10.csv")
    void mockedTestForLog10(double x, double result) throws IOException {
        Ln ln = LnTest.mock(0.1);
        Log log = new Log(ln);

        assertEquals(result, log.log(10, x, 0.1));
    }

    public static Log mock(double eps) throws IOException {
        Log log = Mockito.mock(Log.class);

        CsvFileConsumer.consume("/test/log5.csv", (x, result) -> {
            Mockito.when(log.log(5, x, eps)).thenReturn(result);
        });

        CsvFileConsumer.consume("/test/log10.csv", (x, result) -> {
            Mockito.when(log.log(10, x, eps)).thenReturn(result);
        });


        return log;
    }
}
