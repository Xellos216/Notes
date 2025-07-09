# 📘 Web Development A to Z – QA 통합본

> 각 주차별 실습 중 자주 나왔던 질문과 답변을 정리한 문서입니다.
---

## Q1.  강의자료의 '코드 스니펫'이란 무엇인가?
‘코드 스니펫(Code Snippet)’은 자주 사용하는 코드 조각을 의미하는 일반적인 개발 용어입니다. 강의자료 제작자가 임의로 만든 표현이 아니라, 실무에서도 흔히 쓰이는 용어입니다.

---

## Q2.  .json이란 확장자는 무엇을 의미하나?
JSON(JavaScript Object Notation)은 데이터를 구조화하여 저장하고 전송하기 위한 텍스트 기반 포맷입니다. 보통 API 응답, 설정파일 등에 사용되며, key-value 형태를 가집니다.

---

## Q3.  HTML, CSS, JS 모두 프론트엔드인가? JS는 백엔드 역할도 하는 거 아닌가?
기본적으로 HTML/CSS/JS는 모두 프론트엔드 기술입니다. JS는 브라우저 내 동작하는 스크립트 언어로 시작했지만, Node.js를 사용하면 백엔드에서도 사용 가능합니다. 즉, JS는 양쪽 모두에서 사용될 수 있습니다.

---

## Q4.  Git 패널이란 무엇인가?
VSCode에서 왼쪽 Activity Bar(사이드바) 중 소스 제어 아이콘(🔃 또는 Git 아이콘)을 눌렀을 때 나오는 패널입니다. 변경 사항, 커밋, 푸시 등을 시각적으로 처리할 수 있습니다.

---

## Q5.  Alt+B 단축키로 HTML 미리보기 안 되는 이유는?
Alt+B는 VSCode 확장 프로그램(Live Server, Open in Browser 등)에서 설정된 단축키입니다. 우분투에서는 단축키가 다를 수 있으며, 확장 프로그램이 설치되어 있어야 작동합니다.

---

## Q6.  우분투에서 VSCode 자주 쓰는 단축키는?

- 터미널 열기: `Ctrl + \``
- 사이드바 보기: `Ctrl + B`
- 파일 열기: `Ctrl + P`
- 코드 자동 정리: `Shift + Alt + F`
- HTML 미리보기 (Live Server): `Alt + L`, `Alt + O`

---

## Q7.  CSS 클래스명 앞 파란 물결 밑줄은 무엇인가?
VSCode에서는 정의되지 않았거나 오타 가능성이 있는 class 이름에 경고 표시를 합니다. 작동에 영향을 주지는 않지만, 해당 클래스가 실제 HTML에 존재하지 않으면 스타일이 적용되지 않을 수 있습니다.

---

## Q8.  ID, PW 인풋 칸 정렬이 안 맞는 이유는?
텍스트 길이가 달라서 정렬이 어긋납니다. 해결법은 다음과 같습니다:

- `label` 태그 사용 후 고정된 `width` 부여
- `display: flex`로 label/input을 나란히 정렬

---

## Q9.  Login 버튼을 중앙 정렬하려면?
버튼을 감싸는 `.btn-box`라는 div를 만들고 CSS에서 다음을 적용하세요:

```css
.btn-box {
  display: flex;
  justify-content: center;
}
```

---

## Q10.  CSS는 원래 HTML 내부에 쓰는 건가? 따로 파일로 만들지 않나?
학습 초기에는 `<style>` 태그 안에 CSS를 작성하지만, 실무에서는 `.css` 파일로 분리해 외부에서 로딩하는 방식을 씁니다. 유지보수와 재사용성이 좋아지기 때문입니다.

---

## Q11.  label 앞에 왜 .(점)을 안 붙이나?
`label`은 HTML 태그 이름 선택자이기 때문에 점을 붙이지 않습니다. `.className`처럼 `.`을 붙이는 건 클래스 선택자일 때만 해당됩니다.

---

## Q12.  Google Fonts UI가 강의자와 다른 이유는?
Google Fonts는 UI가 업데이트되었기 때문입니다. 핵심 기능은 동일하며, `@import`와 `font-family` 코드를 HTML에 복사해서 쓰는 방식은 변하지 않았습니다. 최신 UI에서는 `body { font-family: ... }` 부분은 수동 작성해야 할 수 있습니다.

---

