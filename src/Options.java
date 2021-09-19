import java.util.Scanner;

class Options {

    private double low, up, step, eps;

    private double readInput(Scanner scn, String prompt) {
        double lower = -333.d;
        double upper = 333.d;
        while (true) {
            System.out.println(prompt);
            String line = scn.nextLine();
            try {
                double val = Double.parseDouble(line);
                if (val < lower || val > upper) {
                    System.out.println("Try again, bad value");
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Wrong number");
            }
        }
    }

    Options enterOptions(Scanner scanner){
        this.setLow(readInput(scanner, "\nEnter low bound:"));
        this.setUp(readInput(scanner, "Enter up bound:"));
        this.setStep(readInput(scanner, "Enter step:"));
        this.setEps(readInput(scanner, "Enter epsilon:"));
        return this;
    }

    double getEps() {
        return eps;
    }

    double getLow() {
        return low;
    }

    double getStep() {
        return step;
    }

    double getUp() {
        return up;
    }

    private void setEps(double eps) {
        this.eps = eps;
    }

    private void setStep(double step) {
        this.step = step;
    }

    private void setLow(double low) {
        this.low = low;
    }

    private void setUp(double up) {
        this.up = up;
    }

}
