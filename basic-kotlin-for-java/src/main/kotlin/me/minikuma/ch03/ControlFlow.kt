package me.minikuma.ch03

fun main(args: Array<String>) {
    // if
    // int lowest = (a < b) ? a : b;

    val myInt = 199
    val anInt = 200
    val lowest = if(myInt < anInt) myInt else anInt
    println("더 작은 값은 $lowest")

    val temp = 80
    val isAirConditionOn = if (temp >= 80) {
        println("더워요!")
        "ON";
    } else {
        println("덥지 않아요!")
        "OFF";
    }
    println("에어컨 $isAirConditionOn")
}