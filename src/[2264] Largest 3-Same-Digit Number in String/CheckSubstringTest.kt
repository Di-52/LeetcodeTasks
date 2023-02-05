import org.junit.Test
import kotlin.test.assertEquals

/**
 * @author Demitrist on 05.02.2023
 **/

class CheckSubstringTest {
    private val checker = CheckSubstring.Base()

    @Test
    fun test_valid(){
        val input = listOf(
            "000","111","222","333","444","555","666","777","888","999"
        )
        val expected = true

        input.forEach {
            assertEquals(expected, checker.isValid(substring = it))
        }
    }

    @Test
    fun test_invalid(){
        val input = listOf(
            "123","121","331","12","1111",""
        )
        val expected = false

        input.forEach {
            assertEquals(expected, checker.isValid(substring = it))
        }
    }
}