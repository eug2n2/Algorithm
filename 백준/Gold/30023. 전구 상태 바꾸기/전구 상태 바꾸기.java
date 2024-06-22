import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static boolean avail;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		String s = bf.readLine();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'R') {
				a[i] = 0;
			} else if (s.charAt(i) == 'G') {
				a[i] = 1;
			} else {
				a[i] = 2;
			}
		}
		int answer = Integer.MAX_VALUE;

		// 시작 경우의 수는 3가지
		for (int i = 0; i < 3; i++) {
			avail = false;
			int tmp =solve(a.clone(), n);
			if (avail) {
				answer = Math.min(answer,tmp + i);
			}
			for (int j = 0; j < 3; j++) {
				a[j]++;
				if (a[j] == 3) {
					a[j] = 0;
				}
			}
		}

		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);

	}

	private static int solve(int[] arr, int n) {
		int count = 0;
		for (int i = 1; i < n - 2; i++) {
			while (arr[0] != arr[i]) {
				count++;
				for (int j = i; j < (i + 3); j++) {
					arr[j]++;
					if (arr[j] == 3) {
						arr[j] = 0;
					}
				}
			}
		}
		if (arr[0] == arr[n - 1] && arr[0] == arr[n - 2]) {
			avail = true;
			return count;
		}
		return 0;
	}
}