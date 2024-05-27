import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int to;
	int weight;

	public Edge(int to, int weight) {
		super();
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight; // 오름차순
	}

}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken()); // 컴퓨터개수
			int d = Integer.parseInt(st.nextToken()); // 의존성개수
			int start = Integer.parseInt(st.nextToken()); // 해킹당한 컴
			List<Edge>[] graph = new List[n + 1];
			int[] dist = new int[n + 1];
			for (int i = 0; i <= n; i++) {
				dist[i] = Integer.MAX_VALUE;
				graph[i] = new ArrayList<>();
			}
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(bf.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				graph[y].add(new Edge(x, w));
			}

			int ans = 0;
			int cnt = 0;
			PriorityQueue<Edge> pq = new PriorityQueue<>();

			pq.add(new Edge(start, 0));
			dist[start] = 0;
			boolean[] visited = new boolean[n + 1];

			while (!pq.isEmpty()) {
				Edge p = pq.poll();
				if (!visited[p.to]) {
					visited[p.to] = true;
					for (int i = 0; i < graph[p.to].size(); i++) {
						Edge tmp = graph[p.to].get(i);
						if (dist[tmp.to] > dist[p.to] + tmp.weight) {
							dist[tmp.to] = dist[p.to] + tmp.weight;
							pq.add(new Edge(tmp.to, dist[tmp.to]));
						}
					}
				}
			}
			for (int i = 1; i < n + 1; i++) {
				if (dist[i] != Integer.MAX_VALUE) { // 감염된 컴퓨터
					cnt++;
					ans = Math.max(ans, dist[i]);
				}
			}
			sb.append(cnt).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

}