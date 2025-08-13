# 📱 모바일 접근 제한 분석 마무리

---

## 1. 분석 목적 및 실험 개요

본 보고서는 **내일배움캠프 학습 플랫폼(nbcamp.spartacodingclub.kr)**에서 발생하는 모바일 접근 제한 현상을 기술적으로 분석하고,  
그 차단이 고의적인 필터링인지 혹은 React 기반 구조의 기술적 미구현인지 판단하며,  
우회 가능성 및 방법을 정리하는 것을 목표로 합니다.

### 🧪 실험 개요
- 주요 페이지: `/mypage/attendance/timer`, `/my-page/user`
- 모바일 환경: iPhone Safari, 모바일 Chrome 등
- 실험 도구: DevTools(Device Toolbar), Inspect Browser(iOS), User-Agent 변경
- 주요 확인 항목: UI 렌더링 상태, React Console 오류, Network 응답 코드, Viewport 전환

---

## 2. 접속 실패 현상 요약

### UI 결과
- `"PC에서 접속해주세요"` 문구와 함께 **차단 화면 출력**
- React 렌더링 자체가 실패한 것이 아니라 **조건부 UI가 출력**된 사례도 있음

### Console 오류
React 콘솔에 다음과 같은 **Minified Error**들이 발생:

| 오류 코드 | 원인 요약 |
|-----------|-----------|
| #425 | 렌더 순서 꼬임, useEffect 구조 실패 |
| #418 | `undefined.map()` 등 잘못된 데이터 렌더링 시도 |
| #423 | 잘못된 `props.children` 전달 |

→ 모두 **React 클라이언트 측 렌더링 실패**를 의미

### Network 상태
- 대부분의 API 응답은 `200 OK`로 **정상 처리**
- 일부 실험에선 `500`, `404` 응답 발생 (Axios 기반)
- `Authorization: Bearer ...` 토큰 포함 → 로그인 인증은 정상
- `User-Agent` 및 `Sec-Ch-Ua-Platform`도 모바일로 인식됨

---

## 3. 서버 차단 여부 판단

- 서버는 **HTTP 상태코드 200 OK**를 반환함
- `Server: Vercel`, `x-matched-path` 등 정상 응답 헤더 존재
- **User-Agent 기반 필터링 없음** (Mac 기반 WebKit 유지 시 우회 성공)
- SSL/TLS, HSTS, HTTP/2 기반의 차단 또는 프록시 탐지 징후 없음

→ ✅ 서버는 모바일을 차단하고 있지 않으며, **기술적으로 응답을 정상 반환 중**

---

## 4. 클라이언트 측 기술적 실패 분석

- React SPA 구조에서 렌더링 중 오류 발생 → **초기 렌더 실패**
- 특정 모바일 환경(iPhone Safari 등)에서 JavaScript 예외처리 미흡
- Axios 요청이 초기 컴포넌트에서 실패하며, 전반적인 화면 구성 실패
- Console warning은 GSAP, Swiper 등 부가 요소 관련

→ ❗ 원인은 **보안 정책**이 아니라 **클라이언트 측 구현의 안정성 부족**

---

## 5. 우회 성공 사례 및 방법 정리

### 방법
- iOS Safari + Inspect Browser 앱 사용
- `Devices → Desktop: 1280x800` 설정
- 새로고침 또는 뷰포트 재조정

### 결과
- 출석 페이지 정상 렌더링됨
- 출석 토글 버튼 작동 확인됨
- React 콘솔 오류 사라짐
- 네트워크 요청 및 응답 정상

→ ✅ 우회 성공. 모바일에서도 조건 충족 시 정상 접속 가능

---

## 6. 최종 결론 및 판단

| 항목 | 결과 |
|------|-------|
| 서버 차단 여부 | ❌ 차단 아님 |
| 클라이언트 렌더 오류 | ✅ 존재 |
| 기술적 미구현 여부 | ✅ 맞음 |
| 우회 가능성 | ✅ 충분함 |
| 보안 정책 여부 | ❌ 해당 없음 |

> **요약**: 본 이슈는 보안 차단이 아닌 React 기반 SPA의 **모바일 환경 대응 미흡**에 기인한 기술적 문제이며,  
> 뷰포트 및 UA 조건을 조정함으로써 충분히 우회 가능함.

---

## 7. 관련 캡처 목록

- `Mobile_restriction_bypassed.jpg`
- `Mobile_restriction_settings`

---

