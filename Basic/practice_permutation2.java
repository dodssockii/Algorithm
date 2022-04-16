import java.util.Arrays;

// 중복허용 순열
public class practice_permutation2 {

    static char[] src = {'a', 'b', 'c'};

    public static void main(String[] args) {

        makePermutation(2, new char[2], 0);
    }

    private static void makePermutation(int toChoose, char[] choosed, int depth){
        if(toChoose == 0 ){
            System.out.println(Arrays.toString(choosed));
            return;
        }
        for(int i=0 ;i<src.length; i++){
                choosed[depth] = src[i];
                makePermutation(toChoose-1, choosed, depth+1);
        }
    }
}
