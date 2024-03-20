import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int[] map;

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

	public static void kruskal(int[][] map) {
		int cost = 0;
		for (int i = 0; i < map.length; i++) {
			if (find( map[i][0]) != find( map[i][1])) {
				cost += map[i][2];
				union(map[i][0],  map[i][1]);
			}
		}
		System.out.println(cost);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());
		int[][] graph = new int[m][3];
		parent = new int[n+1];
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			graph[i][0] = Integer.parseInt(st.nextToken());
			graph[i][1] = Integer.parseInt(st.nextToken());
			graph[i][2] = Integer.parseInt(st.nextToken());
			

		}
		Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		kruskal(graph);

	}
}
