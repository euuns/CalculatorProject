package org.example.calculator_lv3;

public class ArithmeticCalculator {

    private Integer firstNumber;
    private Integer secondNumber;
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
    public int getFirstNumber() { return this.firstNumber; }
    public int getSecondNumber() { return this.secondNumber; }

    // 모든 변수에 값이 제대로 들어갔는지 확인
    public Boolean isSelectedNumber() { if(this.selectedOperation == null) return Boolean.FALSE; else return Boolean.TRUE; }
    public Boolean isFirstNumber() { if(this.firstNumber == null) return Boolean.FALSE; else return Boolean.TRUE; }
    public Boolean isSecondNumber() { if(this.secondNumber == null) return Boolean.FALSE; else return Boolean.TRUE; }


    public int calculate(){
        return operation.operate(this.firstNumber, this.secondNumber);
    }

}
