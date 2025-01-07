package org.example.calculator_lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class ArithmeticCalculator <T extends Number> {


    private OperatorType operation;
    private final InputInfo inputInfo;
    private final CheckValue check = new CheckValue();


    private List<String> postfixResult;


    // 생성자
    // 인자로 사용자가 계산하고 싶은 계산식을 문자열로 받음
    public ArithmeticCalculator(String input) throws WrongInputException {

        // ArithmeticCalculator 인스턴스 동시에 InputInfo 생성자 호출
        inputInfo = new InputInfo(input);
    }


    // Setter & Getter
    public void setOperation(OperatorType operation) { this.operation = operation; }    // 연산할 OperatorType 지정
    public List<String> getPostfixResult() { return  this.postfixResult; }              //후위로 표기된 postfixResult



    // 입력받은 중위표기법 형태를 후위표기법으로 반환
    public void infixToPostfix() {
        Postfix postfix = new Postfix(inputInfo.getCalculationFormula());
        this.postfixResult = postfix.getFormula();
    }


    // 후위로 표기된 postfixResult를 가져와 계산
    // 계산은 stack 이용
    public double calculate() throws WrongSecondNumberException{
        Stack<Double> result = new Stack<>();

        for (String s:postfixResult) {
            if(check.isNumber(s)){
                result.push(Double.parseDouble(s));
            } else{
                selectOperator(s);

                // 먼저 나가는 숫자가 뒤에 있는 수
                // 나누기 연산을 해야 하니 순서 중요
                double y = result.pop();
                double x = result.pop();

                if(operation.name().equals("DIVIDE") && y==0) {
                    throw new WrongSecondNumberException();
                }

                result.push(operation.apply(x, y));
            }
        }
        return result.pop();
    }


    // 타입에 맞게 출력하기 위한 메서드
    // 기존 메서드 변경
    public Number typeSetting(double answer){
        if(answer == (int)answer)
            return (int)answer;
        else return answer;
    }


    // 연산자가 맞을 경우, enum 클래스인 OperatorType를 통해 연산자 정보 반환
    // InputInfo에서 넘어온 메서드
    public void selectOperator(String operator){
        if(operator.equals(OperatorType.ADD.getSymbol())) {
            setOperation(OperatorType.ADD);

        } else if(operator.equals(OperatorType.SUBTRACT.getSymbol())) {
            setOperation(OperatorType.SUBTRACT);

        } else if(operator.equals(OperatorType.MULTIPLY.getSymbol())) {
            setOperation(OperatorType.MULTIPLY);

        } else if (operator.equals(OperatorType.DIVIDE.getSymbol())) {
            setOperation(OperatorType.DIVIDE);
        }
    }

}
