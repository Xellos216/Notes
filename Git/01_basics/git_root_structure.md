# 09_git_root_structure.md

## 🧭 목적
Git은 `.git` 폴더가 있는 디렉토리를 루트로 인식합니다.  
하위 디렉토리(`T_Project/` 등)에서 작업하면 원격에 전체 구조가 반영되지 않을 수 있습니다.

---

## 📌 문제 사례

- `T_Project/` 내부에서 `git init` 또는 `commit` 했을 때
- 원격에는 `T_Project/` 폴더만 보이고 상위 구조는 누락됨
- IntelliJ에서 하위 프로젝트만 관리되는 것처럼 보이는 현상 발생

---

## ✅ 해결 방법

```bash
# 1. 루트 디렉토리로 이동
cd ~/git_repos/Study_notes

# 2. git 루트 확인
git rev-parse --show-toplevel

# 3. 루트에서 전체 커밋 진행
git add .
git commit -m "루트 기준 전체 구조 푸시"
git push origin main --force
```

- 항상 `.git`이 존재하는 루트에서 작업할 것
