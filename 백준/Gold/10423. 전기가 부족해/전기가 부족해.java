import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;

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

	public static void kruskal(int[][] graph) {
		long cost = 0;
		for (int i = 0; i < graph.length; i++) {
			if (find(graph[i][0]) != find(graph[i][1])) {
				cost += graph[i][2];
				union(graph[i][0], graph[i][1]);
			}
		}
		System.out.println(cost);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < k; i++) {
			int a = Integer.parseInt(st.nextToken());
			parent[a] = 0;
		}

		int[][] graph = new int[m][3];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
				graph[i][0] = a;
				graph[i][1] = b;
				graph[i][2] =w;
			
		}
		Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);
		kruskal(graph);
	}
}
