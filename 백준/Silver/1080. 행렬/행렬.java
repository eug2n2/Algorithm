import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		// 입력 받은 숫자
		int n = Integer.parseInt(st.nextToken()); // 크기
		int m = Integer.parseInt(st.nextToken()); // 크기
		int[][] amap = new int[n][m];
		int[][] bmap = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				amap[i][j] = str.charAt(j) - '0';
			}
		}
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				bmap[i][j] = str.charAt(j) - '0';
			}
		}

		int answer = 0;
		for (int i = 0; n > 2 && i < n - 2; i++) {
			for (int j = 0; m > 2 && j < m - 2; j++) {
				if (amap[i][j] != bmap[i][j]) {
					answer++;
					for (int x = i; x < i + 3; x++) {
						for (int y = j; y < j + 3; y++) {
							amap[x][y] = amap[x][y] == 1 ? 0 : 1;
						}
					}
				}
			}
		}
		out: for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (amap[i][j] != bmap[i][j]) {
					answer = -1;
					break out;
				}
			}
		}

		System.out.println(answer);
	}
}