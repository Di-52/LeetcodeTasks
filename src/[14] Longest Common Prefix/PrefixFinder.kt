/**
 * @author Demitrist on 30.01.2023
 **/

interface PrefixFinder {
    fun prefix(strings: Array<String>): String

    class Base(private val validator: ArrayValidator):PrefixFinder{

        override fun prefix(strings: Array<String>): String {
            if (!validator.isValid(strings)) throw IllegalArgumentException()

            var result = mutableMapOf<String,Int>()
            var prefix: String

            strings.forEach {
                prefix = it
                var found = 0

                while (found < 2 && prefix.length > 0)
                {
                    strings.forEach {
                        if (it.startsWith(prefix)){
                            found++
                        }
                    }
                    if (found == strings.size){
                        result.put(prefix, found)
                    }
                    else{
                        found =0
                        prefix = prefix.dropLast(1)
                    }
                }
            }
            var res = ""
            var foundCount = 0
            result.forEach {
                if (it.value > foundCount) res = it.key
            }
            return res
        }
    }
}