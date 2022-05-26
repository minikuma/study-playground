## Design Pattern for Java

Java 예제를 통해 살펴보는 Design Pattern 인프런 강좌 (디자인 패턴, 백기선 님)를 참고한 스터디 저장소 입니다.

---

### Features

(1) 생성 패턴   

* Singleton
  * synchronized keyword
  * eager initialization(이른 초기화)
  * Double-Checked Locking + volatile keyword
  * static inner class - Holder Class 사용 (추천 방법)
  * Enumerate 사용 (추천 방법)
  * (번외) Singleton 을 깨뜨리는 여러 가지 방법들
    * Java Reflection 을 통한 Private 생성자 호출
    * 직렬화 이후 역 직렬화 과정에서 발생하는 생성자 호출 - ```resolve()``` 메서드 재 정의로 방어
* Factory Method Pattern     
  : 구체적인 구현체를 하위 클래스에서 결정 (객체를 만드는 과정을 추상화 함, 객체를 만드는 과정에 집중)
  * 인터페이스 적용
* Abstract Factory Pattern    
  : 사용하는 관점에 집중 (팩토리를 사용하는 방법 - Composition)
  * 여러 객체를 구체적인 클래스에 의존하지 않고 만들 수 있게 해 준다.
  * 어디에서 쓰일까?
    * ```DocumentBuilderFactory```
    * ```FactoryBean```
* Builder Pattern
  * 복잡한 객체를 생성할 때 정의된 프로세스대로 만들 수 있다. (객체 생성 순서 제어)
  * 객체의 생성 과정을 숨길 수 있다. (클라이언트 코드는 심플하게 가져갈 수 있다)
  * 불안정한 객체 생성을 막을 수 있다.
  * 같은 객체지만 여러 빌더 프로세스를 통해 다양한 인스턴스를 만들어 낼 수 있다.
  * (단점)
    * 객체의 양이 많아질 수 있다.
    * 구조가 복잡해 질 수 있다.
  * 어디서 쓰일까?
    * ```StringBuffer```, ```StringBuilder```
    * ```Stream``` API 중 ```Steam.Builder```, ```SteamBuilder```
    * Lombok 의 ```@Builder``` Annotation
    * ````UriComponents````
* Prototype Pattern
  * 기존 인스턴스를 복제하여 새로운 인스턴스를 만드는 방법
  * 복제 기능을 가지고 있는 기존 인스턴스를 프로토타입으로 사용하여 새 인스턴스를 만들 수 있도록 해준다.
  * shallow copy vs deep copy: 자바에서 지원하는 clone 은 shallow copy
  * (장점)
    * 복잡한 객체 과정을 숨길 수 있다.
    * 복제를 통해 새 인스턴스를 만드는 비용을 절약할 수 있다.
    * 추상적인 타입을 반환할 수 있다.
  * (단점)
    * 객체를 만드는 거 자체가 복잡하다. (순환 참고 같은 경우)
  * 어떻게 쓰일까?
    * ```ArrayList``` -> 복사 하려면? ```ArrayList.clone()``` 자주 쓰이지 않는다.
      * (예) ```List<Object> clone = new ArrayList<>(객체)```
    * ```ModelMapper``` -> Reflection


(2) 구조 패턴

* Adapter Pattern
  * 기존 코드를 클라이언트가 사용하는 인터페이스의 구현체로 바꿔주는 패턴
  * 클라이언트가 사용하는 인터페이스를 따르지 않는 기존 코드를 재사용할 수 있게 해준다.
  * (장점)
    * 기존 코드 변경 없이 원하는 인터페이스 구현체를 만들어 재사용할 수 있다.
    * 개방 폐쇄 원칙에 부합하는 패턴
    * 기존 코드가 하던 일과 특정 인터페이스 구현체로 변환하는 작업을 각기 다른 클래스로 분리하여 관리 (단일 책임)
  * (단점)
    * 복잡도 증가
    * 기존 코드가(Adaptee) 가 해당 인터페이스를 직접 구현하도록 하여 복잡도를 줄일 수도 있다.
  * 어떻게 쓰일까?
    * ```Arrays.asList()```
    * ```Collections.enumeration()```
    * ```Collections.list()```
    * ```FileInputStream(), BufferedReader()```
    * ```Spring Security```
    * ```Spring MVC - HandlerAdapter```
