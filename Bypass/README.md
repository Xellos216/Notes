## ⚠️ 불법적인 우회를 목적으로 하지 않으며, 학습과 기록을 위한 자료입니다.

---

## 🧭 모바일 환경에서의 우회 실험 정리 및 분석

본 리포지토리는 내일배움캠프 학습 플랫폼의 모바일 접속 제한 현상에 대해 접근 우회 실험을 수행한 결과를 기록합니다.

---

### 📌 실험 목적

- 모바일 환경에서 특정 페이지(`내 학습공간`) 접근이 제한되는 원인 파악
- 차단 원인이 **정책적 필터링인지**, 아니면 **기술적 미구현**인지 판단
- 다양한 우회 시도(Proxy, Viewport 변경, JS 조작 등)를 통해 접근 가능성 확보

---

### ⚙️ 실험 개요

| 실험 도구 | 시도 내용 | 결과 |
|-----------|-----------|------|
| **Charles Proxy** | HTTPS 트래픽 복호화, User-Agent 변조 | ❌ SSL Reset 및 `PROTOCOL_ERROR` 발생 |
| **mitmproxy** | HTTP/2 → HTTP/1.1 다운그레이드, UA 변조 | ❌ 차단 우회 실패 (JS 기반 감지 가능성) |
| **Inspect Browser (iOS)** | Viewport 변경 (Desktop: 1280x800) | ✅ 우회 성공, 정상 렌더링 및 버튼 출력 |

---

### 🔬 실험 상세 요약

#### 1️⃣ Charles Proxy 기반 실험

- iPhone → Charles 연결 후 HTTPS 트래픽 복호화
- User-Agent를 데스크탑 Chrome으로 변경
- SSL 인증서 설치 완료 상태에서도 `ERR_CONNECTION_CLOSED` 발생
- 서버 측 TLS 핸드쉐이크 수준에서 **MITM 차단 장치 추정**
- **JA3 hash 기반 탐지 또는 HTTP/2 제한 가능성 존재**

➡️ **결론**: SSL 프록시 차단 장치로 인해 실질적 패킷 분석 불가능

---

#### 2️⃣ mitmproxy 기반 실험

- HTTP/2 → HTTP/1.1로 다운그레이드
- User-Agent 강제 변경 (PC Chrome)
- SSL 복호화 및 요청 조작은 성공
- 하지만 페이지 진입 시 여전히 **"PC에서 접속해주세요"** 문구 노출

➡️ **결론**: UA 변조만으로는 우회 불가  
→ 클라이언트 측 JavaScript가 **뷰포트, 터치 기능 등 종합적 조건 판별** 가능성 높음

---

#### 3️⃣ Inspect Browser (iOS 앱) 실험

- 모바일 브라우저지만, Desktop 뷰포트(1280x800) 강제 설정
- `my-page/user` 및 `attendance/timer` 모두 정상 접근 확인
- React Console 오류 소멸, API 요청 모두 200 OK
- **출석 버튼 UI 노출 및 토글 작동**

➡️ **결론**: 뷰포트와 환경 정보 조작만으로 **정상 렌더링 유도 가능**

---

### ✅ 최종 결론

| 항목 | 판단 |
|------|------|
| **서버 차단 여부** | ❌ 없음 (HTTP 200 OK, 인증 정상) |
| **보안 정책 여부** | ❌ 없음 (User-Agent, SSL 인증 문제 아님) |
| **차단 원인** | ✅ 클라이언트 렌더링 실패 (React SPA의 모바일 환경 대응 미흡) |
| **우회 방법** | ✅ 모바일 웹 뷰포트 1280 x 800 변경 시 우회 가능 |

> **요약**: 모바일 환경에서의 접속 실패는 의도적 차단이 아닌 
> React 기반 SPA 구조에서의 **기술적 미구현**, 현재 뷰포트 조작 시 우회 가능.

---

### 📁 실험별 상세 문서

| 문서 | 내용 |
|------|------|
| `01_Mobile_bypass_try_charles.md` | Charles를 통한 SSL 복호화 및 분석 시도 |
| `02_Mobile_bypass_try_mitmproxy.md` | mitmproxy 기반 HTTP/1.1 다운그레이드 실험 |
| `03_Mobile_bypass_try_inspect_browser.md` | Inspect Browser로 뷰포트 조정 통한 우회 성공 |
| `04_Mobile_bypass_try_iOS.md` | iOS, Safari Viewport 1280x800 변경으로 모바일 우회 |

---

### 🗂 디렉토리 구조

```
mobile-bypass-experiment/
 └── images
  └── .jpg
├── Mobile_bypass_try_charles.md
├── Mobile_bypass_try_mitmproxy.md
├── Mobile_bypass_try_inspect_browser.md
├── Mobile_bypass_try_iOS.md
├── QA.md
├── us_patch.py
└── README.md
```
