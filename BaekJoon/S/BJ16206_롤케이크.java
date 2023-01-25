import java.util.Arrays;
import java.util.Scanner;

public class BJ16206_롤케이크 {
    static Scanner scanner = new Scanner(System.in);
    static int N = scanner.nextInt();
    static int M = scanner.nextInt();
    static int cnt = 0;

    public static void main(String[] args) {

        int map[] = new int[N];
        int mapTen[] = new int[N];
        int index=0;
        for(int i = 0; i< N; i++) {
            map[i]=scanner.nextInt();
        }

        Arrays.sort(map);

        for(int i = 0; i< N; i++) {
            if(map[i]==10) cnt++;

            if(map[i]>10) {
                if(map[i]%10==0) cut(map[i]); //롤케잌 길이가 10으로 나눠떨어지는것들에 대해 먼저 자르기 시작
                else mapTen[index++] = map[i]; // 10으로 나눠떨어지지 않는 것들은 배열에 저장해두었다가 커팅횟수가 남으면 그때 자르기
            }
        }

        if(M >0) { //10으로 나눠떨어지는 롤케잌들을 다 자르고도 커팅횟수가 남았으면
            for(int j=0; j<index; j++) cut(mapTen[j]); //나머지에 대해서도 커팅을 진행해준다.
        }

        System.out.println(cnt);

    }
    public static void cut(int len){
        if(M <=0)
            return; // 최대커팅횟수를 넘지 않게 자를 수 있다.
        else {
            cnt++;
            M--;
            int length = len-10; // 한번 자르고 남은 롤케잌의 길이
            if(length>10) {
                cut(length); // 남은 롤케잌의 길이가 10보다 길다면 재귀함수를 이용해서 다시 cut 함수를 실행해준다.
            }
            else {
                if(length ==10) cnt++; //마지막 남은 조각의 길이가 10이라면 길이가10인 롤케잌 개수 +1을 해줌.
                return;
            }

        }


    }

}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class BJ16206_롤케이크 {
//
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringTokenizer st;
//    static StringBuilder sb = new StringBuilder();
//
//    static int N, M;
//    static int[] map;
//    static int[] mapTen;
//
//    public static void main(String[] args) throws IOException {
//        st = new StringTokenizer(br.readLine().trim(), " ");
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        map = new int[N];
//        mapTen = new int[N];
//        st = new StringTokenizer(br.readLine().trim(), " ");
//        for(int i=0; i<N; i++){
//            int num = Integer.parseInt(st.nextToken());
//            if(num%10==0){
//                mapTen[i] = num;
//            }else{
//                map[i] = num;
//            }
//        }
//        Arrays.sort(map);
////        System.out.println(Arrays.toString(map));
////        System.out.println(Arrays.toString(mapTen));
//
//        int cnt = 0;
//        // 나머지가 0인 값들 즉 10, 20, 30~~
//        for(int i=0; i<N; i++){
//            if (mapTen[i] == 10) {
//                cnt++;
//            } else if (mapTen[i]>0) {
//                if((mapTen[i] / 10) - 1 <= M) {
//                    cnt += mapTen[i] / 10;
//                    int mm = mapTen[i] / 10 - 1;
//                    M -= mm;
//                }else{
//                    cnt += M;
//                    break;
//                }
//            }else{
//                continue;
//            }
//        }
//
//        for(int i=0; i<N; i++){
//            if(map[i]<10){
//                continue;
//            }else if(10< map[i] && map[i] <= 19){
//                if(map[i]/10 <= M){
//                    cnt ++;
//                    M--;
//                }else{
//                    break;
//                }
//            }else if(map[i]>=20) {
//                int div = (map[i] / 10);
//                if (div <= M) {
//                    cnt += map[i]/10;
//                    M -= div;
//                } else {
//                    cnt += M;
//                    break;
//                }
//            }
//        }
//        System.out.println(cnt);
//    }
//}
