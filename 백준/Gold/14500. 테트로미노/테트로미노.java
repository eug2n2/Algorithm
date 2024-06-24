import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] arr;
	static int[][] block = { { 0, 0, 0, 1, 0, 2, 0, 3 }, { 0, 0, 1, 0, 2, 0, 3, 0 }, { 0, 0, 1, 0, 0, 1, 1, 1 },
			{ 0, 0, 1, 0, 2, 0, 2, 1 }, { 0, 0, 1, 0, 0, 1, 0, 2 }, { 0, 0, 0, 1, 1, 1, 2, 1 },
			{ 0, 0, 1, 0, 1, -1, 1, -2 }, { 0, 0, 1, 0, 1, 1, 2, 1 }, { 0, 0, 0, 1, 1, 0, 1, -1 },
			{ 0, 0, 0, 1, 0, 2, 1, 1 }, { 0, 0, 1, 0, 1, -1, 1, 1 }, { 0, 0, 1, 0, 2, 0, 1, 1 },
			{ 0, 0, 1, 0, 2, 0, 1, -1 }, { 0, 0, 1, 0, 2, 0, 0, 1 }, { 0, 0, 1, 0, 2, 0, 2, -1 },
			{ 0, 0, 0, 1, 0, 2, 1, 2 }, { 0, 0, 1, 0, 1, 1, 1, 2 }, { 0, 0, 1, 0, 1, -1, 2, -1 },
			{ 0, 0, 0, 1, 1, 1, 1, 2 } };
	static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);
		System.out.println(ans);
	}

	static void dfs(int x, int y) {

		if (x == n) {
			return;
		}
		if (y == m) {
			dfs(x + 1, 0);
			return;
		}

		// 아무 블록 사용안하는게 이득 일수도 있으니..
		dfs(x, y + 1);

		for (int i = 0; i < 19; i++) {
			int tmp = 0;
			for (int j = 0; j <= 6; j += 2) {
				if ((x + block[i][j]) >= 0 && (x + block[i][j]) < n && (y + block[i][j + 1]) >= 0
						&& (y + block[i][j + 1]) < m) {
					tmp += arr[x + block[i][j]][y + block[i][j + 1]];
				}
			}
			ans = Math.max(ans, tmp);
		}
	}

}