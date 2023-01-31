import org.junit.Assert.*
import org.junit.Test

/**
 * @author Demitrist on 30.01.2023
 */

class ArrayValidatorTest{

    private val validator = ArrayValidator.Base()

    @Test
    fun `test valid`(){
        val input = listOf(
            arrayOf("flower","flow","flight"),
            arrayOf("dog","racecar","car"),
            arrayOf("car", "cat", "cant"),
            arrayOf("craft", "fast", "food"),
            arrayOf("health", "count", "read")
        )
        val expected = true

        input.forEach {
            var actual = validator.isValid(it)
            assertEquals(expected, actual)
        }
    }

    @Test
    fun `test invalid`(){
        val input = listOf(
            arrayOf("cat5", "ta3k", "1rat"),
            arrayOf("test$", "cat dog", ".front"),
            arrayOf("React", "newMessage", "CARROT"),
            emptyArray(),
            Array(size = 201) { "" },
            arrayOf(
                "this string contain more 200 chars" +
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
        val expected = false

        input.forEach {
            var actual = validator.isValid(it)
            assertEquals(expected,actual)
        }
    }
}