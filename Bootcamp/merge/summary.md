# 📚 Web Development A to Z – Summary 통합본 

## HTML, CSS, Bootstrap

### 학습 목표
- HTML과 CSS를 활용해 **웹 페이지의 뼈대와 디자인 구성**하기
- Bootstrap을 통해 빠르게 UI를 꾸며보기


---

## 1-2. 웹 브라우저 작동 원리

### 🔸 핵심 개념
- 웹 브라우저는 **서버에 요청**을 보내고, 받은 HTML을 **화면에 그리는 역할**을 수행
- 개발자 도구로 **웹 페이지의 HTML 구조와 API 응답**을 확인할 수 있음

### 🔸 브라우저 작동 순서 요약
1. 사용자가 주소 입력
2. 브라우저가 서버에 요청
3. 서버는 HTML, CSS, JS 혹은 JSON 등의 응답 전달
4. 브라우저가 받은 응답을 기반으로 렌더링

### 🔸 클라이언트와 서버
- HTML 파일이 직접 응답으로 오는 경우도 있지만,
- API를 통해 JSON 데이터만 받고, JavaScript로 페이지를 구성하는 경우도 많음

```json
{
  "RESULT": {
    "CODE": "INFO-000",
    "MESSAGE": "정상 처리되었습니다"
  },
  "list_total_count": 1,
  "row": [
    {
      "MSRDT": "202004241900",
      "MSRRGN_NM": "은평구",
      "PM10": 30
    }
  ]
}
```


---

## 1-3. 코딩 환경 세팅하기

### 🔸 에디터: VS Code
- Microsoft의 대표적인 코드 편집기
- **HTML, CSS, JS 실습에 최적화**
- 추천 확장 기능: `Live Server` (HTML 파일을 실시간 미리보기 가능)


---

## 1-4. HTML 기초

### 🔸 폴더 및 파일 생성 실습
```
/sparta/frontend/tags.html
```

### 🔸 HTML과 CSS의 개념
- HTML: **페이지의 뼈대**를 구성하는 언어
- CSS: 해당 뼈대의 **스타일과 레이아웃**을 꾸미는 언어


---

## 1-5. 로그인 페이지 만들기

### 🔸 예시 코드
```html
<h1 class="mytitle">로그인 페이지</h1>
<button class="mybtn">로그인하기</button>
```


---

## 1-6. CSS 기초

### 🔸 주요 속성
- 배경: background-color, background-image
- 크기: width, height
- 글꼴: font-size, color, font-family
- 여백: margin, padding
- 정렬: text-align, display


---

## 1-7~1-8. 자주 쓰는 CSS

### 🔸 margin vs padding 비교
- margin: 외부 여백
- padding: 내부 여백


---

## 1-9. 구글폰트 적용하기

### 🔸 예시 코드
```css
@import url('https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap');
* {
  font-family: 'Gowun Dodum', sans-serif;
}
```


---

## 1-10. Bootstrap 적용하기

### 🔸 CDN 적용
```html
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
```


---

## 1-11. [추억앨범] 프로젝트 1

### 🔸 카드 레이아웃 구성
- `row-cols-md-4` 클래스 활용해 4개 카드 한 줄 정렬


---

## 1-12. [추억앨범] 프로젝트 2

### 🔸 포스팅 입력 박스 추가
```css
.mypostingbox {
  width: 500px;
  margin: 20px auto;
  padding: 20px;
  box-shadow: 0px 0px 3px 0px blue;
}
```

### 🔸 폼 구성 예시
```html
<input type="email" class="form-control" placeholder="앨범 이메일" />
<input type="text" class="form-control" placeholder="앨범 제목" />
<textarea class="form-control" placeholder="앨범 내용"></textarea>
```


---



---

## 🗓️ Week 2 - JavaScript 기초, DOM, JQuery

## 학습 목표

- **HTML**은 뼈대, **CSS**는 꾸미기, **Javascript**는 **움직이기**!
- Javascript는 웹을 동적으로 작동시키는 핵심 언어.
- 실생활 예시: 모바일 청첩장을 만들어 사용자 인터랙션 처리 가능
- 예시 기능:
  - 버튼 클릭 시 사진 바뀜
  - 스크롤 시 요소 변경
  - 요청 전송 및 응답 처리 등

