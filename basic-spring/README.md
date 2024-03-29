### Basic Spring      

(1) Bean 등록 방법     
- [x] ```@Configuration``` 사용하는 방법
- [x] ```@ComponentScan``` 사용하는 방법 (```@Component``` 애노테이션을 Scan 후 Bean으로 등록)
   * ```@ComponentScan``` 탐색 위치 지정 가능
   * 탐색 위치를 지정하지 않으면? ```@ComponentScan``` 가 붙은 패키지가 시작위치가 된다.
   * (권장) 패키지 지정 없이 프로젝트 최상단에 위치 (스프링 부트 기본 방법)
   * ```@SpringBootApplication``` 애노테이션에 ```@ComponentScan``` 애노테이션이 메타 애노테이션으로 포함되어 있음
   * (참고) 애노테이션은 상속 관계가 없음 (애노테이션이 다른 애노테이션에 포함 시키는 것은 스프링에서 지원하는 기능)
   * 애노테이션의 부가 기능
     * ```@Controller```: 스프링 MVC 로 인식
     * ```@Repository```: 스프링 데이터 접근 계층으로 인식, 데이터 계층의 예외로 변환
     * ```@Configuration```: 스프링 설정 정보 인식, 스프링이 싱글톤으로 유지될 수 있게 해줌
     * ```@Service```: 특별한 처리는 없지만, 핵심 비즈니스 계층을 의미
- [x] ```@ComponentScan``` Filter 적용
- [x] 빈의 중복과 충돌 (수동 빈과 자동 빈이 충돌나는 경우 수동 빈으로 덮어쓴다. 스프링 부트는 덮어쓰는거를 방지하고 오류 발생)


(2) 의존관계주입
- [x] 다양한 의존관계 주입 (생성자, 필드, ```setter```, 일반 메서드)
- [x] ```@Autowired```, ```@Quilified```, ```@Primary``` (Type > Field > Parameter 순으로 탐색)
- [x] 조회 빈이 여러 개인 경우
- [x] 조회한 빈이 모두 필요한 경우

(3) 빈 생명 주기
- [x] 초기화, 소멸 (```InitializingBean```, ```DisposableBean```)
- [x] 애노테이션 활용 (```@PostConstruct```, ```@PreDestroy```)

(4) 빈 스코프
- [x] 빈 스코프 종류 (singleton, prototype)
- [x] singleton, prototype 함께 사용하는 경우 문제 (Provider, Proxy)
- [x] request 스코프
---
