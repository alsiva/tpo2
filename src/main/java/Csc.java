public class Csc {

    private final Sin sin;

    public Csc() {
        this.sin = new Sin();
    }

    public Csc(Sin sin) {
        this.sin = sin;
    }

    public double csc(double x, double eps) {
        double sinVal = sin.sin(x, eps);
        if (sinVal == 0) {
            return Double.NaN;
        }
        return 1 / sinVal;
    }
}
