# 📘 Git 학습 통합 문서 (재정렬 구조)

---

## 🟢 1단계: Git 기본 개념과 환경 설정

### ✅ Git vs GitHub 차이
- Git은 로컬 버전 관리 시스템
- GitHub는 클라우드 기반 원격 저장소 플랫폼

### ✅ Git 루트 디렉토리 개념
- `.git` 폴더가 있는 위치가 루트
- 루트 기준으로 커밋/푸시해야 전체 구조가 보존됨

---

## 🟡 2단계: 커밋과 .gitignore 실전 흐름

### ✅ git add 없이 commit하면 아무 일도 안 일어나는 이유
- `git add`를 해야 staging 영역에 올라가고, 커밋 가능
- `git commit -am`은 이미 추적된 파일만 포함

### ✅ 커밋 메시지 수정
- 최근 커밋: `git commit --amend`
- 과거 커밋: `git rebase -i HEAD~n` 후 `reword`
- 빈 커밋: `git commit --allow-empty`

### ✅ .gitignore 설정과 정리 절차
- `.idea/`, `*.class`, `out/` 등은 `.gitignore`로 제외
- 이미 올라간 파일 제거: `git rm --cached`
- `.gitignore` 기준으로 `git clean -fdX` 가능

---

## 🟡 3단계: Git 명령어 및 clone/pull 개념 정리

### ✅ git clone vs git pull
| 명령어 | 목적 | 설명 |
|--------|------|------|
| `clone` | 처음 복제 | 원격 전체 복사 |
| `pull` | 최신화 | 기존 로컬에 변경 사항 병합 |

### ✅ SSH 인증 오류 및 레포 주소 오타 해결
- 정확한 주소로 `git remote set-url origin ...`
- SSH 인증 확인: `ssh -T git@github.com`

### ✅ 파일 이름 변경 반영
- `git mv` 또는 `git rm + git add`를 사용해야 이름 변경 인식됨

---

## 🟡 4단계: 브랜치 병합 전략 (merge vs rebase)

### ✅ 병합 비교

| 항목 | merge | rebase |
|------|-------|--------|
| 이력 | 분기 구조 | 선형 정렬 |
| 협업 | 안전 | 주의 필요 |
| 명령어 | `git merge` | `git rebase` |

### ✅ 병합 충돌 해결

1. 충돌 파일 확인
2. 수동으로 수정
3. `git add`
4. `git commit` or `git rebase --continue`

---

## 🔵 5단계: GitHub 연동 및 Pages 배포

### ✅ CLI 기반 GitHub 인증

```bash
gh auth login
gh auth status
```

### ✅ GitHub 비공개 레포 생성 및 푸시

```bash
gh repo create Traffix --private --source=. --remote=origin --push
```

### ✅ GitHub Pages 배포

1. 레포 생성 (예: `Xellos216.github.io`)
2. `index.html` 포함 커밋
3. GitHub → Settings → Pages → 브랜치 설정
4. 자동 배포 주소 생성

---

## 🔵 6단계: Git 핵심 명령어 요약 (pull/reset/revert 등)

### ✅ git pull
- 원격 → 로컬 병합
- `git pull --rebase`로 커밋 이력을 선형 정리

### ✅ git reset
| 옵션 | 설명 |
|------|------|
| `--soft` | 커밋만 취소 |
| `--mixed` | staging도 취소 |
| `--hard` | 파일까지 되돌림 (위험) |

### ✅ git revert
- 반대 내용의 새 커밋으로 롤백
- 협업 시 안전

### ✅ git stash
- 작업 중 변경사항 임시 저장

---

## 🧠 보충 개념 및 CLI vs Desktop 비교

- GitHub Desktop은 CLI 유저에게 불필요
- `.idea/`, `*.iml`, `out/` 등의 파일은 항상 무시 처리
- `git push -u origin main` → 이후 push/pull 간소화

---

## ✅ 요약 결론

| 주제 | 요점 |
|------|------|
| Git vs GitHub | 로컬 vs 클라우드 저장소 |
| commit 흐름 | `add → commit → push`, `-am`은 추적된 파일만 |
| 병합 전략 | 협업은 `merge`, 개인은 `rebase` |
| GitHub 연동 | `gh` CLI로 인증 및 Pages 배포 |
| 실전 팁 | `stash`, `reset`, `revert`로 안전하게 되돌리기 |