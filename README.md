![header](https://capsule-render.vercel.app/api?type=egg&color=FF834E)

# 🍔 Burger Drop

<br>

## 👉🏻 서비스 소개

    집에서도 햄버거의 맛을 놓치지 마세요! 햄버거 포장&메뉴 웹사이트로 원하는 햄버거를 주문하고, 배달 받고, 즐기세요! 
    BD는 당신의 입맛에 맞는 햄버거를 쉽고 빠르게 제공합니다. 
    다양한 종류의 햄버거, 사이드 메뉴, 음료수 등을 원하는 조합으로 선택하세요. 
    햄버거 포장&메뉴 웹사이트와 함께 라면 언제 어디 서나 맛있는 햄버거를 즐길 수 있습니다.

<br>

## ❓기획 의도

    버거킹을 모토로 한 인터넷 주문 배달 사이트

<br>

## 개발 환경

     Spring Version : 3.1.2
     JDK Version : 17

<br>

## 🗓️ 프로젝트 기간

    2023년 8월 16일 ~ 2023년 9월 18일

<br>

## 🔧 사용한 Tool

<div style="display: flex; justify-content: center;">
  <img src="https://img.shields.io/badge/Java-007396?&style=flat&logo=Java&logoColor=white" style="margin-right: 10px;">
  <img src="https://img.shields.io/badge/HTML5-E34F26?style=flat&logo=HTML5&logoColor=white" style="margin-right: 10px;"/>
	<img src="https://img.shields.io/badge/CSS3-1572B6?style=flat&logo=CSS3&logoColor=white" style="margin-right: 10px;" />
  <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat&logo=javascript&logoColor=white" />
</div>

<div style="display: flex; justify-content: center;">
  <img src="https://img.shields.io/badge/Spring-6DB33F?&style=flat&logo=spring&logoColor=white" style="margin-right: 10px;">
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=mysql&logoColor=white" style="margin-right: 10px;"/>
  <img src="https://img.shields.io/badge/ApachetTomcat-F8DC75?style=flat&logo=apachetomcat&logoColor=white"/>
</div>

<div style="display: flex; justify-content: center;">
  <img src="https://img.shields.io/badge/Git-F05032?style=flat&logo=git&logoColor=white" style="margin-right: 10px;">
  <img src="https://img.shields.io/badge/Github-181717?style=flat&logo=github&logoColor=white" style="margin-right: 10px;">
  <img src="https://img.shields.io/badge/Intellijidea-000000?style=flat&logo=intellijidea&logoColor=white" style="margin-right: 10px;">
  <img src="https://img.shields.io/badge/Postman-FF6C37?style=flat&logo=postman&logoColor=white" style="margin-right: 10px;">
</div>

<div style="display: flex; justify-content: center;">

  <img src="https://img.shields.io/badge/Redis-DC382D?style=flat&logo=Redis&logoColor=white" style="margin-right: 10px;">
  <img src="https://img.shields.io/badge/Bootstrap-7952B3?style=flat&logo=Bootstrap&logoColor=white" style="margin-right: 10px;">
  <img src="https://img.shields.io/badge/Slack-4A154B?style=flat&logo=Slack&logoColor=white" style="margin-right: 10px;">
  <img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=flat&logo=Thymeleaf&logoColor=white" style="margin-right: 10px;">
</div>

<div style="display: flex; justify-content: center;">
  <img src="https://img.shields.io/badge/WebSocket-F56640?style=flat&logo=WebSocket&logoColor=white" style="margin-right: 10px;">
  <img src="https://img.shields.io/badge/Amazon S3-569A31?style=flat&logo=Amazon S3&logoColor=white" style="margin-right: 10px;">
  <img src="https://img.shields.io/badge/ApachetTomcat-F8DC75?style=flat&logo=apachetomcat&logoColor=white" style="margin-right: 10px;"/>
  <img src="https://img.shields.io/badge/Docker-2496ED?style=flat&logo=Docker&logoColor=white" style="margin-right: 10px;"/>
</div>

<br>
<h2>⚙️서비스 아키텍처</h2>
<p align="center">
  <img src="https://github.com/burger-drop/burger-drop-repo/assets/94231335/6d9e5d0d-3196-4ba6-8464-83a8caf078fa" style="margin-right: 10px;">
</p>


<br>

# ✨주요 기능
1. Redis를 활용한 Refresh token 운용 - JWT의 취약점 보완 및 로그인 상태 유지
2. AWS S3를 활용한 이미지 파일 업로드 및 저장
3. SMTP를 활용한 이메일 인증 기능
4. WebSocket, stomp, Redis 사용한 채팅 기능
5. AWS EC2를 사용한 배포
6. Redis와 Interceptor를 활용한 방문자 정보 저장 - 총 방문자 수와 주된 방문 경로 파악
7. Swagger 연동 - API 명세서 작성 시간 단축 및 API 테스트 보조
8. 위치기반 API를 활용한 거리계산, 배달예정시간 계산
9. Redis Cache 적용 - 상품 목록 조회, 상품 단건 조회
10. Docker 사용 - 최대한 환경에 구애받지 않고 안정적으로 프로그램 구동 및 배포, 확장 가능
11. SSE를 사용한 알림기능

<br>

## 💫 기능

`회원 가입 / 로그인`
- 유저는 회원가입 시 이메일 인증을 해야한다.
- 소셜 로그인 가능 (구글, 카카오, 네이버)
    - 소셜 로그인 버튼 클릭 → 기존 회원이면 로그인 → 기존 회원 아니면 회원가입

`유저`
- 유저 페이지에서 정보 조회, 수정, 탈퇴, 로그아웃 가능하다.
- 주문내역과 리뷰 작성 내역을 볼 수 있다.

`상품`
- 회원 가입이나 로그인 하지 않아도 전체 상품 조회가 가능하다.
- 회원 가입이나 로그인 하지 않아도 상품 키워드 검색 기능을 사용할 수 있다.
- 관리자는 상품 생성, 조회, 수정, 삭제가 가능하다.
- 관리자는 옵션 생성, 조회, 수정, 삭제가 가능하다.
- 카테고리 별로 상품을 확인할 수 있다. [햄버거, 음료, 사이드]

`리뷰`
- 유저는 리뷰 생성, 조회, 수정, 삭제가 가능하다
- 리뷰를 쓸 때 별점을 부여할 수 있다.
- 음식 이미지를 첨부할 수 있다.

`장바구니`
- 유저는 장바구니에 상품을 추가, 조회 및 삭제가 가능하다.
- 장바구니에 상품을 담을 때, 해당 상품의 카테고리 별로 정해진 옵션을 추가할 수 있다.
- 옵션을 추가할 경우 옵션 별로 추가 가격이 청구된다.
- 장바구니에 담긴 상품을 주문할 수 있다.
- 주문할 때 포장 or 배달을 선택할 수 있다.

`배달 / 포장`
- 포장을 선택한다면 조리 시간을 더한 시간이 포장 시간으로 표시된다.
- 배달을 선택한다면 원래 금액에서 2000원이 추가된다.
- 주문 완료 시간에 배달 시간을 추가하여 총 시간이 표시가 되는데 여기서 배달 시간이란 매장과 사용자 간의 거리를 위도와 경도를 통해서 1km 당 1분 씩 추가한 시간을 말한다.
- 사용자는 자신의 모든 주문 목록 중 최신의 10개까지 조회할 수 있다.
- 사용자는 자신의 준비 중인 주문을 취소할 수 있다.
- 관리자는 최대 100개의 최신의 완료된 주문 목록과 모든 준비 중인 주문 목록을 조회할 수 있다.
- 5분마다 전체 준비 중인 주문 목록을 조회하여 완료 시간을 넘은 주문을 완료 상태로 바꾼다.

`채팅`
- 유저는 관리자에게 1:1 문의를 할 수 있다.
- 채팅방 생성 및 종료는 유저만 가능하다.
- 관리자는 전체 채팅방 조회를 할 수 있다.

`알림`
- 사이트를 이용 중인 유저에게 SSE(Server Sent Event)를 이용하여 실시간 알람을 기능 제공하고 있다.
- 회원정보 수정, 주문 완료 및 취소, 배달 완료시 알림이 표시된다.
- 알림 전체 삭제가 가능하다.

`백오피스`
- Interceptor를 통해 홈페이지 방문자들의 ip주소, 방문한 경로, 방문 시각을 저장한다.
- 관리자는 방문자 목록 조회, ip주소로 방문자 검색, 총 방문자 수 확인을 할 수 있다.
- 관리자는 총 주문 수를 확인할 수 있다.
- 관리자는 전체 회원가입한 유저 목록을 조회할 수 있고, 일반 유저의 정보를 수정하거나, 탈퇴시킬 수 있다.
- 관리자는 username과 nickname을 키워드로 검색할 수 있다.

<br>

# 🧑🏻‍💻 담당 업무

| 이름 | 기능 |
| :-- | :-- |
| 김예성 (리더) | Oauth2 카카오톡 소셜로그인<br>스프링 시큐리티 필터로 로그인 구현 (JWT 토큰 인증/인가)<br>Redis를 활용한 refreshToken 저장 accessToken 발급<br>비밀번호 암호화 BCryptPasswordEncoder<br>S3 활용한 이미지 업로드<br>마이페이지(프로필 조회 및 수정, 리뷰 내역 조회, 주문 내역 조회)<br>SMTP 이메일 인증<br> 담당한 백엔드의 프론트엔드 페이지 작성 및 연결 |
| 서지인 (부리더) | WebSocket, STOMP, redis를 사용한 실시간 채팅 기능<br> SSE 실시간 알림 기능<br> 담당한 백엔드의 프론트엔드 페이지 작성 및 연결 |
| 신성민 | 상품, 옵션, 장바구니, 주문 CRUD 작성 및 엔티티 연관관계 설정<br> 위치기반 API를 사용하여 거리계산 및 배달소요시간 계산<br> 스케쥴러를 사용하여 주문 목록 관리 및 수령 완료 처리<br> 상품목록, 방문자 IP주소, 유저목록 키워드 검색 기능<br> 백오피스(총 매출액, 모든 주문 목록, 총 유저 목록, 방문자 목록, 조회수 확인)<br> Redis, Interceptor 를 사용한 방문자 정보 저장<br> Swagger 연동 (JWT 인증 버튼 포함)<br>상품에 평점 기능 추가<br> 상품 목록 조회, 상품 단건 조회에 Redis Cache 적용<br> 담당한 백엔드의 프론트엔드 페이지 작성 및 연결 |
| 박진성 | 유저 평판 관리(리뷰 조회, 작성, 수정, 삭제, 좋아요, 좋아요 취소, 평점)<br> AWS EC2를 활용한 배포<br> Git Actions를 활용한 CI/CD 구축 |

<br>

# ✔️ 기술적 의사 결정

<details>
<summary>검색 기능에 QueryDsl 적용 여부</summary>
<div markdown="1">       

<br>

### - 기술의 개념

    - QueryDSL은 하이버네이트 쿼리 언어(HQL: Hibernate Query Language)의 쿼리를 타입에 안전하게 생성 및 관리해주는 프레임워크이다. 정적 타입을 이용하여 SQL과 같은 쿼리를 생성할 수 있게 해 준다. 자바 백엔드 기술은 Spring Boot와 Spring Data JPA를 함께 사용한다. 하지만, 복잡한 쿼리, 동적 쿼리를 구현하는 데 있어 한계가 있다. 이러한 문제점을 해결할 수 있는 것이 QueryDSL이다.

     - 왜 이 기술을 선택했는지?

    - 검색할 때 사용자가 바라는 특징에 부합하는 상품을 검색 결과로 보여주어 더 나은 서비스를 제공하기 위해서이다.
    - JPQL과 비교하였을 때 가독성이 높고 확장 가능한 동적 쿼리를 작성할 수 있어 Querydsl을 사용했다.

     - 기술의 장, 단점

    - 장점
        - 사용자가 원하는 상품을 조금 더 빠르게 찾을 수 있다.
    - 단점
        - 메인 페이지의 로딩 시간이 증가한다.
        - 이미 카테고리 별로 나누어서 조회하는 기능이 있기에 큰 쓸모가 없다.
        - 검색 기능을 위해 상품 엔티티의 컬럼이 쓸데없이 증가할 수 있다.

</div>
</details>

<details>
<summary>채팅 저장소 Redis , MySQL</summary>
<div markdown="1">       

     - 기술의 개념

    - Redis
        - 데이터베이스, 캐시, 스트리밍 엔진 및 메시지 브로커로 사용하는 오픈 소스 인메모리 데이터 저장소
        - 메모리 기반의 key-value 저장소로, 다양한 자료구조를 지원
        - 인메모리 데이터 저장, 키-값 저장, 높은 가용성, 풍부한 데이터 구조, 빠른읽기와 쓰기 가 특징이다.
    - MySQL
        - 관계형 데이터베이스 관리 시스템 (RDBMS)
        - 표 형태의 데이터를 관리허며, 데이터는 여러 테이블에 저장되고 이러한 테이블 간의 관계를 통해 데이터 구성
        - 구조화된 데이터, SQL 쿼리, 트랜잭션 관리, 확장성이 특징이다.

     - 왜 이 기술을 선택했는지?

    - 데이터로서의 가치를 더 중점으로 두었고 데이터를 휘발하는게 아니라 영구적으로 가지고 있기 위해 mysql 선택

</div>
</details>

<details>
<summary>Swagger 연동</summary>
<div markdown="1">       

     - 기술의 개념

    - 현재 개발 중인 코드를 Swagger와 연동하여 프로젝트에 작성된 controller의 API 명세들을 한번에 확인할 수 있다. 또한 Swagger UI를 이용하면 API를 쉽게 테스트할 수 있으며, API 호출 시 전달해야 할 파라미터를 확인할 수 있기에 프론트엔드 개발에도 도움을 줄 수 있다.

     - 왜 이 기술을 선택했는지?

    - API 문서를 생성할 때, 따로 개발자가 문서를 작성하지 않아도 되므로 개발 시간을 단축할 수 있고, 코드에서 수정한 부분이 즉시 자동으로 Swagger UI에도 적용되기 때문이다.

     - 기술의 장, 단점

    - 장점 : API 문서를 생성할 때, 따로 개발자가 문서를 작성하지 않아도 되므로 개발 시간을 단축할 수 있다. 코드의 변경점이 자동적으로 적용된다. API 기능을 테스트하기 편하다.
    - 단점 : Mockito 와 같은 가짜 객체로 기능만을 테스트하는 것이 아니기에 프로젝트 전체를 실행해야 원하는 기능을 시험해 볼 수 있다.

     - 참고 자료

    - https://swagger.io/specification/
    - https://marketplace.visualstudio.com/items?itemName=42Crunch.vscode-openapi

    - 대체 기술
        - POSTMAN
        - GitBook

</div>
</details>

<details>
<summary>위치기반 API를 사용한 거리계산 및 배달소요시간 계산</summary>
<div markdown="1">       

     - 기술의 개념

    - 카카오의 지도 url과 연계된 위치기반 API를 사용하여 사용자가 입력한 주소로부터 상세 주소, 위도, 경도 등을 가져온다. 가져온 상세 주소의 앞 부분에 표시되는 지역을 확인하고, 그 지역의 중심부 위도, 경도로 부터 사용자의 위도, 경도 까지 얼마나 차이가 있는지 km단위로 계산한다.

     - 왜 이 기술을 선택했는지?

    - 카카오는 예전에 다음(한메일)을 인수하며 DAUM 지도 시스템을 함께 가져왔고, 현재 카카오 택시나 카카오 지도와 같은 서비스를 실제로 운영하고 있다. 또한 개발자를 위한 가이드라인도 상세하게 잘 작성되어 있어서 처음 위치기반 API를 사용하고 학습함에 있어 가장 진입장벽이 낮을 것이라고 생각했다.
    - 찾아보니 구글맵, 네이버지도, 카카오맵을 비교, 정리한 자료가 있었다. 버거드롭 프로젝트는 국내 고객에게 서비스를 제공하는 것을 상정하고 있기에 제공하는 정보량보다는 속도에 중점을 두어 선택하였다.
    - 속도 테스트에서 첫 로딩은 구글맵이 가장 빠르고 네이버맵 이 가장 느렸지만, 검색시간은 구글맵이 압도적으로 느리고 카카오맵이 가장 빨랐다. 그렇기에 속도와 사용성 측면에서 가장 이점이 있다고 생각되는 카카오맵의 위치기반 API를 사용하기로 결정하였다.

    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/d00db562-2625-4cce-9cbc-a0f0008aa8e5/9ac851ad-e24c-4df8-b0dc-9c4d8ff26daa/Untitled.jpeg)

    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/d00db562-2625-4cce-9cbc-a0f0008aa8e5/01d752cb-ec21-4038-8638-d4c312dd1345/Untitled.jpeg)

     - 기술의 장, 단점

    - 장점 : 진입장벽이 낮다. 가이드라인이 잘 작성되어 있어 다른 기능에 접목하여 사용하기 용이하다.
    - 단점 : 이러한 외부 Rest API를 사용해본 경험이 많지 않아 어떤 점이 단점인지 잘 모르겠다.

     - 참고 자료

    - https://apis.map.kakao.com/web/guide/
    - https://developers.kakao.com/docs/latest/ko/local/dev-guide
    - https://fruitdev.tistory.com/189
    - https://epdev.tistory.com/8

    - 대체 기술이 있는가?
        - 구글맵, 네이버지도
        - 사설 지도 서비스 유료 API

