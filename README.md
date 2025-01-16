# 계산기 프로그램 만들기
[TIL 블로그 링크](https://rvrlo.tistory.com/entry/TIL-2-3%EC%A3%BC%EC%B0%A8-%EA%B3%BC%EC%A0%9C-%EA%B3%84%EC%82%B0%EA%B8%B0-%EB%A7%8C%EB%93%A4%EA%B8%B0)

<br>

### Lv 1. 기본 연산을 수행하는 계산기

<br>

#### 1. 양의 정수 2개 입력 받기
#### 2. 사칙연산 기호 입력 받기
#### 3. 입력 받은 정보를 가지고 사칙연산 수행하기
- 연산 오류가 발생하는 경우 해당 오류에 대한 내용을 정제하여 출력
#### 4. 계산을 반복하고, exit가 입력되면 종료

<br><br>

객체 지향 원리를 사용하지 않고, 한 클래스 안에서 변수와 함수로만 구성된 절차적 프로그래밍 방식으로 작성한다.
- inputNumber(): 입력한 숫자 반환
- inputOperator(): 입력한 연산자 반환
- checkOperator(): 사칙연산(+,-,*,/) 입력을 확인
- getResult(): 연산 결과 반환
- arithmeticError(): 수학적 에러(0으로 나누는 경우)가 나오는 경우

<br><br><hr>Mbr>

### Lv 2. 클래스를 활용하는 계산기

<br>

#### 1. main()을 수행하는 클래스와 연산을 수행하는 클래스 분리
#### 2. 연산 클래스에 사칙연산 수행, 결과를 반환하는 메서드 구현
#### 3. 계산 결과를 저장하는 FIFO 자료구조 사용
#### 4. 컬렉션 필드 접근을 위한 Getter/Setter
#### 5. 연산 결과에서 먼저 저장된 데이터를 삭제하는 메서드 구현

<br><br>

Lv 2를 확장해 클래스를 활용하는 계산기를 만든다. 자바 객체를 활용해 클래스를 정의하고, 연산을 수행한다. <br>
확장한 이후에도 수정 전의 기능이 똑같이 동작해야 한다.

<br><br>

<p>- result: Queue&ltInteger&gt</p>
<p>+ calculate(int,int,String): int</p>
<p>+ getFirstResult(): Integer</p>
<p>+ checkOperator(String): Boolean</p>
<p>+ getResult(): String</p>
<p>+ removeResult(): void</p>
<p>+ arithmeticError(): void</p>

<br><br><hr><br>

### Lv 3. Enum, 제네릭, 람다 & 스트림을 이해한 계산

<br>

#### 1. Enum타입을 활용해 연산자 정보 관리
#### 2. 여러 타입을 모두 입력받아 계산할 수 있도록 Generic 사용
#### 3. 저장된 연산 결과를 조회하는 메서드 구현
#### 4. 결과 조회 시, 입력한 값보다 큰 값들을 출력 → Lambda & Stream

<br><br>

레벨 2에서 객체 지향 원칙을 적용하고 자바의 여러 기능을 추가하여 확장시킨다. <br>
기존 요구사항에 더해서 몇가지 기준을 추가하였다.

<br>

##### 1. 계산식 입력은 숫자와 문자 따로 받지 않고, (1.2+24.27)/3 처럼 한 줄로 입력 받는다.
##### 2. 괄호를 사용하여 우선순위 연산을 할 수 있다.
##### 3. 입력한 계산식은 후위표기법 형식으로 변환하여 계산한다.

<br><br>

#### 클래스 다이어그램

![Diagram2](https://github.com/user-attachments/assets/bc807431-7a49-4444-8e24-c4e2b33124aa)


##### <interface> Operation<T, U, R>
- 각 연산자를 구현할 인터페이스

##### <Enum> OperatorType
- 연산자 정보와 그 연산 기능이 들어있는 Enum클래스
- 각 연산자는 Lambda를 적용해 상수 메서드로 활용
- 각 상수 메서드는 인터페이스의 메서드를 오버라이딩한 것

<br>

##### WrongInputException, WrongSecondNumberException
- WrongInputException: InputInfo에서 사용하는 잘못된 입력에 대한 예외 처리
- WrongSecondNumberException: ArithmeticCalculator에서 사용하는 나누기 관련 예외 처리
  
<br>

##### ArithmeticCalculator<T>
- main이 사용하는 유일한 클래스로 연산을 진행
- 객체가 생성되면서 생성자 안에 **InputInfo**를 인스턴스
- **InputInfo** 객체를 이용해 infixToPostfix()에서 Postfix 인스턴스
- **Postfix**를 통해 후위연산된 값을 postfixResult로 받아온다.
- postfixResult를 이용해 calculate()으로 연산 실행
- 연산 결과는 double로 받지만, 만약 그 결과가 정수인 경우 int로 main에 넘겨준다.

<br>

##### CheckValue
- 정규표현식을 사용해 숫자, 연산자, 괄호를 확인하기 위한 클래스

<br>

##### InputInfo,　Postfix,　CalculatorApp
- InputInfo: 입력받은 값을 처리하기 위한 클래스, 입력 정보 처리 기능
- Postfix: 사용자에게 입력받은 중위표기식을 후위표기로 변경
- CalculatorApp: main이 있는 클래스

<br>

단일 책임 원칙 (SRP)를 위해 각 클래스가 기능 별로 분리되도록 생성하였다. <br>
Generic을 사용하려고 했지만, 열거형에서 사용이 불가능해 Number로 대체하였다.

<br><br><br><br>
