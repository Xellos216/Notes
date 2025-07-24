# Ubuntu: 유선 네트워크 연결 실패 시 점검 및 복구 절차

## 📌 상황
Ubuntu 환경에서 다음과 같은 알림 발생:

> **Connection failed**  
> Activation of network connection failed

Windows 등 타 OS에서는 유선 인터넷이 정상 작동하는 경우, **Ubuntu 내부의 설정 문제 또는 드라이버 이슈**일 가능성이 높음.

---

## ✅ 1. 빠른 1차 조치

```bash
sudo systemctl restart NetworkManager
```

- 네트워크 매니저 서비스를 재시작하여 일시적인 오류를 초기화

또는 단순 재부팅으로도 복구되는 경우 있음.

---

## ✅ 2. 장치 인식 확인

```bash
ip link
```

- `enp3s0`, `eth0` 등 유선 장치가 존재하는지 확인
- `NO-CARRIER` 표시: 케이블 연결 감지 안 됨 → 드라이버 또는 하드웨어 이슈 가능성

---

## ✅ 3. 드라이버 상태 점검

```bash
lspci -nnk | grep -A3 -i ethernet
```

- `Kernel driver in use`, `Kernel modules` 확인
- Realtek 계열이라면 기본 `r8169` 대신 `r8168-dkms` 설치 필요할 수 있음

---

## ✅ 4. 수동 DHCP 요청 (IP 할당 시도)

```bash
sudo dhclient -v enp3s0
```

- IP를 수동으로 요청하여 DHCP 서버(공유기)로부터 응답을 받는지 확인
- 실패 시 로그 출력 확인

---

## ✅ 5. 로그 확인

```bash
journalctl -xeu NetworkManager.service
```

- 정확한 실패 원인을 로그에서 추적

---

## ✅ 6. 네트워크 설정 초기화 (설정 꼬임 방지용)

```bash
sudo rm /etc/NetworkManager/system-connections/*
sudo systemctl restart NetworkManager
```

- GUI에서 다시 유선 연결을 설정해줄 것

---

## ✅ 7. Realtek 드라이버 교체 (선택)

Realtek 칩셋이 불안정한 경우 아래 실행:

```bash
sudo apt install r8168-dkms
sudo modprobe -r r8169
sudo modprobe r8168
```

```bash
echo "blacklist r8169" | sudo tee -a /etc/modprobe.d/blacklist.conf
```

- 이후 `r8168`이 기본 모듈로 적용되어 부팅 시 자동 사용됨

---

## ✅ 요약: 발생 시 우선 순위 조치

1. `sudo systemctl restart NetworkManager`  
2. `ip link`, `lspci -nnk`로 장치 및 드라이버 상태 확인  
3. `sudo dhclient -v enp3s0`로 수동 IP 요청  
4. 반복될 경우 `r8168-dkms` 설치 및 `r8169` 블랙리스트 처리

---

## 🔖 참고
- 동일 문제가 반복 발생 시, `journalctl` 로그 백업 필수
- 절전 모드 복귀 후 발생하는 경우 `udev` 자동 재탐색 이슈일 수 있음