# 🧭 Linux Desktop Tuning & Customization Guide

> Ubuntu GNOME 환경에서 자주 발생하는 UI 관련 불편을 해결하고, Nemo를 활용한 커스터마이징 및 초기 설정을 정리한 실전 가이드입니다.

본 문서는 리눅스를 처음 사용하는 사용자도 문제 없이 GNOME 환경을 다룰 수 있도록 초급 → 중급 → 실전 순서로 구성됩니다.

## 🟢 1. GNOME 텍스트 에디터 초기화 (초급)
GNOME Text Editor가 이전 세션을 자동 복원하는 문제 해결

➡️ 사용자 `.desktop` 파일 수정으로 항상 빈 창으로 시작하도록 설정

# ✅ 해결 방법: "항상 빈 페이지로 열리도록" GNOME Text Editor 설정하는 법

Ubuntu에서 GNOME Text Editor(기본 텍스트 편집기)가 이전에 열었던 파일들을 자동으로 복원하는 기능을 끄고, 항상 빈 페이지로 시작하도록 설정하려면 다음과 같이 사용자 정의 `.desktop` 실행 파일을 수정해야 합니다.

---

## 🔧 Step 1. 기본 실행 파일 복사

```bash
cp /usr/share/applications/org.gnome.TextEditor.desktop ~/.local/share/applications/
```

- 시스템 전체 설정을 건드리지 않고 사용자 계정 기준으로만 수정됩니다.

---

## 🔧 Step 2. 복사한 `.desktop` 파일 수정

```bash
nano ~/.local/share/applications/org.gnome.TextEditor.desktop
```

### 아래 항목 찾기:

```ini
Exec=gnome-text-editor %U
```

### 다음과 같이 수정:

```ini
Exec=gnome-text-editor --new-window %U
```

- `--new-window` 옵션을 추가하면 항상 빈 창으로 실행됩니다.

---

## 🔧 Step 3. Dock 아이콘도 수정된 설정으로 고정

1. 기존 Dock에 있는 GNOME Text Editor 아이콘 제거
2. 수정된 `.desktop` 파일을 **드래그하여 바탕화면 또는 Dock에 고정**
3. 이후 아이콘 클릭 시 항상 빈 페이지로 실행됩니다.

---

## ✅ 요약

| 항목 | 설명 |
|------|------|
| 적용 대상 | GNOME Text Editor (Ubuntu 기본 텍스트 편집기) |
| 목적 | 이전 세션 복원 방지, 항상 빈 페이지로 시작 |
| 핵심 변경 | `.desktop` 실행파일의 `Exec` 항목에 `--new-window` 옵션 추가 |

---

## 🧪 참고

- `gnome-text-editor`는 Ubuntu 22.04 이상에서 `gedit`를 대체한 기본 텍스트 에디터입니다.
- 해당 설정은 GUI로는 불가능하며 `.desktop` 파일 수정을 통해서만 가능합니다.

---

## 🟡 2. GNOME 바탕화면 아이콘 제거 (중급)
Nemo 제거 이후 바탕화면에 아이콘이 계속 남는 문제 해결

➡️ autostart, 확장 프로그램, gsettings 설정 정리

## 🔹 Remove Desktop Icons Gnome

# Ubuntu GNOME 바탕화면 아이콘 강제 제거 정리

## 📝 문제 요약

Nemo를 기본 파일 탐색기로 등록하고 삭제한 이후, 바탕화면에 원치 않는 폴더 아이콘들(Downloads, Documents 등)이 자동으로 생성되고 삭제되지 않는 문제가 발생함.

---

## 🧾 원인 분석

1. `nemo-desktop`이 바탕화면을 takeover한 설정이 autostart에 남아 있음
2. GNOME 기본 `show-desktop-icons`는 false지만, 바탕화면에 계속 아이콘이 보임
3. 실제 원인은 GNOME Shell 확장 `ding@rastersoft.com` (Desktop Icons NG) 활성화

---

## ✅ 최종 해결 절차

### 1. Nemo 관련 autostart 파일 제거

```bash
rm -f ~/.config/autostart/nemo-desktop.desktop
```

### 2. GNOME 설정에서 바탕화면 아이콘 끄기

```bash
gsettings set org.gnome.desktop.background show-desktop-icons false
```

### 3. GNOME Shell 확장 목록 확인

```bash
gnome-extensions list
```

### 4. 바탕화면 아이콘 확장 비활성화

```bash
gnome-extensions disable ding@rastersoft.com
```

### 5. 적용 반영 (Nautilus 재시작 또는 로그아웃)

```bash
nautilus -q
```

※ GNOME Wayland에서는 `gnome-shell --replace`가 동작하지 않을 수 있으므로, **로그아웃 후 재로그인** 권장

---

## ✅ 추가 팁 (선택 사항)

### 바탕화면 디렉토리 완전 무효화

```bash
xdg-user-dirs-update --set DESKTOP $HOME/.disabled_desktop
```

이후 `nautilus -q` 또는 재로그인

---

## 🟢 결과

