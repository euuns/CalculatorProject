package org.example.calculator_lv3;

public class ArithmeticCalculator {

    private int firstNumber;
    private int secondNumber;
    private String selectedOperation;

    private AbstractOperation operation;


    // Setter
    public void setSelectedOperation(String operation){
        this.selectedOperation = operation;
    }
    public void setFirstNumber(int firstNumber){
        this.firstNumber = firstNumber;
    }
    public void setSecondNumber(int secondNumber){
        this.secondNumber = secondNumber;
    }
    public void setOperation(AbstractOperation operation) { this.operation =operation; }


    public String getSelectedOperation() { return this.selectedOperation; }
    public int getSecondNumber() { return this.secondNumber; }


    public int calculate(){
        return operation.operate(this.firstNumber, this.secondNumber);
    }

}
