## 프로젝트 패키지 구조
```
dev.memory.TodoDoit
├── config
├── controller
├── dto
├── entity
├── exception
├── repository
├── service
└── util
```
---------------------------------------
## Error 코드 설명
[에라코드 설명](./Docs/ErrorsCodes.md)

---------------------------------------
### url 구조
1. /api/auth: 회원가입및 로그인
2. /api/todos: Todo 관련기능

**회원가입**
| Method | URL | 설명 |
|-------|----|-------|
|POST|/api/auth/signup|일반 회원가입 처리|

**로그인**
| Method | URL | 설명 |
|-------|----|-------|
|POST|/api/auth/login|일반 로그인 처리|

**소셜로그인**
| Method | URL | 설명 |
|-------|----|-------|
|POST|/api/auth/social-login|소셜 로그인 처리|

**비밀번호 찾기**
| Method | URL | 설명 |
|-------|----|-------|
|POST|/api/auth/reset-password|비밀번호 재설정|

**Todo API**
| Method | URL | 설명 |
|-------|----|-------|
|GET|/api/todos|모든 Todo 조회|
|POST|/api/todos|새로운 Todo 생성|
|GET|/api/todos/{id}|특정 Todo 조회|
|PUT|/api/todos/{id}|Todo 수정|
|DELETE|/api/todos/{id}|Todo 삭제|


---------------------------------------
## 1.config
* 전역 설정 관련 클래스
* 예시파일:
  * SecurityConfig : Spring Security 설정
  * OAuth2Config : 소셜 로그인 API 연동 설정
  * DatabaseConfig : 데이터베이스 설정(미정)
---------------------------------------
## 2. controller
* HTTP 요청/응답 처리하는 API 컨트롤러
* 예시파일:
  * AuthController : 회원가입, 로그인, 소셜 로그인 API
  * TodoController : Todo CRUD API
---------------------------------------
## 3. dto
* 데이터 전송 객체(Data Transfer Object)
* 클라이언트와 데이터를 주고받는데 사용
* 예시파일 :
  * UserSignupRequest : 회원가입 요청 데이터
  * UserLoginRequest : 로그인 요청 데이터
  * TodoRequest : Todo 생성/수정 요청 데이터
  * TodoResponse : Todo 조회 응답 데이터
---------------------------------------
## 4. entity
* 데이터베이스와 매핑되는 JPA 엔티티 클래스
* 예시파일 :
  * User : 사용자 정보
  * Todo : Todo 정보
  * Category : Todo 카테고리
---------------------------------------
## 5. exception
* 예외 처리를 위한 클래스와 핸들러
* 예시파일 :
  * GlobalExceptionHandler : 전역 예외 처리
  * UserNotFoundException : 사용자 찾을 수 없음 예외
  * TodoNotFoundException : Todo 항목 찾을 수 없음 예외
---------------------------------------
## 6. repository
* 데이터베이스와 직접 통신하는 레이어
* JPA 또는 데이터 접근 기술 사용
* 예시파일 :
  * UserRepository : 사용자 관련 데이터 처리
  * TodoRepository : Todo 관련 데이터 처리
  * CategoryRepository : 카테고리 관련 데이터 처리
---------------------------------------
## 7. service
* 비즈니스 로직을 처리하는 클래스
* Controller와 Repository를 연결하는 중간 레이어
* 예시파일 :
  * AuthService : 회원가입, 로그인, 소셜 로그인 로직
  * TodoService : Todo 관리 로직
  * CategoryService : 카테고리 관련 로직
---------------------------------------
## 8. util
* 공통적으로 사용되는 유틸리티 클래스
* 예시파일 :
  * PasswordEncoderUtil : 비밀번호 암호화 유틸리티
  * JwtTokenProvider : JWT 생성 및 검증
  * DateUtil : 날짜 및 시간 처리 유틸리티
---------------------------------------

# 기능별 클래스 예시
## 회원가입 및 로그인
* Controller : AuthController
* Service : AuthService
* Repository : UserRepository
* Entity : User
* DTO : UserSignupRequest, UserLoginRequest

## 소셜 로그인
* Config : OAuth2Config
* Controller : AuthController
* Service : AuthService

## Todo 관리
* Controller : TodoController
* Service : TodoService
* Repository : TodoRepository
* Entity : Todo
* DTO : TodoRequest, TodoResponse


