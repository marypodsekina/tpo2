package mocks;

import interfaces.ISecCalculator;

public class SecMock implements ISecCalculator {
    @Override
    public double sec(double val, double eps){
        return 1.0/Math.cos(val);
    }
}