## 🧠 자바스크립트 배우기 전에!

- 지난 1주차 학습 내용(HTML, CSS, Bootstrap) 복습
- 복습용 미니 프로젝트: **스파르타플릭스**
  - 추억앨범 구조와 매우 유사
  - 기본 뼈대 구성, 부트스트랩 활용

## 🎬 [스파르타플릭스] 프로젝트 1 - 상단 만들기

- 폴더 구조: `sparta/spartaflix/index.html`
- 템플릿 구성:
  - Bootstrap CDN 연결
  - 배경 이미지 설정
  - 구글 폰트 적용
  - nav bar 구성
  - 로그인 / 회원가입 버튼 구성
- 참고 링크:
  - Bootstrap: https://getbootstrap.com/docs/5.3/getting-started/introduction/
  - 배경 이미지: Netflix API 링크
  - 킹덤 설명 텍스트 포함

## 🧩 [스파르타플릭스] 프로젝트 2 - 카드 추가하기

1. 카드 구성:
   - Bootstrap Card 컴포넌트 복사 및 커스터마이징
   - 포스터 이미지 삽입
   - `.row-cols-md-3 g-4` → `.row-cols-md-4 g-4`로 조정
2. 카드 내용 수정:
   - 영화 제목, 코멘트 작성
   - 별점은 `<p>` 태그 내 ⭐️⭐️⭐️

## 📝 [스파르타플릭스] 프로젝트 3 - 포스팅 박스 만들기

- 입력 폼 구성:
  - 입력창(제목, 추천 이유)
  - 장르 선택 드롭다운
  - 기록 버튼
- 주요 CSS:
  - `box-shadow: 0px 0px 3px 0px gray;`
  - `padding: 20px;`
- Bootstrap 참고 요소:
  - Forms > Floating Labels
  - Input group
  - Buttons > Variants

## 💡 Javascript에 대해

### ✔ 왜 사용하는가?

- 클라이언트와 서버 간 동작 정의
- 사용자 인터랙션 구현 (클릭, 입력, 반응 등)
- 표준화된 동적 웹 개발 언어로 자리 잡음

### ✔ Java vs Javascript?

- 아무 관련 없음 (이름만 비슷함)

### ✔ 활용성

- 프론트엔드 + 백엔드 통합 개발 가능 (Node.js 등)
- 다양한 플랫폼(IoT, 게임, 앱 등)에 응용 가능
- 필수적인 웹 기술로 광범위하게 사용됨


---

👉 이후에는 Javascript 기초문법을 학습하고, JQuery 활용으로 이어집니다.

## 🧪 Javascript 기초문법 1 - 출력과 개발자 도구 사용

- `console.log()` 함수: 콘솔에 텍스트 또는 값 출력
- 실행 위치: 브라우저 → 우클릭 → '검사' → 'Console' 탭 확인
- 버튼 클릭과 연결: `<button onclick="hey()">`로 함수 호출

```javascript
function hey() {
  console.log('안녕하세요');
}
```


---

## 🧮 Javascript 기초문법 1 - 변수 & 연산

- `let` 키워드로 변수 선언  
  - 예: `let a = 2; let b = 'Bob';`
- 문자열은 작은 따옴표(‘ ’) 또는 큰 따옴표(“ ”)로 감쌈
- 숫자 연산: `+`, `-`, `*`, `/`, `%` 등
- 문자열 + 문자열 → 연결됨

```javascript
let a = 2;
let b = 3;
console.log(a + b); // 5

let c = '대한';
let d = '민국';
console.log(c + d); // 대한민국
```


---

## 📦 Javascript 기초문법 2 - 배열 & 딕셔너리

### ✅ 배열 (Array)

- 순서대로 값을 나열한 자료형
- 인덱스는 0부터 시작

```javascript
let a = ['사과', '수박', '딸기', '참외'];
console.log(a[0]); // 사과
console.log(a.length); // 4
```

### ✅ 딕셔너리 (Object)

- 키-값 쌍으로 이루어진 자료 구조

```javascript
let a = {'name': '영수', 'age': 27};
console.log(a['name']); // 영수
```

- 딕셔너리를 배열처럼 묶어 사용 가능:

