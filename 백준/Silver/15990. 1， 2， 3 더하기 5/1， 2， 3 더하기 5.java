import java.io.*;
public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		long mod = 1000000009;
		long[][] dp = new long[100001][3]; // 마지막에 넣은수 기준으로 구분
		dp[1][0] = 1; // 1
		dp[2][1] = 1; // 2
		dp[3][0] = 1; // 2+1
		dp[3][1] = 1; // 1+2
		dp[3][2] = 1; // 3
		// 오름차순으로 값을 채워서, 중복 제거 (맨 끝에 큰 값 넣기)
		for (int i = 4; i <= 100000; i++) {
			dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % mod;
			dp[i][1] = (dp[i - 2][0] + dp[i - 2][2]) % mod; // +2
			dp[i][2] = (dp[i - 3][0] + dp[i - 3][1]) % mod; // +3
		}

		int tc = Integer.parseInt(bf.readLine());

		for (int t = 0; t < tc; t++) {
			int n = Integer.parseInt(bf.readLine());
			System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % mod);
		}

	}
}
