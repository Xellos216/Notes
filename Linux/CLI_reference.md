# 🖥️ Linux CLI 실전 정리 가이드

> 터미널에서 자주 사용하는 단축키, 명령어 패턴, 텍스트 편집기 nano 사용법, 안전한 삭제 명령어 등을 초급 → 고급 순으로 정리한 실전형 CLI 요약입니다.

## 🟢 1. 터미널 단축키 총정리 (입문)
Bash 기준으로 명령어 편집, 조작, 히스토리 탐색 등에 쓰이는 핵심 단축키를 정리합니다.
### 🔹 Linux CLI Shortcuts
# Linux CLI Keyboard Shortcuts (Bash 기준)

## ✅ 터미널 조작 관련 단축키

| 단축키 | 기능 설명 |
|--------|-----------|
| `Ctrl + L` | 📌 **화면 지우기 (clear 명령과 동일)** |
| `Ctrl + C` | 현재 실행 중인 명령어 **강제 종료** |
| `Ctrl + D` | 현재 터미널 세션 **종료** (exit 역할) |
| `Ctrl + Z` | 현재 프로세스를 **백그라운드로 보냄** (suspend) |
| `fg` | `Ctrl+Z`로 백그라운드 보낸 프로세스를 **포그라운드로 복귀** |

---

## ✅ 명령어 편집 관련 단축키

| 단축키 | 기능 설명 |
|--------|-----------|
| `Ctrl + A` | 커서를 **줄 맨 앞으로 이동** |
| `Ctrl + E` | 커서를 **줄 맨 끝으로 이동** |
| `Ctrl + U` | 커서부터 **줄 시작까지 삭제** |
| `Ctrl + K` | 커서부터 **줄 끝까지 삭제** |
| `Ctrl + W` | 커서 앞의 **한 단어 삭제** |
| `Alt + D` | 커서 뒤의 **한 단어 삭제** |
| `Ctrl + Y` | 마지막에 삭제한 텍스트 **붙여넣기 (yank)** |
| `Alt + .` | **이전 명령어의 마지막 인자** 재사용 |

---

## ✅ 명령어 검색 및 실행 히스토리

| 단축키 | 기능 설명 |
|--------|-----------|
| `Ctrl + R` | **히스토리에서 명령어 검색** |
| `Ctrl + G` | `Ctrl + R` 검색 중단 |
| `↑` / `↓` | 이전/다음 명령어 히스토리 탐색 |
| `!!` | 직전 명령어 실행 |
| `!abc` | 최근 실행한 `abc`로 시작하는 명령어 재실행 |

---

## ✅ 프로세스 제어 및 기타

| 단축키 | 기능 설명 |
|--------|-----------|
| `Ctrl + S` | **출력 멈춤** (scroll freeze) → `Ctrl + Q`로 해제 |
| `Ctrl + Q` | 출력 재개 |
| `Tab` | 자동 완성 |
| `Tab Tab` | 자동 완성 가능한 목록 표시 |

---

## ✅ clear 단축키 정리

| 명령어 | 역할 |
|--------|------|
| `clear` | 화면을 지우되 히스토리는 남음 |
| `Ctrl + L` | **clear와 동일한 기능**, 빠르게 화면 클리어 |
| `reset` | 화면 클리어 + 터미널 상태 초기화 (터미널이 깨졌을 때 사용) |

---

## 🟡 2. 파일/디렉토리 명령어 모음 (실전)
파일 삭제, 디렉토리 복사, 구조 출력 등 자주 쓰이는 명령어를 모았습니다.
### 🔹 Useful Commands
# Useful Commands for File & Folder Management

정리 및 자동화 작업에 자주 사용하는 CLI 명령어들을 정리한 문서입니다.

---

## 🔍 1. 특정 이름의 파일 일괄 삭제

```bash
find . -type f -name "Java.png" -delete
```

- 현재 디렉토리 이하에서 이름이 `Java.png`인 모든 파일을 찾아 삭제함.

---

## 📄 2. 특정 확장자의 파일 경로 출력

```bash
find . -type f -name "*.md" -print
```

- 현재 디렉토리 이하의 모든 `.md` 파일 경로를 출력함.

---

## 🧹 3. pycache 디렉토리 일괄 삭제

```bash
find . -type d -name "__pycache__" -exec rm -r {} +
```

