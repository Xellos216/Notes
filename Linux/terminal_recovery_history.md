# Linux Terminal Recovery & History Management (Bash 기준)

## ✅ 1. 터미널 상태 복구 팁

### 🔧 (1) `reset` 명령
```bash
reset
```
- ANSI 코드 등으로 터미널 화면이 깨졌을 때 초기화
- 입력이 안 될 경우 `Enter` 또는 `Ctrl + J`로 실행

---

### 🔧 (2) 출력 멈춤/재개
- `Ctrl + S`: 터미널 출력 정지 (실수로 눌러 프리징처럼 보일 수 있음)
- `Ctrl + Q`: 출력 재개

---

### 🔧 (3) 문자 인코딩 문제 해결 (로케일 문제)
```bash
export LANG=C
```
- 특수문자나 화면이 깨질 경우 ASCII 환경으로 복구

---

### 🔧 (4) 화면 강제 리셋
```bash
tput reset
```
- `reset`과 유사, `TERM` 환경 기준으로 동작

---

## ✅ 2. 쉘 히스토리 관리 (Bash 기준)

### 📌 기본 히스토리 파일
- `~/.bash_history`에 저장됨 (세션 종료 시 기록됨)

---

### 🔍 (1) 히스토리 조회 및 검색
```bash
history          # 전체 히스토리 목록
history | grep ssh
Ctrl + R         # 실시간 히스토리 검색
```

---

### 🛠 (2) 히스토리 삭제
```bash
history -d N     # N번째 항목 삭제
history -c       # 전체 히스토리 삭제
rm ~/.bash_history  # 파일 자체 삭제 (영구)
```

---

### 🔄 (3) 세션과 히스토리 파일 간 동기화
```bash
history -w       # 현재 세션 → 파일 저장
history -r       # 파일 → 현재 세션 불러오기
```

---

### ⚙ (4) 히스토리 관련 환경변수
`~/.bashrc` 예시:
```bash
export HISTSIZE=5000
export HISTFILESIZE=10000
export HISTCONTROL=ignoredups:ignorespace
```

| 변수명 | 설명 |
|--------|------|
| `HISTFILE` | 저장 파일 경로 지정 |
| `HISTSIZE` | 메모리 내 명령어 개수 |
| `HISTFILESIZE` | 파일 내 저장 용량 |
| `HISTCONTROL` | 중복/공백 무시 등 필터링 설정 |