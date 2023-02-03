import org.junit.Test
import kotlin.test.assertEquals

/**
 * @author Demitrist on 03.02.2023
 **/

class MostWordsFounderTest {

    @Test
    fun test(){
        val input = listOf(
            listOf("alice and bob love leetcode", "i think so too", "this is great thanks very much"),
            listOf("please wait", "continue to fight", "continue to win"),
            listOf("a"),
            listOf("s s s", "a a a a a", "e e e e e e e e e e")
        )
        val founder = MostWordsFounder.Base()
        val expected = listOf(
            6,
            3,
            1,
            10
        )

        input.forEachIndexed { index, sentence ->
            assertEquals(expected[index], founder.mostWords(sentences = sentence))
        }
    }
}