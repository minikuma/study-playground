## Effective-Java-3rd

Effective Java 인프런 백기선님, 강의와 Effective Java 3판 책을 스터디하면서 작성된 코드입니다.  

---

### Features

(1) 아이템1.생성자 대신 정적 팩토리 메서드를 **고려**하라.
* (장점)
  * 이름을 가질 수 있다. (명시적 방법, 동일한 시그니처를 가진 생성자를 생성할 수 없다.)
  * 호출될 때마다 생성자를 새롭게 생성하지 않아도 된다. (예) ```Boolean.valueOf```
    (Flyweight Pattern)
  * 반환 타입에서 하위 객체를 반환할 수 있다.
  * 입력 매개변수에 따라 다른 클래스의 객체를 반환할 수 있다. (예) ```EnumSet```
  * 정적 팩토리 매서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다. (서비스 프로바이더)
* (단점)
  * 상속이 필요한 경우 사용하기 어렵다. (정적 팩토리만 존재하는 경우 하위 클래스를 만들수 없다)
  * 프로그래머가 찾기가 어렵다. javadoc 메소드가 많은 경우에 static method 를 찾기가 어렵다. ```of``` 와 같은 특정 명명규칙을 이용하여 찾기 쉽게 만들 수 있다. 가장 좋은 방법은 문서화를 하는 것이다.
* 추가적으로?
  * 열거 타입은 인스턴스가 하나만 존재함을 보장한다.
    * 상수 목록을 담는 데이터 타입
    * 타입 안정성 제공
    * 싱글톤 패턴
  * 객체가 자주 요청된다면 플라이웨이트 패턴을 사용할 수 있다.
  * 자바 8부터 인터페이스가 정적 메서드를 가질 수 있다.
  * 서비스 제공자 프레임워크를 만드는 기반이 되었다.
    * 다양한 변경: 브릿지 패턴, 의존 객체 프레임워크, ```java.util.ServiceLoader```
  * 서비스 제공자 인터페이스가 없다면 각 구현체를 리플렉션을 사용해야 한다.
  * 브릿지 패턴
  * 의존 객체 주입 프레임워크

(2) 아이템2.생성자에 매개변수가 많다면 빌더를 고려해라.
* 정적 팩토리와 생성자에 선택적 매개변수가 많을 때 고려할 수 있는 방안
  * 대안1: 점층적 생성자 패턴 또는 생성자 체이닝
  * 대안2: 자바빈즈 패턴 (객체를 여러 번 호출하여 객체를 생성 - 불완전한 객체가 생성될 수 있음)
    * 불변객체를 만들기 어렵다.
    * 대신 ```freezing``` 기능을 사용한다. (현업에서 거의 사용되지 않는다.)
  * 추천대안: 빌더 (무조건 좋지는 않지만 좋은 대안이 되는 경우가 있음)
    * 불변객체가 필요하다.
    * 선택적 매개변수와 필수 매개변수가 혼합되어 있는 경우
  * 계층적 빌더
* 정리 해 보기
  * p15. 자바빈즈
    * ```java.beans``` package 내부에 정의
    * ```getter``` & ```setter``` 메소드 이름 정의
    * Serializable Interface 구현
    * 스펙 중에 ```getter``` & ```setter``` 를 주로 쓰는 이유: 여러 프레임워크에서 리플렉션을 통해 객체의 값을 조회하거나 설정하기 때문이다.
  * p17. 객체 얼리기(freezing)
    * 임의의 객체를 불변객체로 만들어 준다.
  * p17. 빌더 패턴
  * p19. ```IllegalArgumentException```
    * RuntimeException (복구할 방법이 없음)
    * checked exception(컴파일, 복구가능한 상황) vs unchecked exception(런타임, 복구 불가능)
    * 최소한 어떤 매개변수가 잘못되었는 지 알려 주는게 좋다.
    * 선언하는 경우는 무엇인가? 클라이언트한테 명시적으로 알려주고 싶을 때
  * p20. 재귀적인 한정 타입을 이용한 제네릭 타입
  * p21. 가변인수(varargs) 매개변수를 여러 개 사용할 수 있다.
    * 여러 인자를 받을 수 있음

(3) 아이템3.생성자나 열거 타입으로 싱글턴임을 보증하라.
* 첫번째 방법: private 생성자 + ```public static final``` 필드
  * 싱글톤
  * 단점1) 싱글톤은 테스트 하기가 어렵다.
  * 단점2) 리플렉션으로 private 생성자를 호출할 수 있다.
  * 단점3) 역직렬화할 때 새로운 인스턴스가 생성된다.
* 두번째 방법: private 생성자 + ```public static``` method
* 세번재 방법: 제네릭 싱글톤 팩토리 (원하는 타입으로 형변환을 해줄 수 있다) ```==``` 비교가 안됨
* 네번째 방법: ```Supplier```
* 다섯번째 방법: 열거 타입
* 정리
  * p23, 리플렉션 API 로 private 생성자 호출
  * p24, 메서드 참조를 공급자로 사용
    * 스태틱 메소드 레퍼런스
    * 인스턴스 메소드 레퍼런스
    * 임의 객체의 인스턴스 메소드 레퍼런스
    * 생성자 레퍼런스
  * p24, ```Supplier<T>```, 함수형 인터페이스
  * p23, 직렬화, 역직렬화, ```Serializable```, ```transient```
    * ```transient```
    * byte stream (메시지를 효율적으로 전송하는 과정)
    * serialVersionUID 언제 왜 사용하는가?
      * 클래스의 변경을 구분
      * serialVersionUID 직접 관리한다면?
    * 심화학습) 객체 직렬화 스펙

