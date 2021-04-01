package functions;

import interfaces.ICscCalculator;
import interfaces.ISinusCalculator;

import static java.lang.Double.NaN;

public class CscCalculator implements ICscCalculator {


    private ISinusCalculator iSinusCalculator;

    public CscCalculator(ISinusCalculator iSinusCalculator) {
        this.iSinusCalculator = iSinusCalculator;
    }

    @Override
    public double csc(double x, double eps) {
        if ((x % (Math.PI) == 0 && (x / (Math.PI)) % 2 != 0) || (x == 0)) return NaN;
        return 1 / iSinusCalculator.sin(x, eps);
    }
}