</div>
</details>

<details>
<summary>Redis와 Interceptor를 사용하여 방문자 정보 저장</summary>
<div markdown="1">       

     - 기술의 개념

    - Interceptor를 사용하여 홈페이지에 방문한 방문자의 ip주소, 입장 경로, 방문 시각을 가져와 Redis에 저장한다. 1시간마다 Redis에 저장된 방문자들의 정보를 한꺼번에 DB에 옮겨 저장하고 Redis에 있는 정보들은 삭제하고 다시 방문자 정보를 수집한다. Redis에 저장했다가 한 번에 옮기는 이유는 방문자가 들어올 때 마다 DB에 연결하여 저장하는 것은 DB I/O가 너무 많아 DB에 대한 부담이 크게 증가한다고 생각했기 때문이다.

     - 왜 이 기술을 선택했는지?

    - 방문자의 ip주소를 수집하는 기능과, 접근과 처리 속도가 가장 빠른 Redis를 한번쯤은 써보고 싶었기 때문이다.

     - 기술의 장, 단점

    - 장점 : DB에 부담이 덜 간다.
    - 단점 : nginx나 프록시를 사용하는 방문자들에게서는 ip주소를 제대로 수집할 수 없다.

     - 참고 자료

    - https://foot-develop.tistory.com/61

