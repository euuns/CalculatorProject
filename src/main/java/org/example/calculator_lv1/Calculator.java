package org.example.calculator_lv1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int num1, num2;
        String operator, end_check;
        Queue<Integer> result = new LinkedList<Integer>();

        System.out.println("===계산기===");
        do{
            System.out.print("첫번째 숫자: ");
            num1 =  Integer.parseInt(new Scanner(System.in).next());
            System.out.print("두번째 숫자: ");
            num2 = Integer.parseInt(new Scanner(System.in).next());


            do{
                System.out.print("사칙연산 기호 입력 (+,-,*,/) : ");
                operator = new Scanner(System.in).next();

                if (!(operator.equals("+") || operator.equals("-") ||
                        operator.equals("*") || operator.equals("/"))){
                    System.out.println("다시 입력해주세요. ");
                } else break;
            }while(true);


            switch (operator) {
                case "+" -> result.add(num1 + num2);
                case "-" -> result.add(num1 - num2);
                case "*" -> result.add(num1 * num2);
                case "/" -> result.add(num1 / num2);
            }

            System.out.println("결과 : " + result.poll());

            System.out.println("exit를 입력하면 종료합니다. 종료하시겠습니까? ");
            end_check = new Scanner(System.in).next();
        }while(! end_check.equals("exit"));

    }
}
