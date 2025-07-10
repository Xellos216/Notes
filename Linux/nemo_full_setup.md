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