```javascript
let a = [
  {'name': 'A', 'age': 27},
  {'name': 'B', 'age': 15},
  {'name': 'C', 'age': 20}
];
console.log(a[0]['name']); // A
```

### ✅ 왜 필요한가?

- 정보를 순서대로, 또는 키로 빠르게 찾기 위해 사용
- 다양한 데이터를 묶어서 관리 가능


---

## 🧰 Javascript 기초문법 2 - 기본 함수 활용

- 내장 함수 예시:
  - 문자열 나누기: `split()`
  - 산술 연산: `+`, `-`, `*`, `/`

```javascript
let result = 'sparta@gmail.com'.split('@');
console.log(result[0]); // 'sparta'
console.log(result[1]); // 'gmail.com'
```


---

## 🔁 Javascript 기초문법 3 - 반복문 & 조건문

### ✅ 반복문: forEach

```javascript
let fruits = ['사과', '배', '감'];
fruits.forEach(a => {
  console.log(a);
});
```

### ✅ 조건문: if ~ else

```javascript
let age = 24;
if (age > 20) {
  console.log('성인입니다');
} else {
  console.log('청소년입니다');
}
```

### ✅ 반복 + 조건

```javascript
let ages = [12, 15, 20, 25, 17, 37, 24];
ages.forEach((a) => {
  if (a >= 20) {
    console.log('성인입니다');
  } else {
    console.log('청소년입니다');
  }
});
```


---

🔎 **보충 개념**  
- `let`: 블록 스코프 변수 선언 키워드 (중복 선언 불가)  
- `console.log()`: 디버깅을 위한 출력 함수  
- `forEach()`: 배열 순회용 고차함수  
- `split()`: 문자열을 분할하여 배열로 반환하는 메서드  
- 조건문과 반복문은 로직 제어의 핵심 구조로, 이후 DOM 제어나 이벤트 처리에 필수적으로 연결됨


## 🖱️ Javascript 활용문법 (DOM 조작)

### ✅ 함수 연결 및 Alert

- `onclick`으로 버튼에 함수 연결 가능
- `alert()` 함수는 사용자에게 알림창 띄움

```javascript
function hey() {
  alert('안녕!');
}
```

- HTML 예시:
```html
<button onclick="hey()">영화 기록하기</button>
```


---

### ✅ HTML 조작: document 객체

- `document.getElementById('id명').style.color = 'red'`
  → 특정 요소 스타일 변경
- `document`는 브라우저 전체 HTML 문서를 의미


---

## 🌐 JQuery 시작하기

### ✅ JQuery란?

- Javascript를 간결하고 쉽게 사용할 수 있도록 만든 JS 라이브러리
- 기본 문법을 단축형으로 표현 가능

### ✅ JS vs JQuery 비교

```javascript
// JS
document.getElementById('hello').innerHTML = '안녕';
// JQuery
$('#hello').html('안녕');
```


---

## 🛠 JQuery 연습하기

### ✅ JQuery 문법 예시

```javascript
let a = ['사과', '배', '감'];
$('#q1').text(a[1]); // 배
```

```javascript
let b = {'name': '영수', 'age': 30};
$('#q2').text(b['name']); // 영수
```

```javascript
let c = [
  {'name': '철수', 'age': 30},
  {'name': '영희', 'age': 28},
];
$('#q3').text(c[1]['age']); // 28
```


---

### ✅ 반복문 + JQuery 적용

```javascript
let fruits = ['사과', '배', '감'];
let temp_html = '';
fruits.forEach((a) => {
  temp_html += `<p>${a}</p>`;
});
$('#q1').append(temp_html);
```

- `.append()` : 기존 HTML 내용 뒤에 새 요소 추가
- `.empty()` : 기존 내용 비우기


---

### ✅ 객체 리스트 다루기

```javascript
let people = [
  {'name': '영수', 'age': 26},
  {'name': '철수', 'age': 30}
];

let temp_html = '';
people.forEach((p) => {
  temp_html += `<p>${p.name}은 ${p.age}살입니다</p>`;
});
$('#q2').append(temp_html);
```


---

📌 **Tip**
- JQuery에서 `$()`는 요소를 선택하는 대표 문법
- `.text()`, `.html()`, `.append()`, `.empty()` 등 다양한 메서드를 함께 학습


