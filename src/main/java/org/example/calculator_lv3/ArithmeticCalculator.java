package org.example.calculator_lv3;

public class ArithmeticCalculator <T extends Number> {

    private T firstNumber;
    private T secondNumber;
    private OperatorType operation;

    private String input;


    // Setter
    public void setFirstNumber(T firstNumber){
        this.firstNumber = firstNumber;
    }
    public void setSecondNumber(T secondNumber){
        this.secondNumber = secondNumber;
    }
    public void setOperation(OperatorType operation) { this.operation = operation; }
    public void setInputOperator(String input) { this.input = input; }


    public OperatorType getOperation() { return this.operation; }
    public T getFirstNumber() { return this.firstNumber; }
    public T getSecondNumber() { return this.secondNumber; }
    public String getInputOperator() { return this.input; }


    // 모든 변수에 값이 제대로 들어갔는지 확인
    public Boolean isSelectedNumber() { return this.input == null ? Boolean.FALSE :  Boolean.TRUE; }
    public Boolean isFirstNumber() { return this.firstNumber == null ? Boolean.FALSE :  Boolean.TRUE; }
    public Boolean isSecondNumber() { return this.secondNumber == null ? Boolean.FALSE :  Boolean.TRUE; }


    public T calculate(){
        return operation.apply(this.firstNumber, this.secondNumber);
    }

}
