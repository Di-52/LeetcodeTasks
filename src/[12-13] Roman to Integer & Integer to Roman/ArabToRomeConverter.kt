class ArabToRomeConverter(private val dictionary: Dictionary<Int, String>) :
    SequenceConvert<ArabDigitSequence, DigitSequence<*>> {
    override fun convert(source: ArabDigitSequence): DigitSequence<*> {
        var temp: MutableList<Digit<Int>> = mutableListOf()
        var t = dictionary.search(value = Digit.ArabDigit(source.read().toInt()))
        if (!t.isEmpty()) return RomeDigitSequence(t)
        if (source.read().toInt() == 0) return DigitSequence.Empty()
        while (source.canRead()) temp.add(source.nextDigit())
        val result: MutableList<String> = mutableListOf()
        temp.reversed().toMutableList()
        temp.forEachIndexed { index, num ->
            var str = dictionary.search(num)
            if (str.read() == "") {
                var nums = TermsOfNumber(num.read()).convert()
                nums.forEach {
                    str = dictionary.search(Digit.ArabDigit(it))
                    if (str.read() == "")
                        result.add("*")
                    else result.add(str.read().toString())
                }
            } else result.add(str.read().toString())
        }

        return RomeDigitSequence(result.joinToString(""))
    }

}