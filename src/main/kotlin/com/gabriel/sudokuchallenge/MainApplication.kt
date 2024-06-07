package com.gabriel.sudokuchallenge

import com.gabriel.sudokuchallenge.controller.SudokuViewController
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        var sudokuViewController = SudokuViewController()

        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("view/sudoku-view.fxml"))
        fxmlLoader.setController(sudokuViewController)
        val scene = Scene(fxmlLoader.load())
        stage.title = "Sudoku Solver!"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}