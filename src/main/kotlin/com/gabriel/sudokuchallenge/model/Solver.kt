package com.gabriel.sudokuchallenge.model

class Solver() {

    //inicializa uma matriz de tamanho 9x9
    private var sudokuGrid: Array<IntArray>

    init {
        sudokuGrid = arrayOf(
            intArrayOf(5, 3, 0, 0, 7, 0, 0, 0, 0),
            intArrayOf(6, 0, 0, 1, 9, 5, 0, 0, 0),
            intArrayOf(0, 9, 8, 0, 0, 0, 0, 6, 0),
            intArrayOf(8, 0, 0, 0, 6, 0, 0, 0, 3),
            intArrayOf(4, 0, 0, 8, 0, 3, 0, 0, 1),
            intArrayOf(7, 0, 0, 0, 2, 0, 0, 0, 6),
            intArrayOf(0, 6, 0, 0, 0, 0, 2, 8, 0),
            intArrayOf(0, 0, 0, 4, 1, 9, 0, 0, 5),
            intArrayOf(0, 0, 0, 0, 8, 0, 0, 7, 9)
        )
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
        //localiza qual as coordenadas do bloco 3x3
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
        for (row in 0..9) { //percorre as linhas da matriz
            for (collumn in 0..9) { //percorre as colunas da matriz
                for (number in 1..9) { //testa na posição [] números de 1 a 9
                    if (!isInTheRow(row, number) && (!isInTheColumn(collumn, number) && (isInTheBlock(row, collumn, number))))
                        sudokuGrid[row][collumn] = number
                }
            }
        }

        return TODO("ainda não sei a lógica completa")
    }

}