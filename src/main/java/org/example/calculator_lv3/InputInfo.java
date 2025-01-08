package org.example.calculator_lv3;

import java.util.ArrayList;
import java.util.List;

// 입력받은 내용만 관리하는 클래스
public class InputInfo {

    // 후위 연산에 사용할 List -> 숫자와 연산자로 나뉘어 하나의 String
    public List<String> calculationFormula;


    // 기존 TakeQuestion -> 생성자로 변경
    public InputInfo(String input) throws WrongInputException {
        this.calculationFormula = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        // input.split("") -> 1글자씩 나눈 String[]으로 반환 -> 각 요소를 String i에 대입
        // Pattern.matches 인자로 CharSequence -> String은 CharSequence를 implement -> char가 아닌 String 사용
        for ( String i : input.split("") ) {
            CheckValue check = new CheckValue();
            if (check.isNumber(i) || (i.equals("."))) {  // 숫자거나, . 이라면 sb에 연결
                sb.append(i);

                // 괄호 체크 추가
            } else if (check.isParentheses(i)) {
                if(sb.length() > 0){
                    // 앞에 숫자가 왔으면 계산식에 숫자를 추가하고 sb 초기화
                    this.calculationFormula.add(sb.toString());
                    this.calculationFormula.add(i);     //괄호 추가
                    sb.setLength(0);
                } else{
                    // 괄호 앞에 숫자가 없다면 = 연산자가 있을 경우 -> sb초기화 x 괄호 추가
                    this.calculationFormula.add(i);
                }

                // 연산자일 경우
            } else if (check.isOperator(i)) {
                if (sb.length() > 0) {
                    this.calculationFormula.add(sb.toString());
                    sb.setLength(0);
                }
                this.calculationFormula.add(i);

                // 숫자, 괄호, 연산자 모두 아닐 경우 -> 예외 발생
            } else {
                throw new WrongInputException(i);
            }
        }

        // 모든 문자열 확인이 끝나고 sb에 남아있는 마지막 숫자까지 저장
        if (sb.length() > 0) {
            this.calculationFormula.add(sb.toString());
        }
    }


    public List<String> getCalculationFormula(){
        return this.calculationFormula;
    }

}

