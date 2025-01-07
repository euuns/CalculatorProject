package org.example.calculator_lv3;

public enum OperatorType {
    ADD("+", (a,b) -> a+b),
    SUBTRACT("-", (a,b)->a-b),
    MULTIPLY("*", (a,b) -> a*b),
    DIVIDE("/", (a,b)->a/b);


    private final String input;
    private final Operation<Double, Double, Double> func;

    OperatorType(String input, Operation<Double, Double, Double> func){
        this.input = input;
        this.func = func;
    }

    public Double apply(double a, double b){
        return func.apply(a,b);
    }

    public String getSymbol() {
        return input;
    }
}

