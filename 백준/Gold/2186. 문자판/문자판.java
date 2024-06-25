import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

 class route {
	int cnt;
	int x;
	int y;

	public route(int cnt, int x, int y) {
		this.cnt = cnt;
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int finalsize = 0;
	static int ans = 0;
	static String find;
	static int n, m, k;
	static char[][] arr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken()); // nxm
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken()); // 움직일 때는 상하좌우로 K개의 칸까지만 이동할 수 있다
		arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		find = bf.readLine();
		finalsize = find.length();
		dp = new int[finalsize][n][m]; // 글자수 번째 가짓수 ...
		Deque<route> queue = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] != find.charAt(finalsize - 1))
					continue;
				dp[0][i][j] = 1; // 1번째 글자 == 0 번째 배열
				route rtmp = new route(1, i, j);
				queue.add(rtmp);
			}
		}
		while(!queue.isEmpty()) {
			route  p = queue.poll();
			int cnt  = p.cnt;
			int x = p.x;
			int y =p.y;
			if (cnt == finalsize) {
				continue;
			}
			for (int i = 1; i <= k; i++) {
				for (int di = 0; di < 4; di++) {
					int nx = dx[di] * i + x;
					int ny = dy[di] * i + y;
					if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
						continue;
					}
					if (arr[nx][ny] != find.charAt(finalsize - 1 - cnt))
						continue;

					if (dp[cnt][nx][ny] == 0) { // 방문 안 했다면 ..
						cal(cnt, nx, ny);
//						System.out.println(cnt + " " + find.charAt(finalsize - 1 - cnt) + " " + arr[nx][ny] + " " + nx + " "
//								+ ny + " " + dp[cnt][nx][ny]);
						queue.add(new route(cnt + 1, nx, ny));
						if (cnt == finalsize - 1) {
							ans += dp[cnt][nx][ny];
						}
					}

				}
			}
		}
		
		System.out.println(ans);
	}

	public static void cal(int cnt, int x, int y) {

		for (int i = 1; i <= k; i++) {
			for (int di = 0; di < 4; di++) {
				int nx = dx[di] * i + x;
				int ny = dy[di] * i + y;
				if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}
				dp[cnt][x][y] += dp[cnt - 1][nx][ny];

			}
		}
	}
}
