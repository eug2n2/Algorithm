import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int ans = 0; // 적의 개수
	static int m;
	static int n;
	static int d;
	static int total = 0;
	static int enemy;
	static int[] gs = new int[3];
	static boolean[][] visited;// 마지막행 궁수 방문여부 체크

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		enemy = 0; // 적개수
		map = new int[n][m];
		visited = new boolean[1][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // map 입력받기
				if (map[i][j] == 1) {
					enemy++;
				}
			}
		}
		dfs(0, 0);
		System.out.println(ans);
	}

	public static void dfs(int cnt, int start) {
		if (cnt == 3) { // cnt: 궁수개수
			attack();
			ans = Math.max(ans, total);
			total = 0;
			
			return;
		}
		for (int i = start; i < m; i++) {
			if (!visited[0][i]) {
				visited[0][i] = true;
				gs[cnt] = i;
				dfs(cnt + 1, i + 1);
				visited[0][i] = false;
			}
		}

	}

	public static void attack() {
		int[][] newmap = new int[n][m];
		for (int i = 0; i < n; i++) {
			newmap[i] = map[i].clone();
		}
		int e = enemy;
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				// 세 번째 원소를 기준으로 오름차순 정렬
				int result = Integer.compare(arr1[2], arr2[2]);
		        // 세 번째 원소가 같을 경우 두 번째 원소를 오름차순 정렬
		        if (result == 0) {
		            result = Integer.compare(arr1[1], arr2[1]);
		        }
		        return result;
			}
		});
		while (e != 0) {
			List<int[]> target = new ArrayList<>();
			for (int cnt = 0; cnt < 3; cnt++) {
				queue.clear();
				for (int i = n - 1; i >= 0; i--) {
					for (int j = 0; j < m; j++) {
						int dist = n - i + Math.abs(j - gs[cnt]);
						if (newmap[i][j] == 1 && dist <= d) {
							queue.add(new int[] { i, j, dist });
						}
					}
				}
					if (!queue.isEmpty()) {
						int[] p = queue.poll();
						boolean avail = false;
						for (int s = 0; s < target.size(); s++) {
							if (newmap[p[0]][p[1]] == 1 && target.get(s)[0] == p[0] && target.get(s)[1] == p[1]) {
								avail = true;// 같은게 있다.
								break;
							}
						}
						if (!avail) {
							target.add(new int[] { p[0], p[1] });
							total++;
							e--;

						}
					}
			}
			for (int s = 0; s < target.size(); s++) {
				newmap[target.get(s)[0]][target.get(s)[1]] = 0;
			}
			for (int i = n - 1; i >= 0; i--) {
				for (int j = 0; j < m; j++) {
					if (newmap[i][j] == 1) {
						newmap[i][j] = 0;
						if (i == n - 1) { // 범위 밖
							e--;
						} else {
							newmap[i + 1][j] = 1;
						}
					}
				}
			}
		}
	}
}
