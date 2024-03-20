import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 가로
		int m = Integer.parseInt(st.nextToken()); // 세로
		int k = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		boolean[][][] visited = new boolean[n][m][k + 1];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		int cnt = -1;
		visited[0][0][0] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0, 1, 0 });
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			int x = p[0], y = p[1], punch = p[3];
			int tmp = p[2];
			if (x == n - 1 && y == m - 1) {
				cnt = tmp;
				break;
			}
			for (int di = 0; di < 4; di++) {
				int nx = x + dx[di];
				int ny = y + dy[di];

				// 범위 확인
				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				// 현재 위치가 1이고 방문하지 않은 경우
				if (map[nx][ny] == 0) {
					if (!visited[nx][ny][punch]) { // 지금까지 벽 안 부순 경우
						visited[nx][ny][punch] = true;
						queue.add(new int[] { nx, ny, tmp + 1, punch });
					}
				} else if (punch < k && !visited[nx][ny][punch+1]) {
					visited[nx][ny][punch+1] = true;
					queue.add(new int[] { nx, ny, tmp + 1, punch+1 });
				} // 지금까지 벽 안 부순 경우 부술 거야.
			}

		}

		System.out.println(cnt);
	}
}
