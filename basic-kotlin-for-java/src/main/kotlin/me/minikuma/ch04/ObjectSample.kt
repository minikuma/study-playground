package me.minikuma.ch04

/**
 * Objects - 자바 스크립트와 비슷
 */

object MySingleton {
    var temperatures = arrayOf(20, 15, 29)
    fun getLastTemperature() = temperatures.last()
}


fun main(args: Array<String>) {
    val location = object {
        var xPosition = 200
        var yPosition = 400
        // 객체 내부에 함수 선언도 가능
        fun printIt() {
            println("Function Position = (${xPosition}, ${yPosition})")
        }
    }
    println("Position = (${location.xPosition}, ${location.yPosition})")
    location.printIt()
    // 수정 가능
    location.xPosition = 2000
    location.yPosition = 4000
    location.printIt()

    val temperature = MySingleton.getLastTemperature()
    println("마지막으로 조회된 온도는 = $temperature 도")

    return
}