/**
 * @author Demitrist on 05.02.2023
 **/

interface CheckSubstring {

    fun isValid(substring: String): Boolean

    class Base : CheckSubstring {
        override fun isValid(substring: String): Boolean {
            var result = true
            if (substring.length != 3) result=false
            else{
                if(substring[0] != substring[1] || substring[0] != substring[2])
                    result =false
            }
            return result
        }
    }
}