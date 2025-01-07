package org.example.calculator_lv3;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputInfo input = new InputInfo();


        while(true){
            System.out.print("계산 식 입력: ");

            int test = 0;
            String question = scanner.nextLine();
            input.TakeQuestion(question);

            if (!input.checkedInputTrue()) {
                test = 1;
                continue;
            }

            input.selectOperator();
            if (!input.SecondInDivision()) {
                test = 1;
                continue;
            }

            if(test == 0)
                break;
        }

        System.out.println("결과: " + input.getResult());
    }
}
