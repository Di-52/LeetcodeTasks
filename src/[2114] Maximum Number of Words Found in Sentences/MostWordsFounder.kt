/**
 * @author Demitrist on 03.02.2023
 **/

interface MostWordsFounder {

    fun mostWords(sentences: List<String>): Int

    class Base : MostWordsFounder {
        override fun mostWords(sentences: List<String>): Int {
            var result = 0
            sentences.forEach {
                val words = it.split(' ').count()
                result = if (words > result) words else result
            }
            return result
        }
    }
}