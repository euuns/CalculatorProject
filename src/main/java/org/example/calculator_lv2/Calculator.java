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
            case "/" -> oper_result = num1 / num2;
        }

        result.add(oper_result);
        return oper_result;
    }

    public Integer getResult(){
        return result.peek();
    }

    public void setResult(int updateValue){
        result.add(updateValue);
    }

    public void removeResult(){
        result.poll();
    }
}
