package org.example.calculator_lv3;

class WrongInputException extends Exception{
    public WrongInputException(String error){
        super(error + "는 잘못된 입력입니다. 다시 입력해주세요.");
    }
}

class WrongSecondNumberException extends Exception{
    public WrongSecondNumberException(){
        super("0으로 나눌 수 없습니다. 다시 입력해주세요.");
    }
}