package mocks;

import interfaces.ILn;

public class LnMock implements ILn {
    @Override
    public double ln(double x, double eps){
        return Math.log(x);
    }
}
