import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String args[]) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// 입력 받은 숫자
		int n = Integer.parseInt(bf.readLine()); // 크기
		int[] stairs = new int[n + 1];
		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			stairs[i] = Integer.parseInt(bf.readLine());
		}
		dp[1] = stairs[1];
		if (n >= 2) {
			dp[2] = dp[1] + stairs[2];
		}

		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 3] + stairs[i - 1] + stairs[i], dp[i - 2] + stairs[i]);

		}
		System.out.println(dp[n]);
	}

}