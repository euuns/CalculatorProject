package org.example.calculator_lv3;

public enum OperatorType {
    ADD("+"){
        @Override
        public <T extends Number> T apply(T a, T b){
            double result = a.doubleValue() + b.doubleValue();
            return (T) theResulttype(result);
        }
    },

    SUBTRACT("-"){
        @Override
        public <T extends Number> T apply(T a, T b){
            double result = a.doubleValue() - b.doubleValue();
            return (T) theResulttype(result);
        }
    },

    MULTIPLY("*"){
        @Override
        public <T extends Number> T apply(T a, T b){
            double result = a.doubleValue() * b.doubleValue();
            return (T) theResulttype(result);
        }
    },

    DIVIDE("/"){
        @Override
        public <T extends Number> T apply(T a, T b){
            double result = a.doubleValue() / b.doubleValue();
            return (T) theResulttype(result);
        }
    };


    private final String input;

    OperatorType(String input){
        this.input = input;
    }

    public String getSymbol() {
        return input;
    }

    // 제네릭을 사용하여 연산 처리
    public abstract <T extends Number> T apply(T a, T b);


    // 결과에 맞는 데이터타입으로 반환
    private static <T extends Number> Number theResulttype(double result){
        if ((int)result == result){
            return (int) result;
        } else
            return result;
    }
}

