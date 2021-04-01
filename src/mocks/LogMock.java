package mocks;

import interfaces.ILog;

public class LogMock implements ILog {
    @Override
    public double log(double x, double a, double eps) {
        return Math.log(x)/Math.log(a);
    }
}
