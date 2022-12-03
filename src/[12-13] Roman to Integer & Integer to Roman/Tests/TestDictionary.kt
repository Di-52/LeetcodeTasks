import org.junit.Test
import kotlin.test.assertEquals

/**
 * @author Demetrist on 03.12.2022
 */

class TestDictionary {

    @Test
    fun test_arab_dictionary_success() {
        val inputList = listOf(
            1, 5, 40, 100, 1000
        )
        val resultList = listOf(
            "I", "V", "XL", "C", "M"
        )
        val dict = Dictionary.Arab()
        inputList.forEachIndexed { index, i ->
            assertEquals(
                expected = Digit.RomeDigit(resultList[index]),
                actual = dict.search(Digit.ArabDigit(inputList[index]))
            )
        }
    }

    @Test
    fun test_arab_dictionary_fail() {
        val inputList = listOf(
            0, 3, 44, 5555
        )
        val dict = Dictionary.Arab()
        inputList.forEachIndexed { index, i ->
            assertEquals(
                expected = Digit.Empty(),
                actual = dict.search(Digit.ArabDigit(inputList[index]))
            )
        }
    }

    @Test
    fun test_rome_dictionary_success() {
        val inputList = listOf(
            "I", "V", "X", "C", "M"
        )
        val resultList = listOf(
            1,5,10,100,1000
        )
        val dict = Dictionary.Rome()
        inputList.forEachIndexed { index, i ->
            assertEquals(
                expected = Digit.ArabDigit(resultList[index]),
                actual = dict.search(Digit.RomeDigit(inputList[index]))
            )
        }
    }

    @Test
    fun test_rome_dictionary_fail() {
        val inputList = listOf(
            "DD", "F", "1",""
        )
        val dict = Dictionary.Rome()
        inputList.forEachIndexed { index, i ->
            assertEquals(
                expected = Digit.Empty(),
                actual = dict.search(Digit.RomeDigit(inputList[index]))
            )
        }
    }
}