</div>
</details>

<br>

# 🙃 트러블 슈팅

<details>
<summary>JWT의 보안적 취약성</summary>
<div markdown="1">       

- 만료 기한이 짧은 엑세스 토큰과 만료 기한이 긴 리프레시 토큰을 사용
- 리프레시 토큰은 영구적으로 보관할 필요가 없으니 속도가 빠른 레디스를 저장소로 사용
- 리프레시 토큰까지 탈취 되었을 때를 대비하여 강제종료 API 마련

</div>
</details>

<details>
<summary>Swagger 인증버튼 문제</summary>
<div markdown="1">       

- 현재 진행 중인 프로젝트의 인증, 인가 방식은 토큰값을 헤더가 아닌 쿠키에 저장하는 방식을 가지고 있다. 그래서 기본적으로 헤더에서 토큰 값을 가져오는 Swagger의 인증버튼이 제대로 동작하지 않는 문제가 있었다.
- Swagger 공식 문서에 Cookie Authentication이라는 기능도 있었지만 이 기능을 사용할 경우 CSRF 공격에 취약해 지므로 CSRF 토큰까지 사용할 필요가 있기에, 이 기능을 사용하기보다는 프로젝트 인증 방식에서 헤더에도 토큰값을 추가해주는 걸로 문제를 해결하였다.

