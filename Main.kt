package signature

enum class ASCIIFont(val symbol: List<String>) {
    A(listOf("____"
            ,"|__|"
            ,"|  |")),
    B(listOf("___ "
            ,"|__]"
            ,"|__]")),
    C(listOf("____"
            ,"|   "
            ,"|___")),
    D(listOf("___ "
            ,"|  \\"
            ,"|__/")),
    E(listOf("____"
            ,"|___"
            ,"|___")),
    F(listOf("____"
            ,"|___"
            ,"|   ")),
    G(listOf("____"
            ,"| __"
            ,"|__]")),
    H(listOf("_  _"
            ,"|__|"
            ,"|  |")),
    I(listOf("_"
            ,"|"
            ,"|")),
    J(listOf(" _"
            ," |"
            ,"_|")),
    K(listOf("_  _"
            ,"|_/ "
            ,"| \\_")),
    L(listOf("_   "
            ,"|   "
            ,"|___")),
    M(listOf("_  _"
            ,"|\\/|"
            ,"|  |")),
    N(listOf("_  _"
            ,"|\\ |"
            ,"| \\|")),
    O(listOf("____"
            ,"|  |"
            ,"|__|")),
    P(listOf("___ "
            ,"|__]"
            ,"|   ")),
    Q(listOf("____"
            ,"|  |"
            ,"|_\\|")),
    R(listOf("____"
            ,"|__/"
            ,"|  \\")),
    S(listOf("____"
            ,"[__ "
            ,"___]")),
    T(listOf("___"
            ," | "
            ," | ")),
    U(listOf("_  _"
            ,"|  |"
            ,"|__|")),
    V(listOf("_  _"
            ,"|  |"
            ," \\/ ")),
    W(listOf("_ _ _"
            ,"| | |"
            ,"|_|_|")),
    X(listOf("_  _"
            ," \\/ "
            ,"_/\\_")),
    Y(listOf("_   _"
            ," \\_/ "
            ,"  |  ")),
    Z(listOf("___ "
            ,"  / "
            ," /__")),
    SPACE(listOf("    ", "    ", "    ")),
    DELIMITER(listOf(" ", " ", " "))
}

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

fun displayBadge(name: String, status: String) {
    val asciiFontNameList = mutableListOf<ASCIIFont>()
    for (letter in name) {
        if (letter != ' ') {
            asciiFontNameList.add(ASCIIFont.valueOf(letter.uppercase()))
        } else {
            asciiFontNameList.add(ASCIIFont.valueOf("SPACE"))
        }
    }
    var firstString = ""
    var secondString = ""
    var thirdString = ""
    for (letterIndex in 0 until asciiFontNameList.size) {
        firstString += asciiFontNameList[letterIndex].symbol[0] + " "
        secondString += asciiFontNameList[letterIndex].symbol[1] + " "
        thirdString += asciiFontNameList[letterIndex].symbol[2] + " "
    }
    firstString = firstString.substring(0, firstString.length - 1)
    secondString = secondString.substring(0, secondString.length - 1)
    thirdString = thirdString.substring(0, thirdString.length - 1)
    val len: Int
    val nameOffsetLeft: Int
    val nameOffsetRight: Int
    if (firstString.length > status.length) {
        len = firstString.length
        nameOffsetLeft = 0
        nameOffsetRight = 0
    } else {
        len = status.length
        if (firstString.length % 2 == status.length % 2) {
            nameOffsetLeft = (len - firstString.length) / 2
            nameOffsetRight = nameOffsetLeft
        } else {
            nameOffsetLeft = len / 2 - (firstString.length / 2 + firstString.length % 2)
            nameOffsetRight = len - firstString.length - nameOffsetLeft
        }
    }
    val maxLen = len + 6
    println("*".repeat(maxLen))
    println("*  " + " ".repeat(nameOffsetLeft) + firstString + " ".repeat(nameOffsetRight) + "  *")
    println("*  " + " ".repeat(nameOffsetLeft) + secondString + " ".repeat(nameOffsetRight) + "  *")
    println("*  " + " ".repeat(nameOffsetLeft) + thirdString + " ".repeat(nameOffsetRight) + "  *")
    val center: Int
    val offsetLeft: Int
    val offsetRight: Int
    if (firstString.length % 2 == status.length % 2) {
        offsetLeft = (len - status.length) / 2
        offsetRight = offsetLeft
    } else {
        center = len / 2
        offsetLeft = center - (status.length / 2 + status.length % 2)
        offsetRight = len - status.length - offsetLeft
    }

    println("*  " + " ".repeat(offsetLeft) + status + " ".repeat(offsetRight) + "  *")
    println("*".repeat(maxLen))

}

fun main() {
//    Test cases
//  displayBadge("Bill Gates", "VIP")
//  displayBadge("Tom Smith", "Worker")
//  displayBadge("Mr Anonimous", "Participant")
//  displayBadge("John S", "Worker-coworker-superdupercoworker")
//  displayBadge("X Y", "VeryVeryLooooooooooongSatus")

    print("Enter name and surname: ")
    val name = readln()
    print("Enter person's status: ")
    val status = readln()
    displayBadge(name, status)
}