package org.example.calculator_lv1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int num1, num2;
        String operator, end_check;

        System.out.println("===계산기===");
        do{
            System.out.print("첫번째 숫자: ");
            num1 =  inputNumber();
            System.out.print("두번째 숫자: ");
            num2 = inputNumber();


            do{
                operator = inputOperator();

                // 입력받은 연산자가 +,-,*,/ 인지 체크
                if (checkOperator(operator)){
                    System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
                }
            }while(checkOperator(operator));

            // 연산 결과 출력
            System.out.println("결과 : " + getResult(num1, num2, operator));

            // 계속 계산한 것인지 확인
            System.out.println("exit를 입력하면 종료합니다. 종료하시겠습니까? ");
            end_check = new Scanner(System.in).next();

        // exit가 입력되지 않으면 계속 반복
        }while(! end_check.equals("exit"));
    }


    // 숫자 입력 메서드
    public static int inputNumber(){
        return Integer.parseInt(new Scanner(System.in).next());
    }

    // 연산자 입력 메서드
    public static String inputOperator(){
        System.out.print("사칙 연산 기호를 입력해주세요 (+, -, *, /) : ");
        return new Scanner(System.in).next();
    }

    // 연산자가 제대로 입력됐는지 확인
    public static Boolean checkOperator(String operator){
        return switch (operator) {
            case "+", "-", "*", "/" -> Boolean.FALSE;
            default -> Boolean.TRUE;
        };
    }

    // 연산 결과를 가져오는 메서드
    public static int getResult(int num1, int num2, String operator){
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
        };
        return oper_result;
    }

    // ArithmeticException 발생으로 결과를 반환하지 않음
    public static void arithmeticError(){
        System.out.println("0으로 나누는 것은 불가능합니다.");
    }
}
