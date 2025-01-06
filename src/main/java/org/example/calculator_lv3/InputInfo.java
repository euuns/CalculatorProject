package org.example.calculator_lv3;

import java.util.regex.Pattern;

public class InputInfo {

    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    private final ArithmeticCalculator calculator = new ArithmeticCalculator();


    // 숫자가 입력되었는지 확인하는 메서드
    private Boolean checkNumber(String inputNumber){
        return Pattern.matches(NUMBER_REG, inputNumber);
    }
    // 연산자가 입력되었는지 확인하는 메서드
    private Boolean checkOperator(String inputOperator){
        return Pattern.matches(OPERATION_REG, inputOperator);
    }


    // 문제를 숫자와 연산자로 나누어서 대입
    public InputInfo TakeQuestion(String question){
        String first = "";
        String second = "";
        int OPERATOR = 0;

        StringBuilder stringBuilder = new StringBuilder();

        for (String i:question.split("")) {
            if (checkNumber(i)){
                if (OPERATOR == 0){
                    stringBuilder.append(first).append(i);
                } else{
                    stringBuilder.append(second).append(i);
                }
            } else if (checkOperator(i)) {
                OPERATOR = 1;
                first = stringBuilder.toString();
                calculator.setFirstNumber(Integer.parseInt(first));

                stringBuilder.replace(0, first.length(), "");

                calculator.setSelectedOperation(i);
            }
        }
        calculator.setSecondNumber(Integer.parseInt(stringBuilder.toString()));

        return InputInfo.this;
    }


    // 연산자가 맞을 경우, enum 클래스인 OperatorType를 통해 연산자 정보 반환
    public void selectOperator(){
        if(calculator.getSelectedOperation().equals(OperatorType.ADD.getType())) {
            calculator.setOperation(new AddOperation());
        } else if (calculator.getSelectedOperation().equals(OperatorType.SUBTRACT.getType())) {
            calculator.setOperation(new SubstractOperation());
        } else if (calculator.getSelectedOperation().equals(OperatorType.MULTIPLY.getType())) {
            calculator.setOperation(new MultiplyOperation());
        } else if (calculator.getSelectedOperation().equals(OperatorType.DIVIDE.getType())) {
            calculator.setOperation(new DivideOperation());
        }
    }

    // 나누기에서 두번째 숫자 확인
    public Boolean SecondInDivision(){
        if(calculator.getSecondNumber() == 0){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public int getResult(){
        return calculator.calculate();
    }

}

