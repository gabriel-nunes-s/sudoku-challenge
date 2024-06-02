package com.gabriel.sudokuchallenge

import com.gabriel.sudokuchallenge.controller.SudokuViewController
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("view/sudoku-view.fxml"))
        val scene = Scene(fxmlLoader.load())
        stage.title = "Sudoku Solver!"
        stage.scene = scene
        stage.show()

        val controller = SudokuViewController()
        controller.showMatrix()
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}