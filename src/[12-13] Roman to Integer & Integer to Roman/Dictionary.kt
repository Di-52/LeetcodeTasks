import java.lang.IllegalArgumentException

interface Dictionary<T,R> {

    fun search(value: Digit<T>): Digit<*>

    class Rome() : Dictionary<String, Int> {
        private val map: Map<String, Int> = mapOf(
            Pair("I", 1),
            Pair("V", 5),
            Pair("X", 10),
            Pair("L", 50),
            Pair("C", 100),
            Pair("D", 500),
            Pair("M", 1000)
        )

        override fun search(value: Digit<String>): Digit<*> {
            val result = map?.get(value.read()) ?: 0
            if (result == 0) return Digit.Empty()
            return Digit.ArabDigit(result)
        }

    }

    class Arab : Dictionary<Int, String> {
        private val map: Map<Int, String> = mapOf(
            Pair(1, "I"),
//            Pair(4, "IV"),
            Pair(5, "V"),
//            Pair(9, "IX"),
            Pair(10, "X"),
//            Pair(40, "XL"),
            Pair(50, "L"),
//            Pair(90, "XC"),
            Pair(100, "C"),
//            Pair(400, "CD"),
            Pair(500, "D"),
//            Pair(900, "CM"),
            Pair(1000, "M")
        )

        override fun search(value: Digit<Int>): Digit<*> {
            var result = map?.get(value.read()) ?: ""
            if (result.isEmpty()) return Digit.Empty()
            return Digit.RomeDigit(result)
        }
    }
}