package me.minikuma.ch03

/**
 * Functions
 */

fun myFunction(param1: Int, param2: Int): Int {
    return param1 + param2;
}

fun myFunction1(param1: Int, param2: Int): Int = param1 + param2

fun myFunction2(param1: Int, param2: Int) = param1 + param2

// default 값을 갖는 함수
fun myDefaults(param1: Int = 1, param2: Int = 5, message: String = "Hi"): Int {
    val results = param1 + param2
    println(message)
    return results
}

fun main(args: Array<String>) {
    println("10 + 20 = ${myFunction(10, 20)}")
    println("10 + 20 = ${myFunction1(10, 20)}")
    println("10 + 20 = ${myFunction2(10, 20)}")
    myDefaults(10, 20, "Hello")
    myDefaults(message = "Greetings")
}