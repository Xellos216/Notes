import service.ArithmeticCalculator;
import model.ArithmeticOperator;
import ui.CalculatorUI;
import util.SafeRunner;

public class Main {
    public static final boolean DEBUG = true;

    public static void main(String[] args) {
        CalculatorUI ui = new CalculatorUI();
        ArithmeticCalculator calculator = new ArithmeticCalculator();

        ui.printWelcome();

        while (true) {
            Double a = ui.readNumber("Enter first number (or 'exit'):");
            if (a == null) break;

            ArithmeticOperator op = ui.readOperator("Enter operator (+, -, *. /):");
            if (op == null) continue;

            Double b = ui.readNumber("Enter second number (or 'exit):");
            if (b == null) break;

            try {
                double result = calculator.calculate(a, b, op);
                ui.printResult(result);

                if (DEBUG) {
                    ui.printDebug(calculator);
                }
            }catch (Exception e) {
                ui.printError("Calculation error: " + e.getMessage());
            }

            ui.printHistory(calculator.getResults());
        }

        ui.printExit();
    }
}
