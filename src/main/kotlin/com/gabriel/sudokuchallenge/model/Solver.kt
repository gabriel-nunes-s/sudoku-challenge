package com.gabriel.sudokuchallenge.model

class Solver() {

    //armazena a matriz resolvida
    var solvedGrid: Array<IntArray> = Array(9) { IntArray(9) }

    private fun validPosition(sudokuGrid: Array<IntArray>, row: Int, column: Int, number: Int): Boolean {
        //valida as posições na linha
        for (i in 0..8) {
            if (sudokuGrid[row][i] == number) return false
        }

        //valida as posições na coluna
        for (i in 0..8) {
            if (sudokuGrid[i][column] == number) return false
        }

        //mapeamento do bloco 3x3
        val blockStartPositionX: Int = row - (row % 3)
        val blockStartPositionY: Int = column - (column % 3)

        //valida as posições no bloco
        for (i in blockStartPositionX until blockStartPositionX + 3) { //range x
            for (j in blockStartPositionY until blockStartPositionY + 3) { //range y
                if (sudokuGrid[i][j] == number) return false
            }
        }

        return true
    }

    fun solve(sudoku: Array<IntArray>): Boolean {
        var solvedSudoku = sudoku

        // percorre  toda a matriz
        for (row in 0..8) { //percorre as linhas da matriz
            for (column in 0..8) { //percorre as colunas da matriz
                if (solvedSudoku[row][column] == 0) {//verifica se a posição é vazia
                    for (number in 1..9) {//testa números de 1 a 9 na posição
                        if (validPosition(solvedSudoku, row, column, number)) {
                            solvedSudoku[row][column] = number
                            if (solve(solvedSudoku)) {
                                solvedGrid = solvedSudoku
                                return true
                            }
                            sudoku[row][column] = 0
                        }
                    }
                    return false
                }
            }
        }

        return true
    }
}