/**
 * @author Demitrist on 30.01.2023
 **/

interface ArrayValidator {

    fun isValid(strings: Array<String>): Boolean

    class Base : ArrayValidator {

        override fun isValid(strings: Array<String>): Boolean {
            var result = strings.size in 1..200
            strings.forEach {
                result = result && it.contains("^[a-z]*$".toRegex()) && it.length <= 200
            }
            return result
        }
    }
}