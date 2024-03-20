import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int[] friend;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(bf.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			parent = new int[2 * n];
			friend = new int[2 * n]; // 친구개수
			for (int i = 0; i < 2 * n; i++) {
				parent[i] = i;
				friend[i] = 1;
			}
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
				String a = st.nextToken();
				String b = st.nextToken();
				if (!map.containsKey(a)) {
					map.put(a, cnt++);
				}
				if (!map.containsKey(b)) {
					map.put(b, cnt++);
				}

				sb.append(union(map.get(a), map.get(b)) + "\n");
			}
		}
		System.out.println(sb);
	}

	public static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	public static int union(int x, int y) {
		int fx = find(x);
		int fy = find(y);
		if (fx < fy) {
			x = fx;
			y = fy;
		} else {
			x = fy;
			y = fx;
		}
		if (x != y) {
			parent[y] = x;
			friend[x] += friend[y];
			friend[y] = 1;
		}

		return friend[x];
	}
}
