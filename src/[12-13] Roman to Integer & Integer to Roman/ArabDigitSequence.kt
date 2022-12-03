data class ArabDigitSequence(val sequence: String) :
    DigitSequence.Abstract(), DigitSequence<Digit.ArabDigit> {
    constructor(list: List<Digit.ArabDigit>) : this(list.joinToString("").toInt())
    constructor(intVal: Int) : this(intVal.toString())

    override var digitsList: MutableList<Char> = sequence.toCharArray().toMutableList()
    override var pointer: Int = 0

    override fun nextDigit(): Digit.ArabDigit {
        if (digitsList.size <= pointer || pointer < 0)
            throw IllegalStateException()
        return Digit.ArabDigit(
            (Math.pow(
                10.0,
                (digitsList.size - pointer - 1).toDouble()
            )).toInt() * digitsList[pointer++].toString().toInt()
        )
    }

    override fun read(): String {
        val result = digitsList.joinToString("")
//        return if (result == "0") "" else result
        return result
    }
}