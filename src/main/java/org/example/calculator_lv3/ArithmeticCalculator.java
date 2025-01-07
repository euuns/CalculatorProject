package org.example.calculator_lv3;

import java.util.Stack;


public class ArithmeticCalculator <T extends Number> {


    private OperatorType operation;

    // 후위 연산에서 사용할 stack 선언
    private Stack<T> stack = new Stack<>();

    private InputInfo inputInfo;


    // Setter
    public void setOperation(OperatorType operation) { this.operation = operation; }



    public OperatorType getOperation() { return this.operation; }




    public Number calculate(){
        double result = operation.apply(firstNumber, secondNumber);

        if(result == (int)result)
            return (int)result;
        else return result;
    }




    // 연산자가 맞을 경우, enum 클래스인 OperatorType를 통해 연산자 정보 반환 ★
//    public void selectOperator(){
//        if(calculator.getInputOperator().equals(OperatorType.ADD.getSymbol())) {
//            calculator.setOperation(OperatorType.ADD);
//
//        } else if(calculator.getInputOperator().equals(OperatorType.SUBTRACT.getSymbol())) {
//            calculator.setOperation(OperatorType.SUBTRACT);
//
//        } else if(calculator.getInputOperator().equals(OperatorType.MULTIPLY.getSymbol())) {
//            calculator.setOperation(OperatorType.MULTIPLY);
//
//        } else if (calculator.getInputOperator().equals(OperatorType.DIVIDE.getSymbol())) {
//            try{
//                if(calculator.getSecondNumber().equals(0))
//                    throw new WrongSecondNumberException();
//
//                calculator.setOperation(OperatorType.DIVIDE);
//
//            } catch (WrongSecondNumberException e){
//                System.out.println(e.getMessage());
//            }
//        }
//    }

}
