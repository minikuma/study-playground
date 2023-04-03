package com.virtualpairprogrammers.learningkotlin.kotlin

fun main(args: Array<String>) {
    var name: String = "Kotlin" // mutable
    val surname: String = "Programming" // Immutable

    name = "modify kotlin"

    println(name + " " + surname)

    println("name \$name ${surname.toUpperCase()}")
    println("name " + name + " " + surname)

    println("Your first name has ${name.length} characters")
    println("Your product cost \$about10")

    // multiple line strings
    println("=============================================")
    val story = """It was a dark and stormy night.
        |A foul smell crept across the city.
        |Jan wondered what time it was, and when it would be daylight.""".trimMargin("|")

    println(story)
    println("=============================================")

    val changedStory = story.replaceAfterLast("it", " would be dawn.")
    println(changedStory)
}