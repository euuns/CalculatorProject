package org.example.calculator_lv3;

import java.util.Scanner;

public class ArithmeticClaculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputOperator = scanner.nextLine();

        for (OperatorType operator:OperatorType.values()) {
            if (inputOperator.equals(operator.getType())){
                System.out.println(operator.getType()+"을 입력했습니다.");
                System.out.println(operator.name()+"과 같습니다.");
            }
        }
    }
}
