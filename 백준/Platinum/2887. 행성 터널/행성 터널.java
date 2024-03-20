
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int[][] map ;
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x < y) parent[y] = x;
		else parent[x] = y;
	}

	public static int find(int x) {
		if(parent[x] == x) return x;
		else return parent[x]=find(parent[x]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(bf.readLine());
		int[][] graph = new int[v][4];
		int[][] map = new int[3*v-3][3];
		for (int i = 0; i < v; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			graph[i][0] = Integer.parseInt(st.nextToken());
			graph[i][1] = Integer.parseInt(st.nextToken());
			graph[i][2] = Integer.parseInt(st.nextToken());
			graph[i][3] =i;

		}
		Arrays.sort(graph, (o1, o2) -> o1[0] - o2[0]);
		int idx=0;
		for (int i = 0; i < v- 1; i++) {
			int weight = Math.abs(graph[i][0] - graph[i + 1][0]);
			map[idx][0] =graph[i][3];
			map[idx][1] =graph[i+1][3];
			map[idx][2]= weight;
			idx++;
		}
		
		Arrays.sort(graph, (o1, o2) -> o1[1] - o2[1]);
		for (int i = 0; i < v- 1; i++) {
			int weight = Math.abs(graph[i][1] - graph[i + 1][1]);
			map[idx][0] =graph[i][3];
			map[idx][1] =graph[i+1][3];
			map[idx][2]= weight;
			idx++;
		}

		Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);
		for (int i = 0; i < v- 1; i++) {
			int weight = Math.abs(graph[i][2] - graph[i + 1][2]);
			map[idx][0] =graph[i][3];
			map[idx][1] =graph[i+1][3];
			map[idx][2]= weight;
			idx++;
		}
		parent = new int[v];
		for (int i = 0; i < v; i++) {
			parent[i] = i;
		}

		Arrays.sort(map, (o1, o2) -> o1[2] - o2[2]);
		int cost=0;
		for (int i = 0; i < 3*v-3; i++) {
			// 사이클이 발생하는 간선은 제외.
			if (find(map[i][0]) != find(map[i][1])) {
				cost += map[i][2];
				union(map[i][0],map[i][1]);
			}
		}
		System.out.println(cost);

	}
}
