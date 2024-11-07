import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        char[] board = {' ',' ',' ',' ',' ',' ',' ',' ',' '};


        for (int i = 0; i < 9; i++) {


            board = playerTurn('X', board);
            board = playerTurn('0', board);
        }
        System.out.println("Tie game!");

    }



    static char[] playerTurn(char player, char[] board) {
        Scanner scanner = new Scanner(System.in);
        printBoard(board);
        while (true) {
            try {
                System.out.println("Player " + player + "'s move: ");
                Integer move = Integer.parseInt(scanner.nextLine());
                if(move >0 && move <= 9){
                    if (board[move-1] == ' '){
                        board[move-1] = player;
                        checkIfWinningMove(board, move);
                        break;
                    }else{
                        System.out.println("Occupied space!");
                    }
                }
            } catch (NumberFormatException _) {}
        }
        return board;
    }



    static void printBoard(char[] board) {
        for (int i = 1; i <= board.length; i++) {
            if (i % 3 == 0){
                System.out.println(board[i-1]);
                if (i != 9){
                    System.out.println("-----");
                }
            }else {
                System.out.print(board[i-1]+ "|");
            }
        }
    }
    static void checkIfWinningMove(char[] board, int move) {
        //Check Diagonal
        if((move % 2) != 0){
            if(board[0] == board[4] && board[4] == board[8] && board[8] != ' '){
                win(board, board[8]);
            }
            if(board[2] == board[4] && board[4] == board[6] && board[6] != ' '){
                win(board, board[6]);
            }
        }
        for (int i = 0; i < 3; i++) {
            //Check Vertical
            if(board[i] == board[i+3]&& board[i] == board[i+6] && board[i] != ' '){
                win(board, board[i]);
            }
            //Check Horizontal
            if(board[i] == board[i+1]&& board[i] == board[i+2] && board[i] != ' '){
                win(board, board[i]);
            }
        }
    }
    static void win(char[]board, char winner){
        printBoard(board);
        System.out.println("Player "+winner+" wins!");
        exit(0);
    }
}
//EXPANDABLE BOARD