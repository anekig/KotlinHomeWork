import java.lang.Exception

// NumberProvider

interface NumberProvider {
    fun getNumber(): Int
}

class UserInputNumberProvider: NumberProvider {
    override fun getNumber(): Int {
        return readLine()!!.toInt()
    }
}

// Tasks

class Tasks {
    fun getMessageForNumber(numberProvider: NumberProvider): String {
        return try {
            val number = numberProvider.getNumber()
            "Вы ввели число $number"
        } catch (e: Exception) {
            "Ошибка: вы ввели не число"
        }
    }

    fun reverseNumber(number: Any): String {
        return try {
            val reversedNumber = number.toString().reversed().toInt()
            "Число наоборот: $reversedNumber"
        } catch (e: Exception) {
            "Ошибка: получено не число"
        }
    }

    fun getSeason(monthNumber: Int): String {
        return when (monthNumber) {
            1,2,12 -> "Зима"
            3,4,5 -> "Весна"
            6,7,8 -> "Лето"
            9,10,11 -> "Осень"
            else -> "Неверный номер месяца"
        }
    }

    fun getSortedArrayFromNegative(arrayOfNumbers: Array<Int>): Array<Int> {
        var negativeArray = arrayOf<Int>()
        var positiveArray = arrayOf<Int>()
        for (number in arrayOfNumbers) {
            if (number < 0) {
                negativeArray += number
            } else {
                positiveArray += number
            }
        }
        return negativeArray + positiveArray
    }
}