## Q13.  왜 폰트가 적용되지 않나요?

**원인:**

* 처음에는 `Nothing You Could Do` 폰트만 `@import` 하고 적용했으나, 해당 폰트는 **영문 전용**으로, 한글은 적용되지 않음.

**해결:**

* "Noto Sans KR"과 같이 한글 지원 폰트를 함께 지정하면 혼합 적용 가능.

```css
font-family: "Nothing You Could Do", "Noto Sans KR", sans-serif;
```

---

## Q14.  카드 간격이 이상하게 나옵니다

**원인:**

* `.row` 아래 자식 요소가 `col`로 감싸져 있지 않으면 **부트스트랩 그리드 시스템이 깨짐**

**해결:**

* 모든 카드(`.card`)는 반드시 `<div class="col">...</div>`로 감싸야 `g-4` (gap) 간격이 제대로 적용됨.

---

## Q15.  `col`이 뭐죠?

**답변:**

* 부트스트랩의 **그리드 시스템**에서 열(column)을 의미.
* `.row`로 묶인 행(row) 내부에서 `.col`은 콘텐츠의 너비를 자동 계산하여 배치함.
* 반응형 클래스도 지원 (`col-md-6`, `col-lg-4` 등)

---

## Q16.  부트스트랩(Bootstrap)이란?

**정의:**

* 트위터 개발자들이 만든 **HTML/CSS/JS UI 프레임워크**
* 레이아웃, 버튼, 폼 등 미리 정의된 클래스를 제공해 빠르게 웹사이트를 만들 수 있게 해줌.

**저작권 문제:**

* MIT 라이선스로 배포됨 → 상업적 사용 포함하여 자유롭게 사용 가능

