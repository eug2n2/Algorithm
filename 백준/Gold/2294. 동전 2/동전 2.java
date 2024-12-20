import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()); // 동전 종류
        int k = Integer.parseInt(st.nextToken()); // 가치의 합이 되어야하는 기준
        int[] dp = new int[k+1];

        for (int i =0;i<n;i++){
            int tmp = Integer.parseInt(bf.readLine());
            if(tmp>k) continue;
            if(tmp==k){
                System.out.println(1);
                return;
            }
            dp[tmp]=1;
        }

        for(int i =2;i<=k;i++){
            for(int j =1 ;j<=i/2;j++){
                if(dp[j]==0 || dp[i-j]==0) continue;
                if(dp[i]==0){
                    dp[i]=dp[i-j]+dp[j];
                }
                dp[i] = Math.min(dp[i],dp[i-j]+dp[j]);
            }
        }
        if(dp[k]==0){
            System.out.println(-1);
            return;
        }
        System.out.println(dp[k]);


    }

}