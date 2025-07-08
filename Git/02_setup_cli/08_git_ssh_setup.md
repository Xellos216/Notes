# 08_git_ssh_setup.md

## 🔐 목적
GitHub에서 HTTPS 대신 SSH 방식으로 Git 인증을 설정하고 사용하는 방법을 정리합니다.  
(PAT 토큰을 매번 입력하지 않기 위해 SSH 권장)

---

## 🛠 설정 절차

```bash
# 1. SSH 키 생성 (기존 키 있으면 생략 가능)
ssh-keygen -t ed25519 -C "your_email@example.com"

# 2. SSH 공개키 복사
cat ~/.ssh/id_ed25519.pub
```

→ GitHub → Settings → SSH and GPG Keys → New SSH key → 붙여넣기

---

## 🔁 리포지토리 원격 주소 변경

```bash
# 1. 기존 원격을 SSH 형식으로 재설정
git remote set-url origin git@github.com:<USERNAME>/<REPO>.git

# 2. 확인
git remote -v
```

---

## ✅ 사용 예

```bash
git add .
git commit -m "작업 완료"
git push origin main
```

→ SSH는 비밀번호 없이 자동 인증됨.
