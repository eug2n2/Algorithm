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
	int cnt;
	StringBuilder route;

	public Edge(int to, int weight, StringBuilder route, int cnt) {
		super();
		this.to = to;
		this.cnt = cnt;
		this.weight = weight;
		this.route = route;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight; // 오름차순
	}

}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine()); // 도시
		int m = Integer.parseInt(bf.readLine()); // 버스의 개수
		List<Edge>[] graph = new List[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder(x + " " + y);
			graph[x].add(new Edge(y, w, sb, 2));
		}
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int ans1 = 0;
		int ans2 = 0;
		StringBuilder ans3 = new StringBuilder();
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		if (start != end) {
			for (int i = 0; i < graph[start].size(); i++) {
				pq.add(graph[start].get(i));
			}
		}else {
			ans1=0;
			ans2=1;
			ans3= ans3.append(end);
		}
		boolean[] visited = new boolean[n + 1];
		visited[start] = true;
		while (!pq.isEmpty()) {
			Edge p = pq.poll();
			if (p.to == end) {
				ans1 = p.weight;
				ans2 = p.cnt;
				ans3 = p.route;
				break;
			}
			if (!visited[p.to]) {
				visited[p.to] = true;
				for (int i = 0; i < graph[p.to].size(); i++) {
					StringBuilder tsb = new StringBuilder(p.route);
					Edge tmp = graph[p.to].get(i);
					tmp.weight += p.weight;
					tmp.cnt=p.cnt+1;
					tmp.route = tsb.append(" " + tmp.to);
					pq.add(tmp);
				}
			}
		}

		System.out.println(ans1);
		System.out.println(ans2);
		System.out.println(ans3);
	}
}