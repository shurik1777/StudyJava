package KnightMove;

import java.util.Arrays;

public class KnightTour {

    private static final int[] ROW_MOVES = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] COL_MOVES = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        int n = 8; // размер доски
        int[][] board = new int[n][n];

        // Начинаем с (0, 0)
        if (solve(board, 0, 0, 1)) {
            printBoard(board);
        } else {
            System.out.println("Решение не найдено");
        }
    }

    /**
     * Проверяем, можно ли походить в клетку (row, col).
     */
    private static boolean isSafe(int[][] board, int row, int col) {
        int n = board.length;
        return (row >= 0 && row < n && col >= 0 && col < n && board[row][col] == 0);
    }

    /**
     * Рекурсивная функция для выполнения обхода конём.
     */
    private static boolean solve(int[][] board, int row, int col, int moveNum) {
        int n = board.length;

        // Конец игры: если мы достигли последней клетки на доске
        if (moveNum == n * n + 1) {
            return true;
        }

        // Попробуйте сделать ход из клетки (row, col) в каждое возможное направление
        for (int i = 0; i < 8; i++) {
            int nextRow = row + ROW_MOVES[i];
            int nextCol = col + COL_MOVES[i];

            if (isSafe(board, nextRow, nextCol)) {
                board[nextRow][nextCol] = moveNum;
                if (solve(board, nextRow, nextCol, moveNum + 1)) {
                    return true;
                } else {
                    // откатываем ход
                    board[nextRow][nextCol] = 0;
                }
            }
        }

        return false;
    }

    /**
     * Выводит шахматную доску на экран.
     */
    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}