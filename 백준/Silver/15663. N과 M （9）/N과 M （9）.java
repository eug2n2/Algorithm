import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int[] arr;
	static ArrayList<Integer> nlist;

	static LinkedHashSet<String> ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ans = new LinkedHashSet<>();
		st = new StringTokenizer(bf.readLine());
		nlist = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			nlist.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(nlist);
		arr = new int[m];
		visited = new boolean[n];
		dfs(n, m, 0);
		ans.forEach(System.out::println);
	}

	public static void dfs(int n, int m, int depth) {
		if (depth == m) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < m; i++) {
				sb.append(arr[i] + " ");
			}
			ans.add(sb.toString());
			return;
		}
		for (int i = 0; i < nlist.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = nlist.get(i);
				dfs(n, m, depth + 1);
				visited[i] = false;
			}
		}

	}
}
