import java.io.*;
import java.util.StringTokenizer;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		long mod = 1000000009;
		long[][] dp = new long[1001][1001]; // 사용한 숫자의 개수
		dp[1][1] = 1; // 1
		dp[2][1] = 1; // 2
		dp[2][2] = 1; // 1+1
		dp[3][1] = 1; // 3
		dp[3][2] = 2; // 1+2 ,2+1
		dp[3][3] = 1; // 1+1+1

		for (int i = 4; i <= 1000; i++) {
			dp[i][i] = 1; // 1+1+...+1
			for (int j = i - 1; j >= 2; j--) {
				// 마지막에 1을 넣는 경우
				dp[i][j] += dp[i - 1][j - 1];

				// 마지막에 2를 넣는 경우
				dp[i][j] = (dp[i][j] + dp[i - 2][j - 1]) % mod;

				// 마지막에 3을 넣는 경우
				dp[i][j] = (dp[i][j] + dp[i - 3][j - 1]) % mod;

			}
		}

		int tc = Integer.parseInt(bf.readLine());

		for (int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			long result = 0;
			for (int i = 1; i <= m; i++) {
				result = (result + dp[n][i]) % mod;
			}
			System.out.println(result);
		}

	}
}
