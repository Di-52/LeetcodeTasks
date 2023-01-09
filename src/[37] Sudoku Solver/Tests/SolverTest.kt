import com.sun.nio.sctp.HandlerResult
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * @author Demitrist on 08.01.2023
 **/

class SolverTest {

    @Test
    fun test_succes_solving() {
        val board: GameBoard = TestGameBoard()
        board.listOfCells = mutableListOf(0, 2, 3)
        val methods: MethodChain = TestMethodsChain()
        methods.result = mutableListOf(
            FakeResult.Success(result = 1),
            FakeResult.Error(error = true),
            FakeResult.Error(error = true)
        )
        val solver: Solver = Solver.Base(
            gameBoard = board,
            methods = methods
        )
        val result: Boolean = solver.solve()
        assertTrue(result)
        assertEquals(listOf(1, 2, 3) board . listOfCells)
    }

    @Test
    fun test_succes_two_step_solving(){
        val board: GameBoard = TestGameBoard()
        board.listOfCells = mutableListOf(0, 2, 0)
        val methods: MethodChain = TestMethodsChain()
        methods.result = mutableListOf(
            FakeResult.Success(result = 1),
            FakeResult.Error(error = true),
            FakeResult.Error(error = true)
        )
        val solver: Solver = Solver.Base(
            gameBoard = board,
            methods = methods
        )
        var result: Boolean = solver.solve()

        assertFalse(result)
        assertEquals(listOf(1, 2, 0) board . listOfCells)

        methods.result = mutableListOf(
            FakeResult.Error(error = true),
            FakeResult.Error(error = true),
            FakeResult.Success(result = 3)
        )
        result = solver.solve()
        assertTrue(result)
        assertEquals(listOf(1, 2, 3) board . listOfCells)
    }

    @Test(expected = IllegalStateException::class)
    fun test_no_solve(){
        val board: GameBoard = TestGameBoard()
        board.listOfCells = mutableListOf(0, 0, 0)
        val methods: MethodChain = TestMethodsChain()
        methods.result = mutableListOf(
            FakeResult.Error(error = true),
            FakeResult.Error(error = true),
            FakeResult.Error(error = true)
        )
        val solver: Solver = Solver.Base(
            gameBoard = board,
            methods = methods
        )
        solver.solve()
    }

    @Test(expected = IllegalArgumentException::class)
    fun test_fake_input(){
        val board: GameBoard = TestGameBoard()
        board.listOfCells = mutableListOf(-5, 0, 1)
        val methods: MethodChain = TestMethodsChain()
        methods.result = mutableListOf(
            FakeResult.Error(error = true),
            FakeResult.Error(error = true),
            FakeResult.Error(error = true)
        )
        val solver: Solver = Solver.Base(
            gameBoard = board,
            methods = methods
        )
    }
}

private class TestGameBoard() : GameBoard {
    var listOfCells: MutableList<Int> = mutableListOf()

    override fun boardIsFull(): Boolean = cells.all { it > 0 }
    override fun nextEmpty(): GameBoard.Cell {
        val result: MutableList<TestCell> = mutableListOf()
        cells.forEach {
            if (it == 0 && result.isEmpty())
                result.add(TestCell(it))
        }
        if (result.isNotEmpty())
            return result[0]
        else throw IllegalStateException()
    }
}

private class TestMethodsChain() : MethodChain.Handle {
    var result: MutableList<HandlerResult> = mutableListOf()
    override fun handle(cell: GameBoard.Cell): HandleResult = result
}

private interface FakeResult : HandleResult {
    data class Success(private val result: Int) : FakeResult
    data class Error(private val error: Boolean) : FakeResult
}