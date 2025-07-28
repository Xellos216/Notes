### 📄 InputHandler.java (주석 포함, 예외 메시지·로깅 개선 버전)

```java
package Kiosk.util;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 🖐️ **콘솔 입력 유틸리티**
 * - 정수/문자열 입력 공통 처리, 재시도 루프 내장
 * - 잘못된 입력 → 사용자 친화적 안내 문구 출력 후 재요청
 * - 단위 테스트를 위한 `Scanner` 주입 구조 준비 (현재는 간단히 `static final`)
 */
public class InputHandler {

    /** 표준 입력 스트림 (싱글톤) */
    private static final Scanner scanner = new Scanner(System.in);

    /* ----------------- 정수 입력 ----------------- */

    /**
     * 정수 입력 일반 메서드
     * @param message 프롬프트 메시지
     * @return 입력된 int (예: 메뉴 번호)
     */
    public static int getIntInput(String message) {
        while (true) {
            System.out.print(message);
            try {
                String raw = scanner.nextLine().trim();
                return Integer.parseInt(raw);
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("⚠️ 숫자만 입력해주세요.");
            }
        }
    }

    /**
     * 범위 검증 포함 정수 입력 (min~max)
     */
    public static int getIntInRange(String msg, int min, int max) {
        while (true) {
            int value = getIntInput(msg);
            if (value < min || value > max) {
                System.out.printf("⚠️ %d ~ %d 사이의 숫자를 입력해주세요.%n", min, max);
                continue;
            }
            return value;
        }
    }

    /**
     * 0 이상의 정수만 허용 (음수 방어)
     */
    public static int getPositiveInt(String msg) {
        return getIntInRange(msg, 0, Integer.MAX_VALUE);
    }

    /* ----------------- 문자열 입력 ----------------- */

    /**
     * 공백/빈 문자열 방어 문자열 입력
     * @param message 프롬프트
     * @return 트림된 입력 문자열
     */
    public static String getStringInput(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("⚠️ 내용을 입력해주세요.");
        }
    }
}
```

---

#### ✅ 핵심 변경점·리팩토링 포인트

1. **에러 메시지 이모지 & 구체화**: 사용자의 입력 실수를 명확히 안내.
2. **범용 **`` 재사용 → 중복 제거.
3. 테스트 용이성 고려 → `Scanner` 싱글톤화, 추후 DI 대비.
4. Java 17 `printf` 활용해 동적 범위 메시지 출력.