- 바탕화면 아이콘 완전히 제거됨
- Nemo 설정 잔재 제거 완료
- GNOME 환경이 깔끔하게 복구됨

---

## 🔵 3. Nemo 완전 설정 (중~고급)
Nemo 설치부터 기본 탐색기로 설정, 단축키, 즐겨찾기, `.hidden` 활용까지 포괄적 정리

## 🔹 Nemo Full Setup

# Nemo 설치 및 설정 정리

이 문서는 Ubuntu GNOME 환경에서 Nautilus를 대체하기 위해 Nemo를 설치하고, 기본 파일 탐색기로 설정한 후, 단축키와 동작을 커스터마이징한 과정을 정리한 것이다.

---

## ✅ 1. Nemo 설치

```bash
sudo apt update
sudo apt install nemo
```

---

## ✅ 2. Nemo를 기본 파일 탐색기로 설정

```bash
xdg-mime default nemo.desktop inode/directory
```

설정 확인:

```bash
xdg-mime query default inode/directory
```

→ 결과가 `nemo.desktop`이면 성공

---

## ✅ 3. Nautilus 제거 여부

- Nautilus는 GNOME에서 바탕화면 관리 및 일부 시스템 기능에 관여하므로 **완전 제거는 비권장**
- 대신 Nemo만 기본 탐색기로 설정하고 Nautilus는 남겨두는 방식으로 처리

---

## ✅ 4. 바탕화면 아이콘 사용 여부

사용자는 **바탕화면 아이콘을 사용하지 않음**  
→ `gsettings` 설정 생략 가능

```bash
# 생략 가능: 바탕화면 아이콘 관리 설정
gsettings set org.gnome.desktop.background show-desktop-icons false
gsettings set org.nemo.desktop show-desktop-icons true
```

---

## ✅ 5. Nemo에서 현재 폴더를 터미널로 여는 기능

- Nemo는 기본적으로 **`Ctrl + T`** 를 누르면 현재 디렉토리 기준으로 터미널을 연다
- 우클릭 메뉴에서도 **“Open in Terminal”** 항목이 기본 제공됨

---

## ✅ 6. 단축키 등록 시 주의사항

전역 단축키를 사용하여 터미널을 열 때:

```bash
gnome-terminal
```

- `--working-directory="%f"` 같은 인자는 **전역 단축키에서는 작동하지 않음**
- Nemo 내에서만 현재 디렉토리 정보를 알 수 있으므로 **전역 단축키로는 불가능**

---

## ✅ 7. Nemo 시작 시 특정 폴더에서 열기 (예: Favorites)

```bash
nemo "$HOME/.local/share/nemo/favorites"
```

해당 명령을 단축키 또는 `.desktop`에 등록하면 특정 폴더에서 시작 가능

폴더가 없다면:

```bash
mkdir -p ~/.local/share/nemo/favorites
```

---

## ✅ 8. 사이드바 항목 설정

- 기본 사이드바 항목 설정은 `dconf-editor` 또는 `gsettings`로 가능
- `dconf-editor` 설치:

```bash
sudo apt install dconf-editor
```

경로 예시:

```
/org/nemo/sidebar-panels/tree/
```

설정 예시:

```bash
gsettings set org.nemo.desktop volumes-visible false
gsettings set org.nemo.desktop network-volumes-visible false
```

> 다만 GNOME 버전 및 Nemo 빌드에 따라 해당 키가 없을 수도 있음

---

## ✅ 9. 기타

- 불필요한 즐겨찾기(Quick Access) 경로는 `~/.config/gtk-3.0/bookmarks` 파일에서 직접 삭제

---

## ✅ 10. `.hidden` 파일을 이용한 사이드바 항목 숨기기

- 특정 폴더를 물리적으로 삭제하지 않고 **탐색기에서만 숨기고 싶을 때** 사용
- `~/.hidden` 파일에 숨기고 싶은 폴더명을 한 줄씩 입력

예시:

```bash
nano ~/.hidden
```

```
Templates
Videos
Pictures
Music
Public
Desktop
```

- 이후 Nemo를 재시작해야 반영됨:

```bash
nemo --quit && nemo &
```

> `.hidden` 파일은 숨김 표시 상태 (`Ctrl + H`)에서도 보이지 않을 수 있음

---

## ✅ 11. 재부팅 후에도 Nemo가 바탕화면을 계속 관리하도록 자동 실행 등록

- 기본 탐색기 설정만으로는 **재부팅 시 바탕화면 아이콘 관리가 해제될 수 있음**
- 아래 `.desktop` 파일을 만들어 autostart에 등록

```bash
mkdir -p ~/.config/autostart

cat <<EOF > ~/.config/autostart/nemo-desktop.desktop
[Desktop Entry]
Type=Application
Exec=nemo-desktop
Hidden=false
NoDisplay=false
X-GNOME-Autostart-enabled=true
Name=Nemo Desktop
Comment=Launch Nemo to manage desktop
EOF
```

> 이 설정을 통해 `nemo-desktop`가 로그인 시 자동 실행되어 바탕화면을 계속 관리함