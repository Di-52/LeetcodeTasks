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
            arrayOf("car", "cat", "can't"),
            arrayOf("craft", "fast", "food"),
            arrayOf("health", "count", "read")
        )
        val expected = true

        input.forEach {
            assertEquals(expected, validator.isValid(it))
        }
    }

    @Test
    fun `test invalid`(){
        val input = listOf(
            arrayOf("cat5", "task2", "1rat"),
            arrayOf("test$", "cat dog", "front."),
            arrayOf("React", "New", "Carrot"),
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
        val expected = false

        input.forEach {
            var actual = validator.isValid(it)
            assertEquals(expected,actual)
        }
    }
}