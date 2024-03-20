import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken()); // 학생 수
		int m = Integer.parseInt(st.nextToken()); // 도로 개수
		int ap = Integer.parseInt(st.nextToken()); // 목적지
		List<Edge>[] graph = new List[n + 1];
		for (int i = 1; i <= n; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[x].add(new Edge(y, w));
		}

		PriorityQueue<Integer> ans = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int start = 1; start <= n; start++) {
			pq.offer(new Edge(start, 0));
			boolean[] visit = new boolean[n + 1];
			int[] dp = new int[n + 1];
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[start] = 0;
			while (!pq.isEmpty()) {
				Edge cur = pq.poll();
				if (visit[cur.to])
					continue;

				visit[cur.to] = true;

				for (Edge ed : graph[cur.to]) {
					if (dp[ed.to] > dp[cur.to] + ed.weight) {
						dp[ed.to] = dp[cur.to] + ed.weight;
						pq.offer(new Edge(ed.to, dp[ed.to]));
					}
				}
			}
			pq.offer(new Edge(ap, 0));
			visit = new boolean[n + 1];
			int[] dp1 = new int[n + 1];
			Arrays.fill(dp1, Integer.MAX_VALUE);
			dp1[ap] = 0;
			while (!pq.isEmpty()) {
				Edge cur = pq.poll();
				if (visit[cur.to])
					continue;

				visit[cur.to] = true;

				for (Edge ed : graph[cur.to]) {
					if (dp1[ed.to] > dp1[cur.to] + ed.weight) {
						dp1[ed.to] = dp1[cur.to] + ed.weight;
						pq.offer(new Edge(ed.to, dp1[ed.to]));
					}
				}
			}
			ans.add(dp[ap]+dp1[start]);
		}
		System.out.println(ans.poll());
	}
}

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