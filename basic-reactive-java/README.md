## Java Reactive Programing

---

### Features

(Sec05) Flux - Emitting items Programmatically    
이벤트를 내보내는 여러 가지 방법

* ```Create```: 특정 조건인 경우 이벤트 방출을 멈출 수 있음
* ```FluxSink```
  * Create 를 통해 Emitting 되는 데이터는 Subscriber 의 처리를 기다리지 않고 데이터를 보낼 수 있다. 만약 Subscriber 가 처리 속도를 따라가지 못한다면 어떻게 될까? ```FluxSink``` 에는 이러한 경우를 대비하여 여러 기능을 제공하고 있다.

---
