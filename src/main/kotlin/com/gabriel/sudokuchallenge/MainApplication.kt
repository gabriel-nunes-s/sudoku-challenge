package com.gabriel.sudokuchallenge

import com.gabriel.sudokuchallenge.controller.MainViewController
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.layout.GridPane
import javafx.stage.Stage

class MainApplication : Application() {

    companion object {
        lateinit var staticStage: Stage
    }

    override fun start(stage: Stage) {
        staticStage = stage
        val loader = FXMLLoader(MainApplication::class.java.getResource("view/main-view.fxml"))
        val scene = Scene(loader.load())
        stage.title = "Sudoku Solver!"
        stage.scene = scene
        stage.centerOnScreen()
        stage.show()
    }
}

fun main() {
    Application.launch(MainApplication::class.java)
}