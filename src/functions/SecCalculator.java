package functions;

import interfaces.ICosinusCalculator;
import interfaces.ISecCalculator;

import static java.lang.Double.NaN;

public class SecCalculator implements ISecCalculator {

    private ICosinusCalculator iCosinusCalculator;

    public SecCalculator(ICosinusCalculator iCosinusCalculator) {
        this.iCosinusCalculator = iCosinusCalculator;
    }

    @Override
    public double sec(double x, double eps) {
        if (x % (0.5 * Math.PI) == 0 && (x / (0.5 * Math.PI)) % 2 != 0) return NaN;
        return 1 / iCosinusCalculator.cos(x, eps);
    }

}
