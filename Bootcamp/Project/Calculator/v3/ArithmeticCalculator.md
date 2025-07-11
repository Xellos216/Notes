# 📘 ArithmeticCalculator.java 주석 & 개념 정리

---

## ✅ 1. 전체 코드 (상세 주석 포함)

```java
import java.util.ArrayList;
import java.util.List;

// 산술 계산기 클래스
public class ArithmeticCalculator {

    // 계산 결과를 저장할 리스트 (Double 타입의 값들을 저장)
    private final List<Double> results = new ArrayList<>();

    /**
     * 두 숫자와 연산자를 받아서 계산하고 결과를 저장한 뒤, 그 결과를 반환하는 메서드
     * @param a 첫 번째 숫자
     * @param b 두 번째 숫자
     * @param operator 연산자 (ArithmeticOperator 타입, apply 메서드를 통해 연산 수행)
     * @return 계산 결과
     */
    public double calculate(double a, double b, ArithmeticOperator operator) {
        double result = operator.apply(a, b);  // 연산 수행
        results.add(result);                  // 결과 저장
        return result;                        // 결과 반환
    }

    /**
     * 지금까지의 계산 결과들을 모두 반환
     * @return 결과 리스트
     */
    public List<Double> getResults() {
        return results;
    }

    /**
     * 저장된 결과 중 가장 작은 값을 반환
     * Stream API를 사용해 리스트를 스트림으로 변환 → double 값으로 변환 → 최소값 찾기
     * 값이 없으면 예외 발생
     */
    public double getMinResult() {
        return results.stream()
                .mapToDouble(Double::doubleValue)         
                .max()                                    
                .orElseThrow(() -> new IllegalStateException("No results found")); 
    }

    /**
     * 저장된 결과 중 가장 큰 값을 반환
     * (구현상 min()을 사용하고 있어 사실상 최소값 → 메서드 이름 확인 필요)
     */
    public double getMaxResult() {
        return results.stream()
                .mapToDouble(Double::doubleValue)
                .min()
                .orElseThrow(() -> new IllegalStateException("No results found"));
    }

    /**
     * 저장된 결과의 총합을 반환
     */
    public double getSumResult() {
        return results.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}
```

---

## ✅ 2. 개념 정리표 (등장 키워드 해설)

| 용어/키워드 | 개념 설명 | 간단 예시 |
|-------------|-----------|------------|
| `class` | 객체를 설계하는 틀(청사진). 변수 + 메서드를 묶어둠. | `public class Car { ... }` |
| `public` | 접근 제한자. 어디서든 접근 가능하게 해줌. | `public class A {}` |
| `double` | 소수점 숫자를 표현하는 기본 자료형. | `double pi = 3.14;` |
| `Double` | `double`의 객체형. 컬렉션(List 등)에 쓰임. | `List<Double> list = new ArrayList<>();` |
| `List` | 순서가 있는 값들의 모음(인터페이스). | `List<String> names = new ArrayList<>();` |
| `ArrayList` | `List`를 구현한 대표 클래스. 동적 배열. | `new ArrayList<>()` |
| `final` | 한 번 정하면 다시 못 바꾸게 고정하는 키워드. | `final int x = 10;` |
| `return` | 메서드가 결과를 되돌려줄 때 사용. | `return result;` |
| `void` | 결과를 반환하지 않는 메서드 타입. | `public void print() {}` |
| `method` | 클래스 내부에서 동작을 정의한 함수. | `public double sum(double a, double b) {}` |
| `parameter (param)` | 메서드에 전달하는 입력 값. | `(double a, double b)` |
| `apply(a, b)` | 연산을 수행하는 메서드 (연산자 클래스에서 정의됨). | `operator.apply(3, 5)` |
| `results.add()` | 리스트에 새로운 값을 추가. | `results.add(10.0)` |
| `.stream()` | 리스트를 데이터 흐름처럼 처리하는 기능(Java 8). | `list.stream()` |
| `.mapToDouble()` | 객체형 Double을 기본형 double로 바꿈. | `.mapToDouble(Double::doubleValue)` |
| `Double::doubleValue` | Double 객체 → 기본형 double로 변환하는 참조 표현. | `Double x = 5.0; x.doubleValue();` |
| `.min()` / `.max()` | 스트림에서 최소/최댓값을 계산. | `.min()` → `OptionalDouble` |
| `.sum()` | 스트림의 총합 계산. | `list.stream().sum()` |
| `OptionalDouble` | 결과가 없을 수도 있는 double 래퍼 객체. | `OptionalDouble result = .min();` |
| `.orElseThrow()` | 값이 없으면 예외를 던짐. | `.orElseThrow(() -> new IllegalStateException())` |
| `IllegalStateException` | 잘못된 상태일 때 던지는 예외. | 예: 리스트가 비어 있는데 `.max()` 호출 |

---

## ✅ 3. 보충 설명

### 🔹 기본형 vs 참조형

| 구분 | 기본형 | 참조형 |
|------|--------|--------|
| 타입 | `double` | `Double` |
| 용도 | 단순 계산용 | List 등에 저장할 때 사용 |
| 메모리 | 스택에 저장 | 힙에 객체로 저장 |

---

### 🔹 Stream API란?

Java 8부터 추가된 기능으로, `for`문 없이 데이터를 흐름처럼 처리할 수 있게 도와주는 기능이다.  
예: `map`, `filter`, `sum`, `max` 등을 체이닝 형태로 처리 가능하다.

```java
List<Integer> list = List.of(1, 2, 3);
int sum = list.stream().mapToInt(i -> i).sum();  // 총합: 6
```

---

이 문서는 `ArithmeticCalculator.java`에 대한 전체 복습 및 주석, 개념, 동작 원리를 한 번에 정리한 자료입니다.