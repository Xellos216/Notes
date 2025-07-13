# 07_git_remote_reset.md

## 🔧 목적
로컬 Git 디렉토리 기준으로 원격 GitHub 리포지토리를 덮어씌우는 절차를 정리합니다.  
(예: IntelliJ에서 자동으로 잘못 올라간 파일을 덮어쓰기할 때)

---

## ⚙️ 전체 순서

```bash
# 1. 원격 레포 주소 확인 (기존은 tree/main/... 식으로 잘못된 경우가 많음)
git remote -v

# 2. 원격 주소를 정확히 재설정 (리포지토리 전체 주소여야 함)
git remote set-url origin https://github.com/<USERNAME>/<REPO>.git

# 3. 강제 push로 원격 내용을 덮어쓰기
git push origin main --force
```

---

## ✅ 체크포인트

- `tree/main/...` 같은 경로는 Git 원격 주소로 사용할 수 없음
- 반드시 전체 `.git` 단위 경로 (`.git`이 있는 레포 루트)여야 함
- 강제 푸시 전에 로컬 상태를 백업해두는 것을 권장
- commit 전이면 git reset으로 staging 취소 가능
