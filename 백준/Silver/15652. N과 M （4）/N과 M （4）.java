import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static StringBuilder sb = new StringBuilder();;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[m];
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

			if (depth == 0) {
				arr[depth] = i + 1;
				dfs(n, m, depth + 1);
			} else if (arr[depth - 1] <= i + 1) {
				arr[depth] = i + 1;
				dfs(n, m, depth + 1);
			}
		}

	}
}
