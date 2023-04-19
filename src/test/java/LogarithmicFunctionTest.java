import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogarithmicFunctionTest {
    private static final String csvFile = "/test/logarithmic.csv";

    @ParameterizedTest
    @CsvFileSource(resources = csvFile)
    void integrationTest(double x, double result) {
        Ln ln = new Ln();
        Log log = new Log(ln);
        LogarithmicFunction logarithmicFunction = new LogarithmicFunction(log, ln);

        assertEquals(result, logarithmicFunction.calculate(x, 0.1));
    }

    @ParameterizedTest
    @CsvFileSource(resources = csvFile)
    void mockedTest(double x, double result) throws IOException {
        Ln ln = LnTest.mock(0.1);
        Log log = LogTest.mock(0.1);
        LogarithmicFunction logarithmicFunction = new LogarithmicFunction(log, ln);

        assertEquals(result, logarithmicFunction.calculate(x, 0.1));
    }


    public static LogarithmicFunction mock(double eps) throws IOException {
        LogarithmicFunction logarithmicFunction = Mockito.mock(LogarithmicFunction.class);

        CsvFileConsumer.consume(csvFile, (x, result) -> {
            Mockito.when(logarithmicFunction.calculate(x, eps)).thenReturn(result);
        });

        return logarithmicFunction;
    }
}