* Bridge Pattern
  * 추상적인 것과 구체적인 것을 분리하여 연결하는 패턴 (Composition)
  * 연결보다는 분리에 초점을 맞춰서 생각
  * 클라이언트는 추상적인 계층만 사용
  * 예를 들어 분리의 의미는 동작과 상태 이렇게 분리하는 것을 의미한다.
  * (장점)
    * 추상적인 코드를 구체적인 코드 변경 없이도 독립적 확장이 가능하다.
    * 추상적인 코드와 구체적인 코드를 분리
  * (단점)
    * 계층 구조가 늘어나서 복잡도가 증가할 수 있다.
  * 어디에서 사용할까?
    * ```JDBC```: ```Driver```(interface)
    * ```Logger```: ```slf4j```(interface) 의 ```LoggerFactory``` 는 변경되지 않는다.
    * ```PlatformTransactionManager```, ```MailSender```
* Composite Pattern
  * 그룹 전체와 개별 객체를 동일하게 처리할 수 있는 패턴
  * 클라이언트 입장에서 전체 혹은 부분을 모두 동일한 컴포넌트로 인식할 수 있는 계층 구조를 만든다. 
  * (장점)
    * 복잡한 트리 구조를 편리하게 사용할 수 있다. 사용 시, 최상위 노드 혹은 말단 노드 여부를 확인할 필요 없다.
    * 다형성, 재귀 활용이 좋다.
    * 클라이언트 입장에서 새로운 타입을 추가되더라도 클라이언트 코드는 바뀌지 않는다.
  * (단점)
    * 트리를 만들어야 되기 때문에(공통 인터페이스) 지나친 일반화를 해야 하는 경우가 발생할 수 있다.
  * 어디에서 사용할까?
    * ```Swing```, ```JFrame```
* Decorator Pattern
  * 기존 코드를 변경하지 않고 부가 기능을 추가하는 패턴
  * 상속이 아닌 위임을 사용 -> 상속의 문제를 해결
  * (장점)
    * 새로운 클래스를 만들지 않고 기존 기능을 조합할 수 있다.
    * 컴파일 타임이 아닌 런타임에 동적으로 기능 확장 가능
  * (단점)
    * 데코레이터를 조합하는 코드의 복잡도가 올라갈 수 있다.
  * 어디에서 사용할까?
    * ```Collection``` -> ```checkedList``` 메소드, ```syncronized``` 메소드, ```unmodified``` 메소드
    * ```HttpServletRequestWrapper```, ```HttpServletResponseWrapper```
    * ```ServerHttpRequestDecorator```, ```ServerHttpResponseDecorator``` (WebFlex HTTP 요청)
* Facade Pattern
  * 복잡한 서브 시스템 의존성을 최소화하는 방법
  * 클라이언트가 사용해야 하는 복잡한 서브 시스템 의존성을 간단한 인터페이스로 추상화할 수 있다.
  * (장점)
    * 서브 시스템의 의존성을 한곳으로 모아 놓을 수 있다.
  * (단점)
    * 파사드 클래스가 서브 시스템에 대한 모든 의존성을 가지게 된다.
  * 어디서 사용할까?
    * ```PlatformTransactionManager``` (구체적인 기술을 뒤로 감추는 시각에서 본다면...)
    * ```MailSender```
* Flyweight Pattern
   * 객체를 가볍게 만들어 메모리 사용을 줄이는 패턴
   * 자주 변하는 속성(extrinsic)과 변하지 않는 속성(intrinsic)을 분리하고 재사용하여 메모리 사용을 줄인다.
   * (장점)
     * 애플리케이션에서 사용하는 메모리를 줄일 수 있다.
     * 복잡도가 증가하게 된다.
   * 어디서 사용할까?
     * ```Integer.valueOf``` 메서드
