import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x < y)
			parent[y] = x;
		else
			parent[x] = y;
	}

	public static int find(int x) {
		if (x == parent[x])
			return x;
		else
			return parent[x] = find(parent[x]);
	}

	public static void kruskal(double[][] graph) {
		double cost = 0;
		for (int i = 0; i < graph.length; i++) {
			if (find((int)(graph[i][0])) != find((int)(graph[i][1]))) {
				cost += graph[i][2];
				union((int)(graph[i][0]), (int)(graph[i][1]));
			}
		}
		double ans = Math.round(cost * 100) / 100.0; // 100을 곱하고 반올림한 뒤, 다시 100으로 나눔
		String result = String.format("%.2f", ans); 
		System.out.println(result);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
		int[][] wooju = new int[n+1][2];
		for (int i = 1; i <=n; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			wooju[i][0] = a;
			wooju[i][1] = b;
			
		}
		double[][] graph = new double[n*(n-1)/2][3];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		int idx =0;
		for(int i=1;i<n;i++) {
			for(int j=i+1;j<=n;j++) {
				graph[idx][0]=i;
				graph[idx][1]=j;
				graph[idx][2]=  Math.sqrt(Math.pow(wooju[i][0] - wooju[j][0], 2)+  Math.pow(wooju[i][1] - wooju[j][1], 2));
				idx++;
			}
		}
		 Arrays.sort(graph, (o1, o2) -> Double.compare(o1[2], o2[2]));
		kruskal(graph);
	}
}
