import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static HashSet<Integer> set0;
	static HashSet<Integer> set1;
	static ArrayList<Integer>[] graph;
	static String ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			visited = new boolean[v+1];
			set1 = new HashSet<>();
			set0 = new HashSet<>();
			graph = new ArrayList[v + 1];
			for (int i = 1; i <= v; i++) {
				graph[i] = new ArrayList<>();
			}
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a].add(b);
				graph[b].add(a);
				
			}
			ans = "YES";
			for(int i =1;i<=v;i++) {
				if(!visited[i] && ans.equals("YES")) {
					dfs(i,0);
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int point, int group) {
		if(ans.equals("NO")) return;
		visited[point]=true;
		if(group==0) {
			set0.add(point);
		}else {
			set1.add(point);
		}
		for (int i=0; i<graph[point].size();i++) {
			int tmp =graph[point].get(i);
			if(!visited[tmp]) {
				dfs(tmp,1-group);
			}else {
				if(group==0 && set0.contains(tmp)) {
					ans ="NO";
					return;
				}else if (group==1 && set1.contains(tmp)) {
					ans ="NO";
					return;
				}
			}
		}
	}
}
