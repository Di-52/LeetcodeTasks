/**
 * @author Demetrist on 03.12.2022
 */
class TermsOfNumber(private val num: Int) {
    private var base: Int
    private var size: Int

    init {
        val list = mutableListOf<Int>()
        size = Math.pow(10.0, (num.toString().length - 1).toDouble()).toInt()
        base = num / size
    }

    fun convert(): List<Int> {
        if (base == 1 || base == 5) return listOf(num)
        val result = mutableListOf<Int>()
        when (base) {
            in 2..3 -> for(i in 1..base) result.add(1 * size)
            4 -> {
                result.add(1 * size)
                result.add(5 * size)
            }
            in 6..8 -> {
                result.add(5 * size)
                for (i in 1..base - 5) result.add(1 * size)
            }
            9-> {
                result.add(1 * size)
                result.add(10 * size)
            }
        }
        return result
    }
}