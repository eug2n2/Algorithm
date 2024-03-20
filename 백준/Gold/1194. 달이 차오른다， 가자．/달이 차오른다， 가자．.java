import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static Queue<int[]> queue;
	static int m;
	static int ans = Integer.MAX_VALUE;
	static char[][] map;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());// 행
		m = Integer.parseInt(st.nextToken());// 열
		map = new char[n][m];
		queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '0') {
					queue.add(new int[] { i, j, 0 });
				}
			}
		}
		visited = new boolean[n][m][64];
		System.out.println(bfs());
	}

	public static int bfs() {
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		int time = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] p = queue.poll();
				int x = p[0];
				int y = p[1];
				int key = p[2];
				visited[x][y][key]=true;
				for (int di = 0; di < 4; di++) {
					int nx = x + dx[di];
					int ny = y + dy[di];
					if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny][key] && map[nx][ny] != '#') {
						char c = map[nx][ny];
						if (c == '1') {
							return time;
						} else if (c >= 'a' && c <= 'f') {
							visited[nx][ny][key] = true;
							queue.add(new int[] { nx, ny, key | (1 << c - 97)});
						} else if (c >= 'A' && c <= 'F' && open(c, key)) {
							visited[nx][ny][key] = true;
							queue.add(new int[] { nx, ny, key });
						} else if (c == '.' || c == '0') {
							visited[nx][ny][key] = true;
							queue.add(new int[] { nx, ny, key });
						}
					}
				}
			}
			time++;
		}
		return -1;
	}

	public static boolean open(char door, int key) {
		int i = door - 65;
		if ((key & (1 << i)) > 0) {
			return true;
		} else {
			return false;
		}

	}
}