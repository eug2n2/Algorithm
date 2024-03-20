import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int ans = Integer.MAX_VALUE;
	static int[][] map;
	static int[] cp = { 0, 5, 5, 5, 5, 5 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0, 0);
		if (ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		System.out.println(ans);
	}

	public static void dfs(int xstart, int ystart, int cnt) {
		if (xstart >= 9 && ystart > 9) {
			ans = Math.min(ans, cnt);
			return;
		}
		if (ans <= cnt) {
			return;
		}
		if (ystart > 9) {
			dfs(xstart + 1, 0, cnt);
			return;
		}
		if (map[xstart][ystart] == 1) {
			for (int size = 5; size > 0; size--) {
				if (cp[size] > 0 && check(xstart, ystart, size)) {
					cp[size]--;
					attach(xstart, ystart, size, 0);
					dfs(xstart, ystart + 1, cnt + 1);
					cp[size]++;
					attach(xstart, ystart, size, 1);
				}
			}
		} else {
			dfs(xstart, ystart + 1, cnt);
		}
	}

	public static void attach(int x, int y, int size, int state) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				map[i][j] = state;
			}
		}
	}

	public static boolean check(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (i < 0 || i >= 10 || j < 0 || j >= 10 || map[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}
}
