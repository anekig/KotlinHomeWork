class Tasks {

    fun printEnteredNumber() {
        val number = readLine()!!
        println("Вы ввели число $number")
    }

    fun reverseNumber(number: Int) {
        val reversedNumber = number.toString().reversed().toInt()
        println(reversedNumber)
    }

    fun printSeason(monthNumber: Int) {
        when (monthNumber) {
            1,2,12 -> println("Зима")
            3,4,5 -> println("Весна")
            6,7,8 -> println("Лето")
            9,10,11 -> println("Осень")
            else -> println("Неверный номер месяца")
        }
    }

    fun negativeSortArray(arrayOfNumbers: Array<Int>) {
        var negativeArray = arrayOf<Int>()
        var positiveArray = arrayOf<Int>()
        for (number in arrayOfNumbers) {
            if (number < 0) {
                negativeArray += number
            } else {
                positiveArray += number
            }
        }
        val sortedArray = negativeArray + positiveArray
        println(sortedArray.joinToString())
    }

}

