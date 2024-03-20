import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] arr;
	static int ans = Integer.MAX_VALUE;
	static int total = 0; // 사람수 총합 ( 5구역에서 쓰려고 )

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				total += arr[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n; j++) {
				for (int d1 = 1; d1 < n; d1++) {
					for (int d2 = 1; d2 < n; d2++) {
//						System.out.println(i+" "+j+" "+ d1+" "+d2);
						if ((i + d1 + d2) < n && (j - d1) >= 0 && (j + d2) < n) {
							cal(i, j, d1, d2);
						}
					}
				}
			}
		}
		System.out.println(ans);
	}

	public static void cal(int x, int y, int d1, int d2) { //
		boolean[][] border = new boolean[n][n];
		int[] people = new int[5]; // 구역별 인구수
		for (int i = 0; i <= d1; i++) {
			border[x + i][y - i] = true; // 1
			border[x + d2 + i][y + d2 - i] = true; // 4
		}

		for (int i = 0; i <= d2; i++) {
			border[x + i][y + i] = true; // 2
			border[x + d1 + i][y - d1 + i] = true; // 3
		}
		// 구역별 인원수구하기 
		for (int i = 0; i < x + d1; i++) {
			for (int j = 0; j <= y; j++) {
				if (border[i][j])
					break;
				people[0] += arr[i][j];

			}
		}
		for (int i = 0; i <= x + d2; i++) {
			for (int j = n - 1; j > y; j--) {
				if (border[i][j])
					break;
				people[1] += arr[i][j];
			}
		}

		for (int i = x + d1; i < n; i++) {
			for (int j = 0; j < y - d1 + d2; j++) {
				if (border[i][j])
					break;
				people[2] += arr[i][j];
			}
		}

		for (int i = x + d2 + 1; i < n; i++) {
			for (int j = n - 1; j >= y - d1 + d2; j--) {
				if (border[i][j])
					break;
				people[3] += arr[i][j];
			}
		}

		// 5 구역
		people[4] = total;

		for (int i = 0; i < 4; i++) {
			people[4] -= people[i];
		}
		Arrays.sort(people);
		ans = Math.min(ans, people[4] - people[0]);
	}
}
