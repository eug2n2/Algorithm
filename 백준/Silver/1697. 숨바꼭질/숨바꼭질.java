import java.util.*;
import java.lang.*;
import java.io.*;
import java.awt.Point;
class Main {
	 public static void main(String[] args) throws IOException {
		  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		  StringTokenizer st = new StringTokenizer(bf.readLine());
		  int n = Integer.parseInt(st.nextToken());
		  int m = Integer.parseInt(st.nextToken());
		  int[] dp = new int [100002];
		  Arrays.fill(dp, 100003);
		
		  int answer=0;
          for (int i=n; i>=0; i--){
              dp[i]= n-i;
              
          }
		  for (int i=n+1; i<=100000;i++) {
			 if(i%2==1) { //홀수
				 dp[i]=Math.min(i-n,Math.min(dp[i-1]+1,Math.min(dp[i+1]+1,dp[(i+1)/2]+2)));
				  }
            //dp [(i+1)]은 아직 계산을 하지않았으므로, dp[(i+1)/2]+2 을 통해 계산
			 else{ //짝수 
				dp[i]=Math.min(i-n,Math.min(dp[i-1]+1,Math.min(dp[i/2]+1,dp[i+1]+1)));
				  }
             }
		  System.out.println(dp[m]);
				  
		  }
		 }