import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CPUPlayer cpuPlayer = new CPUPlayer(Mark.O);
        Board board = new Board();
        System.out.println(board);

        board.play(new Move(0, 0), Mark.O);
        board.play(new Move(0, 1), Mark.O);
        board.play(new Move(1, 0), Mark.X);
        board.play(new Move(1, 1), Mark.X);
        System.out.println(board);

        ArrayList<Move> coups = cpuPlayer.getNextMoveMinMax(board);
        for (Move m : coups) {
            System.out.println("(" + m.getRow() + "," + m.getCol() + ")");
        }
    }
}