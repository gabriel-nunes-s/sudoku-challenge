package com.gabriel.sudokuchallenge.controller

import com.gabriel.sudokuchallenge.model.Solver
import javafx.fxml.FXML
import javafx.scene.control.Alert
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.GridPane

class SudokuViewController {

    // Atributos FXML para interação com a tela
    @FXML
    private lateinit var gridPane: GridPane

    @FXML
    private lateinit var btnSolve: Button

    @FXML
    private lateinit var btnChangeMatrix: Button

    @FXML
    private lateinit var lblMessage: Label

    private var sudokuGrid: Array<IntArray> = Array(9) { IntArray(9) }

    // Função executada após a instância do controlador
    @Override
    fun initialize() {
        // Cria uma lista com todos os filhos do gridPane
        val children = gridPane.children

        // Loop que assimila os valores da lista ao array
        for (node in children) {
            // Registra as coordenadas do node em questão
            val row = GridPane.getRowIndex(node) ?: 0
            val col = GridPane.getColumnIndex(node) ?: 0

            // É assimilado 0 à posição se o Label esteja vazio, caso contrário, o número é assimilado
            if (node is Label) {
                val text = node.text
                sudokuGrid[row][col] = if (text.isEmpty()) 0 else text.toInt()
            }
        }
    }

    @FXML
    fun onBtnSolveClick() {
        // Inicializa a classe Solver e passa a matriz crua a ser resolvida
        val solver = Solver()
        if (solver.solve(sudokuGrid)) {
            sudokuGrid = solver.solvedGrid
            setSolvedGrid()
            lblMessage.text = "Solved!"
        } else {
            // A matriz não é válida, logo exibe uma mensagem de erro
            val alert = Alert(Alert.AlertType.ERROR)
            alert.title = "Error!"
            alert.headerText = null
            alert.contentText = "The current matrix is not valid!"
            alert.show()
        }
    }

    @FXML
    fun onBtnChangeMatrixClick() {
        TODO("not implemented yet")
    }

    // Loop para preencher o gridPane com os valores do array
    private fun setSolvedGrid() {
        val children = gridPane.children

        for (node in children) {
            val row = GridPane.getRowIndex(node) ?: 0
            val col = GridPane.getColumnIndex(node) ?: 0

            if (node is Label) {
                node.text = sudokuGrid[row][col].toString()
            }
        }
    }
}