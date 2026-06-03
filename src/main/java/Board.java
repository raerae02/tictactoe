import java.lang.reflect.Array;
import java.util.ArrayList;

// IMPORTANT: Il ne faut pas changer la signature des méthodes
// de cette classe, ni le nom de la classe.
// Vous pouvez par contre ajouter d'autres méthodes (ça devrait
// être le cas)
class Board {
    private Mark[][] board;

    // Ne pas changer la signature de cette méthode
    public Board() {
        board = new Mark[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Mark.EMPTY;
            }
        }
    }

    // Place la pièce 'mark' sur le plateau, à la
    // position spécifiée dans Move
    //
    // Ne pas changer la signature de cette méthode
    public void play(Move m, Mark mark) {
        board[m.getRow()][m.getCol()] = mark;
    }

    public void undo(Move m){
        board[m.getRow()][m.getCol()] = Mark.EMPTY;
    }


    // retourne  100 pour une victoire
    //          -100 pour une défaite
    //           0   pour un match nul
    // Ne pas changer la signature de cette méthode
    public int evaluate(Mark mark) {
        if(aGagne(mark)) return 100;
        if(aGagne(Utils.getOpposingPlayer(mark))) return -100;
        return 0;
    }

    public ArrayList<Move> getPossibleMoves(){
        ArrayList<Move> moves = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j].equals(Mark.EMPTY)){
                    moves.add(new Move(i,j));
                }
            }
        }
        return moves;
    }

    private boolean aGagne(Mark mark){
        //verify rows
        for (int i = 0; i < 3; i++) {
            if(board[i][0] == mark && board[i][1] == mark && board[i][2] == mark){
                return true;
            }
        }
        //verify columns
        for (int i = 0; i < 3; i++) {
            if(board[0][i] == mark && board[1][i] == mark && board[2][i] == mark) {
                return true;
            }
        }
        //verify diagonals
        if(board[0][0] == mark && board[1][1] == mark && board[2][2] == mark){
            return true;
        }
        if(board[0][2] == mark && board[1][1] == mark && board[2][0] == mark){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
                if (j < board[i].length - 1) {
                    sb.append("|");
                }
            }
            sb.append("\n");
            if (i < board.length - 1) {
                sb.append("-----\n");
            }
        }
        return sb.toString();
    }
}
