
public class TrigonometricFunction {
    private final Sec sec;
    private final Sin sin;
    private final Cot cot;
    private final Cos cos;
    private final Csc csc;

    public TrigonometricFunction(Sec sec, Sin sin, Cot cot, Cos cos, Csc csc) {
        this.sec = sec;
        this.sin = sin;
        this.cot = cot;
        this.cos = cos;
        this.csc = csc;
    }

    public double calculate(double x, double eps) {
        return (sin.sin(x, eps) * cot.cot(x, eps) - sin.sin(x, eps)) * (cos.cos(x, eps) / (sec.sec(x, eps) - csc.csc(x, eps))) * cos.cos(x, eps) - sin.sin(x, eps);
    }
}
