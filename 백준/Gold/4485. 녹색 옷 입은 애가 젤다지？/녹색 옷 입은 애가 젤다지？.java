import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int idx = 1;
		while (true) {
			int n = Integer.parseInt(bf.readLine());
			if (n == 0)
				break;
			int[][] map = new int[n][n];
			int[][] dist = new int[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			dist[0][0] = map[0][0];
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});
			pq.offer(new int[] { 0, 0, map[0][0] });
			int[] dx = { -1, 1, 0, 0 };
			int[] dy = { 0, 0, 1, -1 };
			while (!pq.isEmpty()) {
				int[] p = pq.poll();
				int cost = p[2];
				int x = p[0];
				int y = p[1];
				if (dist[x][y] < cost)
					continue;
				for (int di = 0; di < 4; di++) {
					int nx = x + dx[di];
					int ny = y + dy[di];
					if (nx < 0 || ny < 0 || nx >= n || ny >= n)
						continue;
					int tmp = dist[x][y] + map[nx][ny];
					if (tmp < dist[nx][ny]) {
						dist[nx][ny] = tmp;
						pq.offer(new int[] { nx, ny, tmp });
					}
				}
			}
			System.out.println("Problem " + idx + ": " + dist[n - 1][n - 1]);
			idx++;
		}

	}
}
