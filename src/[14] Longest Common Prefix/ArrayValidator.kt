/**
 * @author Demitrist on 30.01.2023
 **/

interface ArrayValidator {

    fun isValid(strings: Array<String>): Boolean

    class Base : ArrayValidator {
        override fun isValid(strings: Array<String>): Boolean {
            if (strings.size in 1..200){
                strings.forEach {
                    if (it.length > 200 || it.contains("[^a-z]*".toRegex()))
                        return false
                }
                return true
            }
            return false
        }

    }
}