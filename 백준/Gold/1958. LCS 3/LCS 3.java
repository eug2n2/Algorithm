import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String a = bf.readLine();
		String b = bf.readLine();
		String c = bf.readLine();
		int asize = a.length();
		int bsize = b.length();
		int csize = c.length();
		int[][][] dp = new int[asize + 1][bsize + 1][csize + 1];

		for (int i = 1; i < asize + 1; i++) {
			for (int j = 1; j < bsize + 1; j++) {
				for (int k = 1; k < csize + 1; k++) {
					if (a.charAt(i - 1) == b.charAt(j - 1) && b.charAt(j - 1) == c.charAt(k - 1)) {
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
					} else {
						dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
					}

				}
			}
		}
		System.out.println(dp[asize][bsize][csize]);
	}
}
