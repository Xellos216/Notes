# 📘 GitHub CLI 학습 통합 문서 (재정렬 구조)

---

## 🟢 1단계: 기초 이해 및 환경 설정 (입문자용)

> Git과 GitHub의 구조를 처음 접하는 사람에게 적합

### ✅ GitHub CLI 기본 환경

- OS: Ubuntu or Parrot
- 인증 방식: SSH
- CLI 도구: `git`, `gh`

```bash
gh auth login
gh auth status
```

- 기본 Git 명령어 흐름:

```bash
git init
git add .
git commit -m "First commit"
git branch -M main
git remote add origin <URL>
git push -u origin main
```

---

## 🟡 2단계: GitHub 레포지토리 관리

> GitHub CLI로 레포 생성/관리하는 실무 흐름을 익히는 단계

### ✅ GitHub CLI로 레포 생성 및 초기 푸시

```bash
gh repo create <레포명> --public --source=. --remote=origin --push
```

옵션 정리:

| 옵션 | 설명 |
|------|------|
| `--public` | 공개 레포 생성 |
| `--source=.` | 현재 폴더 기준 |
| `--remote=origin` | 원격 origin 연결 |
| `--push` | 자동 푸시 포함 |

### ⚠️ 유의사항
- `gh repo create` 전에 반드시 `git init` 필요
- 기본 브랜치 고정:  
  ```bash
  git config --global init.defaultBranch main
  ```

### 🔴 GitHub CLI로 레포 삭제하기

> 본인 소유의 레포지토리를 CLI로 삭제할 때 주의사항 포함

### ✅ 삭제 명령어

```bash
gh repo delete <OWNER>/<REPO> --yes
````

* 예: `gh repo delete Xellos216/IntroPage --yes`
* `--yes`: 삭제 확인 프롬프트 생략

### ⚠️ 주의사항 및 오류 해결

| 오류                                 | 원인 및 해결 방법                                |
| ---------------------------------- | ----------------------------------------- |
| `HTTP 403: Must have admin rights` | 해당 레포의 **소유자(admin)** 권한이 있어야 함           |
| `needs the "delete_repo" scope`    | GitHub CLI 토큰에 **delete\_repo** 권한이 없어 발생 |

### 🔐 권한 추가 방법

```bash
gh auth refresh -h github.com -s delete_repo
```

* GitHub 인증 페이지 열림 → 로그인하여 권한 부여
* 이후 다시 삭제 명령 실행 가능

### 🔁 흐름 요약

1. 삭제 대상이 **본인 소유**인지 확인 (`gh repo view`)
2. `delete_repo` 권한 추가 (`gh auth refresh`)
3. 삭제 명령 실행 (`gh repo delete ... --yes`)

---

## 🟡 3단계: 협업 흐름과 pull/push 구조

> 팀 협업 중 생기는 변경사항 반영, 충돌 해결 등

### ✅ 팀원이 커밋한 파일 반영

```bash
git pull origin main
```

- `origin`: 원격 저장소
- `main`: 병합 브랜치

### 🔄 동기화 워크플로우

```bash
git branch          # 현재 브랜치 확인
git pull origin main
ls                  # 변경 내용 확인
```

### ⚠️ 충돌 발생 시

```bash
# 충돌 파일 수동 수정 후
git add <파일>
git commit
git push
```

### 📌 협업 팁

- 푸시 전 반드시 `git pull`로 충돌 사전 방지
- VSCode 또는 `git status` 활용 권장

---

## 🟡 4단계: Pull Request (PR) 및 브랜치 전략

> 기능별 브랜치 전략과 PR 생성 실습

```bash
git checkout -b feature/login
git push -u origin feature/login
gh pr create --base main --head feature/login --title "로그인 기능" --body "내용"
gh pr view --web
```

---

## 🟡 5단계: gh CLI 명령어 요약

| 작업 목적 | 명령어 |
|----------|--------|
| 새 레포 생성 + 푸시 | `gh repo create --source=. --push` |
| PR 생성 및 열람 | `gh pr create`, `gh pr view --web` |
| 인증 및 상태 | `gh auth login`, `gh auth status` |
| 기타 | `gh issue list`, `gh repo list`, `gh repo delete` 등

---

## 🔵 6단계: GitHub Pages 배포

> 정적 웹사이트 배포 실습

### ✅ 전체 흐름 요약

1. 레포 생성  
2. `index.html` 포함 후 커밋  
3. GitHub → Settings → Pages → 브랜치 설정  
4. 자동 주소 생성:  
   `https://사용자명.github.io/레포명`

### 🧩 예시

```bash
git clone git@github.com:Xellos216/Team_Intro.git
cp ./Version_04.html ./index.html
git add .
git commit -m "Deploy team page"
git push origin main
```

---

## 🔵 7단계: 개인 vs 조직 레포 비교

| 항목 | 개인(Personal) | 조직(Organization) |
|------|----------------|----------------------|
| 소유자 | 본인 | 팀/회사 |
| 권한 관리 | 수동 초대 | 팀 기반 역할 분리 |
| 삭제 권한 | 본인만 가능 | 관리자만 가능 |
| 사용 목적 | 학습, 포트폴리오 | 협업, 기업 운영 |
| 보안 | 제한적 | 이중 인증, 감사 로그 가능 |

> ✅ 협업 중심이라면 **Organization** 활용 권장

---

## 🟡 8단계: Fork 및 삭제, 소유권 개념

- Fork한 레포도 내 계정에 표시됨
- 내 레포를 누가 Fork해도 **삭제할 수 없음**
- 레포를 삭제해도 로컬 디렉토리는 유지됨
- 삭제 후 `git push` 등은 오류 → 원격 재연결 필요

```bash
git remote set-url origin <새_URL>
```

---

# ✅ 결론

- GitHub CLI를 사용하면 GUI 없이 효율적으로 협업 및 배포 가능
- 실무에서는 `git pull → edit → commit → push`의 흐름을 자동화/루틴화하는 것이 중요
- 프로젝트 단위 협업이라면 **Organization + GitHub Pages** 구조 추천
