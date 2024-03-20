import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
import java.util.Stack;
class Main {
    public static void main(String args[]) throws IOException {
    	
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
     // 입력 받은 숫자
        int n = Integer.parseInt(bf.readLine()); //크기 
        int[]wine= new int[n+1];
        int[]dp= new int[n+1];
       
        for (int i=1;i<=n;i++) {
        	wine[i] = Integer.parseInt(bf.readLine());
        }
        dp[1]= wine[1];
        if(n>=2) {
        	dp[2]=wine[1]+wine[2];
        }
        for(int i=3;i<=n;i++) {
        	dp[i]= Math.max(dp[i-1],Math.max(dp[i-2]+wine[i], dp[i-3]+wine[i-1]+wine[i]));
        }
        
    
    System.out.println(dp[n]);
    }
}