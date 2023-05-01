package chapter04

import java.util.*

fun main(args: Array<String>) {
    var name: String? = null

    if (name != null) {
        println(name.uppercase(Locale.getDefault()))
    }
    println("===========")
    println("$name".uppercase(Locale.getDefault()))

    println("===========")
    var result = name?.uppercase(Locale.getDefault());
    println(result)
    println("===== name? 동일한 효과 ======")
    /*
    var result2: String

    if (name != null) {
        result2 = name.uppercase(Locale.getDefault())
    } else {
        result2 = null
    }*/

    println("===== name!! 사용시 주의 필요 NPE 발생할 수 있음 ======")
    // var result2 = name!!.uppercase(Locale.getDefault());
    // println(result2)

    println("===== Noting Class ======")
    var address: String? = null
    address = "hello"
    println("$address")

    var myInteger :Int? = 7
    myInteger = null
    println("$myInteger")
}