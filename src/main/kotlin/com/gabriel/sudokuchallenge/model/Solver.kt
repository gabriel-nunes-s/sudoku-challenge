package com.gabriel.sudokuchallenge.model

class Solver() {

    //armazena a matriz resolvida
    var solvedGrid: Array<IntArray> = Array(9) { IntArray(9) }

    private fun validPosition(sudokuGrid: Array<IntArray>, row: Int, column: Int, number: Int): Boolean {
        // Verifica se o número já existe na linha
        for (i in 0..8) {
            if (sudokuGrid[row][i] == number) return false
        }

        // Verifica se o número já existe na coluna
        for (i in 0..8) {
            if (sudokuGrid[i][column] == number) return false
        }

        // Mapeamento do bloco 3x3
        val blockStartPositionX: Int = row - (row % 3)
        val blockStartPositionY: Int = column - (column % 3)

        // Verifica se o número já existe no bloco 3x3
        for (i in blockStartPositionX until blockStartPositionX + 3) { //range x
            for (j in blockStartPositionY until blockStartPositionY + 3) { //range y
                if (sudokuGrid[i][j] == number) return false
            }
        }

        // Se o número não foi encontrado nem na linha, coluna ou bloco, é válido
        return true
    }

    fun solve(sudoku: Array<IntArray>): Array<IntArray> {
        var sudokuGrid = sudoku

        // Loop para percorrer toda a matrix linha por linha, da esquerda para a direita
        for (row in 0..8) {
            for (column in 0..8) {
                if (sudokuGrid[row][column] == 0) { // Verifica se a posição é vazia
                    for (number in 1..9) { // Testa números de 1 a 9 na posição
                        if (validPosition(sudokuGrid, row, column, number)) {
                            sudokuGrid[row][column] = number // Se válido, associa a posição ao número
                            return solve(sudokuGrid)
                            sudoku[row][column] = 0 // Retorna ao ponto anterior e assimila zero à posição caso encontre algum número inválido
                        }
                    }
                    throw Exception("The current matrix is not valid!") // A matriz é considerada inválida se nenhum número dee 1 a 9 for possível
                }
            }
        }

        return sudokuGrid
    }
}