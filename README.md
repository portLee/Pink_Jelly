# Pink_Jelly
> SpringBoot + MyBatis + Thymeleaf 프로젝트

## :computer:프로젝트 소개
고양이를 키우는 즐거움을 공유하고, 새로운 관계를 형성할 수 있는 공간을 제공하기위한 **고양이 커뮤니티 웹애플리케이션** 입니다.

### :calendar:개발 기간
- 2023.11.06 ~ 2023.11.24

### :family_man_woman_girl_boy:개발 인원
- **이헌구(팀장)**
- 이승우
- 조동현

### :gear:개발 환경
- **언어**: Java(JDK 17), JavaScript
- **서버**: Apache Tomcat(ver. 9.0.82)
- **프레임워크**: Spring Boot(ver. 2.7.17), MyBatis(ver. 2.3.1)
- **DB**: MySQL(ver. 8.0.34)
- **API, 라이브러리**: 카카오Map API, 카카오 및 구글 로그인 API, Thymeleaf, jQuery, Axios, slick.js

## :pushpin:주요 기능

<details markdown="1">
  <summary><b>로그인 및 회원가입</b></summary>
  <div>
    <img src="https://github.com/portLee/Pink_Jelly/assets/146898974/1ca95903-0d73-425a-8876-bfa33c5cfbf6">
    <img src="https://github.com/portLee/Pink_Jelly/assets/146898974/4c0ac442-d80e-4a3d-8e28-5a24065660ff">
  </div>
</details>

- 카카오 및 구글 로그인 API
- 자동로그인(rememberMe)
- 회원가입시 유효성 검사
- 회원가입시 이메일 인증
- 프로필 이미지 업로드

<details markdown="1">
  <summary><b>프로필</b></summary>
  <div>
    <img src="https://github.com/portLee/Pink_Jelly/assets/146898974/e3b880a0-1895-4b38-8925-3c7880f7d41e">
    <img src="https://github.com/portLee/Pink_Jelly/assets/146898974/460f9366-7037-4dd5-9328-c262f88e20eb">
  </div>
</details>

- 네이버 에디터로 소개글 작성
- 친구 추가, 삭제, 차단
- 회원정보 수정
- 작성한 게시글 목록

<details markdown="1">
  <summary><b>메인 페이지</b></summary>
  <div>
    <img src="https://github.com/portLee/Pink_Jelly/assets/146898974/277a4d32-1da0-4e6a-938b-c8664dbcf84a">
    <img src="https://github.com/portLee/Pink_Jelly/assets/146898974/4690bc8e-8328-4216-ae3f-d198a6759f89">
  </div>
</details>

- 게시글 검색(제목, 내용, 닉네임, 아이디)
- 게시글 등록, 읽기, 수정, 삭제(CRUD)

<details markdown="1">
  <summary><b>입양소 게시판</b></summary>
  <div>
    <img src="https://github.com/portLee/Pink_Jelly/assets/146898974/b5d7b50f-c53d-483a-bf39-63aaa5011a78">
    <img src="https://github.com/portLee/Pink_Jelly/assets/146898974/f142d7f8-4ba2-4de8-98e8-147dfbf444c9">
  </div>
</details>

- 입양소와 입양후기 게시판 비동기 처리
- 입양소 1 : 1 채팅

<details markdown="1">
  <summary><b>댓글 및 대댓글</b></summary>
  <div>
    <img src="https://github.com/portLee/Pink_Jelly/assets/146898974/6714b716-74c7-4541-8805-821163045f4a">
  </div>
</details>

- 댓글 및 대댓글 작성, 읽기, 수정, 삭제(CRUD)
- 비동기 처리

<details markdown="1">
  <summary><b>추모 게시판</b></summary>
  <div>
    
  </div>
</details>

- 추모글 자동 등록

<details markdown="1">
  <summary><b>병원 정보</b></summary>
  <div>
    <img src="https://github.com/portLee/Pink_Jelly/assets/146898974/7967d8ff-1268-43bd-b6ff-ff73e7585bd4">
    <img src="https://github.com/portLee/Pink_Jelly/assets/146898974/a055cc63-8281-48e1-9532-48e85b9d7d92">
  </div>
</details>

- 카카오 Map API
- 현재 위치 기준 동물 병원 정보 제공

<details markdown="1">
  <summary><b>관리자</b></summary>
  <div>
    <img src="https://github.com/portLee/Pink_Jelly/assets/146898974/c39b6e41-de62-4152-b5bd-ce30cce558c1">
  </div>
</details>

- 게시물 관리
- 회원 관리

<!-- Markdown link & img dfn's -->
[npm-image]: https://img.shields.io/npm/v/datadog-metrics.svg?style=flat-square
[npm-url]: https://npmjs.org/package/datadog-metrics
[npm-downloads]: https://img.shields.io/npm/dm/datadog-metrics.svg?style=flat-square
[travis-image]: https://img.shields.io/travis/dbader/node-datadog-metrics/master.svg?style=flat-square
[travis-url]: https://travis-ci.org/dbader/node-datadog-metrics
[wiki]: https://github.com/yourname/yourproject/wiki
