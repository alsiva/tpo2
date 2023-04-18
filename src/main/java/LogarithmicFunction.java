public class LogarithmicFunction {
    private final Log log;
    private final Ln ln;

    public LogarithmicFunction(Log log, Ln ln) {
        this.log = log;
        this.ln = ln;
    }

    public double calculate(double x, double eps) {
        return Math.pow(Math.pow(log.log(10, x, eps) + ln.ln(x, eps) + ln.ln(x, eps), 3), 2) / log.log(5, x, eps);
    }
}
