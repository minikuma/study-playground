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
}