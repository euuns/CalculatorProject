package org.example.calculator_lv2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        String end_check;

        do{
            System.out.print("첫번째 숫자: ");
            int num1 =  Integer.parseInt(sc.nextLine());
            System.out.print("두번째 숫자: ");
            int num2 = Integer.parseInt(sc.nextLine());

            System.out.print("사칙 연산 기호: ");
            String operator = sc.nextLine();

            System.out.println("결과 : " + calculator.calculate(num1, num2, operator));


            // removeResult를 main에서 활용
            System.out.println("처음 등록한 결과를 삭제하시겠습니까? 1을 입력하면 삭제합니다.");
            System.out.println("\t삭제할 수 있는 값: " + calculator.getResult());
            int deleteCheck = Integer.parseInt(sc.nextLine());
            if (deleteCheck == 1){
                calculator.removeResult();
                System.out.println("삭제하였습니다.");
            }


            // 계속 계산한 것인지 확인
            System.out.println("exit를 입력하면 종료합니다. 종료하시겠습니까? ");
            end_check = sc.nextLine();

            // exit가 입력되지 않으면 계속 반복
        }while(! end_check.equals("exit"));
    }
}
