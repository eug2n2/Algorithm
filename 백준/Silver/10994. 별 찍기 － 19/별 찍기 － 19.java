import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[][] map = new String[4 * n - 3][4 * n - 3]; // 등차수열 공식

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = " ";
			}
		}
		map[2 * n - 2][2 * n - 2] = "*";
		int start = 2 * n - 2;
		int end = 2 * n - 2;
		for (int i = 1; i < n; i++) {
			start = start - 2;
			end += 2;
			for (int j = start; j <= end; j++) {
				map[end][j] = "*";
				map[start][j] = "*";
				map[j][start] = "*";
				map[j][end] = "*";

			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4 * n - 3; i++) {

			for (int j = 0; j < 4 * n - 3; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