---

## 🗓️ Week 3 - jQuery 응용 & Fetch API & 서버 통신

## 01. jQuery 복습 + 실습

- 기존에 배운 `.text()`, `.html()`, `.append()` 사용법 다시 확인
- `.toggle()`을 활용한 버튼 클릭 시 보이기/숨기기 실습

```javascript
function togglePostBox() {
  $('#post-box').toggle();  // id="post-box" 영역을 토글
}
```

- 버튼에 연결: `<button onclick="togglePostBox()">`


---

## 02. 서버와 클라이언트 구조 이해

- 클라이언트: 사용자의 브라우저 (요청을 보냄)
- 서버: 요청을 받고, 처리 후 응답을 보냄
- 통신은 HTTP 기반 (GET/POST)


---

## 03. fetch 기본 문법 학습

```javascript
fetch("요청 URL", {
  method: "POST",
  headers: { "Content-Type": "application/json" },
  body: JSON.stringify({ name: "홍길동", age: 20 })
})
.then(res => res.json())
.then(data => {
  console.log(data);
});
```

- `fetch()`는 비동기 통신 함수
- `.then()`으로 응답을 받고 `.json()`으로 데이터 추출


---

## 04. fetch 실습 1: 버튼 클릭 → 서버로 POST 요청 보내기

- 입력값(제목, 이미지, 코멘트 등)을 가져와서 객체로 만들고 fetch로 전송
- 서버에서 응답을 받으면 콘솔에 확인

```javascript
let data = {
  title: $('#title').val(),
  image: $('#img').val(),
  comment: $('#comment').val()
};

fetch("/movie", {
  method: "POST",
  headers: { "Content-Type": "application/json" },
  body: JSON.stringify(data)
})
.then(res => res.json())
.then(data => {
  alert(data["msg"]);  // 성공 메시지 출력
});
```


---

## 05. fetch 실습 2: 서버에서 영화 데이터 받아와 카드로 출력

- GET 요청을 보내서 영화 목록을 받아옴
- 받아온 데이터를 `.forEach()`로 순회하며 카드 생성

```javascript
fetch("/movie")
  .then(res => res.json())
  .then(data => {
    data.forEach(movie => {
      let html = `<div class="card">...</div>`;
      $('#movie-list').append(html);
    });
  });
```


---

## 06. fetch 실습 3: 조건문 활용 (성인/청소년 분류)

```javascript
if (age >= 20) {
  console.log("성인입니다");
} else {
  console.log("청소년입니다");
}
```

- 영화 정보 중 나이 정보를 기준으로 출력 내용 분기


---

## 07. 실제 공공 API 사용 예시 (서울시 OpenAPI)

```javascript
fetch("https://api.seoul.go.kr/air_quality")
  .then(res => res.json())
  .then(data => {
    let 미세먼지 = data['row'][0]['PM10'];
    $('#dust').text(미세먼지);
  });
```

- 실시간 데이터 사용법 익힘
- JSON 구조에서 필요한 필드를 꺼내 사용하는 연습 포함


---

## 8. [추억앨범] Fetch 적용

- 목표: 서울의 실시간 대기 정보를 받아와 웹 페이지에 표시
- 적용 UI: 사용자 입력 폼 + 실시간 데이터 연동 (IDEX_NM 값 표시)

### 주요 개념 정리

- `fetch()`로 API에서 데이터 받아오기
- `$(document).ready()`를 통해 페이지 로딩 후 fetch 실행
- 응답(response)을 `.json()`으로 파싱
- 특정 key (`RealtimeCityAir` → `row` → `[0]` → `IDEX_NM`)를 찾아 출력

### 예시 코드

```javascript
$(document).ready(function () {
  let url = "http://spartacodingclub.shop/sparta_api/seoulair";
  fetch(url).then(res => res.json()).then(data => {
    let mise = data['RealtimeCityAir']['row'][0]['IDEX_NM'];
    $('#msg').text(mise);
  });
});
```


---

## 9. [스파르타플릭스] Fetch 적용

- 목표: 서울의 실시간 기온(temp)을 받아와 페이지에 표시
- 적용 UI: 스파르타플릭스 페이지 상단 텍스트에 삽입

