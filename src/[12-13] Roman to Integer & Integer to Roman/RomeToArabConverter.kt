class RomeToArabConverter(private val dictionary: Dictionary<String, Int>) :
    SequenceConvert<RomeDigitSequence, ArabDigitSequence> {
    override fun convert(source: RomeDigitSequence): ArabDigitSequence {
        var list: MutableList<Digit<*>> = mutableListOf()
        var t: Digit<*>
        while (source.canRead()) {
            t = dictionary.search(source.nextDigit())
            if (!t.isEmpty())
                list.add(t)
        }
        var temp = list

        for (i in 1..list.size - 1)
            if (list[i].read().toString().toInt() > list[i - 1].read().toString().toInt()) temp[i - 1] = Digit.ArabDigit(temp[i - 1].read().toString().toInt() * -1)
        var result = 0
        temp.forEach {
            result += it.read().toString().toInt()
        }
        return ArabDigitSequence(result)
    }
}