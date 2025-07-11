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
