import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int h;
	static int ans = 4;
	static int total = 0; // 사람수 총합 ( 5구역에서 쓰려고 )
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken()); // 세로선 개수
		m = Integer.parseInt(st.nextToken()); // 가로선 개수
		h = Integer.parseInt(st.nextToken()); // 세로선 마다 가로선을 놓을 수 있는 위치의 개수
		visited = new boolean[h][n];
		for (int j = 0; j < m; j++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			visited[a][b] = true;
		}
		dfs(0, 0);
		if (ans == 4) {
			ans = -1;
		}
		System.out.println(ans);
	}

	public static void dfs(int cnt, int xstart) { //
		if (cnt == Math.min(h * (n - 1) - m+1, 4)) {
			return;
		}
		if (play()) {
			ans = Math.min(ans, cnt);
			return;
		}
		for (int i = xstart; i < h; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (!visited[i][j]) {
					if (j == 0 || (j > 0 && !visited[i][j - 1])) {
						visited[i][j] = true;
						if (j != n - 2) {
							dfs(cnt + 1, i);
						} else {
							dfs(cnt + 1, i + 1);
						}
						visited[i][j] = false;
					}
				}
			}
		}
	}

	public static boolean play() {
		for (int num = 0; num < n; num++) {
			int ro = num;
			for (int i = 0; i < h; i++) {
				if (visited[i][ro]) {
					ro++;
				} else if (ro > 0 && visited[i][ro-1]) {
					ro--;
				}
			}
			if (ro == num) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}