</div>
</details>

<details>
<summary>Redis 키 조회 시 병목현상 발생</summary>
<div markdown="1">       

- Redis는 단일 쓰레드 아키텍쳐이기에 처리가 오래 걸리는 명령을 요청할 경우 그 동작이 마무리 될 때가지 다른 요청을 멈춰두게 되어 병목현상이 발생하게 된다. 특히나 keys, flushall 등의 명령어는 테스트나 소량의 데이터 환경에서는 괜찮지만 점차 데이터를 쌓아가는 환경에서는 운영에 차질을 빚을 정도로 속도가 느려지는 문제가 있다.
- keys 명령어를 scan으로 대체하여 병목 현상을 최소화.

</div>
</details>

<details>
<summary>Redis 캐시를 적용하여 성능 향상</summary>
<div markdown="1">       

- 버거드롭 주문 사이트에서 가장 중요도가 높으면서 조회 빈도도 높은 메인 페이지 음식 목록 조회에 Redis Cache를 적용하여 성능을 향상시켰다. 처음 조회할 때는 650ms 이상이 소요되었지만, 캐시를 적용하고 나서는 평균적으로 60ms 대를 기록하여 약 10배에 가까운 성능 향상이 있었다.
- 상품 단건 조회에서도 처음 조회할 때는 150ms 걸렸지만, 캐시를 적용하고 나서는 50ms 를 기록하여 약 3배의 성능 향상이 있었다.