- Python 실행 시 생기는 `__pycache__` 디렉토리를 찾아 모두 삭제함.

---

## 🗑 4. 폴더 강제 삭제

```bash
rm -rf folder_name/
```

- 지정한 폴더를 강제로 삭제함. **주의해서 사용해야 함**.

---

## 🔀 5. 파일 또는 디렉토리 이동/이름 변경

```bash
mv source target
```

- `source` 파일 또는 폴더를 `target` 위치로 이동하거나 이름을 변경함.

---

## 📂 6. 디렉토리 복사

```bash
cp -r source/ destination/
```

- 디렉토리를 포함한 모든 내용을 재귀적으로 복사함.

---

## 🌳 7. 디렉토리 구조 출력 (2단계까지)

```bash
tree -L 2
```

- 현재 디렉토리부터 2단계까지의 구조를 트리 형식으로 출력함.

---

---

## 🟡 3. nano 텍스트 편집기 단축키 (실전)
nano는 리눅스에서 가장 간편한 텍스트 편집기로, 핵심 단축키를 기능별로 정리합니다.
### 🔹 Nano Shortcuts
# Nano Editor 단축키 정리

`nano`는 간단하고 직관적인 터미널 텍스트 편집기입니다. 아래는 자주 사용하는 단축키들을 기능별로 정리한 것입니다.

---

## 📌 기본 이동

| 기능 | 단축키 |
|------|--------|
| 커서 왼쪽 / 오른쪽 | `←` / `→` |
| 커서 위 / 아래 | `↑` / `↓` |
| 단어 단위 앞으로 / 뒤로 | `Ctrl + ←` / `Ctrl + →` |
| 줄의 맨 앞으로 / 뒤로 | `Ctrl + A` / `Ctrl + E` |
| 문서 맨 위 / 맨 아래 | `Ctrl + Y` / `Ctrl + V` |

---

## ✂️ 텍스트 편집 (복사/자르기/붙여넣기)

| 기능 | 단축키 |
|------|--------|
| 한 줄 잘라내기 (Cut) | `Ctrl + K` |
| 붙여넣기 (Paste) | `Ctrl + U` |
| 복사 (Copy) | `Alt + 6` |

> 📌 **블록 복사 방법**  
> 1. `Ctrl + ^` (또는 `Ctrl + Shift + 6`) → 마킹 시작  
> 2. 방향키로 블록 선택  
> 3. `Alt + 6` 으로 복사  
> 4. `Ctrl + U` 로 붙여넣기

---

## 🧹 삭제

| 기능 | 단축키 |
|------|--------|
| 현재 줄 잘라내기 | `Ctrl + K` |
| 선택 영역 삭제 | `Ctrl + K` (블록 선택 상태에서) |
| 한 글자 삭제 | `Backspace` 또는 `Ctrl + D` |

---

## 💾 저장 & 종료

| 기능 | 단축키 |
|------|--------|
| 저장 (Write Out) | `Ctrl + O` → Enter |
| 종료 (Exit) | `Ctrl + X` |
| 저장 없이 종료 | `Ctrl + X` → `N` 입력 |

---

## 🔎 검색 & 바꾸기

