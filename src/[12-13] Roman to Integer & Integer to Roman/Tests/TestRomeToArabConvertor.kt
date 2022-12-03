import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

/**
 * @author Demetrist on 03.12.2022
 */

class TestRomeToArabConverter {

    @Test
    fun rome_to_arab_converter_test_success(){
        val conv = RomeToArabConverter(Dictionary.Rome())
        val inputList = listOf(
                "I",
                "III",
                "V",
                "IX",
                "LVIII",
                "MCMXCIV"
        )

        val expectedList = listOf(
                "1",
                "3",
                "5",
                "9",
                "58",
                "1994"
        )
        inputList.forEachIndexed(){id,input ->
                assertEquals(expected = expectedList[id], conv.convert(RomeDigitSequence(input)).read())
        }
    }

    @Test
    fun rome_to_arab_converter_test_empty_input(){
        val conv = RomeToArabConverter(Dictionary.Rome())
        assertEquals(expected = "", actual = conv.convert(RomeDigitSequence("")).read())
    }

    @Test()
    fun rome_to_arab_converter_test_random_string(){
        val conv = RomeToArabConverter(Dictionary.Rome())
        val act = conv.convert(RomeDigitSequence("Fuck you"))
        //todo check on invalid symbols
        assertEquals(expected = ArabDigitSequence(0), actual = act)
    }

    @Test
    @Ignore
    fun rome_to_arab_converter_test_invalid_signature(){
        val conv = RomeToArabConverter(Dictionary.Rome())

        //todo test on invalid order of symbols

        val inputList = listOf(
                "I",
                "III",
                "V",
                "IX",
                "LIIIIIV",
                "IMCMXCIV"
        )

        inputList.forEach(){input ->
                assertEquals(expected = "", conv.convert(RomeDigitSequence(input)).read())
        }
    }
}
