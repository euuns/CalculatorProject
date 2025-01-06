package org.example.calculator_lv3;

// 더하기 연산 클래스
class AddOperation implements AbstractOperation{
    @Override
    public int operate(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }
}

// 빼기 연산 클래스
class SubstractOperation implements AbstractOperation{
    @Override
    public int operate(int firstNumber, int secondNumber){
        return firstNumber - secondNumber;
    }
}

// 곱하기 연산 클래스
class MultiplyOperation implements AbstractOperation{
    @Override
    public int operate(int firstNumber, int secondNumber){
        return firstNumber * secondNumber;
    }
}

// 나누기 연산 클래스
class DivideOperation implements AbstractOperation{
    @Override
    public int operate(int firstNumber, int secondNumber){
        return firstNumber / secondNumber;
    }
}