fun square(x: Int): Int {
    return x * x
}

fun main() {

    val a: Int = 5
    val b = 3.14
    val name = "Kotlin"
    var flag = true

    if (flag) {
        println("$name square: ${square(a)}")
    }

    for (i in 0 until 3) {
        println("i = $i")
    }
}
