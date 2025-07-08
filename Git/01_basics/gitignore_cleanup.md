# 10_gitignore_cleanup.md

## 🔧 목적
IDE에서 자동 생성되는 불필요한 파일들을 Git 추적 대상에서 제외하고, 안전하게 삭제하는 절차를 정리합니다.

---

## 📁 제외 대상 예시

- `.idea/`: IntelliJ 프로젝트 설정
- `*.iml`: 모듈 정보 파일
- `out/`: Java 빌드 결과물

---

## 📝 .gitignore 설정 예시

```gitignore
# IDE 설정
.idea/
*.iml

# 빌드 아티팩트
out/
```

> 루트 디렉토리에 `.gitignore` 파일을 위치시켜야 전체 프로젝트에 적용됩니다.

---

## 🧹 불필요한 파일 정리 (git clean)

```bash
git clean -fdX
```

- `-f`: 강제
- `-d`: 디렉토리 포함
- `-X`: `.gitignore`에 명시된 파일만 삭제

**주의:** 삭제되므로 꼭 `.gitignore`가 먼저 있어야 안전합니다.
