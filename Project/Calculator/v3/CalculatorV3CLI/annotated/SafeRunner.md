# 📘 SafeRunner.java (예외 안전 Wrapper 유틸리티) 주석 & 개념 정리

---

## ✅ 1. 전체 코드 (상세 주석 포함)

```java
package util;

import java.util.Optional;
import java.util.function.Supplier;

public class SafeRunner {

    // Optional 반환 Supplier 실행 → 값이 없으면 "N/A" 출력
    private static String safeGet(Supplier<Optional<Double>> supplier) {
        try {
            return supplier.get()
                    .map(Object::toString)   // 값이 있으면 문자열로 변환
                    .orElse("N/A");          // 없으면 "N/A" 리턴
        } catch (Exception e) {
            return "Error";                 // 예외 발생 시 "Error"
        }
    }

    // 예외를 던질 수 있는 Supplier 실행 → 실패 시 "Invalid input"
    private static String safeGet(SupplierWithException<Double> supplier) {
        try {
            return String.valueOf(supplier.get());  // 정상 실행 시 문자열로 출력
        } catch (Exception E) {
            return "Invalid input";  // 예외 발생 시 에러 메시지 리턴
        }
    }

    // 예외 던질 수 있는 Supplier 인터페이스 정의
    @FunctionalInterface
    interface SupplierWithException<T> {
        T get() throws Exception;
    }
}
```

---

## ✅ 2. 개념 정리표

| 항목 | 설명 | 예시 |
|------|------|------|
| `Supplier<T>` | 값을 반환하는 함수형 인터페이스 | `() -> 3.0` |
| `Optional<T>` | 값이 없을 수 있는 컨테이너 | `Optional.of(3.0)` |
| `map()` | Optional 내부 값을 변환 | `opt.map(x -> x + 1)` |
| `orElse()` | 값이 없을 경우 기본값 지정 | `opt.orElse("N/A")` |
| `@FunctionalInterface` | 함수형 인터페이스 명시 어노테이션 | `SupplierWithException<T>` |
| `try-catch` | 예외 처리 구조 | `try { ... } catch (...) { ... }` |

---

## ✅ 3. 활용 구조 요약

```text
함수 실행 → Optional<Double> 결과
   ↓
safeGet() 으로 감싸서 실행
   ↓
예외 또는 null 발생 시 "N/A", "Error" 출력
```

---

## ✅ 4. 장점 및 활용 포인트

| 항목 | 설명 |
|------|------|
| UI 출력 안정성 확보 | 계산 중 예외 발생해도 프로그램 종료 없이 메시지 반환 |
| 중복 예외 처리 제거 | `try-catch`를 개별 연산에 반복하지 않아도 됨 |
| 람다와 함께 사용 | `() -> calculator.getMaxResult()` 형태로 호출 |
| 테스트 용이 | 모든 출력이 String으로 고정되어 테스트 간편 |

---

이 문서는 `SafeRunner.java`의 두 가지 예외 안전 실행 방식과 함수형 인터페이스 활용 구조를 주석 및 개념 중심으로 정리한 것입니다.
