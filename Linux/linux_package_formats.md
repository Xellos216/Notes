# Linux 패키지 포맷 비교: .deb / .rpm / .tar.gz

Linux에서는 다양한 방식으로 프로그램을 배포합니다. 여기서는 대표적인 세 가지 포맷의 차이점을 정리합니다.

---

## 1. `.deb` (Debian Package)

- **사용 배포판**: Ubuntu, Debian, Linux Mint 등 (Debian 계열)
- **설치 명령어**: `sudo dpkg -i package.deb` 또는 `sudo apt install ./package.deb`
- **의존성 관리**: `apt`를 통해 자동 처리 가능 (`apt-get install -f`)
- **구성**:
  - `control` 파일: 메타정보(버전, 의존성 등)
  - `data` 파일: 실제 설치될 파일들

### 특징
- `.deb` 파일은 `dpkg`로 직접 설치 가능
- GUI 소프트웨어 설치기에서도 인식됨
- 대부분 `.deb` 기반 배포판은 `apt` 명령으로 패키지 설치/관리

---

## 2. `.rpm` (Red Hat Package Manager)

- **사용 배포판**: Fedora, CentOS, RHEL 등 (Red Hat 계열)
- **설치 명령어**: `sudo rpm -i package.rpm` 또는 `sudo dnf install ./package.rpm`
- **의존성 관리**: `dnf` 또는 `yum`이 자동 처리
- **구성**:
  - 메타데이터 포함
  - 바이너리 또는 소스 RPM으로 구성 가능

### 특징
- `.deb`과 유사하지만 RPM 계열에서만 호환
- Ubuntu에서는 `alien`을 사용해 `.deb`로 변환 가능하나 비권장

---

## 3. `.tar.gz` (압축 소스 또는 바이너리)

- **사용 배포판**: 모든 리눅스에서 사용 가능
- **설치 명령어**:
  - 압축 해제: `tar -xvzf package.tar.gz`
  - 직접 빌드: `./configure && make && sudo make install` (소스일 경우)
- **의존성 관리**: 자동 불가 (수동 설치 필요)
- **내용물**: 바이너리 또는 소스 코드, README, 설치 스크립트 등

### 특징
- 설치가 아닌 **압축 형식**
- 컴파일이 필요한 경우도 있고, 바이너리 실행만으로 충분한 경우도 있음
- 시스템 패키지 매니저에 등록되지 않음

---

## ✅ 비교 표

| 포맷     | 주 사용 배포판       | 설치 명령어                      | 의존성 처리 | 패키지 관리자 연동 | 설치 난이도 |
|----------|----------------------|----------------------------------|--------------|---------------------|--------------|
| `.deb`   | Ubuntu, Debian 계열  | `dpkg -i` / `apt install`       | 자동/수동    | O                   | 쉬움         |
| `.rpm`   | Fedora, CentOS 등    | `rpm -i` / `dnf install`        | 자동/수동    | O                   | 쉬움         |
| `.tar.gz`| 전 배포판            | `tar` + 수동 컴파일 또는 실행   | 수동         | X                   | 중~어려움    |

---

## 🔚 결론

- **Ubuntu 사용자라면 `.deb`** 포맷을 사용해야 가장 안정적이며,
- **`.rpm`은 Ubuntu에 설치 불가능하거나 비효율적**
- **`.tar.gz`는 특별한 목적(예: 최신 버전 직접 설치)에만 사용**하는 것이 좋다.
