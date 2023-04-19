import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrigonometricFunctionTest {
    private static final String csvFile = "/test/trigonometric.csv";

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

//    @ParameterizedTest
//    @CsvFileSource(resources = csvFile)
//    void mockedTest(double x, double result) throws IOException {
//        Ln ln = LnTest.mock(0.1);
//        Log log = LogTest.mock(0.1);
//        Sec sec =
//        TrigonometricFunction trigonometricFunction = new TrigonometricFunction();
//
//        assertEquals(result, logarithmicFunction.calculate(x, 0.1));
//    }

    @ParameterizedTest
    @CsvFileSource(resources = csvFile)
    void mockedTest(double x, double result) throws IOException {
        Sec sec = SecTest.mock(0.1);
        Sin sin = SinTest.mock(0.1);
        Cot cot = CotTest.mock(0.1);
        Cos cos = CosTest.mock(0.1);
        Csc csc = CscTest.mock(0.1);
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
