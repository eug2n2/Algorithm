import java.io.*;
import java.util.*;

class Main {
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9][9];
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);
	}

	public static void dfs(int cnt, int col) {
		if (col == 9) {
			dfs(cnt + 1, 0);
			return;
		}
		if (cnt == 9) { // 행
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(arr[i][j]+" "); 
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0); // 답이 여러개나오는 경우, 무한루프 
		}
		if (arr[cnt][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (check(cnt, col, i)) {
					arr[cnt][col] = i;
					dfs(cnt, col + 1);
					arr[cnt][col]=0;
				}
			}
		} else {
			dfs(cnt, col + 1);
		}
	}

	public static boolean check(int row, int col, int value) {
		for (int i = 0; i < 9; i++) {
			if (arr[i][col] == value) {
				return false;
			}
		}
		for (int i = 0; i < 9; i++) {
			if (arr[row][i] == value) {
				return false;
			}
		}

		int sx = (row / 3) * 3;
		int sy = (col / 3) * 3;
		for (int i = sx; i < sx + 3; i++) {
			for (int j = sy; j < sy + 3; j++) {
				if (arr[i][j] == value) {
					return false;
				}
			}
		}

		return true;
	}
}