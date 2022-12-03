interface Digit<T> {

    fun read(): T
    fun newValue(value: T): Digit<T>
    fun isEmpty() : Boolean

    data class RomeDigit(private val data: String) : Digit<String> {
        override fun read(): String = data
        override fun newValue(value: String): Digit<String> = RomeDigit(value)
        override fun isEmpty(): Boolean = data.isEmpty()
    }

    data class ArabDigit(private val data: Int) : Digit<Int> {
        override fun read(): Int = data
        override fun newValue(value: Int): Digit<Int> = ArabDigit(value)
        override fun isEmpty(): Boolean = data.toString().isEmpty()
    }

    data class Empty(private val data: String = "") : Digit<String> {
        override fun read(): String = ""
        override fun newValue(value: String): Digit<String> = this
        override fun isEmpty(): Boolean = true
    }
}