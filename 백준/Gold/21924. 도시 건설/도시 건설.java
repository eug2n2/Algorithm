import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int n;
	static long total;

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x < y)
			parent[y] = x;
		else
			parent[x] = y;
	}

	public static int find(int x) {
		if (x == parent[x])
			return x;
		else
			return parent[x] = find(parent[x]);
	}

	public static boolean connect() {

		for (int i = 2; i <= n; i++) {
			if (find(parent[i]) != 1) {
				return false;
			}
		}
		return true;
	}

	public static void kruskal(long[][] graph) {
		long cost = 0;
		for (int i = 0; i < graph.length; i++) {
			if (find((int)graph[i][0]) != find((int)graph[i][1])) {
				cost += graph[i][2];
				union((int)graph[i][0],(int) graph[i][1]);
			}
		}
		if (!connect()) {
			System.out.println(-1);
		} else {
			System.out.println(total - cost);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());
		long[][] graph = new long[m][3];
		parent = new int[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());

			graph[i][0] = Long.parseLong(st.nextToken());
			graph[i][1] = Long.parseLong(st.nextToken());
			graph[i][2] = Long.parseLong(st.nextToken());
			total += graph[i][2];

		}
		Arrays.sort(graph, (o1, o2) -> Double.compare( o1[2],  o2[2]));
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		kruskal(graph);
	}
}
