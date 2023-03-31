<div align="center">
# DB와 연동되는 Java GUI 게임
</br>

### 🚀 프로젝트 소개
- 사용자가 개발자 캐릭터를 육성하는 게임
- 다양한 기능을 이용하여 캐릭터 성장
- 랭킹 시스템을 통해 기록 비교
</br>

## ⌛ 개발 기간
- 23.01.02. ~ 23.01.12.

### ⚙ 개발 환경
- `Java 8`
- `JDK 1.8.0`
- **Database** : MySQL

### 🎯학습 목표
- MySQL 기능 이해와 활용
- Java 라이브러리 이해 및 응용을 통한 DB 연동

### 🚨개발 중점 사항
- 직관적인 UI 구성
- 지속적인 피드백을 통한 밸런스 조정
- 다양한 기능 개발

</br>

### 💼담당 업무
- 로그인 및 로그아웃, 회원가입 기능 구현
- DB에 스탯을 업데이트하는 기능 구현
- 미니게임 구현
- 캐릭터 활동창 GUI 구현

### 🕹주요 기능
#### 1. 초기 실행 화면
![1 로그인](https://user-images.githubusercontent.com/119999798/228733434-2e6ff6b1-1e74-409e-8b5d-d63788fa2e1c.png)
</br>
프로그램을 실행하게 되면 로그인 창이 띄워집니다. 
</br>

#### 2. 회원가입
![2 회원가입](https://user-images.githubusercontent.com/119999798/228733437-75c327eb-00b5-46b4-81b2-11960dce1698.png)
</br>
회원가입을 통해 계정을 생성할 수 있습니다. 
</br>
이때, 정규식을 이용하여 부적합한 입력값을 방지하며, 중복과 비밀번호 일치 여부 등을 검사합니다. 
</br>

#### 3. 게임 실행
![3 실행화면](https://user-images.githubusercontent.com/119999798/228733440-9df158b0-2e43-46fd-bda9-7de4697b7be0.png)
</br>
생성한 계정으로 로그인을 하게 되면 띄워지는 메인 화면입니다. 
</br>
좌측 상단에 플레이 타임과 게임의 배속 지정을 할 수 있는 버튼이 있습니다. 
</br>
그리고 하단에 보이는 HP, 스트레스, 건강 수치는 지속적으로 변화하기 때문에 여러가지 활동을 통해 관리하여야 합니다. 
</br>

#### 4. 프로젝트 창
![4 프로젝트](https://user-images.githubusercontent.com/119999798/228733442-6c94e5a5-0bb2-4222-a61e-cd8ac2a83667.png)
</br>
프로젝트 탭에서 메인 퀘스트 역할의 프로젝트를 수행할 수 있습니다. 
</br>

#### 5. 활동 창
![5 활동창](https://user-images.githubusercontent.com/119999798/228733444-7a91f9a4-27d3-4dbc-b6b6-321505c031cd.png)
</br>
활동창에서 수행할 수 있는 여러 가지 활동을 통해 HP, 스트레스, 건강, 레벨, 재화 등의 보상을 얻을 수 있습니다. 
</br>

![6 상하차](https://user-images.githubusercontent.com/119999798/228733446-9b43ddcf-074f-4d13-9790-13476299c296.png)
</br>
상하차를 통해 재화를 얻을 수 있습니다. 대신 HP와 스트레스, 건강 등의 피해가 발생합니다. 
</br>

![7 잠자기](https://user-images.githubusercontent.com/119999798/228733447-ea3d013d-edd4-463f-bfa7-ee967f88df25.png)
</br>
감소한 HP와 스트레스, 건강를 회복할 수 있도록 잠자기 등의 활동을 할 수도 있습니다. 
</br>

#### 6. 스킬 창
![8 스킬](https://user-images.githubusercontent.com/119999798/228733450-3f36dec4-3635-4ff4-b242-f8b66a80d34c.png)
</br>
재화를 사용하여 스킬을 구매할 수 있습니다. 
</br>구매한 스킬을 활동의 보상을 늘려주거나 즉각적인 효과 등을 발생시키기도 합니다. 
</br>

#### 7. 미니게임 창
![9 미니게임](https://user-images.githubusercontent.com/119999798/228733454-15ddeb2e-9320-4b53-a4b7-1d1a8b9e2537.png)
</br>
각종 미니게임을 통해 보상을 얻을 수 있습니다.
</br>

![10 두더지](https://user-images.githubusercontent.com/119999798/228733460-7cd56ab8-af2f-4b8f-bbe7-03f138515a56.png)
</br>
두더지 게임을 할 수도 있고, 
</br>

![11 틀린그림](https://user-images.githubusercontent.com/119999798/228733461-afb5933c-c1cc-44c5-a0e3-78784367ad0b.png)
</br>
틀린 그림 찾기 게임 등의 미니 게임도 존재합니다. 
</br>

#### 8. 랭킹 창
![12 랭킹](https://user-images.githubusercontent.com/119999798/228733462-c361062e-a06c-4de0-8ae4-be804d598f3b.png)
</br>
HP가 0이 되면 게임오버가 되며, 이렇게 플레이된 기록들은 랭킹을 통해 확인할 수 있습니다. 
</br>

#### 9. 설정 창
![13 설정창](https://user-images.githubusercontent.com/119999798/228733463-21965435-a182-4d18-a2ff-1123723cdcb2.png)
</br>
설정창에서 로그아웃, 회원탈퇴를 할 수 있습니다.
</br>
회원 탈퇴 시 계정은 삭제되며 해당 계정으로는 추가적인 게임이 불가능하게 됩니다. 
</br>
로그아웃 시 다시 로그인 하게 되면 이전 게임을 이어서 할 수 있습니다. 

</br>
</br>

### 💡배우고 느낀 점
- 많은 기능을 구현하려고 하다 보니 코드 역시 길어지게 되었습니다. 그 과정에서 팀원 간 서로의 코드를 이해하는 것에 불편함이 있었고, 이를 해결하기 위해 지속적으로 패키지와 클래스 파일의 이름이나 코드 등을 변경하며 리팩터링을 진행하였습니다. 덕분에 다른 팀원의 코드를 보며 의도를 파악하기 수월해졌고, 깔끔하게 정리된 프로젝트와 코드가 특히나 협업에 있어서 중요하다는 것을 체감하게 되었습니다.</br>
</br>
</div>
