import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int mod = 1000000000;
        int[][] dp = new int[n+1][k+1];
        // 0~n 까지 정수 k+1개를 더해서 n을 만드는 경우의 수
        for(int i=0;i<=n;i++){
            dp[i][1]=1;
        }
        // 0~ n 중 숫자 1 개를 더해서 i를 만드는 경우의 수는 늘 1이니까...
        for(int i =1 ; i<=k;i++){
            dp[0][i]=1; // 0~n 까지 k개의 정수를 사용해 0을 만드는건 늘 1가지
        }
        for (int j =2;j<=k;j++){
            for(int i = 1; i<=n;i++){
                for(int t=0;t<=i;t++){
                    dp[i][j]+= (dp[t][j-1])%mod;
                    dp[i][j]%=mod;
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
