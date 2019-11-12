import org.junit.Test
import org.junit.Assert.*

// Mocks

class ValidNumberProviderMock(private val number: Int) : NumberProvider {
    override fun getNumber(): Int {
        return number
    }
}

class InvalidNumberProviderMock : NumberProvider {
    override fun getNumber(): Int {
        throw NumberFormatException()
    }
}

// Tests

class Tests {
    @Test
    fun testGetMessageForNumberIsNumber() {
        val tasks = Tasks()
        val numberProvider = ValidNumberProviderMock(11)
        val message = tasks.getMessageForNumber(numberProvider)
        assertEquals("Неверное сообщение: $message", "Вы ввели число ${numberProvider.getNumber()}", message)
    }

    @Test
    fun testGetMessageForNumberIsNotNumber() {
        val tasks = Tasks()
        val numberProvider = InvalidNumberProviderMock()
        val message = tasks.getMessageForNumber(numberProvider)
        assertTrue("Неверное сообщение: $message", message.contains("Ошибка"))
    }

    @Test
    fun testGetReversedNumberIsNumber() {
        val tasks = Tasks()
        assertEquals("Число не перевернуто", "Число наоборот: 321", tasks.reverseNumber(123))
    }

    @Test
    fun testGetReversedNumberIsNotNumber() {
        val tasks = Tasks()
        assertEquals("Получено не число", "Ошибка: получено не число", tasks.reverseNumber("Text"))
    }

    @Test
    fun testGetRightSeasonIsRightNumber() {
        val tasks = Tasks()
        assertEquals("Определение времени года не сработало", "Зима", tasks.getSeason(1))
    }

    @Test
    fun testGetRightSeasonIsNotRightNumber() {
        val tasks = Tasks()
        assertEquals("Определение времени года сработало неверно", "Неверный номер месяца", tasks.getSeason(13))
    }

    @Test
    fun testGetSortedArrayFromNegative() {
        val tasks = Tasks()
        val array = tasks.getSortedArrayFromNegative(arrayOf(0, -1, 2, 3))
        assertArrayEquals("Сортировка массива с отрицательных чисел не сработала", arrayOf(-1, 0, 2, 3), array)
    }
}