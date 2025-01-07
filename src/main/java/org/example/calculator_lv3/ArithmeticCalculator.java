package org.example.calculator_lv3;

public class ArithmeticCalculator <T extends Number> {

    private double firstNumber;
    private double secondNumber;
    private OperatorType operation;

    private String input;


    // Setter
    public void setFirstNumber(Number firstNumber){ this.firstNumber = (double)firstNumber; }
    public void setSecondNumber(Number secondNumber){
        this.secondNumber = (double) secondNumber;
    }
    public void setOperation(OperatorType operation) { this.operation = operation; }
    public void setInputOperator(String input) { this.input = input; }


    public OperatorType getOperation() { return this.operation; }
    public Number getFirstNumber() { return this.firstNumber; }
    public Number getSecondNumber() { return this.secondNumber; }
    public String getInputOperator() { return this.input; }


    // 모든 변수에 값이 제대로 들어갔는지 확인
    public Boolean isSelectedNumber() { return this.input == null ? Boolean.FALSE :  Boolean.TRUE; }
    public Boolean isFirstNumber() { return this.firstNumber == 0 ? Boolean.FALSE :  Boolean.TRUE; }
    public Boolean isSecondNumber() { return this.secondNumber == 0 ? Boolean.FALSE :  Boolean.TRUE; }


    public Number calculate(){
        double result = operation.apply(firstNumber, secondNumber);

        // 결과에 맞는 데이터 타입으로 반환
        if ((int)result == result){
            return (int) result;
        } else
            return result;
    }

}
