import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static char[][] map;
	static int ans;
	static boolean[][] visited;
	static int cnt;

	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		for (int i = 0; i < 5; i++) {
			String str = bf.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		ans = 0;
		visited = new boolean[5][5];
		dfs(0, 0);
		System.out.println(ans);
	}

	private static void dfs(int depth, int start) {
		if (depth == 7) {
			if (check()) {
				ans++;
			}
			return;
		}
		for (int i = start; i < 25; i++) {
			visited[i / 5][i % 5] = true;
			dfs(depth + 1, i + 1);
			visited[i / 5][i % 5] = false;
		}

	}

	public static boolean check() {
		boolean[][] visited1 = new boolean[5][5];
		cnt = 0; //
		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < 5; i++) {
			visited1[i] = visited[i].clone();
		}
		out: for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (visited1[i][j]) {
					q.add(new Point(i, j));
					break out;
				}
			}
		}
		int s = 0;
		while (!q.isEmpty()) {
			Point p = q.poll();
			int tmp = 0;

			int[] dx = { 1, 0, 0, -1 };
			int[] dy = { 0, 1, -1, 0 };
			for (int di = 0; di < 4; di++) {
				int sx = dx[di] + p.x;
				int sy = dy[di] + p.y;
				if (sx < 0 || sy < 0 || sx >= 5 || sy >= 5) {
					continue;
				} else if (visited1[sx][sy] == true) {
					if (map[sx][sy] == 'S') {
						s++;
					}
					cnt++; // 인접해있구나
					q.add(new Point(sx, sy));

					visited1[sx][sy] = false;
				}
			}

		}
		if (cnt == 7 && s >= 4) {
			return true;
		} else {
			return false;
		}
	}
}
