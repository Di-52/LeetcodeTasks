/**
 * @author Demitrist on 05.02.2023
 **/

interface FindGoodInteger {

    fun find(string: String): String

    class Base(private val substringChecker: CheckSubstring) : FindGoodInteger {
        override fun find(string: String): String {
            var result = ""
            for (i in 0..string.length - 3) {
                val sub = string.substring(i, i + 3)
                if ((substringChecker.isValid(substring = sub)) &&
                    ((result.isEmpty()) || (result[0] < sub[0]))
                )
                    result = sub
            }
            return result
        }
    }
}