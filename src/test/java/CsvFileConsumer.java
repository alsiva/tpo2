import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.function.BiConsumer;

public class CsvFileConsumer {
    public static void consume(String resourceName, BiConsumer<Double, Double> consumer) throws IOException {
        try (InputStream is = CsvFileConsumer.class.getResourceAsStream(resourceName)) {
            try (Reader reader = new InputStreamReader(is)) {
                for (CSVRecord record : CSVFormat.DEFAULT.parse(reader)) {
                    Double x = Double.valueOf(record.get(0).trim());
                    Double result = Double.valueOf(record.get(1).trim());

                    consumer.accept(x, result);
                }
            }
        }
    }
}
