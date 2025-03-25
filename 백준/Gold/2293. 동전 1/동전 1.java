import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); // 동전 가지 수
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[N];

        for(int i =0;i<N;i++){
            coin[i]= Integer.parseInt(bf.readLine());
        }
        Arrays.sort(coin);

        int[] dp = new int[k+1];
        int cur =coin[0];
        while(true){
            if(cur<=k){
                dp[cur]=1;
                cur+=coin[0];
            }else{
                break;
            }
        }
        for(int i =1;i<N;i++){
            for(int j=coin[i];j<=k;j++){
                if(j==coin[i]){
                    dp[j]++;
                    continue;
                }
                dp[j] +=dp[j-coin[i]];
            }
        }
        System.out.println(dp[k]);

    }
}