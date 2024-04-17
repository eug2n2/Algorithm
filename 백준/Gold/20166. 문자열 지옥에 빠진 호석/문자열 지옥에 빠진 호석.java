import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;
	int cnt;
	StringBuilder godsb;

	Node(int x, int y, int cnt, StringBuilder godsb) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.godsb = godsb;
	}

	@Override
	public String toString() {
		return x + " " + y + " cnt: " + cnt + " godsb: " + godsb;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<>();
		Queue<Node> queue = new ArrayDeque<>();
		char[][] arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			String stmp = bf.readLine();
			for (int j = 0; j < m; j++) {
				char cha = stmp.charAt(j);
				arr[i][j] = cha;
				StringBuilder s = new StringBuilder();
				s.append(cha);
				queue.add(new Node(i, j, 1, s));
			}
		}
		String[] key = new String[k];
		int maxsize = 1;
		for (int i = 0; i < k; i++) {
			String str = bf.readLine();
			map.put(str, 0);
			key[i] = str;
			int length = str.length();
			if (maxsize < length)
				maxsize = length;
		}
		int[] dx = new int[] { -1, 1, 0, 0 };
		int[] dy = new int[] { 0, 0, 1, -1 };
		int[] ddx = new int[] { -1, 1, 1, -1 };
		int[] ddy = new int[] { 1, 1, -1, -1 };
		while (!queue.isEmpty()) {
			Node p = queue.poll();
			if (map.containsKey(p.godsb.toString())) {
				map.put(p.godsb.toString(), map.get(p.godsb.toString()) + 1);
			}
			if (p.cnt == maxsize) {
				continue;
			}
			for (int di = 0; di < 4; di++) {
				int nx = p.x + dx[di];
				int ny = p.y + dy[di];
				if (nx < 0)
					nx = n - 1;
				else if (ny < 0)
					ny = m - 1;
				else if (nx == n)
					nx = 0;
				else if (ny == m)
					ny = 0;
				StringBuilder copysb = new StringBuilder();
				copysb.append(p.godsb.toString()).append(arr[nx][ny]);
				queue.add(new Node(nx, ny, p.cnt + 1, copysb));

			}

			for (int di = 0; di < 4; di++) {
				int nx = p.x + ddx[di];
				int ny = p.y + ddy[di];
				if (nx < 0)	nx = n - 1;
				if (ny < 0)ny = m - 1;
				if (nx == n)	nx = 0;
				if (ny == m)	ny = 0;
				StringBuilder copysb = new StringBuilder();
				copysb.append(p.godsb.toString()).append(arr[nx][ny]);
				queue.add(new Node(nx, ny, p.cnt + 1, copysb));

			}

		}
		StringBuilder sb = new StringBuilder();
		for (String val : key) {
			sb.append(map.get(val)).append("\n");
		}
		System.out.println(sb);
	}
}
