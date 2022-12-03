import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

/**
 * @author Demetrist on 03.12.2022
 */

class TestArabToRomeConverter {

    @Test
    fun test_arab_to_rome_convertor_success() {
        val inputList = listOf(
            0,1, 5, 10, 11, 38, 55, 1994,
        )
        val resultList = listOf(
            "","I", "V", "X", "XI", "XXXVIII", "LV", "MCMXCIV"
        )
        val conv = ArabToRomeConverter(Dictionary.Arab())
        inputList.forEachIndexed { index, i ->
            assertEquals(
                expected = RomeDigitSequence(resultList[index]).read(),
                actual = conv.convert(ArabDigitSequence(inputList[index])).read()
            )
        }
    }

    @Test
    @Ignore
    fun test_arab_to_rome_convertor_negative() {

    }

    @Test
    @Ignore
    fun test_arab_to_rome_convertor_zero() {

    }

    @Test
    @Ignore
    fun test_arab_to_rome_convertor_too_big_number() {

    }
}