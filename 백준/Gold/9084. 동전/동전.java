import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for(int tc =0;tc<T;tc++){
            int N = Integer.parseInt(bf.readLine()); // 동전 가지 수
            int[] coin = new int[N];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            // 오름차순으로 주어짐
            for(int i =0;i<N;i++){
                coin[i]= Integer.parseInt(st.nextToken());
            }

            // 만들어야하는 금액
            int M = Integer.parseInt(bf.readLine());

            int[] dp = new int[M+1];
            int cur =coin[0];
            while(true){
                if(cur<=M){
                    dp[cur]=1;
                    cur+=coin[0];
                }else{
                    break;
                }
            }
            for(int i =1;i<N;i++){
                for(int j=coin[i];j<=M;j++){
                    if(j==coin[i]){
                        dp[j]++;
                        continue;
                    }
                    dp[j] +=dp[j-coin[i]];
                }
            }
            System.out.println(dp[M]);
        }
    }
}