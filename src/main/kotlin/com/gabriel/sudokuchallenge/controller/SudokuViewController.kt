package com.gabriel.sudokuchallenge.controller

import com.gabriel.sudokuchallenge.model.Solver
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.GridPane

class SudokuViewController {

    @FXML
    private lateinit var gridPane: GridPane

    @FXML
    private lateinit var btnSolve: Button

    @FXML
    private lateinit var btnChangeMatrix: Button

    private var sudokuGrid: Array<IntArray> = Array(9) { IntArray(9) }

    @Override
    fun initialize() {
        val children = gridPane.children

        //seta os valores do gridPane para a array
        for (node in children) {
            //pega as coordenadas do node em questão
            val row = GridPane.getRowIndex(node) ?: 0
            val col = GridPane.getColumnIndex(node) ?: 0

            if (node is Label) {
                val text = node.text
                sudokuGrid[row][col] = if (text.isEmpty()) 0 else text.toInt()
            }
        }
    }

    private fun setSolvedGrid(grid: Array<IntArray>) {
        val children = gridPane.children

        for (node in children) {
            val row = GridPane.getRowIndex(node) ?: 0
            val col = GridPane.getColumnIndex(node) ?: 0

            if (node is Label) {
                node.text = sudokuGrid[row][col].toString()
            }
        }
    }

    @FXML
    fun onBtnSolveClick() {
        val solver = Solver() //instancia um novo Solver()
        solver.solve(sudokuGrid) //resolve o sudoku
        sudokuGrid = solver.solvedGrid //armazena o valor do sudoku resolvido
        setSolvedGrid(sudokuGrid) // seta os valores do array resolvido para o gridPane
    }

    @FXML
    fun onBtnChangeMatrixClick() {
        TODO("not implemented yet")
    }
}