/**
 * @author Demitrist on 28.01.2023
 **/

interface Measurer {

    fun size(string: String): Int

    class Base(private val delimiter: String = " ") : Measurer {
        override fun size(string: String): Int {
            if (string.isEmpty()) return 0
            val parts = string.split(delimiter)
            var result = 0
            parts.forEach {
                result = if (it.length > result) it.length else result
            }
            return result
        }
    }
}