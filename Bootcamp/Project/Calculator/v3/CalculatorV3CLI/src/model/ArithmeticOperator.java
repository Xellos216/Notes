package model;

import java.util.function.BinaryOperator;

public enum ArithmeticOperator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    });

    private final String symbol;
    private final Operation operation;

    ArithmeticOperator(String symbol, Operation operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public double apply(double a, double b) {
        return operation.operate(a, b);
    }

    public String getSymbol() {
        return symbol;
    }

    // 연산 수행을 위한 함수형 인터페이스
    @FunctionalInterface
    private interface Operation {
        double operate(double a, double b);
    }

    // 기호로 Enum을 찾는 유틸 메서드
    public static ArithmeticOperator fromSymbol(String symbol) {
        for (ArithmeticOperator op : values()) {
            if (op.getSymbol().equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Invalid operator: " + symbol);
    }
}



