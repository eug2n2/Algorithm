import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int ans;
	static int[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		visited = new int[n][n];
		ans = 0;
		nqueen(0);
		System.out.println(ans);
	}

	private static void nqueen(int cnt) {
		if (cnt == n) {
			ans++;
			return;
		}
		for (int j = 0; j < n; j++) {
			if (visited[cnt][j] <= 0) {
				for (int x = j; x < n; x++) {
					visited[cnt][x]++;
				}
				for (int x = cnt; x < n; x++) {
					visited[x][j]++;
				}

				for (int x = 1; cnt + x < n && j + x < n; x++) {
					visited[cnt + x][j + x]++;
				}

				for (int x = 1; cnt + x < n && j - x >= 0; x++) {
					visited[cnt + x][j - x]++;
				}
				nqueen(cnt + 1);
				for (int x = j; x < n; x++) {
					visited[cnt][x]--;
				}
				for (int x = cnt; x < n; x++) {
					visited[x][j]--;
				}

				for (int x = 1; cnt + x < n && j + x < n; x++) {
					visited[cnt + x][j + x]--;
				}

				for (int x = 1; cnt + x < n && j - x >= 0; x++) {
					visited[cnt + x][j - x]--;
				}

			}
		}
	}

}
