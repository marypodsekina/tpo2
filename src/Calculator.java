import functions.*;
import interfaces.*;

import java.util.HashSet;
import java.util.Scanner;

class Calculator {
    private ISinusCalculator sin = new SinusCalculator();
    private ILn ln = new Ln();
    private ICosinusCalculator cos = new CosinusCalculator(sin);
    private ICscCalculator csc = new CscCalculator(sin);
    private ILog log = new Log(ln);
    private ISecCalculator sec = new SecCalculator(cos);

    private HashSet<Integer> functions = new HashSet<>();
    private IFunction func = new Function(cos, sin, sec, csc, log);

    private boolean stop = false;

    void printSelected(){
        System.out.print("Selected options: ");
        for (Integer k : functions) {
            System.out.printf("%d ", k);
        }
    }

    void enterFunctions(Scanner scanner) {
        while (!stop) {
            printSelected();
            System.out.print("\n");
            System.out.println("Enter functions:\n1.Cos x\n2.Sin x\n3.Cot x\n4.Sec x\n5.Ln x\n6.Log_2 x\n7.Log_5 x\n8.Log_10 x\n9.F(x)\n0.Finish\n\n");
            String input = scanner.nextLine();
            try {
                int inputVal = Integer.parseInt(input);
                if (inputVal > 9 || inputVal < 0) {
                    System.out.println("Bad option\n");
                }else if (inputVal == 0) {
                    stop = true;
                }else if (functions.contains(inputVal)) {
                    functions.remove(inputVal);
                }else {
                    functions.add(inputVal);
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong number");
            }
        }
    }

    StringBuilder getResult(Options options){
        StringBuilder result = new StringBuilder();
        double eps = options.getEps();
        for(double val = options.getLow(); val < options.getUp(); val += options.getStep()){
            for (Integer k : functions) {
                switch (k) {
                    case 1 : result.append(String.format("Cos x;%.8f;%.8f\n", val, cos.cos(val, eps)));
                    case 2 : result.append(String.format("Sin x;%.8f;%.8f\n", val, sin.sin(val, eps)));
                    case 3 : result.append(String.format("Csc x;%.8f;%.8f\n", val, csc.csc(val, eps)));
                    case 4 : result.append(String.format("Sec x;%.8f;%.8f\n", val, sec.sec(val, eps)));
                    case 5 : result.append(String.format("Ln x;%.8f;%.8f\n", val, ln.ln(val, eps)));
                    case 6 : result.append(String.format("Log2 x;%.8f;%.8f\n", val, log.log(val, 2, eps)));
                    case 7 : result.append(String.format("Log5 x;%.8f;%.8f\n", val, log.log(val, 5, eps)));
                    case 8 : result.append(String.format("Log10 x;%.8f;%.8f\n", val, log.log(val, 10, eps)));
                    case 9 : result.append(String.format("F x;%.8f;%.8f\n", val, func.func(val, eps)));
                }
            }
        }
        return result;
    }
}
