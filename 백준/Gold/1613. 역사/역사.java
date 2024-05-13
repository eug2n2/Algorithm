import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n + 1][n + 1];
		for (int q = 0; q < k; q++) {
			st = new StringTokenizer(bf.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			arr[i][j] = 1;
		}
		int s = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();

		for (int q = 1; q <= n; q++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (arr[i][j] == 1 || i == j)
						continue;
					if (arr[i][q] > 0 && arr[q][j] > 0) {
						arr[i][j] = 1;
					}
				}

			}
		}
		for (int q = 1; q <= s; q++) {
			st = new StringTokenizer(bf.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			if (arr[i][j] == 1) {
				sb.append(-1).append("\n");
			}else if (arr[j][i]==1) {
				sb.append(1).append("\n");
			}else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);

	}

}