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
---