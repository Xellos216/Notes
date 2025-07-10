import java.util.ArrayList;
import java.util.List;

public class CalculatorV2GUI {
    // 연산 결과를 저장하는 컬렉션 (외부 직접 접근 금지)
    private List<Integer> results = new ArrayList<>();

    // 사칙연산 수행 메서드
    public int calculate(int num1, int num2, char operator) {
        int result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Cannot divide by zero");
                }
                break;
            default:
                System.out.println("Unsupported operator");
                return 0;
        }

        // 유효한 연산 결과만 저장
        results.add(result);
        return result;
    }

    // 가장 오래된 연산 결과 삭제
    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0); // FIFO 구조
        } else {
            System.out.println("No results to remove");
        }
    }


    // Getter (App 클래스에서 읽기만 가능)
    public List<Integer> getResults() {
        return new ArrayList<>(results); // 복사본 리턴으로 보호
    }
}


