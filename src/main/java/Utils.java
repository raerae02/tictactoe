public class Utils {
    public static Mark getOpposingPlayer(Mark mark){
        if(mark == Mark.X) {
            return Mark.O;
        }
        return Mark.X;
    }
}
