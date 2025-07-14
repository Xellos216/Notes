# Useful Commands for File & Folder Management

정리 및 자동화 작업에 자주 사용하는 CLI 명령어들을 정리한 문서입니다.

---

## 🔍 1. 특정 이름의 파일 일괄 삭제

```bash
find . -type f -name "Java.png" -delete
```

- 현재 디렉토리 이하에서 이름이 `Java.png`인 모든 파일을 찾아 삭제함.

---

## 📄 2. 특정 확장자의 파일 경로 출력

```bash
find . -type f -name "*.md" -print
```

- 현재 디렉토리 이하의 모든 `.md` 파일 경로를 출력함.

---

## 🧹 3. pycache 디렉토리 일괄 삭제

```bash
find . -type d -name "__pycache__" -exec rm -r {} +
```

- Python 실행 시 생기는 `__pycache__` 디렉토리를 찾아 모두 삭제함.

---

## 🗑 4. 폴더 강제 삭제

```bash
rm -rf folder_name/
```

- 지정한 폴더를 강제로 삭제함. **주의해서 사용해야 함**.

---

## 🔀 5. 파일 또는 디렉토리 이동/이름 변경

```bash
mv source target
```

- `source` 파일 또는 폴더를 `target` 위치로 이동하거나 이름을 변경함.

---

## 📂 6. 디렉토리 복사

```bash
cp -r source/ destination/
```

- 디렉토리를 포함한 모든 내용을 재귀적으로 복사함.

---

## 🌳 7. 디렉토리 구조 출력 (2단계까지)

```bash
tree -L 2
```

- 현재 디렉토리부터 2단계까지의 구조를 트리 형식으로 출력함.

---
