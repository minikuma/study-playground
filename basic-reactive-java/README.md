## Java Reactive Programing

---

### Features

(Sec05) Flux - Emitting items Programmatically    
이벤트를 내보내는 여러 가지 방법

* ```Create```: 특정 조건인 경우 이벤트 방출을 멈출 수 있음
  * ```Consumer<FluxSink>``` 
    * ```FluxSink```
      * Create 를 통해 Emitting 되는 데이터는 Subscriber 의 처리를 기다리지 않고 데이터를 보낼 수 있다. 만약 Subscriber 가 처리 속도를 따라가지 못한다면 어떻게 될까? ```FluxSink``` 에는 이러한 경우를 대비하여 여러 기능을 제공하고 있다.
  * 0 ~ N Emitting
  * Overflow 처리 전략이 필요
  * Thread-Safe
  * ```fluxSink.requestedFromDownstream()```, ```fluxSink.isCancelled()```
* ```Generate```
  * ```Consumer<SynchronousSink<T>>```
  * Consumer 는 오직 하나의 요소를 전달할 수 있음(만약 더 많은 아이템을 받기를 원한다면 새로운 인스턴스 생성해야 함)

(Sec06) Operators
* Decorators
* 마치 커피를 만드는 과정과 비슷하다. 커피라는 기본 위에 여러 가지 우유, 휘핑크림, 아이스크림등과 같은것들을 추가하여 여러가지 맛을 내는 커피를 만들어 낼 수 있다.
* features
  * Handle

---
