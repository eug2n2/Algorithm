import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int max; // 최대 맛있는 치즈 정도
	static int n;
	static int min;
	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		int ans = 0;
		arr = new int[n][n];
		max = 0;
		min = 100;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				int a = Integer.parseInt(st.nextToken());
				arr[i][j] = a;
				if (max < a)
					max = a;
				if (min > a)
					min = a;
			}
		}
		for (int size = min; size < max; size++) {
			int tmp = 0;
			Queue<Point> queue = new LinkedList<Point>();
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] > size)
						queue.add(new Point(i, j));
				}
			}
			while (!queue.isEmpty()) {
				Point p = queue.poll();
				if (!visited[p.x][p.y]) {
					tmp++;
					visited[p.x][p.y] = true;
					visited = cheese(visited, size, queue, p.x, p.y, n);
				}
			}
			ans = Math.max(ans, tmp);
		}
		if (ans == 0)
			ans = 1;
		System.out.println(ans);

	}

	public static boolean[][] cheese(boolean[][] visited, int size, Queue<Point> queue, int i, int j, int n) {
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		for (int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];

			// 범위 확인
			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				// 현재 위치가 1이고 방문하지 않은 경우
				if (arr[nx][ny] > size && !visited[nx][ny]) { // 인접배추가 있고, 방문안한 배추일경우
					visited[nx][ny] = true;
					visited = cheese(visited, size, queue, nx, ny, n);
				}
			}
		}
		return visited; // 인접한 위치 중에 조건을 만족하는 것이 없으면 false 반환
	}
}