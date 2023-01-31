/**
 * @author Demitrist on 30.01.2023
 **/

interface PrefixFinder {
    fun prefix(strings: Array<String>): String

    class Base(private val validator: ArrayValidator) : PrefixFinder {

        override fun prefix(strings: Array<String>): String {
            if (!validator.isValid(strings)) throw IllegalArgumentException()

            var founds = 0
            var index = 0
            var minLength = 200

            if (strings[0].isNotEmpty())
                while (founds == 0) {
                    var char = strings[0].toCharArray()[index]
                    strings.forEach {
                        if (it.length < minLength) minLength = it.length
                        if (minLength == 0) return@forEach
                        if (it.toCharArray()[index] == char) founds++
                    }
                    if (founds == strings.size) index++
                    if (index < minLength && founds == strings.size) {
                        founds = 0
                    }
                }

            return if (minLength == 0) "" else strings[0].substring(0..index - 1)
        }
    }
}