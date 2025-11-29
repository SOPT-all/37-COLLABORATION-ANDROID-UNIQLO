# 37-COLLABORATION-ANDROID-UNIQLO
# 1. Project Overview
- 프로젝트 이름 : 모바일 앱 2조 UNIQLO <안드로이드 팀>
- 프로젝트 설명 : DIVE SOPT 37기 합동 세미나에서 진행되는 프로젝트로, UNIQLO앱에서 불편한 점을 찾아 UI/UX를 개선하여 구현합니다.
- 상세 내용 : 카테고리 뷰, 상품 목록 뷰, 상세 페이지를 개선해 구현하였습니다.

# 2. Project Prerequisites
- Gradle 버전 : 8.13
- SDK 버전
    - minSDK : 24
    - targetSDK : 36
    - compileSDK : 36

# 3. Structure & Architecture
- 주요 개발 언어 : Kotlin 2.2.21
- 아키텍처 : Clean Architecture
- 디자인 패턴 : MVVM
- 주요 라이브러리 / 프레임 워크 :
    - Jetpack Compose
    - Dagger Hilt
    - Retrofit

# 4. local properties
```kotlin
base.url = 서버 url 주소
```

# 5. 뷰 설명
## 카테고리 뷰
### 주요 개선 사항
카테고리와 세부 카테고리를 한 화면에서 선택 가능하도록 한 기존의 패션 앱과 달리
유니클로는 카테고리 선택 시, 다음 뎁스로 이동해 세부 카테고리가 나타나는 방식으로 설계됨
→ 의류 탐색 과정에서 이전의 규칙과 달라 혼동을 느낌

### 개선 포인트
- 카테고리와 세부 카테고리 뎁스를 구분하지 않고 하나의 화면에 구성
- 가독성이 떨어지는 카테고리명과 이미지 깔끔하게 정리

### 스크린샷
|                스크린샷                |
|:----------------------------------:|
| <img width="360" src="https://github.com/user-attachments/assets/4a0fe125-35fa-476d-91e9-5fdfe578e2e1" /> |


## 상품 목록 뷰
### 주요 개선 사항
상품 목록의 필터에 ‘온라인 스토어 + 선택한 매장’, ‘카테고리’, ‘판매 유형’ 등 생소한 라이팅이 사용됨
→ 사용자의 학습 없이는 해당 필터링에 대한 인식 어려움

### 개선 포인트
- 상품 필터 내 직관적이지 않은 UX라이팅을 명확하게 재구성

### 스크린샷
|                스크린샷                |
|:----------------------------------:|
| <img width="360" src="https://github.com/user-attachments/assets/924fe12a-79e2-44f5-9704-eefd55ffc7ec" /> |


## 상세 페이지
### 주요 개선 사항
기존 패션 앱은 찜과 리뷰 버튼이 눈에 띄는 곳에 위치한 반면 유니클로는 해당 기능을 강조하지 않음
또한 불필요한 설명이 지나치게 많이 있어 제품 구매에 필요한 기능들이 눈에 띄지 않음
→ 제품 탐색 과정에서 이전의 규칙과 달라 혼동을 느끼고, 불필요한 요소로 인해 주의가 분산됨

### 개선 포이트 
- 위시리스트와 리뷰 버튼을 하단부에 따로 배치 및 고정하여 페이지 스크롤 중에도 해당 기능을 즉시 사용할 수 있도록 개선
- 불필요한 문구를 제거해 사용자가 필요한 기능에 집중할 수 있도록 함

### 스크린샷
|                스크린샷                |                 스크린샷                | 
|:----------------------------------:|:----------------------------------:|
| <img width="360" src="https://github.com/user-attachments/assets/1ffac9e0-528e-4422-97cc-af57521f454a" /> | <img width="360" src="https://github.com/user-attachments/assets/4f0a3ff3-869f-4c2f-85e7-b743f90c54b3" /> |

# 전체 시연 영상
|                스크린샷                |
|:----------------------------------:|
| <video width="360" src="https://github.com/user-attachments/assets/4da6f6f0-f571-4e77-8de3-0235a0c9d3d8" /> |





