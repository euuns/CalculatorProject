package org.example.calculator_lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

// 입력받은 내용만 관리하는 클래스
public class InputInfo {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";


    // 후위 연산에 사용할 List -> 숫자와 연산자로 나뉘어 하나의 String
    public List<String> calculationFormula;


    // 기존 TakeQuestion -> 생성자로 변경
    public InputInfo(String input) throws WrongInputException {
        this.calculationFormula = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        // input.split("") -> 1글자씩 나눈 String[]으로 반환 -> 각 요소를 String i에 대입
        // Pattern.matches 인자로 CharSequence -> String은 CharSequence를 implement -> char가 아닌 String 사용
        for ( String i : input.split("") ) {
            if(checkNumber(i) || (i.equals("."))){  // 숫자거나, . 이라면 sb에 연결
                sb.append(i);
            } else if (checkOperator(i)){           // 연산자일 경우
                if(sb.length() > 0){                // sb에 이미 입력 중인 문자열이 있으면
                    this.calculationFormula.add(sb.toString());
                    sb.setLength(0);                // 다음 숫자 연결을 위해 sb 초기화
                }
                this.calculationFormula.add(i);
            } else{
                throw new WrongInputException(i);
            }
        }
        // 모든 문자열 확인이 끝나고 sb에 남아있는 마지막 숫자까지 저장
        if(sb.length() > 0){
            this.calculationFormula.add(sb.toString());
        }
    }


    // 숫자가 입력되었는지 확인하는 메서드
    private Boolean checkNumber(String inputNumber){
        return Pattern.matches(NUMBER_REG, inputNumber);
    }
    // 연산자가 입력되었는지 확인하는 메서드
    private Boolean checkOperator(String inputOperator){
        return Pattern.matches(OPERATION_REG, inputOperator);
    }



    // 나누기에서 두번째 숫자 확인 ★
//    public Boolean SecondInDivision(){
//        if(calculator.getSecondNumber().equals(0)){
//            return Boolean.FALSE;
//        }
//        return Boolean.TRUE;
//    }


    // 결과 반환 ★
//    public Number getResult(){
//        return calculator.calculate();
//    }

}

