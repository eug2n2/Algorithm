import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int n;
	static int m;
	static int ic;
	static Queue<int[]> queue ;
	static int lump;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken()); // row
		m = Integer.parseInt(st.nextToken()); // col
		map = new int[n][m];
		ic = 0; // 빙산개수
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					ic++;
				}
			}
		}
		int ans = 0;
		check();
		while (lump < 2 && ic != 0) {
			ans++;
			melt();
			check();
		}
		if(ic==0&&lump<2) {
			ans=0;
		}
		System.out.println(ans);

	}

	public static void melt() {
		int[][] newmap = new int[n][m];
		int[] dx = new int[] { -1, 1, 0, 0 };
		int[] dy = new int[] { 0, 0, -1, 1, };
		for (int i = 0; i < n; i++) {
			newmap[i] = map[i].clone();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (newmap[i][j] != 0) {
					int cnt = 0;
					for (int di = 0; di < 4; di++) {
						int nx = dx[di] + i;
						int ny = dy[di] + j;
						if (nx >= 0 && ny >= 0 && nx < n && ny < m && newmap[nx][ny] == 0) {
							cnt++;
						}
					}
					map[i][j] -= cnt;
					if (map[i][j] <= 0) {
						map[i][j] = 0;
						ic--;
					}
				}
			}
		}
	}

	public static void check() {

		visited = new boolean[n][m];
		lump = 0;
		queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					visited[i][j] = true;
					queue.add(new int[] {i,j} );
					dfs();
					lump++;
				}
			}
		}
	}
	public static void dfs() {

		int[] dx = new int[] { -1, 1, 0, 0 };
		int[] dy = new int[] { 0, 0, -1, 1, };
		while(!queue.isEmpty()) {
			int[] p =queue.poll();
			for (int di = 0; di < 4; di++) {
				int nx = dx[di] + p[0];
				int ny = dy[di] + p[1];
				if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny]!=0&& !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new int[] {nx,ny});
				}
			}
			
		}
	}
}
