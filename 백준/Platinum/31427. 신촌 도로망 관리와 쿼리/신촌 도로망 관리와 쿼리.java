import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Queue<Node>[] queueList;
	static int[] parent;
	static int n, m;
	static HashMap<String, long[]> map; // ABCDE, 간선개수 (ABCDE mean: 비용 A>B>C>D>E)

	static class Node {
		int start;
		int end;

		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static int find(int x) {
		if (x == parent[x])
			return x;
		else
			return parent[x] = find(parent[x]);
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x < y)
			parent[y] = x;
		else
			parent[x] = y;
	}

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		queueList = new Queue[5];
		map = new HashMap<>();
		for (int i = 0; i < 5; i++) {
			queueList[i] = new ArrayDeque<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int idx = st.nextToken().charAt(0) - 'A';

			queueList[idx].offer(new Node(start, end));

		}
		boolean[] visited = new boolean[5];
		dfs(visited, 0, "");

		for (int i = 0; i < q; i++) {
			String tmp = "";
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			st = new StringTokenizer(bf.readLine());
			int[] val = new int[5];
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				val[j] = num;
				pq.add(new int[] { num, j }); // ABCDE학교 비용 순서 파악하려고
			}
			while (!pq.isEmpty()) {
				int[] p = pq.poll();
				char c = (char) (p[1] + 65);
				tmp += c;
			}
			long cost = 0;
			long[] arr = map.get(tmp);
			for (int j = 0; j < 5; j++) {
				cost += val[j] * arr[j];
			}
			sb.append(cost).append("\n");
		}
		System.out.println(sb);
	}

	public static void dfs(boolean[] visited, int cnt, String str) {
		if (cnt == 5) {
			parent = new int[n + 1];
			for (int i = 0; i <= n; i++) {
				parent[i] = i;
			}
			cal(str);
			return;
		}
		for (int i = 0; i < 5; i++) {
			if (!visited[i]) {
				visited[i] = true;
				char c = (char) (i + 65);
				dfs(visited, cnt + 1, str + c);
				visited[i] = false;
			}
		}
	}

	public static void cal(String str) {
		int pick = 0;
		HashMap<Integer, Integer> indexmap = new HashMap<>();
		HashMap<Integer, Integer> remap = new HashMap<>();

		for (int i = 0; i < 5; i++) {
			indexmap.put((str.charAt(i)) * (-1), i); // 거리 값에 따른 알파벳 인덱스 map
			remap.put(i, str.charAt(i) - 65);
		}

		long[] arr = new long[5]; // abcde 간선개수 배열
		for (int i = 0; i < 5 && pick < n - 1; i++) {
			int idx = str.charAt(i) - 'A';

			int size = queueList[idx].size();

			while (size-- > 0 && pick < n - 1) {
				Node curr = queueList[idx].poll();

				int find1 = find(curr.start);
				int find2 = find(curr.end);

				if (find1 != find2) {
					union(find1, find2);
					pick++;
					arr[idx]++;
				}
				queueList[idx].offer(curr);
			}
		}

		map.put(str, arr);
	}
}