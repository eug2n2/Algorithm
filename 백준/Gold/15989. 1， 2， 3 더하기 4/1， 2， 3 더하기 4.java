import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		long[][] dp = new long[10001][3];
		// dp[i][0] : 1로만 만드는 법
		// dp[i][1] : 2를 포함하는 방법
		// dp[i][2] : 3을 포함하는 방법

		// 초기값 설정
		for (int i = 1; i <= 10000; i++) {
			dp[i][0] = 1; // 1이하의 수를 사용해 만드는 법
		}
		dp[2][1] = 1; // 2
		dp[3][1] = 1; // 2+1
		dp[3][2] = 1; // 3

		// 오름차순으로 값을 채워서, 중복 제거 (맨 끝에 큰 값 넣기)
		for (int i = 4; i <= 10000; i++) {
			dp[i][1] = dp[i - 2][0] + dp[i - 2][1]; // +2
			dp[i][2] = dp[i - 3][0] + dp[i - 3][1] + dp[i - 3][2]; // +3
		}

		int tc = Integer.parseInt(bf.readLine());

		for (int t = 0; t < tc; t++) {
			int n = Integer.parseInt(bf.readLine());
			System.out.println(dp[n][0] + dp[n][1] + dp[n][2]);
		}

	}
}
