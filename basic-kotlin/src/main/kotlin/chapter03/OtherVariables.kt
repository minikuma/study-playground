package chapter03

import java.math.BigDecimal
import kotlin.math.roundToInt

fun main(args: Array<String>) {
    // 숫자 형 (Double)
    val myDouble = 21.4
    println("Is myDouble a Double? ${myDouble is Double}")
    println("myDouble is a ${myDouble::class.qualifiedName}")

    println("myDouble's javaClass is ${myDouble.javaClass}")
    println("==========================")

    // 숫자 형(Int)
    val myInteger = myDouble.roundToInt()
    println("myInteger is a ${myInteger::class.qualifiedName}")

    val anotherInteger : Int = 13
    println("==========================")
    val myFloat : Float = 13.7f
    val result = myFloat + anotherInteger
    println(result)
    println("==========================")

    // BegDecimal bd = new BigDecimal(17)
    val bd : BigDecimal = BigDecimal(17)
    println("BigDecimal : $bd")

    // 불변
    val bd2 : BigDecimal
    bd2 = bd.add(BigDecimal(30))
    println(bd2)
}