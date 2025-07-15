# 📄 MIT License 정리

MIT License는 오픈소스 라이선스 중에서 가장 간단하고, 자유도가 높은 라이선스입니다.  
아래는 MIT 라이선스의 핵심 개념, 실제 효력 조건, 사용 방법에 대해 정리한 문서입니다.

---

## ✅ MIT License란?

MIT(Massachusetts Institute of Technology)에서 만든 오픈소스 소프트웨어 라이선스로,  
**누구나 자유롭게 사용, 복사, 수정, 배포, 상업적 이용**할 수 있도록 허용합니다.

단, **저작권자 명시와 면책 조항 포함**은 필수입니다.

---

## 🔐 핵심 권한 요약

| 항목 | 허용 여부 | 설명 |
|------|-----------|------|
| ✔ 사용 | 누구나 자유롭게 사용 가능 |
| ✔ 복사 | 원본/수정본 모두 복사 가능 |
| ✔ 수정 | 자유롭게 수정 및 재배포 가능 |
| ✔ 상업적 이용 | 상업용 제품에 포함 가능 |
| ❗ 저작권 고지 | 반드시 원작자 이름과 라이선스 전문을 함께 포함해야 함 |
| ❗ 면책 조항 포함 | 'AS IS' 조건: 오류나 피해에 대해 책임 없음 |

---

## 📌 면책 조항 요약

> 소프트웨어는 "있는 그대로(as-is)" 제공되며,  
> 사용 중 발생하는 문제에 대해 저작자는 **일체의 책임을 지지 않음**을 명시합니다.

---

## 🧾 실사용 시 구성 예시

### 1. `LICENSE` 파일 (필수)

```
MIT License

Copyright (c) 2025 Xellos216

Permission is hereby granted, free of charge, to any person obtaining a copy...
[이하 생략 — 라이선스 전문 포함]
```

※ `https://opensource.org/licenses/MIT`에서 전문을 복사해 사용

---

### 2. `README.md`에 요약 명시 (선택)

```markdown
## 📄 License

This project is licensed under the MIT License.  
See the [LICENSE](./LICENSE) file for details.
```

---

### 3. 각 소스코드 상단 주석에 간단 명시 (권장)

```java
// This file is licensed under the MIT License.
// Copyright (c) 2025 Xellos216
```

---

## ⚠️ "MIT License입니다" 한 줄로 부족한 이유

- 조건이 명시되지 않아 **법적 효력이 불완전**
- 사용자는 정확한 허용 범위를 알 수 없음
- **면책 조항 미포함 시, 법적 분쟁에서 방어력 낮음**

---

## 🧠 MIT License 선택 시 적합한 상황

- 최대한 많은 사용자에게 자유롭게 배포하고 싶은 경우
- 수정, 재배포, 상업적 활용까지 전면 허용하고 싶은 경우
- GPL처럼 소스공개 강제를 원하지 않는 경우

---

## 📎 참고

- 공식 설명: [opensource.org/licenses/MIT](https://opensource.org/licenses/MIT)
- GitHub 추천 오픈소스 라이선스 중 하나
