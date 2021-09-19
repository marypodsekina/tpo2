import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static void writeInFile(StringBuilder buffer){
        try {
            FileWriter wr = new FileWriter("output.csv");
            wr.write(buffer.toString());
            wr.flush();
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Options options = new Options();
        Calculator calculator = new Calculator();
        calculator.enterFunctions(scanner);
        calculator.printSelected();
        writeInFile(calculator.getResult(options.enterOptions(scanner)));
    }
}