| 기능 | 단축키 |
|------|--------|
| 검색 (Find) | `Ctrl + W` |
| 다음 검색 결과로 이동 | `Alt + W` |
| 바꾸기 (Replace) | `Ctrl + \` |

---

## 📍 기타 유용한 기능

| 기능 | 단축키 |
|------|--------|
| 도움말 보기 | `Ctrl + G` |
| 현재 위치 표시 | `Ctrl + C` |
| 줄 번호로 이동 | `Ctrl + _` → 숫자 입력 |

---

## 🔴 4. `rm` 명령어 안전 사용법 (중요)
실수로 시스템을 날릴 수 있는 `rm -rf`를 안전하게 사용하는 방법을 요약합니다.
### 🔹 Rm Command Summary
# Linux `rm` Command Summary

The `rm` command (short for **remove**) is used in Linux to delete files and directories. This document summarizes its behavior and common options.

---

## 🔹 Basic Usage

```bash
rm filename.txt
```

- Deletes a single file.
- **Does not work on directories** without additional options.

---

## 🔸 Common Options

| Option | Full Form | Description |
|--------|-----------|-------------|
| `-r`   | `--recursive` | Recursively deletes directories and their contents |
| `-f`   | `--force`     | Force deletion without prompt or error messages |
| `-i`   | `--interactive` | Ask before every deletion |
| `-v`   | `--verbose`   | Show what is being deleted |

---

## ⚠️ Dangerous Commands

### `rm -r directory/`
- Deletes the directory and everything inside it.
- Will prompt for confirmation (depending on permissions).

### `rm -rf directory/`
- **Forcefully and recursively deletes all contents**.
- **No prompts, no warnings.**
- ⚠️ This command is dangerous and irreversible.

---

## ✅ Safe Practices

- Use `-i` when unsure:
  ```bash
  rm -ri my_folder/
  ```

- Use `trash-cli` or move to trash instead of deleting:
  ```bash
  trash filename.txt
  ```

- Always double-check the path before running `rm -rf`.

---

## 📌 Summary

| Command | Purpose |
|---------|---------|
| `rm file.txt` | Delete file |
| `rm -r folder/` | Recursively delete folder |
| `rm -f file.txt` | Force delete file |
| `rm -rf folder/` | Force and recursively delete folder (no confirmation) |

---

> 💡 Always think twice before using `rm -rf`, especially as `root`.

---

# 📁 파일 정보 확인을 위한 유용한 Bash 명령어

이 문서는 파일의 크기, 타임스탬프, 권한 등을 확인할 때 유용한 Bash 명령어를 요약한 것입니다.

---

## 📁 1. 파일 크기 및 메타데이터 보기

```bash
ls -lh filename
```

- `-l`: 긴 형식으로 출력 (권한, 소유자, 크기, 수정 시간 등)
- `-h`: 사람이 읽기 쉬운 단위(KB, MB, GB 등)로 표시

예시:
```bash
ls -lh video.mp4
# 출력 예: -rw-r--r-- 1 user user 18M Jul 17 19:48 video.mp4
```

---

## 📏 2. 바이트 단위의 정확한 파일 크기 확인

```bash
stat -c %s filename
```

- 파일 크기를 **바이트 단위로 정확히** 반환함
- 스크립트나 정밀 비교 시 유용

예시:
```bash
stat -c %s video.mp4
# 출력 예: 18350080
```

---

## 📊 3. 디스크 사용량 확인 (파일 시스템 블록 단위)

```bash
du -h filename
```

- 해당 파일이 디스크에서 실제로 차지하는 용량을 표시
- 파일 시스템의 블록 단위 오버헤드 포함됨

예시:
```bash
du -h video.mp4
# 출력 예: 20M    video.mp4
```

---

## ⏱️ 4. 파일의 모든 타임스탬프 보기

```bash
stat filename
```

- 수정 시간(`Modify`), 접근 시간(`Access`), 변경 시간(`Change`)을 모두 보여줌
- 추가로 권한, inode 번호, 파일 크기도 표시됨

예시:
```bash
stat video.mp4
```

---

## 🔐 5. 파일 권한만 확인하기

```bash
ls -l filename
```

- 파일의 권한, 소유자, 그룹 정보를 보여줌

예시:
```
-rw-r--r-- 1 user user ...
```

---

## 📂 6. 디렉토리 내 파일 개수 세기

```bash
ls -1 | wc -l
```

- `ls -1`: 파일을 한 줄에 하나씩 출력
- `wc -l`: 줄 수를 세어 파일 개수를 파악

---

## 🧪 7. MIME 타입 확인 (파일 형식 판별)

```bash
file --mime-type filename
```

- 확장자와 관계없이 파일의 실제 콘텐츠 형식(MIME Type)을 감지

예시:
```bash
file --mime-type video.mp4
# 출력 예: video/mp4
```

---

## 🧰 보너스: 전체 정보를 출력하는 스크립트 예제

```bash
#!/bin/bash
f="$1"
echo "이름: $f"
ls -lh "$f"
echo "정확한 크기 (bytes): $(stat -c %s "$f")"
echo "디스크 사용량: $(du -h "$f" | cut -f1)"
echo "MIME 타입: $(file --mime-type -b "$f")"
```

스크립트 이름을 `file_info.sh`로 저장한 뒤 아래처럼 실행:

```bash
./file_info.sh yourfile.mp4
```
