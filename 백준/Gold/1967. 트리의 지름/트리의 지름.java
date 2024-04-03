import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static List<Edge>[] graph;
	static int ans = 0;
	static int total = 0;
	static boolean[] visited;
	static int[] dp;
	static int[] dp1;
	static int end = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(bf.readLine());// 정점개수
		graph = new ArrayList[v + 1];
		for (int i = 1; i <= v; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < v-1; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			
			int p = Integer.parseInt(st.nextToken());
			
			int dist = Integer.parseInt(st.nextToken());
			graph[start].add(new Edge(p, dist));
			graph[p].add(new Edge(start, dist));
		}

		visited = new boolean[v + 1];
		dp = new int[v + 1];
		dp1 = new int[v + 1];
		visited[1] = true;
		dfs(1);
		int ans = Math.max(dp[1],dp1[1]);

		System.out.println(ans);
	}

	public static void dfs(int start) {
		int child = 0;
		PriorityQueue<Integer> pq =new PriorityQueue<>();
		for (Edge edge : graph[start]) {
			if (visited[edge.destination]) {
				continue;
			} else {
				child++;
				visited[edge.destination] = true;
				dfs(edge.destination);
				dp[start] = Math.max(dp[start], edge.distance + dp[edge.destination]);
				dp1[start] = Math.max(dp1[start], dp1[edge.destination]);
				if(pq.size()<2||pq.peek()<(edge.distance+dp[edge.destination])) {
					if(pq.size()==2) {
						pq.poll();
					}
					pq.add(edge.distance +dp[edge.destination]);
				}
			}
		}
		int tmp =0;
		if(child!=0) {
			while(!pq.isEmpty()) {
				tmp+=(pq.poll());
			}
		}
		dp1[start]= Math.max(dp1[start],tmp);
	}
}

class Edge {
	int destination;
	int distance;

	Edge(int destination, int distance) {
		this.distance = distance;
		this.destination = destination;
	}

	@Override
	public String toString() {
		return distance + " 목적지: " + destination;

	}
}