package KnightMove;

public class Ktour {
    static int[][] board;
    static int[][] moves;
    static int maxMoves;
    static int solutionCount = 0;

    public static void main(String[] args) {
        // board двумерный массив, представляющий игровую доску
        board = new int[5][5];
        // maxMoves максимальное количество возможных ходов на игровой доске.
        // Определяется как произведение количества строк и столбцов игровой доски.
        maxMoves = board.length * board[0].length;
        // moves массив, содержащий возможные ходы коня
        moves = new int[][]{{-2, 1}, {-2, -1}, {2, 1}, {2, -1}, {-1, 2},
                {-1, -2}, {1, 2}, {1, -2}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (findPath(i, j, 1)) {
                    printSol();
                    solutionCount++;
                    if (solutionCount == 5) {
                        System.out.println("Найдено 5 решений");
                        return;
                    }
                    board = new int[5][5];
                }
            }
        }
        System.out.println("Найдено 0 решений");
    }

    static boolean findPath(int curX, int curY, int moveNum) {
        // findPath: Метод рекурсивно ищет путь для следующего хода коня на игровой доске.
        // Каждая клетка, которую посетил конь, помечается числом хода.
        // Параметры метода: curX и curY - текущие координаты коня, moveNum - номер текущего хода.
        // Если количество сделанных ходов равно максимальному количеству возможных ходов,
        // то возвращается true (решение найдено). Далее перебираются все возможные ходы из текущей клетки,
        // и если какой-то из них приводит к решению задачи (рекурсивный вызов метода),
        // то такой ход считается возможным и возвращается true.
        // Если все возможные ходы не приводят к решению задачи,
        // то текущая клетка помечается как непосещенная (0) и метод возвращает false
        board[curX][curY] = moveNum; // запомнить ход
        if (moveNum >= maxMoves)
            return true;

        for (int i = 0; i < 8; i++) {
            int nextX = curX + moves[i][0];
            int nextY = curY + moves[i][1];
            if (isPossibleMove(nextX, nextY) && findPath(nextX, nextY, moveNum + 1)) {
                return true;
            }
        }
        board[curX][curY] = 0;
        return false;
    }

    static boolean isPossibleMove(int x, int y) {
        // isPossibleMove: Метод проверяет, может ли конь переместиться на следующую клетку (x, y).
        // Если x и y выходят за границы игровой доски или клетка уже была посещена, то метод вернет false.
        // Иначе метод вернет true
        return x >= 0 && x < board.length && y >= 0 && y < board.length && board[x][y] == 0;
    }

    static void printSol() {
        // Метод выводит найденное решение в консоль
        System.out.println("Решение " + (solutionCount + 1) + ":");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }
}