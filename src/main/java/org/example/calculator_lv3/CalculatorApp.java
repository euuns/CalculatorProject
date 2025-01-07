package org.example.calculator_lv3;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator calculator;
        double result;

        while(true){
            int condition = 0;      // 예외 발생 시 다시 입력하기 위해 사용
            System.out.print("계산식 입력: ");
            String question = scanner.nextLine();

            try{
                calculator = new ArithmeticCalculator(question);
                // WrongInputException

                calculator.infixToPostfix();

                result = calculator.calculate();
                // WrongSecondNumberException

                System.out.println("결과: " + calculator.typeSetting(result));

            } catch (Exception e){
                condition =1;
                System.out.println(e.getMessage());
            }

            // 예외가 발생하지 않고 계산이 완료되면 while 탈출
            if(condition == 0)
                break;

        }
    }
}
