import java.util.Arrays;

// 중복 조합
public class practice_combination2 {

    static char[] src = {'a', 'b', 'c'};

    public static void main(String[] args) {
        makeCombination(2, new char[2], 0, 0);
    }

    private static void makeCombination(int toChoose, char[] choosed, int startIdx, int depth){
        if(toChoose==0){
            System.out.println(Arrays.toString(choosed));
            return;
        }
        for(int i=startIdx; i<src.length; i++){
            choosed[depth] = src[i];
            makeCombination(toChoose-1, choosed, i, depth+1);
        }
    }
}
