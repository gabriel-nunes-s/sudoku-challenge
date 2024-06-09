package com.gabriel.sudokuchallenge.controller

import com.gabriel.sudokuchallenge.MainApplication
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.layout.GridPane
import java.net.URL
import java.util.*

class ChangeMatrixViewController : Initializable {
    @FXML
    lateinit var btnOk: Button

    @FXML
    lateinit var btnClear: Button

    @FXML
    var gridPane: GridPane = GridPane()

    var newSudokuGrid: Array<IntArray> = Array(9) { IntArray(9) }

    override fun initialize(location: URL?, resources: ResourceBundle?) {}

    @FXML
    fun onBtnOkCLick() {
        getGridPaneValues()
        returnToMainScreen()
    }

    @FXML
    fun onBtnClearCLick() {
        for (node in gridPane.children) {
            if (node is TextField) {
                node.text = ""
            }
        }
    }

    private fun getGridPaneValues() {
        for (node in gridPane.children) {
            // Localiza coordenadas do node em questão
            val row = GridPane.getRowIndex(node) ?: 0
            val col = GridPane.getColumnIndex(node) ?: 0

            if (node is TextField) {
                newSudokuGrid[row][col] = if (node.text.isEmpty()) 0 else node.text.toInt()
            }
        }
    }

    private fun returnToMainScreen() {
        val loader: FXMLLoader = FXMLLoader(MainApplication::class.java.getResource("view/main-view.fxml"))
        val root: Parent = loader.load()
        val mainScene = Scene(root)

        with(MainApplication) {
            staticStage.title = "Sudoku Solver!"
            staticStage.scene = mainScene
            staticStage.centerOnScreen()
            staticStage.show()
        }
    }
}