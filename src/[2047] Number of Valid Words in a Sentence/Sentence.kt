/**
 * @author Demitrist on 01.02.2023
 **/

fun main() {
    val input = "type your string here."
    val sent = Sentence.Base(WordValidator.Base())
    println("Valid words count: ${sent.validWords(input)}")
}

interface Sentence {

    fun validWords(string: String): Int

    class Base(private val validator: WordValidator) : Sentence {
        override fun validWords(string: String): Int {
            var result = 0

            val words = string.split(" ")
            words.forEach {
                var word = it.trim()
                if (word.isNotEmpty() && validator.isValid(word = word))
                    result++
            }

            return result
        }
    }
}