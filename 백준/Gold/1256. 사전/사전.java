import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n =Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int [][] dp = new int[n+m+1][m+1]; // 전체 글자수, z사용 개수

        for(int i = 1; i <= (n+m); i++){
            dp[i][1] = i; // ex) 3C1 = 3
            dp[i][0] = 1; // ex) 3C0 = 1
            if (i<=m) {
                dp[i][i] = 1; // ex) 3C3 = 1
            }
        }
        for(int i = 2 ; i <= (n+m); i++){
            for(int j = 2; j<=Math.min(m,i); j++){
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1]; //dp[i-1][j]에다가 a 붙이기 + dp[i-1][j-1]에다가 z붙이기
                if(dp[i][j] > 1000000000) {
                    dp[i][j] = 1000000001; // 오버 플로우를 방지하기 위해 k 값의 최대로 제한함.
                }
            }
        }
        if(dp[m+n][m] < k){
            // k 번째 문자열이 존재하지 않는 경우이다. 그러한 경우에는 -1 을 출력
            System.out.println("-1");
            return; // 메인 메서드 종료
        }
        // 문자열 만들기
        while(!(n==0||m==0)){ // 'a' 와 'z' 를 다 사용할 때 까지 반복\
//            System.out.println(n+" "+m);
            if(n>0&& dp[m+n-1][m] >= k){ // 마지막글자를 a 선택했다고 가정
                sb.append("a");
                n--; // a하나 사용
            } else if (m>0) {
                sb.append("z");
                k = k - dp[m+n-1][m]; // z 를 선택한 것으로 경우의 수를 업데이트 함
                m--; // z 사용
            }
        }
        while (!(n==0 && m==0)){
            if (n>0){
                sb.append("a");
                n--; // a하나 사용
            }else{
                sb.append("z");
                m--;
            }
        }
        System.out.println(sb);
    }

}