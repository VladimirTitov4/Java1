import java.util.*;

class TicTacToe {

    final int SIZE = 5;
    final char DOT_X = 'x';
    final char DOT_O = 'o';
    final char DOT_EMPTY = '.';
    char[][] map = new char[SIZE][SIZE];
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public static void main(String[] args) {
        new TicTacToe();
    }

    TicTacToe() {
        initMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("YOU WON!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("AI WON!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            System.out.println(isCellValid2());
        }
        System.out.println("GAME OVER.");
    }

    void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    void humanTurn() {
        int x, y;
        do {
            System.out.print("Enter X and Y [1..5]: ");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));

        map[y][x] = DOT_X;
    }



    void aiTurn() {
        int[] array = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            int rightDotHorizontal = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_X) rightDotHorizontal++;
                array[i] = rightDotHorizontal;
            }
        }
        int xMax = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > xMax) {
                xMax = array[i];
                index = i;
            }
        }

        int x, y;

        do {
            x = rand.nextInt(SIZE);
            y = index;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O;

    }

    boolean checkWin(char dot) {
        for (int i = 0; i < SIZE; i++) {
            int rightDotHorizontal = 0;
            int rightDotVertical = 0;
            int rightDotDiagonalLeft = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == dot) rightDotHorizontal++;
                if (map[j][i] == dot) rightDotVertical++;
                if (map[j][j] == dot) rightDotDiagonalLeft++;
            }
            if (rightDotDiagonalLeft == SIZE-1 || rightDotHorizontal == SIZE-1 || rightDotVertical == SIZE-1) return true;
        }
        int rightDotDiagonalRight = 0;
        for (int i = 0, j = SIZE-1; i < SIZE || j >= 0; i++, j--) {
            if (map[i][j] == dot) rightDotDiagonalRight++;
        }
        return rightDotDiagonalRight == SIZE - 1;
    }

    boolean isCellValid (int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) return false;
        return map[y][x] == DOT_EMPTY;
    }

    boolean isCellValid2() {
        for (int i = 0; i < SIZE; i++) {
            int dotCount = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_X || map[i][j] == DOT_O) dotCount++;
            }
            System.out.println(dotCount);
            if (dotCount < 5) return true;
        }
        return false;
    }
}