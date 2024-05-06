import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int[] cost;

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
		return parent[x] = find(parent[x]);
	}

	public static void kruskal(int[][] graph) {
		long ans = 0;
		for (int i = 0; i < graph.length; i++) {
//			System.out.println(graph[i][0] + " " + graph[i][1] + " " + graph[i][2] + " ");
			if (graph[i][0] == graph[i][1] && find(graph[i][1]) != 0) {
				ans += graph[i][2];
				union(graph[i][0], 0);
			} else if (find(graph[i][0]) != find(graph[i][1])) {
				ans += graph[i][2];
				union(graph[i][0], graph[i][1]);
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		parent = new int[n + 1];
		cost = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
			cost[i] = Integer.parseInt(bf.readLine());
		}
		int size = (n * n - n) / 2 + n;
		int[][] graph = new int[size][3];
		int idx = 0;
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= n; j++) {
				int w = Integer.parseInt(st.nextToken());
				if (i > j)
					continue;
				graph[idx][0] = i;
				graph[idx][1] = j;
				if (i == j) {
					graph[idx][2] = cost[i];

				} else {
					graph[idx][2] = w;
				}
				idx++;
			}
		}
		Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);
		kruskal(graph);
	}
}