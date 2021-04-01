package functions;

import interfaces.ILn;

public class Ln implements ILn {

    @Override
    public double ln(double x, double eps) {
        double arg = (x - 1) / (x + 1);
        double result = arg;
        double member = arg;
        double prev_result;
        int counter = 3;
        do {
            prev_result = member;
            member = Math.pow(arg, counter) / (double)counter;
            result = result + member;
            counter = counter + 2;
        } while (2 * Math.abs(prev_result - member) >= eps);
        return 2 * result;
    }
}

