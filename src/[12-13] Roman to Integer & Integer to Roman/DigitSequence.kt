import java.lang.Exception

interface DigitSequence<T> {

    fun nextDigit(): T
    fun read(): String

    interface AbstractSequence {
        fun resetPointer()
        fun size(): Int
        fun canRead(): Boolean
    }

    abstract class Abstract() : AbstractSequence {
        protected abstract var digitsList: MutableList<Char>
        protected abstract var pointer: Int

        override fun resetPointer() {
            pointer = 0
        }

        override fun size(): Int = digitsList.size
        override fun toString(): String = digitsList.toString()
        override fun canRead(): Boolean = digitsList.size > pointer
    }

    class Empty: DigitSequence<Nothing> {
        override fun nextDigit(): Nothing = throw Exception()
        override fun read(): String = ""
    }
}