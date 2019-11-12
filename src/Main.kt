fun main() {
    val tasks = Tasks()

    val numberProvider = UserInputNumberProvider()
    println(tasks.getMessageForNumber(numberProvider))

    println(tasks.reverseNumber(123))
    println(tasks.getSeason(6))
    println(tasks.getSortedArrayFromNegative(arrayOf(55, 34, -10, 0, 30, -5)).joinToString())
}