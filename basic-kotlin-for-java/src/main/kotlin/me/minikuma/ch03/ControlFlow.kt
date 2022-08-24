package me.minikuma.ch03

fun main(args: Array<String>) {
    /** (1) if **/
    // int lowest = (a < b) ? a : b;
    println("== (1) control flow - if ==")
    
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

    /** (2) when **/
    
    println("== (2) control flow - when ==")
    
    val burgerOrdered = 8

    when(burgerOrdered) {
        0 -> println("Not hungry!")
        1, 2 -> println("Hungry!")
        3 -> println("Very Hungry!")
        else -> {
            println("Are you sure?")
        }
    }

    when(burgerOrdered) {
        Math.abs(burgerOrdered) -> println("Ordered 0 or more burgers")
        else -> {
            println("Ordered less than 0")
        }
    }

    // 범위 조건
    when(burgerOrdered) {
        0 -> println("We need orders")
        in 1..4 -> println("Got some orders")
        in 5..9 -> println("Business is up")
        else -> {
            println("Not sure")
        }
    }

    // 매개 변수가 없는 경우
    when {
        burgerOrdered <= 0 -> println("None ordered")
        burgerOrdered % 2 == 1 -> println("Odd number ordered")
        burgerOrdered % 2 == 0 -> println("Even number orderd")
    }

    /** (3) while or do ~ while or for (Looping) **/

    println("== (3) control flow - loops ==")

    var x = 0

    // while
    while (x < 10) {
        println("x = $x")
        x += 3
    }

    // do - while
    do {
        println("x = $x")
        x -= 3
    } while (x > 0)

    // for
    for (item in 1..10) {
        print("$item, ")
    }

    for (ch in "biscuit") {
        println(ch)
    }

    /** (4) advanced loops **/

    println("== (4) advanced loops ==")

    var ndx = 0

    for (item in 10.rangeTo(20).step(2)) {
        print("${++ndx}) $item, ")
    }

    println()

    for ((index, item) in 10.rangeTo(20).step(2).withIndex()) {
        print("${index + 1}) $item, ")
    }

    println()

    val myArray = arrayOf(10, 20, 30, 40, 50)

    for (item in myArray.indices) {
        println("At index $item is ${myArray[item]}")
    }
    println()
}