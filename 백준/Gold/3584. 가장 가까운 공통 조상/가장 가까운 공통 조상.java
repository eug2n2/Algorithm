import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(bf.readLine());
			parent = new int[n + 1];
			for (int i = 0; i <= n; i++) {
				parent[i] = i;
			}
			for (int i = 0; i < n - 1; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				parent[b] = a;
			}
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ArrayList<Integer> ap = new ArrayList<>();
			ArrayList<Integer> bp = new ArrayList<>();

			int x = a;
			while (true) {
				ap.add(x);
				if (parent[x] == x)
					break;
				else {
					x = parent[x];
				}
			}
			x = b;
			while (true) {
				bp.add(x);
				if (parent[x] == x)
					break;
				else {
					x = parent[x];
				}
			}
			x=a;
			while (true) {
				if (bp.contains(x)) {
					sb.append(x).append("\n");
					break;
				} else {
					x = parent[x];
				}
			}

		}
		System.out.println(sb);
	}

}
