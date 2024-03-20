import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int start;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		List<Integer>[] graph = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		visited = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[b].add(a);
			graph[a].add(b);
		}
		for (int i = 1; i < n + 1; i++) {
			Collections.sort(graph[i]);
		}
		dfs(graph, start);
		sb.append("\n");
		visited = new boolean[n + 1];
		visited[start] = true;
		sb.append(start + " ");
		queue.add(start);
		bfs(queue, graph);
		System.out.println(sb);
	}

	public static void dfs(List<Integer>[] graph, int sp) {
		sb.append(sp + " ");
		visited[sp] = true;
		int idx = 0;
		while (idx < graph[sp].size()) {
			if (!visited[graph[sp].get(idx)]) {
				dfs(graph, graph[sp].get(idx));
				
			} else {
				idx++;
			}
		}
		return;

	}

	public static void bfs(Queue<Integer> queue, List<Integer>[] graph) {
		while (!queue.isEmpty()) {
			int sp = queue.poll();
			int idx = 0;
			while (idx < graph[sp].size()) {
				if (!visited[graph[sp].get(idx)]) {
					queue.add(graph[sp].get(idx));
					visited[graph[sp].get(idx)] = true;
					sb.append(graph[sp].get(idx) + " ");
				}
				idx++;
			}
		}

	}
}
