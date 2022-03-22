## Design Pattern for Java

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
---