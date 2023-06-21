package Queen;

public class EightQueens {
    private static final int BOARD_SIZE = 8;
    private int[] queens = new int[BOARD_SIZE];

    private int counter = 0; // объявляем счетчик решений

    public void placeQueens() {
        placeQueens(0);
    }

    private void placeQueens(int row) {
        // Функция placeQueens вызывает саму себя рекурсивно
        if (row == BOARD_SIZE) {
            printBoard();
            return;
        }

        for (int col = 0; col < BOARD_SIZE; col++) {
            queens[row] = col;
            if (isValid(row, col)) {
                placeQueens(row + 1);
            }
        }
    }

    private boolean isValid(int row, int col) {
        // Функция isValid проверяет, не находится ли текущий ферзь под ударом какого-либо другого ферзя,
        // уже размещенного на доске. Она проходит по всем предыдущим строкам и проверяет,
        // не находится ли новый ферзь на одной вертикали или диагонали с другими ферзями.
        // Если новый ферзь находится под ударом, функция возвращает false, иначе - true
        for (int i = 0; i < row; i++) {
            int diff = Math.abs(col - queens[i]);
            if (diff == 0 || diff == row - i) {
                return false;
            }
        }
        return true;
    }

    private void printBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                System.out.print((queens[row] == col) ? "F " : "- ");
            }
            System.out.println();
        }
        counter++; // увеличиваем счетчик решений
        System.out.println("Текущее количество решений: " + counter);
        System.out.println();
    }
}