- 문의하기에서 채팅 메시지 죄회할 때 Redis Cache를 적용하여 성능 향상을 시켰다. 14.16KB에서 적용하기 전 평균 45ms, 캐시 적용 후 평균 15ms로 약 3배 이상 성능이 향상되었음.  

</div>
</details>

<details>
<summary>Interceptor를 사용하여 방문자 정보 저장 시 DB 부담 증가</summary>
<div markdown="1">       

- 방문자가 들어올 때마다 해당 정보를 DB에 입력하는 것은 DB와 서버 간의 I/O 빈도를 너무 높여 부담을 높이는 문제가 있다.
- Redis에 방문자 정보들을 모아두었다가 일정 시간마다 벌크 데이터를 한 번에 입력하여 DB에 저장하고 Redis의 정보는 삭제한다. 이러한 방식으로 쓰기 작업의 빈도를 줄여 DB와 서버의 부담을 줄였다.

</div>
</details>

<details>
<summary>Docker를 사용하던 도중 해킹 발생</summary>
<div markdown="1">       

- Docker로 MySQL, Spring, Redis 이렇게 3개의 컨테이너를 돌리는데 Redis에 비밀번호 설정을 안 했더니 바로 해킹을 당하였다. 알아본 바에 의하면 해커들이 뿌려놓은 크롤러 봇에 의해 Redis의 일부가 코인 채굴 사이트에 할당되도록 수정되어 있었다.
- docker-compose의 Redis와 MySQL에 비밀번호를 설정하여 문제를 해결하였다.

