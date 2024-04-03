import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static int r, c;
	static int ans = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = bf.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		boolean[] visited = new boolean[26];
		visited[map[0][0] - 65] = true;
		dfs(1, 0, 0, visited);
		System.out.println(ans);
	}

	public static void dfs(int cnt, int row, int col, boolean[] visited) {
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		for (int di = 0; di < 4; di++) {
			int nx = dx[di] + row;
			int ny = dy[di] + col;
			if (nx < 0 || ny < 0 || ny>=c|| nx>=r|| visited[map[nx][ny] - 65]) {
				ans = Math.max(ans, cnt);
				continue;
			}else {
				visited[map[nx][ny] - 65] = true;
				dfs(cnt + 1, nx, ny, visited);
				visited[map[nx][ny] - 65] = false;
			}
		}

	}
}