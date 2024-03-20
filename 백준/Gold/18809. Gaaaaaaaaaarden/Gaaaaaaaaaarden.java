
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> graph;
	static int g;
	static int r;
	static int n;
	static int m;
	static int ans = 0;
	static boolean[] visited;
	static ArrayList<int[]> possible;
	static int[][] map;
	static int[][]green;
	static int [][] red;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());// 행
		m = Integer.parseInt(st.nextToken());// 열
		g = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n + 1][m + 1];
		possible = new ArrayList<>();
		visited = new boolean[10];
		green = new int [g][2];
		red = new int [r][2];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					possible.add(new int[] {i,j});
				}
			}
		}
		dfsg(0, 0);
		System.out.println(ans);
	}

	public static void dfsg(int cnt, int xstart) {
		if (cnt == g) {
			dfsr(0,0);
			return;
		}
		for (int i = xstart; i < possible.size(); i++) {
				if (!visited[i] && map[possible.get(i)[0]][possible.get(i)[1]] == 2) {
					visited[i]  = true;
					green[cnt][0]=possible.get(i)[0];
					green[cnt][1]=possible.get(i)[1];
					dfsg(cnt + 1, i+1);
					visited[i] = false;
				
				}
			}
		}
	

	public static void dfsr(int cnt, int xstart) {
		if (cnt == r) {
			plant();
			return;
		}
		for (int i = xstart; i <possible.size(); i++) {
			if (!visited[i] && map[possible.get(i)[0]][possible.get(i)[1]] == 2) {
				visited[i]  = true;
				red[cnt][0]=possible.get(i)[0];
				red[cnt][1]=possible.get(i)[1];
				dfsr(cnt + 1, i+1);
				visited[i] = false;
			
			}
		}
	}

	public static void plant() {
		Queue<int[]> q = new LinkedList<>();
		int[][] time = new int[n + 1][m + 1];
		int[][] flower = new int[n + 1][m + 1];
		int result = 0;// 여기서의 꽃개수
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		for (int i =0;i<g;i++) {
			time[green[i][0]][green[i][1]]=1;
			flower[green[i][0]][green[i][1]]=1;
			q.add(new int[] { green[i][0], green[i][1] });
		}
		for (int i =0;i<r;i++) {
			time[red[i][0]][red[i][1]]=1;
			flower[red[i][0]][red[i][1]]=2;
			q.add(new int[] { red[i][0], red[i][1] });
		}

		int day =1;
		while (!q.isEmpty()) {
			int size = q.size();
			day++;
			while (size != 0) {
				int[] p = q.poll();
				size--;
				if (flower[p[0]][p[1]] == 3) {// 꽃은 배양할 수 없다.
					continue;
				} else {
					for (int di = 0; di < 4; di++) {
						int nx = dx[di] + p[0];
						int ny = dy[di] + p[1];
						if (nx <= 0 || ny <= 0 || nx > n || ny > m) {
							continue;
						} else if (time[nx][ny] == day && flower[nx][ny] != flower[p[0]][p[1]]&&flower[nx][ny]!=3) {
							flower[nx][ny] = 3;
							result++;
						} else if ( time[nx][ny]==0 && map[nx][ny] != 0) {
							flower[nx][ny] = flower[p[0]][p[1]];
							time[nx][ny] = day;
							q.add(new int[] { nx, ny });
						}
					}
				}
			}
		}
		ans = Math.max(ans, result);
	}
}