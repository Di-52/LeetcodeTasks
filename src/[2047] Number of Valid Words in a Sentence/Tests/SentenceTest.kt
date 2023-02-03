import org.junit.Assert.*
import org.junit.Test

/**
 * @author Demitrist on 01.02.2023
 */

class SentenceTest {

    @Test
    fun `test fake valid`() {
        val validator: WordValidator = FakeValidator(true)
        val sentence: Sentence = Sentence.Base(validator = validator)
        val inputs = listOf(
            "one two three four",
            "one two three",
            "one two",
            "one"
        )
        val expected = listOf(
            4,
            3,
            2,
            1
        )

        inputs.forEachIndexed { index, string ->
            assertEquals(expected[index], sentence.validWords(string = string))
        }
    }

    @Test
    fun `test fake invalid`() {
        val validator: WordValidator = FakeValidator(false)
        val sentence: Sentence = Sentence.Base(validator = validator)
        val inputs = listOf(
            "one two three four",
            "one two three",
            "one two",
            "one"
        )
        val expected = 0

        inputs.forEach {
            assertEquals(expected, sentence.validWords(string = it))
        }
    }

    @Test
    fun `test real`() {
        val validator = WordValidator.Base()
        val sentence: Sentence = Sentence.Base(validator = validator)
        val inputs = listOf(
            "cat and  dog",
            "!this  1-s b8d!",
            "alice and  bob are playing stone-game10",
            "Flat house stay",
            "more than pre-purchase",
            "if- you -want than, can!",
            ".",
            "as,. rat-fat-boom .start stat.frost",
            " 62   nvtk0wr4f  8 qt3r! w1ph 1l ,e0d 0n 2v 7c.  n06huu2n9 s9   ui4 nsr!d7olr  " +
                    "q-, vqdo!btpmtmui.bb83lf g .!v9-lg 2fyoykex uy5a 8v whvu8 .y sc5 -0n4 zo " +
                    "pfgju 5u 4 3x,3!wl  fv4   s  aig cf j1 a i  8m5o1  !u n!.1tz87d3 .9    " +
                    "n a3  .xb1p9f  b1i a j8s2 cugf l494cx1! hisceovf3 8d93 sg 4r.f1z9w   4- " +
                    "cb r97jo hln3s h2 o .  8dx08as7l!mcmc isa49afk i1 fk,s e !1 ln rt2vhu " +
                    "4ks4zq c w  o- 6  5!.n8ten0 6mk 2k2y3e335,yj  h p3 5 -0  5g1c  tr49, ,qp9 " +
                    "-v p  7p4v110926wwr h x wklq u zo 16. !8  u63n0c l3 yckifu 1cgz t.i   " +
                    "lh w xa l,jt   hpi ng-gvtk8 9 j u9qfcd!2  kyu42v dmv.cst6i5fo rxhw4wvp2 " +
                    "1 okc8!  z aribcam0  cp-zp,!e x  agj-gb3 !om3934 k vnuo056h g7 t-6j! " +
                    "8w8fncebuj-lq    inzqhw v39,  f e 9. 50 , ru3r  mbuab  6  wz dw79.av2xp " +
                    ". gbmy gc s6pi pra4fo9fwq k   j-ppy -3vpf   o k4hy3 -!..5s ,2 k5 j " +
                    "p38dtd   !i   b!fgj,nx qgif "
        )
        val expected = listOf(
            3,
            0,
            5,
            2,
            3,
            3,
            1,
            0,
            49
        )

        inputs.forEachIndexed { index, string ->
            assertEquals(expected[index], sentence.validWords(string = string))
        }
    }
}

private class FakeValidator(private val result: Boolean = true) : WordValidator {
    override fun isValid(word: String): Boolean = result
}