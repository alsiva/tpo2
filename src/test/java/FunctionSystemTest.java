import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionSystemTest {
    private static final double eps = 0.1;
    private static final String csvFile = "/test/system.csv";

    @ParameterizedTest
    @CsvFileSource(resources = csvFile)
    public void integrationTest(double x, double result) {
        Sin sin = new Sin();
        Cos cos = new Cos(sin);
        Sec sec = new Sec(cos);
        Cot cot = new Cot(sin, cos);
        Csc csc = new Csc(sin);
        TrigonometricFunction trigonometricFunction = new TrigonometricFunction(sec, sin, cot, cos, csc);

        Ln ln = new Ln();
        Log log = new Log(ln);
        LogarithmicFunction logarithmicFunction = new LogarithmicFunction(log, ln);

        FunctionSystem functionSystem = new FunctionSystem(logarithmicFunction, trigonometricFunction);
        assertEquals(result, functionSystem.calculate(x, eps));
    }


    @ParameterizedTest
    @CsvFileSource(resources = csvFile)
    public void mockedTest(double x, double result) throws IOException {
        TrigonometricFunction trigonometricFunction = TrigonometricFunctionTest.mock(eps);
        LogarithmicFunction logarithmicFunction = LogarithmicFunctionTest.mock(eps);

        FunctionSystem functionSystem = new FunctionSystem(logarithmicFunction, trigonometricFunction);
        assertEquals(result, functionSystem.calculate(x, eps));
    }
}
