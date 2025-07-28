# 📘 ArithmeticCalculator.java (계산 실행 및 통계 기능 클래스) 주석 & 개념 정리

---

## ✅ 1. 전체 코드 (상세 주석 포함)

```java
package service;

import java.util.ArrayList;
import java.util.List;
import model.ArithmeticOperator;

public class ArithmeticCalculator {
    private final List<Double> results = new ArrayList<>();  // 계산 결과 저장 리스트

    // 계산 수행 메서드
    public double calculate(double a, double b, ArithmeticOperator operator) {
        double result = operator.apply(a, b);  // Enum 기반 연산 수행
        results.add(result);  // 결과 저장
        return result;
    }

    // 결과 전체 리스트 반환
    public List<Double> getResults() {
        return results;
    }

    // 최대값 계산
    public double getMaxResult() {
        return results.stream()
                .mapToDouble(Double::doubleValue)
                .max()
                .orElseThrow(() -> new IllegalStateException("No results found"));
    }

    // 최소값 계산
    public double getMinResult() {
        return results.stream()
                .mapToDouble(Double::doubleValue)
                .min()
                .orElseThrow(() -> new IllegalStateException("No results found"));
    }

    // 전체 합계 계산
    public double getSumResult() {
        return results.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}
```

---

## ✅ 2. 핵심 개념 정리

| 항목 | 설명 | 예시 |
|------|------|------|
| `List<Double>` | 연산 결과 저장용 컬렉션 | `results.add(3.0)` |
| `calculate()` | 연산 수행 및 결과 저장 | `calculate(3, 4, PLUS)` |
| `apply()` | Enum 내부 연산 실행 | `operator.apply(a, b)` |
| `Stream API` | 리스트에 대한 집계 처리 | `.max()`, `.min()`, `.sum()` |
| `orElseThrow()` | 값이 없으면 예외 발생 | 결과가 없을 경우 안전 처리용 |

---

## ✅ 3. 구조 흐름 요약

```text
입력 (a, b, operator)
   ↓
operator.apply(a, b)
   ↓
→ 결과 저장
   ↓
→ 결과 반환
```

---

## ✅ 4. 확장 및 개선 포인트

| 항목 | 설명 |
|------|------|
| 통계 기능 내장 | 별도 리스트 없이 내부에서 max/min/sum 처리 가능 |
| 예외 처리 내장 | 빈 리스트일 경우 `IllegalStateException` 발생 |
| 외부 접근 제한 | `results`는 getter만 존재, 외부 수정 불가 |
| 기능 확장 여지 | 향후 평균값, 표준편차 등 추가 통계도 손쉬움 |

---

이 문서는 `ArithmeticCalculator.java`가 담당하는 연산 수행 및 결과 저장, 그리고 통계 집계 기능을 주석과 개념 중심으로 정리한 것입니다.
