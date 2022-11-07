package signature

fun displayNameTag(firstName: String, lastName: String) {
    val width = firstName.length + lastName.length + 3
    // First line
    println(" ${"_".repeat(width)} ")
    // Second line
    println("| $firstName $lastName |")
    // Third line
    println(" ${"•".repeat(width)} ")
}

fun displayNameTagWithStars(firstName: String, lastName: String) {
    val width = firstName.length + lastName.length + 5
    // First line
    println("*".repeat(width))
    // Second line
    println("* $firstName $lastName *")
    // Third line
    println("*".repeat(width))
}

fun main() {
    val (first, last) = readln().split(" ")
    displayNameTagWithStars(first, last)
}
 