</div>
</details>

<details>
<summary>ubuntu환경에 Redis 설정하는 도중 오류 발생</summary>
<div markdown="1">       

- ubuntu 원격으로 돌리면서 Redis를 redis-erver 명령어로 실행하고 git bash를 종료하면 Redis 서버가 실행되는 상태이지만 기능을 사용할 수 없는 현상이 발생했다.

      먼저 ubuntu@ubuntu:~$ sudo passwd root 명령어로 아래와 같이 비밀번호를 설정하고

       [sudo] password for ubuntu: 현재 접속중인 계정의 비밀번호 입력

       Enter new UNIX password: 설정할 root 계정의 비밀번호 입력

       Retype new UNIX password: 한번 더 재입력 

       password updated successfully 

       su - 명령어로 설정한 비밀번호로 root 권한으로 접속한 다음 

 service redis stop 명령어로실행중이던 Redis 서버를 중지 시킨다.

- ubuntu를 원격으로 돌리면서 동시에 Redis도 원격으로 실행하기 위해서 윈도우 기준 git bash에서 sudo vim /etc/redis/redis.conf 명령어로 vim 편집기에서 bind 0.0.0.0, port 6379, daemonize yes, maxmemory 1g(Redis 최대 메모리 1G로 설정), maxmemory-policy allkeys-lru(최대 사용 메모리를 초과할 시 가장 오래된 데이터를 지워서 메모리를 확보하며 가장 최근에 저장된 데이터를 사용하는 것으로 설정) 설정을 하고 저장 후 종료를 하였다.
- 종료 후, redis-server --daemonize yes를 하면 Redis가 원격으로 실행되어 문제를 해결하였다.

