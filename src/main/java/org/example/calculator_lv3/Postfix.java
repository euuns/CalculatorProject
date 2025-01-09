package org.example.calculator_lv3;

import java.util.*;

public class Postfix {

    private final List<String> formula = new ArrayList<>();


    // 생성자 -> 후위 표기식으로 변경
    public Postfix(List<String> input) {
        Deque<String> toPost = new LinkedList<>();        // 후위로 만들어줄 deque

        // input: 입력받은 중위 표기식
        for (String s : input) {
            CheckValue check = new CheckValue();

            if (check.isNumber(s)) {
                formula.add(s);

                // 괄호일 경우
            } else if(check.isParentheses(s)){
                // 여는 괄호는 deque에 추가
                if(s.equals("(")){
                    toPost.addLast((s));

                // 닫는 괄호가 나오면 deque에서 여는 괄호가 나올 때까지 pop
                } else{
                    while(!toPost.peekLast().equals("(")){
                        formula.add(toPost.removeLast());
                    }
                    // 괄호는 후위표기식에 추가하지 않음. deque에 들어가는 여는 괄호 pop
                    toPost.removeLast();
                }

                // 연산자일 경우 연산자 우선순위 확인 (곱하기, 나누기) > (더하기, 빼기)
            }else if (check.isOperator(s)) {
                // 스택에 값이 있는 상태에서 마지막 연산자가 s보다 우선순위가 크면, pop -> push
                // 더 우선순위가 적은 연산자를 제일 뒤로 보내기 위해 pop을 먼저 하고, s를 push
                while (!toPost.isEmpty() && precedence(toPost.peekLast()) >= precedence(s)) {
                    formula.add(toPost.removeLast());
                }
                toPost.addLast(s);
            }
        }

        // deque에 남은 것 모두 result에 추가
        while(!toPost.isEmpty()){
            formula.add(toPost.removeLast());
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