**공식 문서:** [https://getbootstrap.com/](https://getbootstrap.com/)

---

## Q17.  `<div>`가 너무 헷갈려요. 정리하는 팁은?

### ✔ 추천 방법

1. VSCode 확장 기능: `Auto Rename Tag`, `Highlight Matching Tag`
2. Emmet 단축코드 활용: `div.card>img+div.card-body>h5+p+p`
3. 코드 접기 단축키: `Ctrl + Shift + [` 또는 `]`
4. 명확한 class 네이밍: `main-wrapper`, `form-box`, `card-container` 등으로 구조 구분

---

## Q18.  중앙 폼에 글자가 안 보여요

**원인:**

* `<label for="...">`과 `input id="...">`가 정확히 연결되지 않았거나, HTML 구조가 깨져 있었음

**해결:**

* `<label>`이 연결된 대상의 `id`가 고유해야 하며, 중복되어선 안 됨 (동일 `id` 두 번 쓰지 않기)
* `<div>`를 잘못 닫으면 구조 전체가 깨져 UI가 이상해짐

---

## Q19.  배경 사진이 늘어나 있어요

**원인:**

* `.main` 영역 내에서 `form` 박스 구조가 **`.container-fluid` 밖**에 위치하거나
* 여는/닫는 `<div>`가 어긋나면서 내부 요소 크기를 잘못 계산함

**해결:**

* `<div>` 구조 확인 후 잘 닫고 감싸는지 점검
* `.container-fluid py-5` 내부에 폼도 포함되도록 이동하면 높이 계산이 정확히 이루어짐

```html
<div class="container-fluid py-5">
    <h1>...</h1>
    <p>...</p>
    <div class="mypostingbox">...</div>
</div>
```

---

## ✅ 기타 팁 요약

* `row` 안엔 항상 `col`
* `@import` 폰트는 영문/한글 여부 구분
* Bootstrap은 자유롭게 사용 가능한 CSS 프레임워크
* `<div>` 구조는 코드 폴딩 or Emmet으로 보완

---

## Q20.  `console.log()`는 왜 쓰는가?

- `console.log()`는 **브라우저 개발자 도구(F12)**의 `Console` 탭에서 확인할 수 있는 **디버깅용 출력 함수**입니다.
- 웹페이지에 표시되는 것은 아니고, **개발자 자신이 코드가 제대로 동작하는지 확인하기 위해** 내부 데이터를 출력할 때 주로 사용합니다.
- 예시:
```js
  let name = 'bob';
  let age = 30;
  console.log(name + age);  // 콘솔 창에 bob30 출력됨
```

---

## Q21.  `forEach`라는 함수는 존재하는가?

- `forEach()`는 **배열(Array)** 전용 메서드입니다.
- 배열 안의 각 요소를 하나씩 꺼내서 **콜백 함수 내부에서 실행**시킬 수 있도록 도와줍니다.
- 사용 전에는 반드시 배열인지 확인해야 합니다.

오류 예시:
```js
Array.forEach(a => { console.log(a); });
```
> ❌ `Array`는 배열 인스턴스가 아니라 배열 생성자라 에러 발생

정상 예시:
```js
let ages = [15, 30, 28];
ages.forEach(a => {
  console.log(a);  // 배열 안의 숫자들이 하나씩 출력됨
});
```

---

## Q22.  `forEach(a => {...})`에서 `a`는 무엇인가?

- `a`는 **배열 안의 각 요소를 순서대로 대표하는 변수명**입니다.
- 반복문이 돌면서 배열 안의 값들이 `a`에 하나씩 대입됩니다.

예시:
```js
let ages = [15, 30, 7];

ages.forEach(a => {
  if (a < 20) {
    console.log('청소년입니다.');
  } else {
    console.log('성인입니다.');
  }
});
```
- 해석: 배열 안의 숫자(나이)를 하나씩 `a`에 담아서, `a`가 20보다 작으면 청소년, 아니면 성인이라고 출력

---

## Q23.  다음 함수는 어떤 역할을 하는가?

```js
function checkResult() {
  let fruits = ['사과', '배', '감', '귤', '수박'];
  $('#q1').empty();  // q1 영역 비우기

  fruits.forEach(a => {
    let temp_html = `<p>${a}</p>`;  // <p>사과</p> 식으로 생성됨
    $('#q1').append(temp_html);     // q1 영역에 하나씩 추가
  });
}
```

- 해석:
  - `fruits` 배열에 있는 과일 이름을 하나씩 꺼내서 `<p>` 태그로 감싼 뒤,
  - id가 `q1`인 영역 안에 하나씩 추가해서 출력함

---

## Q24.  다음 함수는 어떤 역할을 하는가?

```js
function checkResult() {
  let people = [
    { 'name': '서연', 'age': 24 },
    { 'name': '연아', 'age': 30 },
    { 'name': '하준', 'age': 12 },
    { 'name': '서연', 'age': 15 },
    { 'name': '지용', 'age': 18 },
    { 'name': '예지', 'age': 36 }
  ];

  $('#q2').empty();  // 기존 내용 비우기

  people.forEach(a => {
    let name = a['name'];
    let age = a['age'];
    let temp_html = `<p>${name}는 ${age}살입니다.</p>`;
    $('#q2').append(temp_html);
  });
}
```

- 해석:
  - `people` 배열은 이름과 나이가 담긴 객체 리스트입니다.
  - 각각의 사람 이름과 나이를 꺼내서, `이름은 나이살입니다.` 형식으로 HTML `<p>` 태그를 만든 뒤,
  - id가 `q2`인 곳에 출력합니다.

---

## Q25.  코드 문제인지, 브라우저 설정 문제인지 어떻게 구분하나요?
- HTML에서 `<script>`가 정상 실행되지 않는 문제는 브라우저 보안 설정(Snap vs Flatpak)이나 잘못된 `<script>` 위치, 문법 오류로 인한 문제일 수 있습니다.
- 테스트 HTML 파일에서 alert가 정상적으로 뜨는 경우, 브라우저 설정 문제는 아닐 가능성이 큽니다. 오히려 코드 자체 문제일 확률이 높습니다.

---

## Q26.  `onclick="hey"`가 작동하지 않는 이유는?
- 함수 호출 시 괄호가 빠졌기 때문입니다.
```html
  <button onclick="hey">  <!-- 잘못된 예 -->
  <button onclick="hey()"> <!-- 올바른 예 -->
```
---

## Q27.  `makeCard()` 함수 내 `let image = $('$image').val();` 가 작동하지 않는 이유는?
- `$image` → `#image`로 수정해야 합니다.
```js
  let image = $('#image').val(); // 아이디 선택자 앞에 # 필요
```

---

## Q28.  모든 값이 image 값만 나오는 이유는?
- 다음 코드에서 `image` 값만 반복 참조하고 있음.
```js
  let image = $('#image').val();
  let title = $('#image').val();
  let content = $('#image').val();
  let date = $('#image').val();
```
- 수정:
```js
  let image = $('#image').val();
  let title = $('#title').val();
  let content = $('#content').val();
  let date = $('#date').val();
```

---

## Q29.  `$('#card')`에서 `$('#')`의 의미는?
- `$()`는 jQuery 함수입니다.
- `'#card'`는 id가 `card`인 요소를 선택한다는 의미입니다.
  → `$('#card')`는 `<div id="card">` 요소를 가리킵니다.

---

## Q30.  `console.log()`에 `title`만 안 나오는 이유는?
- HTML 상 input의 `id="title"`로 되어 있어야 하고,
- JS에서도 `$('#title').val()`로 정확히 선택해야 함.
- 중복된 `id`나 잘못된 선택자가 있을 경우 `undefined`가 출력됨.

---

## Q31.  `let temp_html` 템플릿에서 이미지가 나오지 않는 이유?
- 이미지 `src`에서 다음과 같이 잘못된 문자열이 있음:
```js
  <img src="${https://...}"   // 잘못된 사용
```
- 문자열로 처리해야 하므로 다음처럼 수정해야 함:
```js
  <img src="${image}" 
```

- 또 하나의 오타:
```js
  <p class="card-text">$[comment}</p> // 잘못된 사용
  <p class="card-text">${comment}</p> // 올바른 사용
```

---

## Q32.  `makecard()`로 생성한 이미지가 안 붙는 이유?
- 주로 다음 중 하나일 가능성이 큼:
  1. `image` 변수가 잘못된 값을 가지고 있음
  2. 백틱(```) 템플릿 안에서 `${image}`가 아닌 잘못된 표현 사용
  3. `.append(temp_html)` 대상 `#card`가 존재하지 않음

---

## Q33.  `let`의 의미는?
- ES6 이후 도입된 변수 선언 키워드.
- `var`와 유사하나, 블록 스코프를 가짐.
- 같은 이름으로 재선언 불가 (`let x = 1; let x = 2;` → 에러).

---

## Q34.  HTML, CSS, JS에서 `;` 언제 쓰는가?
- **JS (자바스크립트)**:
  - 문장 종료 시 세미콜론(`;`) 사용.
  - 세미콜론 생략 가능하나, 습관적으로 붙이는 것이 안정적.

- **CSS**:
  - 속성 선언마다 `;`로 구분:
```css
    color: red;
    background-color: blue;
```

- **HTML**:
  - 세미콜론은 문장 종료 용도가 아님. HTML 엔티티에서만 사용됨:
```html
    &nbsp; &lt; &gt;
```

---

## Q35.  백틱(``) vs 작은 따옴표(`'`)의 차이
- 작은따옴표 `'문자열'` 또는 큰따옴표 `"문자열"`은 일반 문자열.
- 백틱은 **템플릿 리터럴**:
  - `${변수}` 형태로 변수 삽입 가능.
  - 여러 줄 문자열도 표현 가능.
```js
  let name = '홍길동';
  console.log(`안녕하세요, ${name}님`); // 변수 삽입 가능
```

---

## Q36.  `.val()`의 의미는?
- jQuery 함수.
  - `$('#input').val()` → 입력창의 **값을 가져오기**
  - `$('#input').val("값")` → 입력창의 **값을 설정하기**

---

---

## Q37.  첫 fetch 코드 작성 후 출력이 undefined로 나오는 문제

**문제 상황**  
- 콘솔 오류: `ReferenceError: data is not defined`  
- 이유: `.then(data => {...})` 내부에서 `data`가 정의되기 전에 외부에서 사용되고 있었음.  

**해결 방법**  
- 모든 fetch 후속 처리는 `.then()` 블록 안에서 수행해야 함.  
- 바깥에서 `data` 사용 시 ReferenceError 발생.

---

## Q38.  `console.log(data)` 찍었는데 안 보임

**확인한 내용**  
- fetch URL을 직접 브라우저에서 접근해보니 데이터 정상 출력  
- 문제는 비동기 흐름을 이해하지 못하고 fetch 외부에서 `data`를 쓰려 했기 때문  
- `.then()` 내부에서만 `data`가 유효함

---

## Q39.  강의 코드와 동일하게 작성했는데 작동 안 함

**코드**  
```javascript
let url = 'http://spartacodingclub.shop/sparta_api/seoulair';
fetch(url).then(res => res.json()).then(data => {
    let rows = data['RealtimeCityAir']['row'];
    ...
});
```

**문제 해결 사항**  
- 콘솔 오류: `ReferenceError: data is not defined`  
- 해결: `data`는 `.then(data => {...})` 안에서만 사용해야 하며, 외부에서 접근하면 오류 발생

---

## Q40.  VSCode에서 들여쓰기 가이드/괄호 색상 안 보임

**설정 상태**  
- settings.json 및 GUI에서 다음 항목 활성화 완료:
  - `editor.guides.indentation`
  - `editor.guides.highlightActiveIndentation`
  - `editor.bracketPairColorization.enabled`

**문제 원인 및 확인 사항**  
- VSCode 우분투 버전에서 테마 또는 Extension에 따라 시각적으로 표시되지 않을 수 있음
- 해결 방법:
  - **VSCode를 완전히 재시작**
  - **테마를 변경하여 표시되는지 확인**
  - `Bracket Pair Colorizer 2` 확장 설치해보는 것도 고려

---

## Q41.  실시간 미세먼지 API 연동 코드 검수 요청

**문제**  
```javascript
let gu_mvl = a['IDEX_MVL'];
if (gu_mise > 40) { // ← gu_mise 정의되지 않음
```

**해결**  
- 변수명 오류 → `gu_mise`가 아니라 `gu_mvl`로 통일해야 함
- 수정 후:
```javascript
if (gu_mvl > 40) {
    ...
}
```

---

## Q42.  전체 코드 해석 요청

```js
function q1() {
    let url = 'http://spartacodingclub.shop/sparta_api/seoulair'; // 1. URL 변수 선언
    $('#names-q1').empty();                                       // 2. 기존 목록 지우기

    fetch(url)                                                    // 3. URL로 요청
        .then(res => res.json())                                  // 4. 응답을 JSON으로 파싱
        .then(data => {
            let rows = data['RealtimeCityAir']['row'];            // 5. 데이터 배열 추출
            rows.forEach(a => {                                   // 6. 각 데이터 순회
                let gu_name = a['MSRSTE_NM'];                      // 7. 구 이름 추출
                let gu_mvl = a['IDEX_MVL'];                        // 8. 미세먼지 수치 추출

                let temp_html = ``;
                if (gu_mvl > 40) {
                    temp_html = `<li class="bad">${gu_name} : ${gu_mvl}</li>`; // 9. 40 초과 시 빨간색
                } else {
                    temp_html = `<li>${gu_name} : ${gu_mvl}</li>`;             // 10. 아니면 일반색
                }
                $('#names-q1').append(temp_html);                  // 11. DOM에 추가
            });
        });
}
```

---

## Q43.  상단 네비바 UI 수정 위치 문의

**수정하고 싶은 부분 (스크린샷 기준)**  
- `Spartafilx`, `홈`, `시리즈`, `영화`, `내가 찜한 스토리`, 검색창, Login, Sign-up 버튼 등

**코드 내 위치**  
```html
<header class="p-3 text-bg-dark">
  <div class="container">
    ...
    <ul class="nav col-12 col-lg-auto ...">
        <li><a href="#" class="nav-link px-2 text-danger">Spartafilx</a></li>
        <li><a href="#" class="nav-link px-2 text-white">홈</a></li>
        ...
    </ul>
    ...
  </div>
</header>
```

이 `<header>` 블록 내부의 `<ul>`, `<form>`, `<div>` 등을 수정하면 원하는 UI 수정 가능

---

## Q44.  `<span id="msg"></span>`의 역할

**위치**
```html
<li><a href="#" class="nav-link px-2 text-white">현재 기온 : <span id="msg">모름</span></a></li>
```

**해석**
- `span`은 **실시간 데이터를 삽입할 자리**  
- `id="msg"`인 이 요소는 `$('#msg').text(temp);` 코드에 의해 온도 정보로 바뀜

**컴퓨터식 해석**
- "span 박스를 만들고 → id를 msg로 붙여라 → 기본값은 '모름'으로 설정해라"
- "fetch로 받아온 데이터를 → msg라는 id를 가진 요소에 텍스트로 삽입해라"

---

## Q45.  Firebase만으로 가능한 범위와 백엔드 전환 시점은?

- Firebase는 백엔드 구축 없이도 로그인, DB 저장, 호스팅이 가능.
- 하지만 다음과 같은 경우 자체 백엔드 필요:
  1. 복잡한 로직 (결제, 승인 흐름)
  2. 외부 API 연동 (예: 배송사, 결제사)
  3. 트래픽 증가 시 비용 최적화 필요
  4. 보안이 중요한 경우 (토큰 발급, 사용자 인증 커스터마이징)
- 실무에서는 Firebase로 MVP 제작 후 Node.js, Spring 등으로 마이그레이션함.

---

## Q46.  SQL DB와 NoSQL DB의 차이 (실무 기준)

| 항목         | SQL (관계형)           | NoSQL (비관계형, 문서형)      |
|--------------|------------------------|-------------------------------|
| 구조         | 정형화된 테이블         | 유연한 JSON 구조 (문서 기반) |
| 확장성       | 수직 확장 (하드웨어 교체) | 수평 확장 (서버 추가)         |
| JOIN         | 강력한 JOIN 가능        | 불가능 또는 비효율적          |
| 정합성 보장  | ACID 트랜잭션 보장     | 약한 정합성, 유연한 처리       |
| 사용 예시    | 회계, 인사, 주문 시스템 | SNS, 채팅, 실시간 게임 데이터 |

- Firestore는 NoSQL → 자유롭게 데이터 구성 가능, 빠른 개발에 유리

---

## Q47.  클라우드란 정확히 무엇인가?

- 인터넷을 통해 서버, DB, 스토리지 등을 **필요할 때만 빌려 쓰는 방식**
- AWS, GCP, Azure, Firebase 등이 대표적
- 서버 직접 구매·관리 X → 개발/운영 집중 가능
- 클라우드 서비스는 실제 전 세계 데이터센터에 물리 서버를 운영 중

---

## Q48.  클라우드 제공자가 내 DB에 접근 가능한가?

- 기술적으로: 예, 접근 가능 (물리적 권한 있음)
- 정책적으로: 접근 금지 + 모든 접근은 감사 로그에 기록
- 실무 대응:
  - Firestore 보안 규칙 설정 필수
  - 민감 데이터는 암호화 후 저장
  - 기업은 자체 키 관리 시스템(CMEK) 도입

---

## Q49.  클라우드에서 DB 유출 시 책임은 누구에게?

- "공유 책임 모델" 적용:
  - 인프라(하드웨어, OS 패치): 클라우드 제공자 책임
  - 앱 보안, DB 접근 권한 설정: 사용자(A사) 책임
- 대부분의 유출 사고는 사용자 측 보안 설정 미비로 발생 → **A사 책임**

---

## Q50.  SDK, npm, CDN, 구성의 의미?

- SDK: 특정 기능을 쉽게 사용할 수 있게 제공되는 개발도구 집합
- npm: Node.js용 패키지 설치 관리자 (`npm install firebase`)
- CDN: 외부 라이브러리를 `<script src="...">`로 가져오는 방식
- 구성: Firebase 콘솔에서 제공하는 설정 객체 (apiKey 등) → 프로젝트와 연결

---

## Q51.  Firebase 연동 코드 분석 (데이터 흐름)

1. **데이터 불러오기 (READ)**  
   `await getDocs(collection(db, "Albums"));`  
   → Firestore에서 모든 앨범 문서 가져와 HTML 카드로 표시

2. **데이터 보내기 (CREATE)**  
   `await addDoc(collection(db, "Albums"), doc);`  
   → 사용자가 입력한 이미지, 제목 등을 Firestore에 저장

3. **기타 기능**  
   - 글쓰기 박스 토글: `$('#postingbox').toggle();`  
   - 외부 API 호출: 서울 공기질 정보 fetch 후 DOM에 출력

---

## Q52.  script type="module"을 쓰면 함수가 작동 안 된다는 말의 의미?

- 모듈 스크립트는 전역(window) 스코프에 함수가 등록되지 않음
- 따라서 `<button onclick="함수()">` 방식은 **작동하지 않음**
- 해결 방법:
  1. `addEventListener()`를 통해 JS 코드 내부에서 동적으로 연결
  2. 필요 시 `window.함수명 = 함수`로 전역 등록

예:
```js
document.querySelector('#btn').addEventListener('click', sayHello);
```

📌 결론: 모듈 스크립트에서는 반드시 "동적으로 이벤트를 바인딩" 해야 한다.