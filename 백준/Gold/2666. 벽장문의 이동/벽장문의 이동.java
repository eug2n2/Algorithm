import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int k;
	static int n;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine()); // 슛자 개수
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		max = Integer.MAX_VALUE;
		k = Integer.parseInt(bf.readLine());
		arr = new int[k];
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		if (a > b) {
			dfs(0, 0, b, a);
		} else {
			dfs(0, 0, a, b);
		}
		System.out.println(max);

	}

	public static void dfs(int cnt, int ans, int ld, int rd) {
		if (cnt == k) {
			if (max > ans) {
				max = ans;
			}
			return;
		}

		int num = arr[cnt];
		if (ld <= num && num <= rd) {
			int tmp = ans + num-ld;
			dfs(cnt + 1, tmp, num, rd);
			tmp =ans + rd-num;
			dfs(cnt + 1, tmp, ld, num);
		} else if (num < ld) {
			int tmp = ans + ld - num;
			dfs(cnt + 1,tmp, num, rd);
		} else if (rd < num) {
			int tmp =ans + num - rd;
			dfs(cnt + 1, tmp, ld, num);
		}

	}
}