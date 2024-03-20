import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r;
	static int c;
	static char[][] map;
	static int[] height;
	static ArrayList<int[]> cluster;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		r = Integer.parseInt(st.nextToken());// 행
		c = Integer.parseInt(st.nextToken());// 열
		map = new char[r][c]; //
		for (int i = 0; i < r; i++) {
			String str = bf.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int n = Integer.parseInt(bf.readLine()); // 막대 던진 횟수
		height = new int[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			height[i] = r - Integer.parseInt(st.nextToken()); // 막대 던진 높이
		}

		for (int i = 0; i < n; i++) { // 막대기 던지기
			if (i % 2 == 0) { // 왼쪽에서
				for (int j = 0; j < c; j++) {
					if (map[height[i]][j] == 'x') {
						map[height[i]][j] = '.';
						break;
					}
				}
			} else {
				for (int j = c - 1; j >= 0; j--) {
					if (map[height[i]][j] == 'x') {
						map[height[i]][j] = '.';
						break;
					}
				}
			}
			findc(i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);

	}

	public static void findc(int num) { // find cluster
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[r][c];
		for (int j = 0; j < c; j++) {
			if (map[r - 1][j] == 'x') {
				queue.add(new int[] { r - 1, j });
			}
		}
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			if (!visited[p[0]][p[1]]) {
				visited[p[0]][p[1]] = true;
				for (int di = 0; di < 4; di++) {
					int nx = dx[di] + p[0];
					int ny = dy[di] + p[1];
					if (nx >= 0 && nx < r && ny < c && ny >= 0 && !visited[nx][ny] && map[nx][ny] == 'x') {
						queue.add(new int[] { nx, ny });
					}
				}
			}
		}
		cluster = new ArrayList<>();
		for (int i = 0; i < r - 1; i++) {
			for (int j = 0; j < c; j++) {
				if (!visited[i][j] && map[i][j] == 'x') {
					cluster.add(new int[] { i, j });
				}
			}
		}
		if (cluster.size() > 0) {
			movec(visited);
		}
	}

	public static void movec(boolean[][] visited) {
		int downh = 101; // 내려야할 높이
		for (int i = 0; i < cluster.size(); i++) {
			int tmp = 0;
			int x = cluster.get(i)[0];
			int y = cluster.get(i)[1];
			for (int j = x + 1; j < r; j++) {
				if (map[j][y] == '.') {
					tmp++;
				} else if (map[j][y] == 'x' && visited[j][y]) {// 방문해야 미네랄, 아니면 클러스터니까
					break;
				}
			}
			downh = Math.min(downh, tmp);
		}
		for (int i = cluster.size() - 1; i >= 0; i--) {
			int x = cluster.get(i)[0];
			int y = cluster.get(i)[1];
			map[x][y] = '.';
			map[x + downh][y] = 'x';
		}
	}
}
