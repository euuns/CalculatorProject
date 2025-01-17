package org.example.calculator_lv3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CalculatorApp {

    static Scanner scanner = new Scanner(System.in);
    static double result;
    static String end = "";
    static Queue<Double> resultsList = new LinkedList<>();


    public static void main(String[] args) {
        ArithmeticCalculator calculator;

        do{
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
                resultsList.add(result);

            } catch (Exception e){
                condition =1;
                System.out.println(e.getMessage());
            }

            System.out.println("exit를 입력하면 종료합니다. 종료하시겠습니까? ");
            end = scanner.nextLine();

        }while(! end.equals("exit"));


        // 입력한 값과 비교하여 더 큰 계산 결과 찾기
        System.out.print("찾을 값을 입력해주세요: ");
        Double findNumber = scanner.nextDouble();

        List<Double> bigNumber = resultsList.stream().filter( number -> number > findNumber ).toList();

        if (bigNumber.isEmpty()){
            System.out.println(findNumber + "보다 큰 수를 찾을 수 없습니다.");
        } else{
            System.out.print(findNumber + "보다 큰 수는 " + bigNumber + "입니다.");
        }

    }
}
