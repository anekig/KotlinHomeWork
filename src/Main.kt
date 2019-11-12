fun main() {
    val tasks = Tasks()

    val numberProvider = UserInputNumberProvider()
    println(tasks.getMessageForNumber(numberProvider))

    tasks.reverseNumber(123)
    tasks.printSeason(6)
    tasks.negativeSortArray(arrayOf(55, 34, -10, 0, 30, -5))
}