package gyliarde.collections.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class AppTicTacToe {

    private char[][] board = new char[3][3];
    private List<int[]> plays = new ArrayList<int[]>();

    AppTicTacToe() {
        this.cleanBoard();
    }

    public void play(int[] play ) {
        plays.add(play);
    }

    private void cleanBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private void executePLays(){
        for (int[] play : plays) {
            int linha = play[0];
            int coluna = play[1];
            char simbolo = (char) play[2];
            board[linha][coluna] = simbolo;
        }
    }

    public void result() {
        executePLays();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
