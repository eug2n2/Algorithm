import java.io.*;
import java.util.*;

class Node {
	int idx;
	int cost;

	Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}
}

public class Main {
	static boolean[] visited;
	// 최단 거리 테이블
	static int[] dist;
	static List<Node>[] graph;
	static int INF =200000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n + 1];
		dist = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = 800001;
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}
		st = new StringTokenizer(bf.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		int ans1 = 0;
		int ans2 = 0;
		visited = new boolean[n + 1];
		dist[1] = 0;
		dijkstra(1);
		ans1 += dist[v1];
		ans2 += dist[v2];
		if (dist[v1] != INF) {
			dist = new int[n + 1];
			visited = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				dist[i] = INF;
			}
			dist[v1] = 0;
			dijkstra(v1);
			ans1 += dist[v2];
			if (dist[v2] != INF) {
				dist = new int[n + 1];
				visited = new boolean[n + 1];
				for (int i = 1; i <= n; i++) {
					dist[i] = INF;
				}
				dist[v2] = 0;
				dijkstra(v2);
				if (dist[n] != INF) {
					ans1 += dist[n];
				} else {
					ans1 = -1;
				}
			} else {
				ans1 = -1;
			}

		} else {
			ans1 = -1;
		}
		
		if (ans2 != INF) {
			dist = new int[n + 1];
			visited = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				dist[i] = INF;
			}
			dist[v2] = 0;
			dijkstra(v2);
			ans2 += dist[v1];
			if (dist[v1]!= INF) {
				dist = new int[n + 1];
				visited = new boolean[n + 1];
				for (int i = 1; i <= n; i++) {
					dist[i] = INF;
				}
				dist[v1] = 0;
				dijkstra(v1);
				if (dist[n] != INF) {
					ans2 += dist[n];
				} else {
					ans2 = -1;
				}
			} else {
				ans2 = -1;
			}

		} else {
			ans2 = -1;
		}
		int ans =0;
		if(ans1==-1 && ans2==-1) {
			 ans =-1;
		}else if (ans1!=-1 && ans2!=-1) {
			ans =Math.min(ans1, ans2);
		}else {
			ans = Math.max(ans2, ans1);
		}
		System.out.println(ans);
	}

	static void dijkstra(int start) {
		// 우선 순위 큐 사용, 가중치를 기준으로 오름차순한다.
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		// 시작 노드에 대해서 초기화
		q.add(new Node(start, 0));
		dist[start] = 0;

		while (!q.isEmpty()) {
			// 현재 최단 거리가 가장 짧은 노드를 꺼내서 방문 처리 한다.
			Node now = q.poll();

			if (!visited[now.idx]) {
				visited[now.idx] = true;
			}
			for (Node next : graph[now.idx]) {

				// 방문하지 않았고, 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧을 경우
				if (!visited[next.idx] && dist[next.idx] > now.cost + next.cost) {
					dist[next.idx] = now.cost + next.cost;
					q.add(new Node(next.idx, dist[next.idx]));
				}
			}
		}
	}
}