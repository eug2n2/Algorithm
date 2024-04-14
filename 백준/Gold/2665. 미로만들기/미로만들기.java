import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] arr;
	static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		int ans = 0;
		arr = new int[n][n];
		dist = new int[n][n];
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < n; j++) {
				int a = str.charAt(j)-'0';
				arr[i][j] = a; // 1 흰방 0 검은방
				// 흰방이어야 지나갈 수있음
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { 0, 0 }); // 출발점 넣기
		dist[0][0] = 0; // 시작방으로서 항상 흰 방임
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			int x = p[0];
			int y = p[1];
			int[] dx = { -1, 1, 0, 0 };
			int[] dy = { 0, 0, 1, -1 };
			for (int di = 0; di < 4; di++) {
				int nx = x + dx[di];
				int ny = y + dy[di];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || dist[nx][ny] <= dist[x][y])
					continue;
				else if (arr[nx][ny] == 1) dist[nx][ny] = dist[x][y];
				else dist[nx][ny] = dist[x][y] + 1;
				queue.add(new int[] { nx, ny });
				

			}
		}
		System.out.println(dist[n - 1][n - 1]);

	}
}