(5) 아이템5.자원을 직접 명시하지 말고 의존 객체 주입을 사용하라.
* 사용하는 자원에 따라 동작이 달라지는 클래스는 정적 유틸리티 클래스나 싱글톤 방식이 적합하지 않음
* 의존 객체 주입이란 인스턴스를 생성하는 시점에 필요한 자원을 넘겨주는 방식
* 이 방식의 변형으로 생성자에 자원 팩토리를 넘겨 줄 수 있음
* 클래스의 유연성, 재 사용성, 테스트가 용이함
* 책에서는 어떻게 나와 있을까?
  * p29 생성자에 자원 팩토리를 넘겨 줄 수 있음
  * p29 자바 8에서 소개한 ```Supplier<T>``` 인터페이스가 팩토리를 표현한 예
  * p29 한정적 와일드 타입을 사용해 팩토리의 타입 매개변수를 제한(하위 타입 포함)
  * p29 팩토리 메소드 패턴
  * p30 의존 객체가 많다면 의존 객체 프레임워크를 사용해라
* 스프링 IoC
  * Inversion of Control
  * 사용 장점
    * 자바 표준 스펙에도 정의 ```@Inject``` 지원
    * 싱글톤 Scope 사용 가능
    * 객체 생성(Bean) 관련 라이브 사이클 인터페이스 제공

(6) 아이템6.블필요한 객체 생성을 피하라.
* 문자열: ```new``` 를 사용하지 않고 리터럴로 사용하여 기존에 문자열 재사용
* 정규식, Pattern: 캐싱하여 재 사용
* 오토 박싱: 기본 타입과, 박싱 타입을 섞어서 사용하면 불필요한 객체 생성 발생할 수 있음
* 책에서는 어떻게 나와 있을까?
  * p31, 사용을 권장하지 않는 API (Deprecation)
    * ```@Deprecated```: 컴파일 시 경고 메시지를 통해 클라이언트에 공지
    * ```@deprecated```: 문서화에서 사용
  * p32, 정규 표현식
  * p32, 가비지 컬렉션의 대상
    * Mark, Sweep, Compact
    * Young Generation (Eden, S0, S1), Old Generation
    * Minor GC, Full GC
    * Throughput, Latency (STW), Footprint
    * Serial, Parallel, CMS, G1, ZGC, Shenandoah
  * p33, 초기화 지연 기법
  * p34, 방어적 복사

(7) 다 쓴 객체 참조를 해제하라.
* 어떤 객체에 대한 레퍼런스가 남아 있다면 해당 객체는 GC 대상이 된다.
* 자기 메모리를 직접 관리하는 경우라면 메모리 누수에 주의해야 한다. (예) 스택, 캐시, 리스너 등
* 참조 객체를 ```null``` 처리하는 경우는 예외적이며 좋은 방법은 유효 범위 밖으로 밀어내는 것이다.
* 책에서는 어떻게 나와 있을까?
  * p37 NullPointException
  * p38 WeakHashMap
    * 약한 참조 (weak reference)
    * key 가 더 이상 strong reference 가 없다면 해당 엔트리를 제거한다.
    * key 가 중요한 경우에 사용한다.(value 도 같이 제거됨)
    * 캐시를 구현하는 데에 사용할 수 있지만 직접 구현은 권장하지 않는다.
  * p39 백 그라운드 스레드
    * ScheduledThreadPoolExecutor

(8) finalizer 와 cleaner 사용을 피하라.
* finalizer 와 cleaner 는 즉시 수행된다는 보장이 없다.
* finalizer 와 cleaner 는 실행되지 않을 수 있다.
* finalizer 와 cleaner 는 심각한 성능 문제가 있다.
* finalizer 는 보안 문제가 있다.
* 반납할 자원이 있는 클래스는 ```AutoCloseable``` 을 구현하고 클라이언트에서 ```close()``` 를 호출하거나 ```try-with-resource``` 를 사용해야 한다.
* p42, Finalizer 공격
* p43, AutoClosable
  * ```try-with-resource``` 를 지원하는 인터페이스
* p45, 정적이 아닌 중첩 클래스는 자동으로 바깥 객체의 참조를 가진다.
* p45, 람다 역시 바깥 객체의 참조를 갖기 쉽다.

(9) try-finally 보다 try-with-resources 를 사용하라.
* try-finally 는 더 이상 최선의 방법이 아니다. (자바 7부터)
* try-with-resources 를 사용하면 코드가 더 짧고 간결하다.
* 만들어지는 예외 정보도 명확하다.

(10) equals 는 일반 규약을 지켜 재 정의 하라. (equals 는 재 정의 하지 않는 것이 최선)
* 재 정의 필요 없는 경우
  * 각 인스턴스는 본질적으로 고유하다. (예) singleton, enum
  * 논리적인 동치성(value 가 같은가)을 검사할 필요가 없는 경우 (예) 문자열
  * 상위 클래스에 이미 정의한 경우 (예) ```list```, ```set```
  * 클래스가 private 이거나, package-private 이고 equals 를 호출할 일이 없는 경우
* 정의가 필요할 때 어떻게 정의해야 하는가?
  * equals 규약
    * 반사성: ```A.equals(A) == true``` (내가 같은 지 확인)
    * 대칭성: ```A.equals(B) == B.equals(A)``` (CaseInsensitiveString)
    * 추이성
    * 일관성
    * ```null``` 이 아님


---