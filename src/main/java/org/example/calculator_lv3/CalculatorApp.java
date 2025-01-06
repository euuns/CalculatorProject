package org.example.calculator_lv3;

import java.util.Arrays;
import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String question = scanner.nextLine();

        InputInfo input = new InputInfo();
        input.TakeQuestion(question);
        input.selectOperator();

        System.out.println(input.getResult());
    }
}
