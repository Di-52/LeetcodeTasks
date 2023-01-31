import org.junit.Assert.*
import org.junit.Test

/**
 * @author Demitrist on 30.01.2023
 */

class PrefixFinderTest {

    @Test
    fun `test correct`() {
        val arrayValidator = FakeValidator(result = true)
        val finder = PrefixFinder.Base(validator = arrayValidator)
        val input = listOf(
            arrayOf(""),
            arrayOf("abab","aba",""),
            arrayOf("flower","flow","flight"),
            arrayOf("car", "cat", "can't"),
            arrayOf("help","head","door","draft","dart"),
            arrayOf("craft", "fast", "food"),
            arrayOf("health", "count", "read"),
            arrayOf("p"),
            arrayOf("a")
        )
        val expected = listOf(
            "",
            "",
            "fl",
            "ca",
            "",
            "",
            "",
            "p",
            "a"
        )

        input.forEachIndexed { index, strings ->
            var actual: String = finder.prefix(strings)
            var exp: String = expected[index]
            assertEquals(exp, actual)
        }
    }

    @Test(expected = IllegalArgumentException::class)
    fun `test incorrect input`() {
        val arrayValidator = FakeValidator(result = false)
        val finder = PrefixFinder.Base(validator = arrayValidator)
        val input = listOf(
            arrayOf("cat5", "ta5ka", "1rat"),
            arrayOf("test$", "cat dog", ".front."),
            arrayOf("React", "newImage", "CARROT"),
            emptyArray(),
            Array(size = 201) { "" },
            arrayOf(
                "qazwsxedcrfvtgbyhnuj" +
                        "qazwsxedcrfvtgbyhnuj" +
                        "qazwsxedcrfvtgbyhnuj" +
                        "qazwsxedcrfvtgbyhnuj" +
                        "qazwsxedcrfvtgbyhnuj" +
                        "qazwsxedcrfvtgbyhnuj" +
                        "qazwsxedcrfvtgbyhnuj" +
                        "qazwsxedcrfvtgbyhnuj" +
                        "qazwsxedcrfvtgbyhnuj" +
                        "qazwsxedcrfvtgbyhnuj" +
                        "a"
            )
        )

        input.forEach {
            finder.prefix(it)
        }
    }
}

private class FakeValidator(private val result: Boolean = true) : ArrayValidator {

    override fun isValid(strings: Array<String>): Boolean = result
}