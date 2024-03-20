import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[][][] dp = new int[n][n][3];// 0 - 1 \ 2 |
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // map 입력받기
			}
		}
		dp[0][0][0] = 1;
		dp[0][1][0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if (i == 0 && j == 1 || i == 1 && j == 1) {
					continue;
				}
				if (map[i][j] != 1) {
//					System.out.println(i+" "+j);
					if (map[i][j-1] == 0) {
						dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][1];
					}
					if (i >= 1 && map[i - 1][j - 1] == 0&&map[i][j-1] == 0&&map[i-1][j] == 0) {
						dp[i][j][1] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
					}
					if (i >= 1 && map[i - 1][j] == 0)
						dp[i][j][2] = dp[i - 1][j][2] + dp[i - 1][j][1];
				}
			}
		}

		System.out.println(dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2]);
	

	}
}
