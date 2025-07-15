package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;


public class CalculatorView extends JFrame {

    private JLabel resultLabel;

    private List<JButton> numberButtons = new ArrayList<>();
    private JButton dotButton;
    private JButton clearButton;
    private JButton equalButton;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton powerButton;
    private JButton sqrtButton;
    private JButton historyClearButton;


    private JTextArea historyArea;

    public CalculatorView() {
        super("Java Swing Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        resultLabel = new JLabel("0", SwingConstants.RIGHT);
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        resultLabel.setOpaque(true);
        resultLabel.setBackground(Color.WHITE);
        resultLabel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        add(resultLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        addButtons(buttonPanel);
        add(buttonPanel, BorderLayout.CENTER);

        historyArea = new JTextArea(5, 20);
        historyArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(historyArea);
        add(scrollPane, BorderLayout.SOUTH);

        setupNumpadKeyBindings();
        setVisible(true);
    }

    private void addNumberButton(JPanel panel, String text, Font font) {
        JButton btn = new JButton(text);
        btn.setFont(font);
        numberButtons.add(btn);
        panel.add(btn);
    }

    private JButton createButton(String text, Font font, JPanel panel) {
        JButton btn = new JButton(text);
        btn.setFont(font);
        panel.add(btn);
        return btn;
    }

    public JButton getHistoryClearButton() {
        return historyClearButton;
    }

    public void clearHistory() {
        historyArea.setText("");
    }

    private ActionListener backspaceListener;

    public void setBackspaceListener(ActionListener listener) {
        this.backspaceListener = listener;
    }


    private void addButtons(JPanel panel) {
        Font btnFont = new Font("Arial", Font.PLAIN, 18);

        addNumberButton(panel, "7", btnFont);
        addNumberButton(panel, "8", btnFont);
        addNumberButton(panel, "9", btnFont);
        divideButton = createButton("/", btnFont, panel);

        addNumberButton(panel, "4", btnFont);
        addNumberButton(panel, "5", btnFont);
        addNumberButton(panel, "6", btnFont);
        multiplyButton = createButton("*", btnFont, panel);

        addNumberButton(panel, "1", btnFont);
        addNumberButton(panel, "2", btnFont);
        addNumberButton(panel, "3", btnFont);
        subtractButton = createButton("-", btnFont, panel);

        addNumberButton(panel, "0", btnFont);
        dotButton = createButton(".", btnFont, panel);
        equalButton = createButton("=", btnFont, panel);
        addButton = createButton("+", btnFont, panel);

        clearButton = createButton("C", btnFont, panel);
        powerButton = createButton("^", btnFont, panel);
        sqrtButton = createButton("√", btnFont, panel);
        historyClearButton = createButton("HC", btnFont, panel);
    }

    private void setupNumpadKeyBindings() {
        JRootPane root = getRootPane();
        InputMap im = root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = root.getActionMap();

        for (int i = 0; i <= 9; i++) {
            final String key = String.valueOf(i);
            im.put(KeyStroke.getKeyStroke("NUMPAD" + i), "numpad_" + key);
            am.put("numpad_" + key, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (JButton btn : numberButtons) {
                        if (btn.getText().equals(key)) {
                            btn.doClick();
                            break;
                        }
                    }
                }
            });


            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "numpad_backspace");
            am.put("numpad_backspace", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 컨트롤러에 위임은 불가능하므로, View에서 listener 등록 방식 필요
                    if (backspaceListener != null) {
                        backspaceListener.actionPerformed(e);
                    }
                }
            });

        }

        bindKey(im, am, KeyStroke.getKeyStroke("ADD"), addButton);
        bindKey(im, am, KeyStroke.getKeyStroke("SUBTRACT"), subtractButton);
        bindKey(im, am, KeyStroke.getKeyStroke("MULTIPLY"), multiplyButton);
        bindKey(im, am, KeyStroke.getKeyStroke("DIVIDE"), divideButton);
        bindKey(im, am, KeyStroke.getKeyStroke("DECIMAL"), dotButton);

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "numpad_enter");
        am.put("numpad_enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equalButton.doClick();
            }
        });

    }

    private void bindKey(InputMap im, ActionMap am, KeyStroke ks, JButton button) {
        String actionKey = "bind_" + ks.toString();
        im.put(ks, actionKey);
        am.put(actionKey, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.doClick();
            }
        });
    }


    public List<JButton> getNumberButtons() {
        return numberButtons;
    }

    public JButton getDotButton() {
        return dotButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getEqualButton() {
        return equalButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSubtractButton() {
        return subtractButton;
    }

    public JButton getMultiplyButton() {
        return multiplyButton;
    }

    public JButton getDivideButton() {
        return divideButton;
    }

    public JButton getPowerButton() {
        return powerButton;
    }

    public JButton getSqrtButton() {
        return sqrtButton;
    }

    public void updateResultLabel(String text) {
        resultLabel.setText(text);
    }

    public void appendToHistory(String text) {
        historyArea.append(text + "\n");
    }
}

