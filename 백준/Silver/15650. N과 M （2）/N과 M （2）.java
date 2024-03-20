import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[m];
		visited = new boolean[n];
		dfs(n, m, 0);
		System.out.println(sb);

	}

	public static void dfs(int n, int m, int depth) {
		if (depth == m) {
			for (int i = 0; i < m - 1; i++) {
				sb.append(arr[i] + " ");

			}
			sb.append(arr[m - 1] + "\n");
			return;
		}

		for (int i = 0; i < n; i++) {

			if (!visited[i] && depth == 0) {
				visited[i] = true;
				arr[depth] = i + 1;
				dfs(n, m, depth + 1);
				visited[i] = false;
			} else if (!visited[i] && arr[depth - 1] < i + 1) {
				visited[i] = true;
				arr[depth] = i + 1;
				dfs(n, m, depth + 1);
				visited[i] = false;
			}
		}

	}
}
