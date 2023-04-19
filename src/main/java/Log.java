public class Log {

    private final Ln ln;

    public Log(Ln ln) {
        this.ln = ln;
    }

    public double log(double a, double b, double esp) {
        double first = ln.ln(b, esp);
        double second = ln.ln(a, esp);
        return ln.ln(b, esp) / ln.ln(a, esp);
    }
}
