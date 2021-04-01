package functions;

import interfaces.ICosinusCalculator;
import interfaces.ISinusCalculator;

public class CosinusCalculator implements ICosinusCalculator {

    private ISinusCalculator iSinusCalculator;

    public CosinusCalculator(ISinusCalculator iSinusCalculator) {
        this.iSinusCalculator = iSinusCalculator;
    }

    @Override
    public double cos(double x, double eps) {
        return iSinusCalculator.sin(x + (Math.PI / 2), eps);
    }
}