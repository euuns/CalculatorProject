package org.example.calculator_lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

    private Queue<Integer> result = new LinkedList<>();

    public int calculate(int num1, int num2, String operator){
        int oper_result = 0;
        switch (operator) {
            case "+" -> oper_result = num1 + num2;
            case "-" -> oper_result = num1 - num2;
            case "*" -> oper_result = num1 * num2;
            case "/" -> {
                // 나누기 입력 시 분모가 0이라면
                if(num2 == 0){
                    arithmeticError();
                } else{
                    oper_result = num1 / num2;
                }
            }
        }

        result.add(oper_result);
        return oper_result;
    }

    public Integer getFistResult(){
        return result.peek();
    }

    // 연산자가 제대로 입력됐는지 확인
    public static Boolean checkOperator(String operator){
        return switch (operator) {
            case "+", "-", "*", "/" -> Boolean.FALSE;
            default -> Boolean.TRUE;
        };
    }

    public String getResult(){
        return result.toString();
    }

    public void removeResult(){
        result.poll();
    }

    // ArithmeticException 발생으로 결과를 반환하지 않음
    public static void arithmeticError(){
        System.out.println("0으로 나누는 것은 불가능합니다.");
    }

}