* Proxy Pattern
  * 특정 객체에 대한 접근을 제어하거나 기능을 추가할 수 있는 패턴
  * 초기화 지연, 접근 제어, 로깅, 캐싱 등 다양한 부분에 사용할 수 있다. (subject, real subject, proxy 관계)
  * (장점)
    * 기존 코드를 변경하지 않고 새로운 기능 추가
    * 기존 코드가 해야 하는 일만 유지
    * 기능 추가 및 초기화 지연 등으로 다양하게 활용 가능
  * (단점)
    * 코드의 복잡도 증가
  * 어디서 사용할까?
    * 다이나믹 프록시, ```java.lang.reflect.proxy```
    * Spring AOP, CGLIB (상속 통한 프록시)

(3) Behavior Pattern

* 책임 연쇄 패턴
  * 요청을 보내는 쪽과 요청을 처리하는 쪽으로 분리하는 패턴
  * 핸들러 체인을 사용하여 처리
  * (장점)
    * 클라이언트 코드를 변경하지 않고 새로운 기능을 추가할 수 있다.
    * 체인의 순서도 변경가능하다. (다양한 체인 구성 가능)
    * 단일책임원칙(SRP)
  * (단점)
    * 디버깅이 번거롭다. (코드의 흐름이 복잡해 진다.)
  * 어디서 사용할까?
    * ```Filter``` 인터페이스 (```doFilter```)
    * ```Spring Security Filter```
* Command Pattern
  * 요청을 캡슐화 하여 호출자(invoker)와 수신자(receiver)를 분리
  * (장점)
    * 기존 코드 변경 없이 새로운 커맨드를 만들 수 있다. (SRP 원칙)
    * 수신자 코드가 변경되어도 호출자는 바뀌지 않는다.
  * (단점)
    * 복잡도가 증가한다.
  * 어디서 사용할까?
    * ```ExecutorService```
    * ```SimpleJdbcInsert``` -> Query 와 Command 분리
    * ```SimpleJdbcCall```
* Interpreter Pattern
  * 자주 등장하는 문제를 간단한 언어로 정의하고 재사용하는 패턴
  * 반복되는 문제 패턴을 언어 또는 문법으로 정의하고 확장할 수 있다.
  * ```Context```, ```Expression```, ```TerminalExpression```, ```Non-TerminalExpression```
  * (장점)
    * 자주 등장하는 문제 패턴을 언어와 문법으로 정의할 수 있다.
    * 기존 코드를 변경하지 않고 새로운 표현식을 추가할 수 있다.
  * (단점)
    * 복잡한 문법을 표현하기 위해서는 Expression 과 Parser 가 복잡해진다.
  * 어디서 사용할까?
    * ```Pattern.matches```
    * ```SPEL``` -> ```SpelExpressionParser``` -> ```@Value("#{2 + 7}")```
* Iterator Pattern
  * 집합 객체 내부 구조를 노출시키지 않고 순회하는 방법을 제공하는 패턴
  * 집합 객체를 순회하는 클라이언트 코드를 변경하지 않고 다양한 순회 방법을 제공한다.
  * (장점)
    * 집합 객체가 가지고 있는 객체들에 손쉽게 접근 가능
    * 일관된 인터페이스를 사용해 여러 형태의 집합 구조를 순회할 수 있다.
  * (단점)
    * 클래스와 복잡도가 증가한다.
  * 어디서 사용할까?
    * ```java.util.Enumeration```, ```java.util.Iterator```
    * ```Streaming API for XML```, ```SAX(Simple API for XML)```
    * ```CompositeIterator```
* Mediator (중재자) Pattern
  * 여러 객체들이 소통하는 방법을 캡슐화하는 패턴
  * 여러 컴포넌트간의 결합도를 중재자를 통해 낮출 수 있다.
  * (장점)
    * 컴포넌트 변경 없이 새로운 중재자를 구현할 수 있다.
    * 각각의 컴포넌트 코드가 간결해 진다. (의존성이 간결해짐)
  * (단점)
    * 중재가의 역할이 많아지면서 복잡도가 높아진다. 한곳에 집중된다.
  * 어디서 사용할까?
    * ```ExecutorService```, ```Executor```
    * ```DispatchServlet```
