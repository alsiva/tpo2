import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrigonometricFunctionTest {
    private static final String csvFile = "/test/trigonometric-function.csv";

    @ParameterizedTest
    @CsvFileSource(resources = csvFile)
    void integrationTest(double x, double result) {
        Sin sin = new Sin();
        Cos cos = new Cos(sin);
        Sec sec = new Sec(cos);
        Cot cot = new Cot(sin, cos);
        Csc csc = new Csc(sin);
        TrigonometricFunction trigonometricFunction = new TrigonometricFunction(sec, sin, cot, cos, csc);

        assertEquals(result, trigonometricFunction.calculate(x, 0.1));
    }

    public static TrigonometricFunction mock(double eps) throws IOException {
        TrigonometricFunction trigonometricFunction = Mockito.mock(TrigonometricFunction.class);

        CsvFileConsumer.consume(csvFile, (x, result) -> {
            Mockito.when(trigonometricFunction.calculate(x, eps)).thenReturn(result);
        });

        return trigonometricFunction;
    }
}
