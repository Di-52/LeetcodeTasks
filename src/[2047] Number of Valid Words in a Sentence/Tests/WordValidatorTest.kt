import org.junit.Test
import kotlin.test.assertEquals

/**
 * @author Demitrist on 01.02.2023
 **/

class WordValidatorTest {
    private val validator = WordValidator.Base()

    @Test
    fun `test valid words`(){
        val words = listOf(
            "cat","rest", "r","tjam.","jet-pack",
            ".", "!", "a-b.")
        val expected = true

        words.forEach {
            assertEquals(expected, validator.isValid(word = it))
        }
    }

    @Test
    fun `test invalid words`(){
        val words = listOf(
            "vat5", "Rat", ".store", " ", "", "red.,", "1-s",
        )
        val expected = false

        words.forEach {
            assertEquals(expected, validator.isValid(word = it))
        }
    }
}