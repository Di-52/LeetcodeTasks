/**
 * @author Demitrist on 02.02.2023
 **/

interface WordValidator {

    fun isValid(word: String): Boolean

    class Base() : WordValidator {
        override fun isValid(word: String): Boolean {
            var chars = word.toCharArray()
            var result = true

            if ((chars.count { it == '-' } > 1) ||
                (chars.last() == '-') ||
                (chars.dropLast(1).count { it == ',' || it == '.' || it == '!' } > 0) ||
                (chars.size > 1 && chars.last() !in 'a'..'z' &&
                        chars.dropLast(1).last() !in 'a'..'z') ||
                (chars.size > 1 && chars.first() !in 'a'..'z'))
                    result = false

            chars.forEach {
                if (!(it in 'a'..'z' || it == '.' || it == ',' || it == '!' || it == '-'))
                    result = false
            }

            return result
        }
    }
}