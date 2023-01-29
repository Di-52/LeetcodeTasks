import org.junit.Assert.*
import org.junit.Test

/**
 * @author Demitrist on 28.01.2023
 */

class MeasurerTest{

    @Test
    fun `test correct result`(){
        val measurer = Measurer.Base(delimiter = " ")
        val expected = listOf(0,0,3,5,6,1,6)
        val strings = listOf(
            "",
            " ",
            "test stair of ant  ",
            "somme",
            "me an     Philip ",
            "a at b",
            "djf   hdhshh hhhhhhhhhhhhhhh sa ssafsadf  384hsd   ")
        strings.forEachIndexed { index, str ->
            assertEquals(expected[index], measurer.size(string = str))
        }
    }
}