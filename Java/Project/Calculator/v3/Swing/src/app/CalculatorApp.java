package app;

import view.CalculatorView;
import controller.CalculatorController;

public class CalculatorApp {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            CalculatorView view = new CalculatorView();
            new CalculatorController(view);
        });
    }
}
