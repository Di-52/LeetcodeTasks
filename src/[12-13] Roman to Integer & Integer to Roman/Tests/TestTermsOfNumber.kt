import org.junit.Test
import kotlin.test.assertEquals

/**
 * @author Demetrist on 03.12.2022
 */

class TestTermsOfNumber {

    @Test
    fun test_terms_of_number() {
        val inputList = listOf(
            1,
            3,
            5,
            10,
            40,
            90,
            300,
            800,
            2000
        )
        val resultList = listOf(
            listOf(1),
            listOf(1, 1, 1),
            listOf(5),
            listOf(10),
            listOf(10, 50),
            listOf(10, 100),
            listOf(100, 100, 100),
            listOf(500, 100, 100, 100),
            listOf(1000, 1000)
        )
        inputList.forEachIndexed { index, i ->
            assertEquals(
                expected = resultList[index],
                actual = TermsOfNumber(inputList[index]).convert())
        }
    }
}