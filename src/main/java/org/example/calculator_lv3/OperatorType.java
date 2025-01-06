package org.example.calculator_lv3;

// enum: 독립된 특수한 클래스로 heap에 저장되며 별개의 주소값을 가짐
// valueOf를 이용해 입력받은 문자열과 일치하는 객체를 반환한다.
enum OperatorType {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String type;
    private OperatorType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
}

