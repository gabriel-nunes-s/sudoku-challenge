package com.gabriel.sudokuchallenge.controller

import com.gabriel.sudokuchallenge.model.Solver
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Alert
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.GridPane
import java.net.URL
import java.util.*

class MainViewController() : Initializable {

    private var sudokuGrid: Array<IntArray> = Array(9) { IntArray(9) }

    // Atributos FXML para interação com a tela
    @FXML
    lateinit var gridPane: GridPane

    @FXML
    private lateinit var btnSolve: Button

    @FXML
    private lateinit var btnClear: Button

    @FXML
    private lateinit var lblMessage: Label

    // Função executada após a instância do controlador
    override fun initialize(location: URL?, resources: ResourceBundle?) {

    }

    @FXML
    fun onBtnSolveClick() {
        // Inicializa a classe Solver e passa a matriz crua a ser resolvida
        getGridPaneValues()
        val solver = Solver()
        if (solver.solve(sudokuGrid)) {
            sudokuGrid = solver.solvedGrid
            setSolvedGrid()
            lblMessage.text = "Solved!"
            btnSolve.isDisable = true
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
    fun onBtnClearClick() {
        for (node in gridPane.children) {
            if (node is TextField) {
                node.text = ""
            }
        }
        btnSolve.isDisable = false
    }

    // Loop para preencher o gridPane com os valores do array
    private fun setSolvedGrid() {
        val children = gridPane.children

        for (node in children) {
            val row = GridPane.getRowIndex(node) ?: 0
            val col = GridPane.getColumnIndex(node) ?: 0

            if (node is TextField) {
                node.text = sudokuGrid[row][col].toString()
            }
        }
    }

    private fun getGridPaneValues() {
        // Cria uma lista com todos os filhos do gridPane
        val children = gridPane.children

        // Loop que assimila os valores da lista ao array
        for (node in children) {
            // Registra as coordenadas do node em questão
            val row = GridPane.getRowIndex(node) ?: 0
            val col = GridPane.getColumnIndex(node) ?: 0

            // É assimilado 0 à posição se o Label estiver vazio, caso contrário, o número é assimilado
            if (node is TextField) {
                val text = node.text
                sudokuGrid[row][col] = if (text.isEmpty()) 0 else text.toInt()
            }
        }
    }
}