import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        testEmptyBoard();
        testMinMax();
        testMinMaxAB();
    }

    private static void testEmptyBoard() {
        CPUPlayer cpuPlayer = new CPUPlayer(Mark.X);
        Board board = new Board();

        ArrayList<Move> moves = cpuPlayer.getNextMoveMinMax(board);
        int nodes = cpuPlayer.getNumOfExploredNodes();

        ArrayList<Move> movesAB = cpuPlayer.getNextMoveAB(board);
        int nodesAB = cpuPlayer.getNumOfExploredNodes();

        System.out.println("MinMax: " + nodes + " nodes");
        System.out.println("AB:     " + nodesAB + " nodes");
    }

    private static void testMinMax(){
        CPUPlayer cpuPlayer = new CPUPlayer(Mark.O);
        Board board = new Board();

        board.play(new Move(0, 0), Mark.O);
        board.play(new Move(0, 1), Mark.O);
        board.play(new Move(1, 0), Mark.X);
        board.play(new Move(1, 1), Mark.X);
        System.out.println(board);

        ArrayList<Move> coups = cpuPlayer.getNextMoveMinMax(board);
        for (Move m : coups) {
            System.out.println("(" + m.getRow() + "," + m.getCol() + ")");
        }
        System.out.println("Explored nodes " + cpuPlayer.getNumOfExploredNodes());
    }

    private static void testMinMaxAB(){
        CPUPlayer cpuPlayer = new CPUPlayer(Mark.O);
        Board board = new Board();

        board.play(new Move(0, 0), Mark.O);
        board.play(new Move(0, 1), Mark.O);
        board.play(new Move(1, 0), Mark.X);
        board.play(new Move(1, 1), Mark.X);
        System.out.println(board);

        ArrayList<Move> coups = cpuPlayer.getNextMoveAB(board);
        for (Move m : coups) {
            System.out.println("(" + m.getRow() + "," + m.getCol() + ")");
        }
        System.out.println("Explored nodes " + cpuPlayer.getNumOfExploredNodes());
    }
}