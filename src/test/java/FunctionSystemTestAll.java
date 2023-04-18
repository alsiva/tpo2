import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

class FunctionSystemTestAll {

    static double functionEps = 0.1;
    static double eps = 0.1;

    static Sec secMock;
    static Cos cosMock;
    static Sin sinMock;
    static Ln lnMock;
    static Log logMock;
    static Cot cotMock;
    static Csc cscMock;

    static Reader secIn;
    static Reader cosIn;
    static Reader sinIn;
    static Reader lnIn;
    static Reader log2In;
    static Reader log10In;
    static Reader cotIn;
    static Reader cscIn;


    @BeforeAll
    static void init() {
        secMock = Mockito.mock(Sec.class);
        cosMock = Mockito.mock(Cos.class);
        sinMock = Mockito.mock(Sin.class);
        lnMock = Mockito.mock(Ln.class);
        logMock = Mockito.mock(Log.class);
        cotMock = Mockito.mock(Cot.class);
        cscMock = Mockito.mock(Csc.class);
        try {
            secIn = new FileReader("src/main/resources/CsvFiles/Inputs/SecIn.csv");
            cosIn = new FileReader("src/main/resources/CsvFiles/Inputs/CosIn.csv");
            sinIn = new FileReader("src/main/resources/CsvFiles/Inputs/SinIn.csv");
            lnIn = new FileReader("src/main/resources/CsvFiles/Inputs/LnIn.csv");
            log2In = new FileReader("src/main/resources/CsvFiles/Inputs/Log2In.csv");
            log10In = new FileReader("src/main/resources/CsvFiles/Inputs/Log10In.csv");
            cotIn = new FileReader("src/main/resources/CsvFiles/Inputs/CotIn.csv");
            cscIn = new FileReader("src/main/resources/CsvFiles/Inputs/CscIn.csv");

            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(secIn);
            for (CSVRecord record : records) {
                Mockito.when(secMock.sec(Double.parseDouble(record.get(0)), functionEps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(cosIn);
            for (CSVRecord record : records) {
                Mockito.when(cosMock.cos(Double.parseDouble(record.get(0)), functionEps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(sinIn);
            for (CSVRecord record : records) {
                Mockito.when(sinMock.sin(Double.parseDouble(record.get(0)), functionEps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(lnIn);
            for (CSVRecord record : records) {
                Mockito.when(lnMock.ln(Double.parseDouble(record.get(0)), functionEps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(log2In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.log(2, Double.parseDouble(record.get(0)), functionEps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(log10In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.log(10, Double.parseDouble(record.get(0)), functionEps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(cotIn);
            for (CSVRecord record : records) {
                Mockito.when(cotMock.cot(Double.parseDouble(record.get(0)), functionEps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(cscIn);
            for (CSVRecord record : records) {
                Mockito.when(cscMock.csc(Double.parseDouble(record.get(0)), functionEps)).thenReturn(Double.valueOf(record.get(1)));
            }


        } catch (IOException ex) {
            System.err.println("Ты как в тесте IOE поймал?!");
        }

    }

//    @ParameterizedTest
//    @CsvFileSource(resources = "/CsvFiles/Inputs/SystemIn.csv")
//    void testSystemWithMocks(double value, double expected) {
//        FunctionSystem functionSystem = new FunctionSystem(secMock, lnMock, logMock, sinMock, cotMock, cosMock, cscMock);
//        Assertions.assertEquals(expected, functionSystem.calculate(value, functionEps), eps);
//
/*
        try {
            Assertions.assertEquals(expected, function.writeResultToCSV(value, functionEps,
                    new FileWriter("C:\\Users\\egorm\\IdeaProjects\\TpoLab2\\src\\main\\resources\\CsvFiles\\Outputs\\SystemOut.csv", true)), eps);
        } catch (IOException e) {
            System.err.println("Да как ты это делаешь ");
        }
    }
*/

/*
    @ParameterizedTest
    @CsvFileSource(resources = "/CsvFiles/Inputs/SystemIn.csv")
    void testWithSec(double value, double expected) {
        FunctionSystem functionSystem = new FunctionSystem(new Sec(cosMock), lnMock, logMock, sinMock, cotMock, cosMock, cscMock);
        Assertions.assertEquals(expected, functionSystem.calculate(value, functionEps), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/CsvFiles/Inputs/SystemIn.csv")
    void testWithCot(double value, double expected) {
        FunctionSystem functionSystem = new FunctionSystem(secMock, lnMock, logMock, sinMock, new Cot(sinMock, cosMock), cosMock, cscMock);
        Assertions.assertEquals(expected, functionSystem.calculate(value, functionEps), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/CsvFiles/Inputs/SystemIn.csv")
    void testWithCsc(double value, double expected) {
        FunctionSystem functionSystem = new FunctionSystem(secMock, lnMock, logMock, sinMock, cotMock, cosMock, new Csc(sinMock));
        Assertions.assertEquals(expected, functionSystem.calculate(value, functionEps), eps);
    }*/


//    @ParameterizedTest
//    @CsvFileSource(resources = "/CsvFiles/Inputs/SystemIn.csv")
//    void cosTest(double value, double expected) {
//        Cos cos = new Cos(sinMock);
//        cos.cos(value, functionEps);
//
//        Mockito.verify(sinMock).sin(value, functionEps);
//    }

   /* @ParameterizedTest
    @CsvFileSource(resources = "/CsvFiles/Inputs/SystemIn.csv")
    void testWithCos(double value, double expected) {
        FunctionSystem functionSystem = new FunctionSystem(new Sec(new Cos(sinMock)), lnMock, logMock, sinMock, cotMock, new Cos(sinMock), cscMock);
        Assertions.assertEquals(expected, functionSystem.calculate(value, functionEps), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/CsvFiles/Inputs/SystemIn.csv")
    void testWithSin(double value, double expected) {
        FunctionSystem functionSystem = new FunctionSystem(new Sec(new Cos(new Sin())), lnMock, logMock, new Sin(), cotMock, new Cos(), cscMock);
        Assertions.assertEquals(expected, functionSystem.calculate(value, functionEps), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/CsvFiles/Inputs/SystemIn.csv")
    void testWithLog(double value, double expected) {
        FunctionSystem functionSystem = new FunctionSystem(secMock, lnMock, new Log(lnMock), sinMock, cotMock, cosMock, cscMock);
        Assertions.assertEquals(expected, functionSystem.calculate(value, functionEps), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/CsvFiles/Inputs/SystemIn.csv")
    void testWithLn(double value, double expected) {
        FunctionSystem functionSystem = new FunctionSystem(secMock, new Ln(), new Log(), sinMock, cotMock, cosMock, cscMock);
        Assertions.assertEquals(expected, functionSystem.calculate(value, functionEps), eps * 20);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/CsvFiles/Inputs/SystemIn.csv")
    void testWithSinAndLn(double value, double expected) {
        FunctionSystem functionSystem = new FunctionSystem();
        Assertions.assertEquals(expected, functionSystem.calculate(value, functionEps), eps * 20);
    }*/
}