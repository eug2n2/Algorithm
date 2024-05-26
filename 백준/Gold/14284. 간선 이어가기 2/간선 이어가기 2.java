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
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken()); // 도시
		int m = Integer.parseInt(st.nextToken()); // 버스의 개수
		List<Edge>[] graph = new List[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[x].add(new Edge(y, w));
			graph[y].add(new Edge(x, w));
		}
		st = new StringTokenizer(bf.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int ans1 = 0;

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		if (start != end) {
			for (int i = 0; i < graph[start].size(); i++) {
				pq.add(graph[start].get(i));
			}
		} else {
			ans1 = 0;
		}
		boolean[] visited = new boolean[n + 1];
		visited[start] = true;
		while (!pq.isEmpty()) {
			Edge p = pq.poll();
			if (p.to == end) {
				ans1 = p.weight;
				break;
			}
			if (!visited[p.to]) {
				visited[p.to] = true;
				for (int i = 0; i < graph[p.to].size(); i++) {
					Edge tmp = graph[p.to].get(i);
					tmp.weight += p.weight;
					pq.add(tmp);
				}
			}
		}

		System.out.println(ans1);
	}
}