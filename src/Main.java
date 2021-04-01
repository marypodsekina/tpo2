import functions.*;
import interfaces.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private static double lower = -333.d;
    private static double upper = 333.d;

    public static double  readInput(Scanner scn, String prompt){

        while(true){
            System.out.println(prompt);
            String line = scn.nextLine();
            try {
                double val = Double.parseDouble(line);
                if(val < lower || val > upper){
                    System.out.println("Try again, bad value");
                    continue;
                }
                return val;
            }
            catch (NumberFormatException e){
                System.out.println("Wrong number");
                continue;
            }
        }
    }
    public static void main(String[] args) {
        boolean stop1 = false;
        ISinusCalculator sin = new SinusCalculator();
        ILn ln = new Ln();
        ICosinusCalculator cos = new CosinusCalculator(sin);
        ICscCalculator csc = new CscCalculator(sin);
        ILog log = new Log(ln);
        ISecCalculator sec = new SecCalculator(cos);
        Scanner read = new Scanner(System.in);
        HashSet<Integer> funcs = new HashSet<>();

        IFunction func = new Function(cos, sin, sec, csc, log);
        while (!stop1) {
            System.out.print("Selected options: ");
            for (Integer k :
                    funcs) {
                System.out.printf("%d ", k);
            }
            System.out.printf("\n");
            System.out.println("Enter functions:\n1.Cos x\n2.Sin x\n3.Cot x\n4.Sec x\n5.Ln x\n6.Log_2 x\n7.Log_5 x\n8.Log_10 x\n9.F(x)\n0.Finish\n\n");
            String readen = read.nextLine();
            try {
                int readenVal = Integer.parseInt(readen);
                if (readenVal > 9 || readenVal < 0) {
                    System.out.println("Bad option\n");
                    continue;
                }
                if (readenVal == 0) break;
                if (funcs.contains(readenVal)) {
                    funcs.remove(readenVal);
                } else {
                    funcs.add(readenVal);
                }
            }
            catch (NumberFormatException e){
                System.out.println("Wrong number");
                continue;
            }
        }
        System.out.print("Selected options: ");
        for (Integer k :
                funcs) {
            System.out.printf("%d ", k);
        }
        double low, up, step;
        double eps;
        low = readInput(read, "Enter low bound:");
        up = readInput(read, "Enter up bound:");
        step = readInput(read, "Enter step:");
        eps = readInput(read, "Enter epsilon:");
        StringBuilder buffer = new StringBuilder();
        for(double val = low; val < up; val += step){
            for (Integer k :
                    funcs) {
                switch (k) {
                    case 1 : buffer.append(String.format("Cos x;%.8f;%.8f\n", val, cos.cos(val, eps)));
                    case 2 : buffer.append(String.format("Sin x;%.8f;%.8f\n", val, sin.sin(val, eps)));
                    case 3 : buffer.append(String.format("Csc x;%.8f;%.8f\n", val, csc.csc(val, eps)));
                    case 4 : buffer.append(String.format("Sec x;%.8f;%.8f\n", val, sec.sec(val, eps)));
                    case 5 : buffer.append(String.format("Ln x;%.8f;%.8f\n", val, ln.ln(val, eps)));
                    case 6 : buffer.append(String.format("Log2 x;%.8f;%.8f\n", val, log.log(val, 2, eps)));
                    case 7 : buffer.append(String.format("Log5 x;%.8f;%.8f\n", val, log.log(val, 5, eps)));
                    case 8 : buffer.append(String.format("Log10 x;%.8f;%.8f\n", val, log.log(val, 10, eps)));
                    case 9 : buffer.append(String.format("F x;%.8f;%.8f\n", val, func.func(val, eps)));
                }
            }
        }
        try {
            FileWriter wr = new FileWriter("output.csv");
            wr.write(buffer.toString());
            wr.flush();
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

