import java.util.HashMap;
import java.util.Scanner;

public class TicTac {
    public static class Points {
        private int row;
        private int col;

        public Points(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private char[][] board = new char[3][3];
    private HashMap<Integer, Points> map = new HashMap<>();
    private char player = 'X';

    public TicTac() {
        loadMap();
        initializeBoard();
    }

    public void loadMap() {
        Integer count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map.put(count, new Points(i, j));
                count += 1;
            }
        }
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void drawBoard() {
        System.out.println("...........");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "| ");
            }
            System.out.println("\n...........");

        }
    }

    public boolean checkBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void togglePlayer() {
        player = (player == 'O') ? 'X' : 'O';
    }

    public boolean checkWin() {
        //check  horizontal
        if (board[0][0] == player && board[0][1] == player && board[0][2] == player) {
            return true;
        }
        if (board[1][0] == player && board[1][1] == player && board[1][2] == player) {
            return true;
        }
        if (board[2][0] == player && board[2][1] == player && board[2][2] == player) {
            return true;
        }
        //check vertical
        if (board[0][0] == player && board[1][0] == player && board[2][0] == player) {
            return true;
        }
        if (board[0][1] == player && board[1][1] == player && board[2][1] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][2] == player && board[2][2] == player) {
            return true;
        }
        //check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    public void chooseSpot() {
        System.out.println(String.format("player " + player + " please select your spot between 1 - 9"));
        Scanner scanner = new Scanner(System.in);
        int point;
        point = scanner.nextInt();
        do {
            Points p = map.get(point);
            board[p.row][p.col] = player;
        }
        while (!checkValidSpot(point));
    }

    private boolean checkValidSpot(int number) {
        if (map.containsKey(Integer.valueOf(number))) {
            Points p = map.getOrDefault(number, null);
            if (p == null || board[p.row][p.col] != ' ') {
                System.out.println("invalid move");
                return false;
            } else {
                return true;
            }
        }
        System.out.println("invalid move");
        return false;
    }

    public char getPlayer() {
        return player;
    }
}
