package mocks;

import interfaces.ICosinusCalculator;

public class CosMock implements ICosinusCalculator {
    @Override
    public double cos(double x, double eps) {
        return Math.cos(x);
    }
}

