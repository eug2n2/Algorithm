import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[][] dp = new int[n][3]; // RGB
		int[][] arr = new int[n][3];

		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < 3; i++) {
				if (i == k) {
					dp[0][i] = arr[0][i];
				} else {
					dp[0][i] = 1000000;
				}
			}
			for (int i = 1; i < n; i++) {
				int r = arr[i][0];
				int g = arr[i][1];
				int b = arr[i][2];

				dp[i][2] = Math.min(dp[i - 1][0] + b, dp[i - 1][1] + b);
				dp[i][0] = Math.min(dp[i - 1][1] + r, dp[i - 1][2] + r);
				dp[i][1] = Math.min(dp[i - 1][0] + g, dp[i - 1][2] + g);
			}
			for (int i = 0; i < 3; i++) {
				if (i != k) {
					ans = Math.min(dp[n-1][i], ans);
				}
			}

		}

		System.out.println(ans);

	}
}