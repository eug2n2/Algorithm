import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

import javax.security.auth.x500.X500Principal;

class Node {
	int x;
	int y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		ArrayList<Node>[][] bridge = new ArrayList[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				bridge[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(bf.readLine());
			int r1 = Integer.parseInt(st.nextToken()) - 1;
			int c1 = Integer.parseInt(st.nextToken()) - 1;
			int r2 = Integer.parseInt(st.nextToken()) - 1;
			int c2 = Integer.parseInt(st.nextToken()) - 1;
			bridge[r1][c1].add(new Node(r2, c2));
			bridge[r2][c2].add(new Node(r1, c1));
		}
		int[][] cow = new int[k][2];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(bf.readLine());
			int r1 = Integer.parseInt(st.nextToken()) - 1;
			int c1 = Integer.parseInt(st.nextToken()) - 1;
			cow[i][0] = r1;
			cow[i][1] = c1;
		}
		int ans = 0;
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		for (int cownum = 0; cownum < k; cownum++) {
			boolean[][] visited = new boolean[n][n];
			Deque<Node> queue = new ArrayDeque<>();
			queue.add(new Node(cow[cownum][0], cow[cownum][1]));
			visited[cow[cownum][0]][cow[cownum][1]] = true;
			while (!queue.isEmpty()) {
				Node p = queue.poll();

				for (int di = 0; di < 4; di++) {
					int nx = p.x + dx[di];
					int ny = p.y + dy[di];
					boolean skip = false;
					if (nx < 0 || ny < 0 || ny >= n || nx >= n || visited[nx][ny]) {
						continue;
					}
					for (int j = 0; j < bridge[p.x][p.y].size(); j++) {
						Node tmp = bridge[p.x][p.y].get(j);
						if (nx == tmp.x && ny == tmp.y) {
							skip = true;
							break;
						}
					}
					if (skip) {
						continue;
					}
					visited[nx][ny] = true;
					queue.add(new Node(nx, ny));
				}
			}
			for (int i = cownum; i < k; i++) {
				if (!visited[cow[i][0]][cow[i][1]]) {
					ans++;
				}
			}

		}
		System.out.println(ans);
	}

}
