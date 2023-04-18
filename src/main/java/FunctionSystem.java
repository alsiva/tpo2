public class FunctionSystem {
    private final LogarithmicFunction logarithmicFunction;
    private final TrigonometricFunction trigonometricFunction;

    public FunctionSystem(LogarithmicFunction logarithmicFunction, TrigonometricFunction trigonometricFunction) {
        this.logarithmicFunction = logarithmicFunction;
        this.trigonometricFunction = trigonometricFunction;
    }

    public double calculate(double x, double eps) {
        if (x <= 0) {
            return trigonometricFunction.calculate(x, eps);
        } else {
            return logarithmicFunction.calculate(x, eps);
        }
    }
}