* Memento Pattern
  * 캡슐화를 유지하면서 객체 내부 상태를 외부에 저장하는 방법
  * 객체 상태를 외부에 저장했다가 다시 원복할 수 있다. 상태는 불변 객체...
  * (단점)
    * 메멘토 객체가 많은 정보를 담고 있고 자주 사용한다면 관리가 어려울 수 있다.
  * 어디서 사용할까?
    * ```Serialization```, ```De-Serialization```
* Observer Pattern
  * 다수의 객체가 특정 객체 상태 변화를 감지하고 알림을 받는 패턴
  * 발행(Publish)-구독(Subscribe) 패턴을 구현할 수 있다.
  * (장점)
    * 상태를 변경하는 객체와 변경을 감지하는 객체의 관계를 느슨하게 유지할 수 있다.
    * Subject 의 상태를 주기적으로 조회(폴링)하지 않고도 자동으로 감지가 가능하다.
    * 런타임에 옵저버를 추가하거나 제거할 수 있다.
  * (단점)
    * 복잡도 증가
    * 다수의 Observer 등록 이후 정리하지 않는다면 Memory 가 낭비될 수 있다.
  * 어디서 쓰일까?
    * ```Observer``` 인터페이스, ```Observable``` 클래스 -> Java 9 + Deprecated
    * ```PropertyChangeListner```, ```Flow``` 인터페이스, ```SubmissionPublisher``` 비동기
    * ```ApplicationEvent```
* Status Pattern (상태 패턴)
  * 객체 내부 상태 변경에 따라 객체의 행동이 달라지는 패턴
  * 상태에 특화된 행동 분리, 새로운 행동을 추가해도 다른 행동에 영향을 주지 않는다.
  * (장점)
    * 상태에 따른 동작을 개별 클래스에서 관리 가능
    * 기존 특정 상태에 따른 동작 변경 없이 새로운 상태를 추가 할 수 있다.
  * (단점)
    * 복잡도 증가
* Strategy Pattern(전략 패턴)
  * 여러 알고리즘을 캡슐화하고 상호 교환 가능하게 하는 패턴
  * 컨텍스트에서 사용할 알고리즘을 클라이언트는 선택할 수 있다.
  * (장점)
    * 새로운 전략을 추가해도 기존 코드 변경이 없다.
    * 상속 대신 위임을 사용할 수 있다.
    * 런타임에 전략 변경이 가능하다.
  * (단점)
    * 복잡도 증가
  * 어디서 쓰일까?
    * ```Comparator```
    * ```PlatformTransactionManager```, ```ApplicationContext```, ```CacheManager```
* Template Method Pattern
  * 알고리즘 서브 구조를 서브 클래스가 확장할 수 있도록 템플릿으로 제공하는 방법
  * 추상 클래스는 템플릿을 제공하고 하위 클래스는 구체적인 알고리즘을 제공한다.
* Template Callback Pattern
  * 콜백으로 상속 대신 위임을 사용하는 템플릿 패턴 
  * 상속 대신 익명 내부 클래스 또는 람다 표현식을 활용할 수 있다.
  * (장점)
    * 템플릿 코드를 재사용하고 중복 코드를 줄일 수 있다.
    * 템플릿 코드를 변경하지 않고 상속을 받아서 구체적인 알고리즘만 변경할 수 있다.
  * (단점)
    * 리스코프 치환 원칙을 위반할 수 있다. -> 상속받은 자식 클래스가 부모의 속성 혹은 의도와 동일해야 한다.
      (final 키워드로 어느 정도는 막을 수 있다.)
    * 알고리즘이 복잡할 수록 복잡도가 증가한다.
  * 어디서 쓰일까?
    * ```HttpSevlet```
    * ```WebSecurityConfigurerAdapter```
    * ```JdbcTemplate```: Template Callback Pattern
    * ```RestTemplate```: Template Callback Pattern
---