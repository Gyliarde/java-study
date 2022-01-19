package gyliarde.collections.tictactoe;

public class App {

    public static void main(String[] args) {
        AppTicTacToe ticTacToe = new AppTicTacToe();

        ticTacToe.play(new int[] { 1, 1, 'X' });
        ticTacToe.play(new int[] { 2, 2, 'O' });
        ticTacToe.play(new int[] { 2, 0, 'X' });
        ticTacToe.play(new int[] { 0, 2, 'O' });
        ticTacToe.play(new int[] { 1, 2, 'X' });
        ticTacToe.play(new int[] { 1, 0, 'O' });

        ticTacToe.result();
    }
}
