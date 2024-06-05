package com.gabriel.sudokuchallenge.model

class Solver(matrix: Array<IntArray>) {

    private var sudokuGrid: Array<IntArray>

    init {
        sudokuGrid = matrix
    }

    // --- funções de verificação ---
    fun isInTheRow(row: Int, number: Int): Boolean {
        //percorre toda a linha
        for (i in 0..8) {
            if (sudokuGrid[row][i] == number) return true
        }
        return false
    }

    fun isInTheColumn(column: Int, number: Int): Boolean {
        //percorre toda a coluna
        for (i in 0..8) {
            if (sudokuGrid[column][i] == number) return true
        }
        return false
    }

    fun isInTheBlock(x: Int, y: Int, number: Int): Boolean {
        //mapeia as coordenadas do bloco 3x3
        val blockStartPositionX: Int = (x % 3)
        val blockFinalPositionX = blockStartPositionX + 2
        val blockStartPositionY: Int = (y % 3)
        val blockFinalPositionY = blockStartPositionY + 2

        for (i in blockStartPositionX..blockFinalPositionX) { //range x
            for (j in blockStartPositionY..blockFinalPositionY) { //range y
                if (sudokuGrid[i][j] == number) return true
            }
        }
        return false
    }

    fun solve(): Array<IntArray> {
        // percorre  toda a matriz
        for (row in 0..8) { //percorre as linhas da matriz
            for (collumn in 0..8) { //percorre as colunas da matriz
                for (number in 1..9) { //testa na posição [] números de 1 a 9
                    if (sudokuGrid[row][collumn] == 0 && !isInTheRow(row, number) && (!isInTheColumn(collumn, number) && (isInTheBlock(row, collumn, number)))) {
                        sudokuGrid[row][collumn] = number
                    }
                }
            }
        }

        return sudokuGrid
    }

}