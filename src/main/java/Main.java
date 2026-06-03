//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board);

        Move move = new Move(0,0);
        board.play(move, Mark.X);
        board.play(new Move(1,0), Mark.O);
        board.play(new Move(0,1), Mark.X);
        board.play(new Move(1,2), Mark.O);
        board.play(new Move(0,2), Mark.X);
        System.out.println(board);

        System.out.println(board.evaluate(Mark.X));

    }
}