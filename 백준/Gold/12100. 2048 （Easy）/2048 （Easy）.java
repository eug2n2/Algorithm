import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int ans;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		int[][] map = new int[n][n];
		ans = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (ans < map[i][j])
					ans = map[i][j];
			}
		}
		dfs(0, map, ans);
		System.out.println(ans);
	}

	public static void dfs(int cnt, int[][] map, int num) {
		if (cnt ==5) {
			ans = Math.max(ans, num);
			return;
		}
		int[] dx = new int[] { 0, 1, 2, 3 }; // 상하좌우
		for (int di = 0; di < 4; di++) {
			int[][] copy = new int[n][n];
			for (int i = 0; i < n; i++) {
				copy[i] = map[i].clone();
			}
			boolean[][] visited = new boolean[n][n];
			int tmp = num;
			switch (dx[di]) {
			case 0: // 상
				for (int i = 1; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if(copy[i][j]==0) continue;
						else if (copy[i - 1][j] == copy[i][j] ) {
							if (visited[i - 1][j])
								continue;
							copy[i - 1][j] = copy[i - 1][j] * 2;
							tmp = Math.max(copy[i - 1][j], tmp);
							copy[i][j] = 0;
							visited[i - 1][j] = true;
						} else  {
							int idx = i - 1;
							while (idx >= 0 && copy[idx][j] == 0) { // 공백 있으면 땡겨준다. 
								copy[idx][j] = copy[idx + 1][j];
								copy[idx + 1][j] = 0;
								idx--;
							}
							if (idx >= 0 && !visited[idx][j] && copy[idx][j] == copy[idx + 1][j]) {
								copy[idx][j] = copy[idx][j] * 2;
								copy[idx + 1][j] = 0;
								tmp = Math.max(copy[idx][j], tmp);
								visited[idx][j] = true;
								
							}
						}
					}
				}
				dfs(cnt + 1, copy, tmp);
				break;
			case 1: // 하
				for (int i = n - 2; i >= 0; i--) {
					for (int j = 0; j < n; j++) {
						if(copy[i][j]==0) continue;
						else if (copy[i + 1][j] == copy[i][j]) {
							if (visited[i + 1][j])
								continue;
							copy[i + 1][j] = copy[i + 1][j] * 2;
							tmp = Math.max(copy[i + 1][j], tmp);
							copy[i][j] = 0;
							visited[i + 1][j] = true;
						} else{
							int idx = i + 1;
							while (idx < n && copy[idx][j] == 0) {
								copy[idx][j] = copy[idx - 1][j];
								copy[idx - 1][j] = 0;
								idx++;
							}
							if (idx < n && !visited[idx][j] && copy[idx][j] == copy[idx - 1][j]) {
								copy[idx][j] = copy[idx][j] * 2;
								copy[idx - 1][j] = 0;
								tmp = Math.max(copy[idx][j], tmp);
								visited[idx][j] = true;
							}
						}
					}
				}
				dfs(cnt + 1, copy, tmp);
				break;
			case 2: // 좌
				for (int i = 0; i < n; i++) {
					for (int j = 1; j < n; j++) {
						if(copy[i][j]==0) continue;
						else if (copy[i][j - 1] == copy[i][j]) {
							if (visited[i][j - 1])
								continue;
							copy[i][j - 1] = copy[i][j - 1] * 2;
							tmp = Math.max(copy[i][j - 1], tmp);
							copy[i][j] = 0;
							visited[i][j - 1] = true;
						} else {
							int idx = j - 1;
							while (idx >= 0 && copy[i][idx] == 0) {
								copy[i][idx] = copy[i][idx + 1];
								copy[i][idx + 1] = 0;
								idx--;
							}

							if (idx >= 0 && !visited[i][idx] && copy[i][idx] == copy[i][idx + 1]) {
								copy[i][idx] = copy[i][idx] * 2;
								copy[i][idx + 1] = 0;
								tmp = Math.max(copy[i][idx], tmp);
								visited[i][idx] = true;
							}
						}
					}
				}

				dfs(cnt + 1, copy, tmp);
				break;
			case 3:
				for (int i = 0; i < n; i++) {
					for (int j = n - 2; j >= 0; j--) {
						if(copy[i][j]==0) continue;
						else if (copy[i][j + 1] == copy[i][j]) {
							if (visited[i][j + 1])
								continue;
							copy[i][j + 1] = copy[i][j + 1] * 2;
							tmp = Math.max(copy[i][j + 1], tmp);
							copy[i][j] = 0;
							visited[i][j + 1] = true;
						} else {
							int idx = j + 1;
							while (idx < n && copy[i][idx] == 0) {
								copy[i][idx] = copy[i][idx - 1];
								copy[i][idx - 1] = 0;
								idx++;
							}
							if (idx < n && !visited[i][idx] && copy[i][idx] == copy[i][idx - 1]) {
								copy[i][idx] = copy[i][idx] * 2;
								copy[i][idx - 1] = 0;
								tmp = Math.max(copy[i][idx], tmp);
								visited[i][idx] = true;
							}
						}

					}
				}
				dfs(cnt + 1, copy, tmp);
				break;
			}
		}

	}
}
