import org.junit.Assert.*
import org.junit.Test

/**
 * @author Demitrist on 01.02.2023
 */

class SentenceTest {

    @Test
    fun `test fake valid`() {
        val validator: WordValidator = FakeValidator(true)
        val sentence: Sentence = Sentence.Base(validator = validator)
        val inputs = listOf(
            "one two three four",
            "one two three",
            "one two",
            "one"
        )
        val expected = listOf(
            4,
            3,
            2,
            1
        )
        inputs.forEachIndexed { index, string ->
            assertEquals(expected[index], sentence.validWords(string = string))
        }
    }

    @Test
    fun `test fake invalid`(){
        val validator: WordValidator = FakeValidator(false)
        val sentence: Sentence = Sentence.Base(validator = validator)
        val inputs = listOf(
            "one two three four",
            "one two three",
            "one two",
            "one"
        )
        val expected = 0

        inputs.forEachIndexed { index, string ->
            assertEquals(expected, sentence.validWords(string = string))
        }
    }

    @Test
    fun `test real`(){
        val validator = WordValidator.Base()
        val sentence: Sentence = Sentence.Base(validator = validator)
        val inputs = listOf(
            "cat and  dog",
            "!this  1-s b8d!",
            "alice and  bob are playing stone-game10",
            "Flat house stay",
            "more than pre-purchase",
            "if- you -want than, can!",
            ".",
            "as,. rat-fat-boom .start stat.frost"
        )
        val expected = listOf(
            3,
            0,
            5,
            2,
            3,
            3,
            1,
            0
        )
        inputs.forEachIndexed { index, string ->
            assertEquals(expected[index], sentence.validWords(string = string))
        }
    }
}

private class FakeValidator(private val result: Boolean = true) : WordValidator {
    override fun isValid(string: String): Boolean = result
}