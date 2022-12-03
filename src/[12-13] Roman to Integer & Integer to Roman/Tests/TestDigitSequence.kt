import org.junit.Test
import kotlin.test.assertEquals

/**
 * @author Demetrist on 03.12.2022
 */

class TestDigitSequence {

    @Test
    fun test_arab_digit_sequence_read_all() {
        val inputList = listOf(
            1, 15,1235
        )
        inputList.forEach{
            var sequence = ArabDigitSequence(it)
            assertEquals(expected = it.toString(), actual = sequence.read())
        }
    }

    @Test
    fun test_arab_digit_sequence_zero(){
        val sequence = ArabDigitSequence(0)
        assertEquals(expected = "0", actual = sequence.read())
    }

    @Test
    fun test_arab_digit_sequence_read_read() {
        val input = 1235
        val resultList = listOf(1000,200,30,5)
        val seq = ArabDigitSequence(input)
        resultList.forEach{
            assertEquals(expected = it, actual = seq.nextDigit().read())
        }
    }

    @Test
    fun test_rome_digit_sequence_read_all(){
        val inputList = listOf(
            "I", "XI", "MCMXCIV"
        )
        inputList.forEach{
            var sequence = RomeDigitSequence(it)
            assertEquals(expected = it, actual = sequence.read())
        }
    }

    @Test
    fun test_rome_digit_sequence_read(){
        val input = "MCMXCIV"
        val resultList = listOf("M","C","M","X","C","I","V")
        val seq = RomeDigitSequence(input)
        resultList.forEach{
            assertEquals(expected = it, actual = seq.nextDigit().read())
        }
    }
}