package chapter02

import java.util.*

fun main(args: Array<String>) {
    println("Hello Kotlin!")
    // Variables
    var name: String = "Name"
    val subName: String = "subName"

    // var(Changeable) vs val(Immutable)
    name = "ChangedName"
    // subName = "ChangedName" Error
    println(name + " " + subName)
    println("$name $subName")

    // String template
    println("Hello name string size is ${name.length}")
    println("Upper String: ${name.uppercase(Locale.getDefault())}")
    println("Your product cost \$about10")

    // multiple line strings
    val story = """
        |It was a dark and stormy night.
        |Jane wondered what time it was, and when it would be daylight...
    """.trimMargin("|")

    println(story)

    val changedStory = story.replaceAfterLast("it", " would be dawn")

    println(changedStory)
}