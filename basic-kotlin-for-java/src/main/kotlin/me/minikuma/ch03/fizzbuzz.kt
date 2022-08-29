package me.minikuma.ch03

import java.util.Arrays

/**
 * Quiz
 */

fun main(args: Array<String>) {

    println("fizz buzz")

    // create loop to display the numbers 1 to 105
    // after the number
    // print "fizz" if the number is divisible by 3
    // print "buzz" if the number is divisible by 5
    // print "fizz buzz" if the number is divisible by 3 and 5

    // add your solution here.
    for (item in 1..105) {
        print("$item : ")
        when {
            (item % 3 == 0 && item % 5 == 0) -> print("fizz buzz")
            (item % 3 == 0) -> print("fizz")
            (item % 5 == 0) -> print("buzz")
        }
        println()
    }
}