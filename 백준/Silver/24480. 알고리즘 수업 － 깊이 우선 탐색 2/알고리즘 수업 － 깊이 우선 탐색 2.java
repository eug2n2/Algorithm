import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int idx=1;
	static int start;
	static boolean[] visited;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		List<Integer>[] graph = new ArrayList[n + 1];
		answer = new int[n+1];
		for (int i = 0; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		visited = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[b].add(a);
			graph[a].add(b);
		}
		for (int i = 1; i < n + 1; i++) {
			 Collections.sort(graph[i], Collections.reverseOrder());
		}
		dfs(graph, start);
		visited = new boolean[n + 1];
		for (int i =1; i<=n;i++) {
			System.out.println(answer[i]);
		}
		
	}

	public static void dfs(List<Integer>[] graph, int sp) {
		visited[sp] = true;
		answer[sp]= idx++;
		int idx1 = 0;
		while (idx1 < graph[sp].size()) {
			if (!visited[graph[sp].get(idx1)]) {
			
				dfs(graph, graph[sp].get(idx1));
				
			} else {
				idx1++;
			}
		}
		return;

	}

}
