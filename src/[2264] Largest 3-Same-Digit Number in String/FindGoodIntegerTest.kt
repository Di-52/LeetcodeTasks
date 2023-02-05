import org.junit.Test
import kotlin.test.assertEquals

/**
 * @author Demitrist on 05.02.2023
 **/

class FindGoodIntegerTest {

    @Test
    fun test(){
        val checker = FakeChecker()
        val finder = FindGoodInteger.Base(substringChecker = checker)
        val input = listOf(
            "6777133339",
            "2300019",
            "42352338"
        )
        val expected = listOf(
            "777",
            "000",
            ""
        )

        input.forEachIndexed { index, string ->
            checker.setValidString(expected[index])
            assertEquals(expected[index], finder.find(string = string))
        }
    }
}

private class FakeChecker : CheckSubstring{
    private var validString = ""

    fun setValidString(str: String) {
        validString = str
    }
    override fun isValid(substring:String):Boolean = validString == substring
}