</div>
</details>

<details>
<summary>수령 예상 시간이 KST(서울 표준시) 기준이 아닌 UTC(기본 설정 시간대)로 나오며 수령 예상시간에 관계없이 배달 완료라고 저장되는 현상(order_complete: true)</summary>
<div markdown="1">       

원인은 TimeStamp 테이블의 cratedAt 컬럼과 Order 테이블의complete_time(수령 예상 시간)의 컬럼 UTC(세계 표준시)로 DB에
저장되는 것이 원인이다.

![Table_order.JPG](https://prod-files-secure.s3.us-west-2.amazonaws.com/d00db562-2625-4cce-9cbc-a0f0008aa8e5/1ea895a9-1f85-47ac-bbc0-cff84b4a31d2/Table_order.jpg)

- 먼저, AWS  EC2의 Time Zone 설정을 변경하였다.
https://yusang.tistory.com/66 를 참고하여 git bash에서

**root 계정으로 변경**

```jsx
sudo su - root
```

**아래의 명령을 차래로 진행합니다.**

```jsx
rm /etc/localtime

ln -s /usr/share/zoneinfo/Asia/Seoul /etc/localtime
```

그리고 나서 date 명령어를 사용하면 

ex) ubuntu@ubuntu: date
Thu Sep 14 15:50:25 KST 2023
설정이 변경된 것을 확인할 수 있었지만 여전히 에러가 발생하였다.

- 두 번째로, AWS RDS에서
https://ndb796.tistory.com/263 (RDS 파라미터 그룹 변경1)
https://yongdev91.tistory.com/10 (RDS 파라미터 그룹 변경2)를 참고하여
파라미터 그룹을 변경하고 파라미터 값들 중에서 time_zone의 시간대를 Asia/Seoul로 변경하였다. 
DB의 시간대는 정상적으로 설정이 되었지만 여전히 에러가 발생하였다.   

- 마지막으로 spring boot 프로젝트의 Time Zone을 변경하는 방법이다.
https://chb2005.tistory.com/201 (프로젝트에서의 Time Zone 변경)을 참고하여
프로젝트의 main 클래스나 @Component로 등록한 클래스 내부에 적어줘야 실행되는
코드를 추가하고
    
    
    `/*`
    
    `프로젝트 실행 시(또는 서버 실행 시)에 최초 한 번만 실행되는 어노테이션이며`
    
    `Time Zone을 기본 UTC(세계표준시)에서 KST(한국 표준시)로 변경해주는 메서드이다.`
    
    `*/`
    
    `@PostConstruct
    public void setTimeZone(){
    TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }`
    
    그러고 나서 재배포 및 ubuntu 서버를 재실행 하였더니 정상적으로 실행되었다.

</div>
</details>

<br>

## API 명세서
[API 명세](https://www.notion.so/API-ca5b9b8b15bd447d938655eeba8844e6?pvs=21)

<br>

## ERD

<img width="821" alt="Untitled" src="https://file.notion.so/f/f/d00db562-2625-4cce-9cbc-a0f0008aa8e5/66b18282-8f29-43b0-95a8-47d7045c758f/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7_2023-10-25_154539.png?id=dc944c0c-1e72-4dc9-9238-9a88a0eef8b8&table=block&spaceId=d00db562-2625-4cce-9cbc-a0f0008aa8e5&expirationTimestamp=1698307200000&signature=3Cd5W70GO1ojEyQRwISf-7hAHR70rAVLO-CxJIyCiPI&downloadName=%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7+2023-10-25+154539.png">

![image](https://github.com/user-attachments/assets/4c15da1b-c06c-4154-8dac-1ccaaeccc6d0)


<br>



<br>

![footer](https://capsule-render.vercel.app/api?section=footer&type=egg&color=FF834E)