### 주요 개념 정리

- `fetch()`로 OpenAPI에서 기온 데이터 호출
- `$(document).ready()`에서 자동 실행
- 응답을 `.json()`으로 파싱 후 `temp` 키에서 값 추출
- `<span id="msg">` 영역에 삽입

### 예시 코드

```javascript
$(document).ready(function () {
  let url = "http://spartacodingclub.shop/sparta_api/weather/seoul";
  fetch(url).then(res => res.json()).then(data => {
    let temp = data['temp'];
    $('#msg').text(temp);
  });
});
```


---

✅ *실시간 데이터를 가져와 DOM에 반영하는 기본 패턴은 위 두 예시를 통해 완전히 이해할 수 있어야 한다.*

## ✅ 요약 마무리

- `jQuery`로 조작 → `fetch()`로 요청 → `then()`으로 응답 처리 → DOM에 출력
- 실습 구조를 기억할 것:
  1. 입력 받기
  2. fetch 요청 보내기 (POST or GET)
  3. 응답 받아 `.forEach()`나 조건문으로 처리
  4. `.append()`로 결과 출력


---

## 🗓️ Week 4 - Firebase & Firestore


## ✅ 2. Firebase 시작하기
- Firebase는 **Google이 제공하는 서버리스 백엔드 플랫폼**.
- 서버를 직접 만들지 않아도, 웹 서비스를 출시 가능.
- 프론트엔드 코드만으로도 백엔드 기능을 사용할 수 있음.
- 구성:
  - 개발 코드 1: 프론트엔드 → 서버로 데이터 전송
  - 개발 코드 2: 서버(파이어베이스) → DB 저장


---

## ✅ 3. 데이터베이스 개념
- 데이터베이스(DB)란? 데이터를 잘 **보관/검색**하기 위해 정리하는 공간.
- 데이터베이스는 크게 두 가지로 나뉨:
  - 관계형 데이터베이스(SQL): 정형 데이터, 은행/대기업
  - 비관계형 데이터베이스(NoSQL): 유연한 구조, 스타트업
- 이번 실습에서는 **클라우드 NoSQL DB인 Firestore** 사용


---

## ✅ 4. Firestore Database 시작하기
- Firestore는 Google의 **NoSQL 클라우드 데이터베이스**.
- 구성 개념:
  - **Collection**: 문서들의 모음 (예: albums)
  - **Document**: 한 개의 데이터 단위 (예: 앨범 1개)
  - **Field**: 문서 내 데이터 속성 (예: title, content, date)

```js
// Firestore 초기 세팅 코드 요약
import { initializeApp } from "firebase/app";
import { getFirestore, collection, addDoc, getDocs } from "firebase/firestore";

const firebaseConfig = {
  // 설정 정보
};

const app = initializeApp(firebaseConfig);
const db = getFirestore(app);
```


---

## ✅ 5. Firestore에 데이터 넣기 (`addDoc`)
- 사용자 입력을 받아 Firestore DB에 저장
- 입력 필드: 앨범 이미지, 제목, 날짜, 내용
- 저장 성공 시 `alert()` 메시지 표시
- 저장 후 새로고침: `window.location.reload()`


---

## ✅ 6. Firestore에서 데이터 가져오기 (`getDocs`)
- `getDocs` 함수로 Firestore의 데이터를 읽어옴
- 가져온 데이터를 HTML 카드 형태로 동적 생성
- 카드에 삽입할 정보: 이미지, 날짜, 제목, 내용
- HTML에서 카드 구조를 미리 만들고, `append`로 붙임
- **형식이 다른 document**는 필터링해서 제외


---

## ✅ 7. 기능 정리: 앨범 카드 불러오기 전체 흐름

- **첫 번째:** Firebase 설정 및 Firestore 세팅 완료
- **두 번째:** 사용자가 입력한 데이터를 변수에 담고, Firestore에 저장 (`addDoc`)
- **세 번째:** Firestore에서 데이터를 읽고 (`getDocs`), HTML 카드로 구성하여 브라우저에 표시

전체 흐름:
프론트엔드 → Firebase → Firestore 
FireStore에서 다시 프론트로 데이터 반환 → HTML 카드로 렌더링