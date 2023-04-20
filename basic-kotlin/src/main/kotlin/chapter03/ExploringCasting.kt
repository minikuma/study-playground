package chapter03

import java.math.BigDecimal
import java.util.*

fun main(args: Array<String>) {
    var result : Any

    val randomNumber = java.util.Random().nextInt(3)

    if (randomNumber == 1) {
        result = BigDecimal(30)
    } else {
        result = "skip"
    }

    println("Result is currently $result")

    if (result is BigDecimal) {
        result = result.add(BigDecimal(47))
    } else {
        var tempResult = result as String;
        result = tempResult.uppercase(Locale.getDefault())
    }

    println("Result is currently $result")
}