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
    // 제너릭으로 변환 시 해당 메서드 수정 필요 ★★★
    public InputInfo TakeQuestion(String question){
        String FIRST = "";
        String SECOND = "";
        int OPERATOR = 0;

        StringBuilder stringBuilder = new StringBuilder();

        try{
            for (String i:question.split("")) {
                if (checkNumber(i)) {
                    if(OPERATOR == 0){
                        stringBuilder.append(FIRST).append(i); }
                    else{
                        stringBuilder.append(SECOND).append(i); }

                } else if (checkOperator(i)) {
                    OPERATOR = 1;
                    // 첫번째 숫자(String)을 숫자로 변환하여 저장
                    FIRST = stringBuilder.toString();
                    calculator.setFirstNumber((Number) Double.parseDouble(FIRST));

                    // 두번째 숫자 입력을 위한 초기화
                    stringBuilder.replace(0, FIRST.length(), "");

                    // 연산자 저장
                    calculator.setInputOperator(i);

                } else
                    // 숫자와 연산자가 아닌 다른 문자가 입력된 경우
                    throw new WrongInputException(i);
            }
            SECOND = stringBuilder.toString();
            calculator.setSecondNumber((Number) Double.parseDouble(SECOND));

        } catch (WrongInputException e){
            System.out.println(e.getMessage());
        }

        return InputInfo.this;
    }


    // 모든 변수에 값이 들어가지 않았을 경우, FALSE를 반환한다.
    public Boolean checkedInputTrue(){
        if(calculator.isSelectedNumber() && calculator.isFirstNumber() && calculator.isSecondNumber()){
            return Boolean.TRUE;
        }
        else return Boolean.FALSE;
    }


    // 연산자가 맞을 경우, enum 클래스인 OperatorType를 통해 연산자 정보 반환
    public void selectOperator(){
        if(calculator.getInputOperator().equals(OperatorType.ADD.getSymbol())) {
            calculator.setOperation(OperatorType.ADD);

        } else if(calculator.getInputOperator().equals(OperatorType.SUBTRACT.getSymbol())) {
            calculator.setOperation(OperatorType.SUBTRACT);

        } else if(calculator.getInputOperator().equals(OperatorType.MULTIPLY.getSymbol())) {
            calculator.setOperation(OperatorType.MULTIPLY);

        } else if (calculator.getInputOperator().equals(OperatorType.DIVIDE.getSymbol())) {
            try{
                if(calculator.getSecondNumber().equals(0))
                    throw new WrongSecondNumberException();

                calculator.setOperation(OperatorType.DIVIDE);

            } catch (WrongSecondNumberException e){
                System.out.println(e.getMessage());
            }
        }
    }


    // 나누기에서 두번째 숫자 확인
    public Boolean SecondInDivision(){
        if(calculator.getSecondNumber().equals(0)){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }


    // 결과 반환
    public Number getResult(){
        return calculator.calculate();
    }

    public OperatorType test(){
        return calculator.getOperation();
    }

}

