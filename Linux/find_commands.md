# 파일 관리용 `find` 명령어 정리

이 문서는 현재 디렉토리 및 하위 디렉토리에서 자주 사용하는 `find` 명령어 패턴들을 정리한 것입니다. 파일 필터링, 탐색, 정리에 유용합니다.

---

## ✅ 파일 검색 – 기본 패턴

### 1. 특정 확장자의 파일 찾기
```bash
find . -type f -name "*.md"
```

### 2. 대소문자 구분 없이 `.md` 파일 찾기
```bash
find . -type f -iname "*.md"
```

### 3. 특정 이름의 파일 찾기
```bash
find . -type f -name "README.md"
```

### 4. 특정 이름을 제외한 `.md` 파일 찾기
```bash
find . -type f -name "*.md" ! -name "README.md" ! -name "Explanations.md"
```

---

## ✅ 파일 삭제 – `-delete` 사용

### 5. `.log` 확장자 파일 모두 삭제
```bash
find . -type f -name "*.log" -delete
```

### 6. 특정 이름의 파일 삭제
```bash
find . -type f -name "Thumbs.db" -delete
```

> ⚠️ 삭제 전에 `-print`로 먼저 확인하는 것을 권장합니다.

---

## ✅ 디렉토리 관련 명령어

### 7. 특정 이름의 디렉토리 찾기
```bash
find . -type d -name ".git"
```

### 8. `node_modules` 디렉토리 삭제
```bash
find . -type d -name "node_modules" -exec rm -rf {} +
```

---

## ✅ 파일 내용 기반 검색 – `grep` 사용

### 9. 특정 단어를 포함한 `.md` 파일 찾기
```bash
grep -rl "TODO" --include="*.md" .
```

### 10. `README`, `readme` 등 다양한 형태 매칭
```bash
find . -type f -regex ".*/[Rr][Ee][Aa][Dd][Mm][Ee]\.md"
```

---

## ✅ 수정 시간, 크기 조건 검색

### 11. 최근 3일 이내 수정된 `.md` 파일
```bash
find . -type f -name "*.md" -mtime -3
```

### 12. 10MB 이상인 `.log` 파일
```bash
find . -type f -name "*.log" -size +10M
```

---

## ✅ 복합 조건 예시

### 13. 규칙에 맞지 않는 `.md` 파일 찾기
```bash
find . -type f -name "*.md" ! -name "README.md" ! -name "Explanations.md"
```

---

## 📝 팁: 삭제 전 미리 확인

```bash
find ... -print             # 삭제 전에 파일 목록만 확인
find ... -ok rm {} \;     # 삭제 전마다 확인 메시지 출력
```
