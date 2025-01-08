package org.example.calculator_lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Postfix {

    private final List<String> formula = new ArrayList<>();


    // 생성자 -> 후위 표기식으로 변경
    public Postfix(List<String> input) {
        Stack<String> stack = new Stack<>();        // 후위로 만들어줄 stack

        // input: 입력받은 중위 표기식
        for (String s : input) {
            CheckValue check = new CheckValue();

            if (check.isNumber(s)) {
                formula.add(s);

                // 괄호일 경우
            } else if(check.isParentheses(s)){
                // 여는 괄호는 stack에 추가
                if(s.equals("(")){
                    stack.push((s));

                // 닫는 괄호가 나오면 stack에서 여는 괄호가 나올 때까지 pop
                } else{
                    while(!stack.peek().equals("(")){
                        formula.add(stack.pop());
                    }
                    // 괄호는 후위표기식에 추가하지 않음. stack에 들어가는 여는 괄호 pop
                    stack.pop();
                }

                // 연산자일 경우 연산자 우선순위 확인 (곱하기, 나누기) > (더하기, 빼기)
            }else if (check.isOperator(s)) {
                // 스택에 값이 있는 상태에서 마지막 연산자가 s보다 우선순위가 크면, pop -> push
                // 더 우선순위가 적은 연산자를 제일 뒤로 보내기 위해 pop을 먼저 하고, s를 push
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(s)) {
                    formula.add(stack.pop());
                }
                stack.push(s);
            }
        }

        // stack에 남은 것 모두 result에 추가
        while(!stack.isEmpty()){
            formula.add(stack.pop());
        }
    }


    public List<String> getFormula() {
        return this.formula;
    }


    // 사칙연산 우선 순위
    private int precedence(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> -1;
        };
    }
}
