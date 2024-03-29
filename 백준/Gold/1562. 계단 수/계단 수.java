import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(bf.readLine());
		int mod =  1000000000;
		long[][][]  dp = new long[n+1][10][1024]; // 자릿수, 끝나는 숫자, 비트마스킹 
		for(int i=0;i<10;i++) {
			dp[1][i][1<<i] =1;
			
		}
		for (int len =2; len<=n;len++) {
			for(int i=0;i<=9;i++) {
				for (int j =0;j<1024 ; j++) {
					int bit  = j | 1<<i;
					// 차이가 하나차이나야되니까 0과 9를 제외하고는 차이가 하나 나는걸 dp 를 더해줍니다. 
					if (i>0) dp[len][i][bit] += dp[len-1][i-1][j];
					if(i<9) dp[len][i][bit] += dp[len-1][i+1][j];
					dp[len][i][bit]%=mod;
				}
			}
		}
		long ans =0;
		for(int i=0;i<9;i++) {
			ans+= dp[n][i][1023];
			ans%=mod;
		}
		System.out.println(ans);
	}
}
