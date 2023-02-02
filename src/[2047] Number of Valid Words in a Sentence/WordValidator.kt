/**
 * @author Demitrist on 02.02.2023
 **/

interface WordValidator {

    fun isValid(word: String): Boolean

    class Base() : WordValidator {
        override fun isValid(word: String): Boolean {
            var result = true

            val chars = word.toCharArray()
            if (chars.count { it == '-' } > 1 || chars.last() == '-')
                result = false
            if (chars.dropLast(1).count { it == ',' || it == '.' || it == '!' } > 0)
                result=false
            if(chars.size > 1 && chars.last() !in 'a'..'z' && chars.dropLast(1).last() !in 'a'..'z')
                result = false
            chars.forEach {
                if (!(it in 'a'..'z' || it == '.' || it == ',' || it == '!' || it == '-'))
                    result = false
            }
            if (chars.size > 1 && chars.first() !in 'a'..'z')
                result = false

            return result
        }
    }
}