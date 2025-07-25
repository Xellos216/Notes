# why_dot_slash_required.md

## ✅ 개요

리눅스에서 실행 파일을 실행할 때 어떤 경우에는 `./typer.sh`처럼 `./`를 붙여야 하고, 어떤 경우에는 `ls`, `python3`처럼 명령어 이름만으로도 실행됩니다. 그 이유는 **실행 경로 검색 순서**와 **`$PATH` 환경변수**의 차이에 있습니다.

---

## 1️⃣ 왜 `./typer.sh`처럼 `./`를 붙여야 할까?

### 🔸 기본 원리
리눅스에서 사용자가 입력한 명령어를 실행할 때, **셸(Bash 등)은 해당 명령어가 어디 있는지**를 **특정 경로 목록에서 순서대로 검색**합니다.

이때 `./`는 **"현재 디렉토리(Current Directory)"를 명시적으로 지정하는 것**입니다.

### 🔸 `./` 없이 실행하면 왜 `command not found`?

```bash
$ typer.sh
bash: typer.sh: command not found
```

이는 현재 디렉토리(`./`)가 실행 경로 검색 대상인 **`$PATH` 환경변수에 포함되어 있지 않기 때문**입니다. 그래서 Bash는 `typer.sh`라는 이름의 실행 파일을 찾을 수 없습니다.

---

## 2️⃣ 왜 `ls`, `python3`는 `./` 없이도 되나?

이런 명령어들은 보통 `/bin`, `/usr/bin`, `/usr/local/bin` 같은 **시스템 디렉토리**에 위치해 있고, 이 경로들은 `$PATH`에 등록되어 있습니다.

### 🔸 `$PATH`란?

`$PATH`는 **쉘이 명령어를 찾을 때 참조하는 디렉토리들의 목록**입니다. `:`로 구분된 문자열이며, 다음과 같이 확인 가능합니다:

```bash
echo $PATH
```

예시 출력:

```bash
/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin
```

이 목록에 있는 디렉토리 중 하나에 `python3`, `ls` 등이 존재하므로 `./` 없이도 실행 가능한 것입니다.

---

## 3️⃣ 시스템 명령어와 사용자 스크립트 실행 방식 차이

| 구분           | 시스템 명령어 (`ls`, `python3`) | 사용자 스크립트 (`typer.sh`)   |
|----------------|-----------------------------|-----------------------------|
| 위치           | `/bin`, `/usr/bin` 등       | 현재 디렉토리(예: `./`)      |
| `$PATH` 포함 여부 | O                           | X                           |
| 실행 시 입력   | `ls`, `python3`              | `./typer.sh`                |

---

## 4️⃣ 내가 만든 스크립트를 `./` 없이 실행하려면?

### ✅ 방법 1: `$PATH`에 디렉토리를 추가

```bash
export PATH=$PATH:/home/username/scripts
```

위 명령어를 `.bashrc` 또는 `.zshrc`에 추가하면 영구 적용됩니다.

```bash
# ~/.bashrc
export PATH=$PATH:$HOME/scripts
```

스크립트 파일은 반드시 **실행 권한**이 있어야 합니다:

```bash
chmod +x typer.sh
```

이제 다음처럼 실행 가능합니다:

```bash
typer.sh
```

### ✅ 방법 2: 스크립트를 `/usr/local/bin` 등에 복사

```bash
sudo cp typer.sh /usr/local/bin/
```

이후 실행:

```bash
typer.sh
```

단, 이름 중복 주의 (`ls`, `cd` 등과 겹치지 않도록)

---

## 📌 결론 요약

- `./`는 **"현재 디렉토리에 있는 실행 파일"임을 명시**하는 역할
- 리눅스는 `$PATH`에 등록된 경로에서만 명령어를 자동 탐색
- 내가 만든 스크립트를 `./` 없이 실행하고 싶다면:
  - ① 스크립트가 있는 디렉토리를 `$PATH`에 등록하거나
  - ② 해당 스크립트를 `$PATH` 내 디렉토리로 복사
