import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine()); // 슛자 개수
		long[] dp = new long[n+1];
		if(n>=2) {
		dp[2]=1;
		}
		for (int i=3;i<=n;i++) {
			dp[i] = (i-1)*(dp[i-1]+dp[i-2])%1000000000;
		}
		System.out.println(dp[n]);
	}
}