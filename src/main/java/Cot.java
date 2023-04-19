public class Cot {

    private final Sin sin;
    private final Cos cos;

    public Cot(Sin sin, Cos cos) {
        this.sin = sin;
        this.cos = cos;
    }

    public double cot(double x, double eps) {
        double cosVal = cos.cos(x, eps);
        if (cosVal == 0) {
            return Double.NaN;
        }
        return cosVal / sin.sin(x, eps);
    }
}
