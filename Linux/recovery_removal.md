# 🛠 Linux Recovery & Manual Removal Guide

> Bash 기반 터미널 복구, 히스토리 관리, 그리고 패키지 관리 도구에 잡히지 않는 수동 설치 프로그램 제거 실습까지 포함한 실전 해결 가이드입니다.
> `초급 문제 해결`부터 `서비스 제거 실습`까지 단계별로 구성되어 있습니다.

## 🟢 1. 터미널 복구 & Bash 히스토리 관리 (기초+실전)
터미널이 깨지거나 멈췄을 때의 복구법과 히스토리 관리 명령어들을 실전 기준으로 정리합니다.

### 🔹 Terminal Recovery History
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

---

## 🔴 2. 수동 설치 프로그램 완전 제거 실습 (심화)
GUI에서 보이지 않고 시스템에 숨어 실행되는 `nProtect` 보안 프로그램을 완전히 제거한 실습을 기록합니다.

### 🔹 NProtect Removal Practice
# Ubuntu 수동 설치 프로그램 제거 실습 (`nProtect nosintgdmn` 예제)

- 날짜: 2025-06-22
- 환경: Ubuntu 기반 데스크탑 (MATE)
- 대상 프로그램: `nProtect Online Security for Linux`
- 설치 경로: `/usr/local/nProtect`
- 실행 서비스: `nosintgdmn.service`

---

## ✅ 문제 상황

- `nProtect` 키보드 보안 프로그램이 설치되어 있었으나,
  - GUI (제어판, Synaptic 등)에서 보이지 않음
  - 자동 실행되며, 백그라운드 프로세스로 상주
- 표준 패키지 관리 도구(apt/snap/flatpak)로 설치되지 않음

---

## 🔍 진단 과정

```bash
# 서비스 상태 확인
systemctl list-units | grep -i nprotect

# 프로세스/파일 위치 탐색
whereis nosintgdmn
sudo find / -name "*nosintgdmn*" 2>/dev/null
```

---

## 🧹 제거 단계 요약

1. 서비스 중지 및 비활성화
```bash
sudo systemctl stop nosintgdmn.service
sudo systemctl disable nosintgdmn.service
```

2. 프로그램 디렉토리 삭제
```bash
sudo rm -rf "/usr/local/nProtect"
```

3. systemd 서비스 파일 제거
```bash
sudo rm -f /usr/lib/systemd/system/nosintgdmn.service
```

4. init.d 및 rc.d 등록 스크립트 제거
```bash
sudo rm -f /etc/init.d/nosintgdmn
sudo rm -f /etc/rc*.d/K01nosintgdmn
```

5. systemd 데몬 재로딩
```bash
sudo systemctl daemon-reload
```

---

## 💡 학습 포인트

- 대부분의 리눅스 사용자는 명령어를 외우기보다 시스템 구조를 이해하고 `패턴`으로 해결
- GUI에 보이지 않는 프로그램은 `/opt`, `/usr/local`, `systemd/init.d` 구조를 의심
- 실습은 보고서처럼 기록하면 반복 학습보다 효율적

---

## ✅ 참고 명령어 정리

```bash
ps aux | grep -i [keyword]
whereis [명령어]
dpkg -l | grep [패키지명]
systemctl list-units | grep -i [서비스명]
find / -name "[이름]" 2>/dev/null
```