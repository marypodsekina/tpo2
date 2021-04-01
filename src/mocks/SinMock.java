package mocks;

import interfaces.ISinusCalculator;

public class SinMock implements ISinusCalculator {
    @Override
    public double sin(double x, double eps) {
        return Math.sin(x);
    }
}

