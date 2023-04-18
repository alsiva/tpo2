import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class Function {
    Sec sec;
    Log log;
    Ln ln;
    Sin sin;
    Cot cot;
    Cos cos;
    Csc csc;

    public Function() {
        this.sec = new Sec();
        this.ln = new Ln();
        this.log = new Log(ln);
        this.sin = new Sin();
        this.cot = new Cot();
        this.cos = new Cos();
        this.csc = new Csc();
    }

    public Function(Sec sec, Ln ln, Log log, Sin sin, Cot cot, Cos cos, Csc csc) {
        this.sec = sec;
        this.log = log;
        this.ln = ln;
        this.sin = sin;
        this.cot = cot;
        this.cos = cos;
        this.csc = csc;
    }

    public double SystemSolve(double x, double eps) {
        if (x <= 0) {
            return (((((sin.sin(x, eps) * cot.cot(x, eps)) - sin.sin(x, eps)) * (cos.cos(x, eps) / (sec.sec(x, eps) - csc.csc(x, eps)))) * cos.cos(x, eps)) - sin.sin(x, eps));
        } else {
            return ((Math.pow((Math.pow((log.log(10, x, eps) + ln.ln(x, eps)) + ln.ln(x, eps), 3)), 2)) / log.log(5, x, eps));
        }
    }

    public double writeResultToCSV(double x, double eps, Writer out) {
        double res = SystemSolve(x, eps);
        try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)) {
            printer.printRecord(x, res);
        } catch (IOException e) {
            System.out.println("Wrong filename");
        }
        return res;
    }
}
