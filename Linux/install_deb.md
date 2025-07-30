# 📦 리눅스 `.deb` 설치 가이드 (Ubuntu/Debian 계열)

이 문서는 `.deb` 형식으로 배포되는 소프트웨어를 Ubuntu 또는 Debian 계열 시스템에서 설치하는 일반적인 방법을 설명합니다.

---

## ✅ `.deb` 파일이란?

- Debian 계열 리눅스(Ubuntu, Mint 등)에서 사용하는 설치 패키지
- Windows의 `.exe`, macOS의 `.dmg`에 해당
- 보통 파일명에 아키텍처(`amd64`, `arm64`) 정보가 포함됨
  - 예: `example_app_amd64.deb`

---

## 🧾 설치 절차

### 1. `.deb` 파일 다운로드

공식 웹사이트나 검증된 저장소에서 `.deb` 파일을 내려받습니다.

> 예시 파일명: `example_app_amd64.deb`

---

### 2. 다운로드 폴더로 이동

```bash
cd ~/Downloads
```

---

### 3. 설치 실행

```bash
sudo dpkg -i example_app_amd64.deb
```

> `dpkg`는 `.deb` 패키지를 설치하는 기본 도구입니다.

---

### 4. 의존성 오류 해결 (필요한 경우)

설치 중 에러가 발생했다면 다음 명령어로 부족한 패키지를 자동 설치합니다:

```bash
sudo apt-get install -f
```

---

## ▶️ 실행

설치된 프로그램은 다음 중 하나로 실행할 수 있습니다:

- 터미널에서 명령어 입력 (`example_app`)
- 애플리케이션 메뉴에서 검색

---

## 🔁 제거 (언인스톨)

```bash
sudo apt remove example_app
```

> 설치한 패키지명을 확인하려면 `dpkg -l | grep example` 사용

---

## 💡 보너스: gdebi를 이용한 편리한 설치

`gdebi`는 `.deb` 파일 설치 시 **의존성까지 자동 처리**하는 도구입니다.

### 설치

```bash
sudo apt install gdebi
```

### 사용

```bash
sudo gdebi example_app_amd64.deb
```

---

## 📌 요약 명령어

| 작업 | 명령어 |
|------|--------|
| 설치 | `sudo dpkg -i 파일명.deb` |
| 의존성 해결 | `sudo apt-get install -f` |
| 제거 | `sudo apt remove 패키지명` |
| gdebi 설치 | `sudo apt install gdebi` |
| gdebi 설치 실행 | `sudo gdebi 파일명.deb` |

---

