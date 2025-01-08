package org.example.calculator_lv3;

import java.util.regex.Pattern;

public class CheckValue {

    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]+(.[0-9]+)?$";
    private static final String PARENTHESES_REG = "[()]";


    // 숫자가 입력되었는지 확인하는 메서드
    public Boolean isNumber(String inputNumber){
        return Pattern.matches(NUMBER_REG, inputNumber);
    }
    // 연산자가 입력되었는지 확인하는 메서드
    public Boolean isOperator(String inputOperator){
        return Pattern.matches(OPERATION_REG, inputOperator);
    }
    public Boolean isParentheses(String inputString) { return Pattern.matches(PARENTHESES_REG, inputString); }


}
