
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		int[][] dp = new int[n][3]; //RGB
		 for (int[] row : dp) {
	            Arrays.fill(row, Integer.MAX_VALUE);
	        }
		int[] color = {0,1,2}; //이전의 색깔 R: 0 G:1 B:2
        StringTokenizer st = new StringTokenizer(bf.readLine());
        dp[0][0]= Integer.parseInt(st.nextToken());
        dp[0][1]= Integer.parseInt(st.nextToken());
        dp[0][2]= Integer.parseInt(st.nextToken());
        
        for (int i =1 ; i<n;i++) {
        st = new StringTokenizer(bf.readLine());
        int r = Integer.parseInt(st.nextToken());
        int g= Integer.parseInt(st.nextToken());
        int b=  Integer.parseInt(st.nextToken());
        
        for (int j=0;j<3;j++) {
        	if(color[j]==0) { //이전에 r을 사용 ->g,b만 사용할 수 있겠죠?
        		dp[i][1]=Math.min(dp[i][1],dp[i-1][j]+ g);
        		dp[i][2]=Math.min(dp[i][2],dp[i-1][j]+ b);
        		
        	}else if(color[j]==1) { //이전에 g을 사용 ->r,b만 사용할 수 있겠죠?
        		dp[i][0]=Math.min(dp[i][0],dp[i-1][j]+ r);
        		dp[i][2]=Math.min(dp[i][2],dp[i-1][j]+ b);
        		
        	} else if(color[j]==2) { //이전에 g을 사용 ->r,b만 사용할 수 있겠죠?
        		dp[i][0]=Math.min(dp[i][0],dp[i-1][j]+ r);
        		dp[i][1]=Math.min(dp[i][1],dp[i-1][j]+ g);
        		
        	}
        	}
		}
		
        int  answer = Math.min(dp[n-1][0], Math.min(dp[n-1][1],dp[n-1][2]));
		System.out.println(answer);
		
	}
}