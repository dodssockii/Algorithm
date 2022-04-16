import java.util.Arrays;

// 순열
public class practice_permutation {

    static char[] src = {'a', 'b', 'c'};

    public static void main(String[] args) {

        makePermutation(2, new char[2], new boolean[src.length], 0);
    }

    private static void makePermutation(int toChoose, char[] choosed, boolean[] visited, int depth){
        if(toChoose == 0 ){
            System.out.println(Arrays.toString(choosed));
            return;
        }
        for(int i=0 ;i<src.length; i++){
            if(!visited[i]){
                visited[i] = true;
                choosed[depth] = src[i];
                makePermutation(toChoose-1, choosed, visited, depth+1);
                visited[i] = false;
            }
        }
    }
}
