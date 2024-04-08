import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[][] arr = new int[4][n];
		int size = n * n;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 4; j++) {
				arr[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		long ans = 0;
		int[] left = new int[size];
		int[] right = new int[size];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				left[idx] = arr[0][i] + arr[1][j];
				right[idx] = arr[2][i] + arr[3][j];
				idx++;
			}
		}
		Arrays.sort(left);
		Arrays.sort(right);
		int start = 0;
		int end = size - 1;
		while (start < size && end >= 0) {
			int tmp = left[start] + right[end];
			if (tmp == 0) {
				int l = left[start];
				int r = right[end];
				long cnt1 = 0;
				long cnt2 = 0;
				while (start < size && l == left[start]) {
					start++;
					cnt1++;
				}
				while (end >= 0 && r == right[end]) {
					end--;
					cnt2++;
				}
				ans += cnt1 * cnt2;
			} else if (tmp > 0) {
				end--;
			} else {
				start++;
			}
		}

		System.out.println(ans);
	}

}
