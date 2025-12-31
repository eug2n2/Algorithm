import java.io.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		long[] dp = new long[1000001]; // dp[i] : i를 1, 2, 3의 합으로 나타내는 방법의 수
		dp[1] = 1; // 1
		dp[2] = 2; // 1+1, 2
		dp[3] = 4; // 1+1+1, 1+2, 2+1, 3

		for (int i = 4; i <= 1000000; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
			dp[i] %= 1000000009;
		}

		int tc = Integer.parseInt(bf.readLine());

		for (int t = 0; t < tc; t++) {
			int n = Integer.parseInt(bf.readLine());
			System.out.println(dp[n]);
		}

	}
}
