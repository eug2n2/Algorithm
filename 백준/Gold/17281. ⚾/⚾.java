import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited = new boolean[9];
	static int[] tasun = new int[9]; // 타순 번호 써져있음
	static int[][] map;
	static int ans;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine()); // 이닝 수
		map = new int[n][9];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		visited[0] = true;
		dfs(0);
		System.out.println(ans);
	}

	public static void dfs(int cnt) {
		if (cnt == 9) {
			base();
			return;
		}
		for (int i = 1; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				tasun[cnt] = i;
				if (cnt + 1 == 3) {
					dfs(4);
				} else {
					dfs(cnt + 1);
				}
				visited[i] = false;

			}
		}
	}

	public static void base() {
		int tmp = 0;
		int one = -1;// 일루에 서있는 사람 번호
		int two = -1;
		int three = -1;
		int out = 0; // 3out이면 이닝 변경
		int inning = 0; // 1이닝
		run:while (true) {
			 for (int i = 0; i < 9; i++) {
				if (map[inning][tasun[i % 9]] == 0) {
					out++;
					if (out == 3) {
						out = 0;
						inning++;
						one =-1;
						two =-1;
						three=-1;
						if (inning == n) {
							break run;
						}
					}
				} else if (map[inning][tasun[i % 9]] == 1) {
					if (three != -1) {
						tmp++;
						three = -1;
					}
					if (two != -1) {
						three = two;
						two = -1;
					}
					if (one != -1) {
						two = one;
						one = -1;
					}
					one = tasun[i % 9];
				} else if (map[inning][tasun[i % 9]] == 2) {
					if (three != -1) {
						tmp++;
						three = -1;
					}
					if (two != -1) {
						tmp++;
						two = -1;
					}
					if (one != -1) {
						three = one;
						one = -1;
					}
					two = tasun[i % 9];
				} else if (map[inning][tasun[i % 9]] == 3) {
					if (three != -1) {
						tmp++;
						three = -1;
					}
					if (two != -1) {
						tmp++;
						two = -1;
					}
					if (one != -1) {
						tmp++;
						one = -1;
					}
					three = tasun[i % 9];
				} else if (map[inning][tasun[i % 9]] == 4) {
					if (three != -1) {
						tmp++;
						three = -1;
					}
					if (two != -1) {
						tmp++;
						two = -1;
					}
					if (one != -1) {
						tmp++;
						one = -1;
					}
					tmp++;
				}
			}
		}

		ans = Math.max(ans, tmp);
	}
}
