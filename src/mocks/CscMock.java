package mocks;

import interfaces.ICscCalculator;

public class CscMock implements ICscCalculator {
    @Override
    public double csc(double val, double eps){
        return 1.0/Math.sin(val);
    }
}
