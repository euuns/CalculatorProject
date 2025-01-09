package org.example.calculator_lv3;

public enum OperatorType {
    ADD("+", (a,b) -> a+b),
    SUBTRACT("-", (a,b)->a-b),
    MULTIPLY("*", (a,b) -> a*b),
    DIVIDE("/", (a,b)->a/b);


    private final String symbol;
    private final Operation<Double, Double, Double> operation;

    OperatorType(String input, Operation<Double, Double, Double> operation){
        this.symbol = input;
        this.operation = operation;
    }

    public Double apply(double a, double b){
        return operation.apply(a,b);
    }

    public String getSymbol() {
        return symbol;
    }
}

