import java.lang.reflect.Array;
import java.util.ArrayList;

// IMPORTANT: Il ne faut pas changer la signature des méthodes
// de cette classe, ni le nom de la classe.
// Vous pouvez par contre ajouter d'autres méthodes (ça devrait 
// être le cas)
class CPUPlayer
{
    final private Mark PLAYER_MAX;
    final private Mark PLAYER_MIN;

    // Contient le nombre de noeuds visités (le nombre
    // d'appel à la fonction MinMax ou Alpha Beta)
    // Normalement, la variable devrait être incrémentée
    // au début de votre MinMax ou Alpha Beta.
    private int numExploredNodes;

    // Le constructeur reçoit en paramètre le
    // joueur MAX (X ou O)
    public CPUPlayer(Mark cpu){
        PLAYER_MAX = cpu;
        PLAYER_MIN = Utils.getOpposingPlayer(PLAYER_MAX);
    }

    // Ne pas changer cette méthode
    public int  getNumOfExploredNodes(){
        return numExploredNodes;
    }

    // Retourne la liste des coups possibles.  Cette liste contient
    // plusieurs coups possibles si et seuleument si plusieurs coups
    // ont le même score.
    public ArrayList<Move> getNextMoveMinMax(Board board)
    {
        numExploredNodes = 0;

        int bestScore = -1000;
        ArrayList<Move> bestMoves = new ArrayList<>();
        ArrayList<Move> moves = board.getPossibleMoves();

        for(Move move : moves){
            board.play(move, PLAYER_MAX);
            int score = minMax(board, PLAYER_MIN);
            board.undo(move);

            if(bestScore < score){
                bestScore = score;
                bestMoves.clear();
                bestMoves.add(move);
            }
            else if (bestScore == score){
                bestMoves.add(move);
            }
        }

        return bestMoves;
    }

    // Retourne la liste des coups possibles.  Cette liste contient
    // plusieurs coups possibles si et seuleument si plusieurs coups
    // ont le même score.
    public ArrayList<Move> getNextMoveAB(Board board){
        numExploredNodes = 0;
        return null;
    }

    private int minMax(Board board, Mark currentPlayer) {
        numExploredNodes++;
        int score = board.evaluate(PLAYER_MAX);

        // base cases

        // maximizing player won
        if (score == 100) {
            return score;
        }

        // minimizing player won
        if (score == -100) {
            return score;
        }

        // draw
        if(!isMovesLeft(board)){
            return 0;
        }

        // maximizing player turn
        int best;
        ArrayList<Move> moves = board.getPossibleMoves();
        if (currentPlayer == PLAYER_MAX) {
            best = -1000;
            for(Move move : moves){
                board.play(move, currentPlayer);
                best = Math.max(best, minMax(board, Utils.getOpposingPlayer(currentPlayer)));
                board.undo(move);
            }
        }

        // minimizing player turn
        else {
            best = 1000;
            for(Move move : moves){
                board.play(move, currentPlayer);
                best = Math.min(best, minMax(board, Utils.getOpposingPlayer(currentPlayer)));
                board.undo(move);
            }
        }
        return best;
    }

    private boolean isMovesLeft(Board board){
        ArrayList<Move> moves = board.getPossibleMoves();
        return !moves.isEmpty();
    }
}
