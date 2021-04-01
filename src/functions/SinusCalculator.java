package functions;

import interfaces.ISinusCalculator;


public class SinusCalculator implements ISinusCalculator {

    @Override
    public double sin(double x, double eps) {
        double factorial = 3 * 2;
        double prev_result = x;
        double result = x - (Math.pow(x, 3) / factorial);
        double next;
        int count = 3;
        while (Math.abs(prev_result - result) >= eps) {
            prev_result = result;
            count = count + 2;
            factorial = factorial * ((count) * (count - 1));
            next = Math.pow(x, count) / factorial;
            if (count % 4 == 3) {
                next = next * (-1);

            }
            result = result + next;
        }
        return result;
    }
}