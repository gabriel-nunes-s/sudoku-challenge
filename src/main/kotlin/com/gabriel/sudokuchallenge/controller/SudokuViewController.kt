package com.gabriel.sudokuchallenge.controller

import com.gabriel.sudokuchallenge.model.Solver
import javafx.fxml.FXML

class SudokuViewController {

    val sudoku = arrayOf(
        intArrayOf(8, 0, 1, 0, 0, 0, 0, 0, 0),
        intArrayOf(2, 5, 0, 0, 7, 0, 0, 9, 0),
        intArrayOf(0, 4, 0, 0, 0, 8, 0, 2, 6),
        intArrayOf(0, 0, 7, 8, 0, 5, 0, 1, 3),
        intArrayOf(0, 0, 5, 0, 4, 3, 0, 0, 7),
        intArrayOf(0, 0, 3, 7, 9, 0, 0, 0, 4),
        intArrayOf(0, 9, 0, 4, 0, 7, 0, 6, 2),
        intArrayOf(1, 0, 0, 5, 8, 6, 0, 7, 9),
        intArrayOf(0, 6, 4, 0, 1, 2, 0, 0, 0)
    )

    init {
        var solver = Solver()
        solver.solve(sudoku)
    }

    @FXML
    fun onSolveButtonClick() {
        TODO("not implemented yet")
    }

    @FXML
    fun onChangeMatrixButtonClick() {
        TODO("not implemented yet")
    }
}