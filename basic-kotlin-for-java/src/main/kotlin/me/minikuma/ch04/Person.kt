package me.minikuma.ch04

/**
 * Class
 */
class Person internal constructor(firstName: String, lastName: String) {
    init {
        println("Creating a person named $firstName $lastName")
    }

    constructor(firstName: String, lastName: String, middleName: String): this(firstName, lastName) {
        // secondary 생성자
    }
}

fun main(args: Array<String>) {
    println("Hello Person Class")
    val me = Person("Troy", "Miles")
    val you = Person("Janet", "Chung", "Yang")
    return
}