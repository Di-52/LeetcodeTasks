class RomeDigitSequence(sequence: String) :
    DigitSequence.Abstract(), DigitSequence<Digit.RomeDigit> {
    constructor(list: List<String>) : this(list.joinToString(""))
    constructor(digit: Digit<*>) : this(digit.read().toString())

    override var digitsList: MutableList<Char> = sequence.toCharArray().toMutableList()
    override var pointer: Int = 0

    override fun nextDigit(): Digit.RomeDigit {
        if (digitsList.size <= pointer || pointer < 0)
            throw IllegalStateException()
        return Digit.RomeDigit(digitsList[pointer++].toString())
    }

    override fun read(): String = digitsList.joinToString("")
}