import java.util.Arrays;

// 조합
public class practice_combination {

    static char[] src = {'a', 'b', 'c'};

    public static void main(String[] args) {
        makeCombination(2, new char[2], 0, 0);
    }

    private static void makeCombination(int tochoose, char[] choosed, int StartIdx, int depth){
        if(tochoose==0){
            System.out.println(Arrays.toString(choosed));
            return;
        }
        for(int i=StartIdx; i<src.length; i++){
            choosed[depth] = src[i];
            makeCombination(tochoose-1, choosed, i+1, depth+1);
        }
    }
}
