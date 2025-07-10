# 🧹 로컬에는 필요하지만 원격(GitHub)에는 올리지 않아야 할 파일 정리법

## ✅ 목적

IntelliJ IDEA의 `.idea/` 폴더처럼 **개발 환경에 필요하지만 GitHub에는 올릴 필요가 없는 파일/폴더**를 정리하는 방법을 설명합니다.

---

## 📁 예시 대상

- `.idea/` (IntelliJ 설정 폴더)
- `*.class` (컴파일 결과물)
- `out/` (빌드 출력 디렉토리)
- `*.log` (로그 파일)
- 기타 개인 설정 파일 등

---

## 🧩 정리 순서 요약

### 1. `.gitignore`에 예외 대상 추가

루트 디렉토리에 `.gitignore` 파일이 없다면 생성 후 다음 내용 추가:

```
**/.idea/
*.class
out/
*.log
```

> `**/.idea/`는 모든 하위 디렉토리의 `.idea/`를 무시함

---

### 2. 이미 Git에 올라간 파일 제거 (로컬은 유지)

`.gitignore`만으로는 **이미 커밋된 파일은 제거되지 않음**  
→ 다음 명령어로 Git 추적에서 제거:

```bash
# 모든 .idea/ 폴더 Git 추적에서 제거
git ls-files | grep '\.idea/' | xargs git rm -r --cached
```

> ❗ 주의: `--cached` 옵션은 **Git에서만 제거하고 로컬에는 남겨둠**

---

### 3. 변경 사항 커밋 및 푸시

```bash
git add .gitignore
git commit -m "Remove .idea folders and update .gitignore"
git push
```

---

## ✅ 정리 완료 확인

```bash
git status
```

또는

```bash
git ls-files | grep '\.idea/'
```

→ 아무 결과도 나오지 않으면 완벽히 정리된 것 ✅

---

## 📌 기타 무시 예시 (선택)

```bash
*.iml
*.log
*.tmp
out/
build/
```

---

## 🕓 정리 일자: 2025-07-10
