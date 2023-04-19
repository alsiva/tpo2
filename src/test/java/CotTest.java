import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CotTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/test/cot.csv")
    void integrationTest(double x, double result) {
        Sin sin = new Sin();
        Cos cos = new Cos(sin);
        assertEquals(result, cos.cos(x, 0.1));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "test/cot.csv")
    void mockedTest(double x, double result) throws IOException {
        Sin sin = SinTest.mock(0.1);
        Cos cos = CosTest.mock(0.1);
        Cot cot = new Cot(sin, cos);

        assertEquals(result, cot.cot(x, 0.1));
    }

    public static Cot mock(double eps) throws IOException {
        Cot cot = Mockito.mock(Cot.class);

        CsvFileConsumer.consume("/test/cot.csv", (x, result) -> {
            Mockito.when(cot.cot(x, eps)).thenReturn(result);
        });

        return cot;
    }
}
