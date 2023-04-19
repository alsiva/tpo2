import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/test/sec.csv")
    void integrationTest(double x, double result) {
        Cos cos = new Cos();
        Sec sec = new Sec(cos);
        assertEquals(result, sec.sec(x, 0.1));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "test/sec.csv")
    void mockedTest(double x, double result) throws IOException {
        Cos cos = CosTest.mock(0.1);
        Sec sec = new Sec(cos);

        assertEquals(result, sec.sec(x, 0.1));
    }

    public static Sec mock(double eps) throws IOException {
        Sec sec = Mockito.mock(Sec.class);

        CsvFileConsumer.consume("/test/sec.csv", (x, result) -> {
            Mockito.when(sec.sec(x, eps)).thenReturn(result);
        });

        return sec;
    }
}
