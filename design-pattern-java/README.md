## Design Pattern for Java

Java 예제를 통해 살펴보는 Design Pattern 인프런 강좌 (디자인 패턴, 백기선 님)를 참고한 스터디 저장소 입니다.

---

### Features
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
---