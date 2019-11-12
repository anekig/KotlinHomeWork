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
    fun testGetMessageForNumberIsValidNumber() {
        val tasks = Tasks()
        val numberProvider = ValidNumberProviderMock(11)
        val message = tasks.getMessageForNumber(numberProvider)
        assertEquals("Неверное сообщение: $message", "Вы ввели число ${numberProvider.getNumber()}", message)
    }

    @Test
    fun testGetMessageForNumberIsInvalidNumber() {
        val tasks = Tasks()
        val numberProvider = InvalidNumberProviderMock()
        val message = tasks.getMessageForNumber(numberProvider)
        assertTrue("Неверное сообщение: $message", message.contains("Ошибка"))
    }
}