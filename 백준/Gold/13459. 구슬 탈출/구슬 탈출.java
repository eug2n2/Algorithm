import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean ans;
	static int n;
	static int m;
	static int hx; // hole x
	static int hy;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		ans = false;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		char[][] map = new char[n][m];
		int bx = 0;
		int by = 0;
		int rx = 0;
		int ry = 0;
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'B') {
					bx = i;
					by = j;
				} else if (map[i][j] == 'R') {
					rx = i;
					ry = j;
				} else if (map[i][j] == 'O') {
					hx = i;
					hy = j;
				}
			}
		}
		dfs(1, map, rx, ry, bx, by, 5);
		
		System.out.println(ans==false?0:1);
	}

//bd: before direction
	public static void dfs(int cnt, char[][] map, int rx, int ry, int bx, int by, int bd) {
		if (cnt ==11) {
			return;
		}
		if (ans) {
			return;
		}
		char[][] copyarr = new char[n][m];

		for (int di = 0; di < 4; di++) {
			for (int i = 0; i < n; i++) {
				copyarr[i] = map[i].clone();
			}
			copyarr[rx][ry] = '.';
			copyarr[bx][by] = '.';
			boolean avail = true; // 파랑 구슬 들어가는지 안들어가는지 여부
			boolean answer = false; // 정답인가요?
			switch (di) {
			case 0: // 상 #이 닿을때까지 행을 줄여가며 이동하면된다
				if (bd == 0 || bd == 1)
					break;
				int idx = rx - 1; // red 이동 (rx변경하면 다른 di 에서 문제 생기니까 금지 )
				int bidx = bx - 1; // blue 이동
				if (rx > bx && by == ry) { // bx가 더 위에 있으니까 bx먼저 이동시켜줘야함
					while (true) { // blue가 더 위에있으므로 blue구슬 먼저 처리할게용
						if (bidx < 0) {
							bidx = 0;
							copyarr[0][by] = 'B';
							break;
						} else if (copyarr[bidx][by] == '#') {
							bidx++;
							copyarr[bidx][by] = 'B';
							break;
						} else if (copyarr[bidx][by] == 'O') {
							avail = false;
							answer = false;
							break;
						} else {
							bidx--;
						}
					}
					while (avail) {
						if (idx < 0) {
							idx = 0;
							copyarr[0][ry] = 'R';
							break;
						} else if (copyarr[idx][ry] == '#' || copyarr[idx][ry] == 'B') {
							idx++;
							copyarr[idx][ry] = 'R';
							break;
						} else if (copyarr[idx][ry] == 'O') {
							answer = true;
							break;
						} else {
							idx--;
						}
					}

				} else { // rx가 더 위에 있으니 괜찮습니다. ^^:

					while (true) {
						if (idx < 0) {
							idx = 0;
							copyarr[0][ry] = 'R';
							break;
						} else if (copyarr[idx][ry] == '#') {
							idx++;
							copyarr[idx][ry] = 'R';
							break;
						} else if (copyarr[idx][ry] == 'O') {
							answer = true;
							break;
						} else {
							idx--;
						}
					}

					while (true) {
						if (bidx < 0) {
							bidx = 0;
							copyarr[0][by] = 'B';
							break;
						} else if (copyarr[bidx][by] == '#' || copyarr[bidx][by] == 'R') {
							bidx++;
							copyarr[bidx][by] = 'B';
							break;
						} else if (copyarr[bidx][by] == 'O') {
							avail = false;
							answer = false;
							break;
						} else {
							bidx--;
						}
					}
				}
				if (answer) {
					ans=true;
					break;
				} else if (!avail) {
					break;
				} else {
//					System.out.println(idx + " 상 " + ry + " " + bidx + " " + by);
					dfs(cnt + 1, copyarr, idx, ry, bidx, by, di);

				}
				break;
				// 하
			case 1:
				if (bd == 0 || bd == 1)
					break;
				idx = rx + 1;
				bidx = bx + 1;
				if (rx < bx && by == ry) { // bx가 더 아래 에 있으니까 bx먼저 이동시켜줘야함
					while (true) { // blue가 더 아래에있으므로 blue구슬 먼저 처리할게용
						if (bidx == n) {
							bidx = n - 1;
							copyarr[bidx][by] = 'B';
							break;
						} else if (copyarr[bidx][by] == '#') {
							bidx--;
							copyarr[bidx][by] = 'B';
							break;
						} else if (copyarr[bidx][by] == 'O') {
							avail = false;
							answer = false;
							break;
						} else {
							bidx++;
						}
					}
					while (avail) {
						if (idx == n) {
							idx = n - 1;
							copyarr[idx][ry] = 'R';
							break;
						} else if (copyarr[idx][ry] == '#' || copyarr[idx][ry] == 'B') {
							idx--;
							copyarr[idx][ry] = 'R';
							break;
						} else if (copyarr[idx][ry] == 'O') {
							answer = true;
							break;
						} else {
							idx++;
						}
					}

				} else { // rx가 더 아래에 있으니 괜찮습니다. ^^:

					while (true) {
						if (idx == n) {
							idx = n - 1;
							copyarr[idx][ry] = 'R';
							break;
						} else if (copyarr[idx][ry] == '#') {
							idx--;
							copyarr[idx][ry] = 'R';
							break;
						} else if (copyarr[idx][ry] == 'O') {
							answer = true;
							break;
						} else {
							idx++;
						}
					}

					while (true) {
						if (bidx == n) {
							bidx = n - 1;
							copyarr[bidx][by] = 'B';
							break;
						} else if (copyarr[bidx][by] == '#' || copyarr[bidx][by] == 'R') {
							bidx--;
							copyarr[bidx][by] = 'B';
							break;
						} else if (copyarr[bidx][by] == 'O') {
							avail = false;
							answer = false;
							break;
						} else {
							bidx++;
						}
					}
				}
				if (answer) {
					ans=true;
					break;
				} else if (!avail) {
					break;
				} else {
					dfs(cnt + 1, copyarr, idx, ry, bidx, by, di);

				}
				break;
			case 2:
				if (bd == 2 || bd == 3)
					break;
				idx = ry - 1; // red 이동 (rx변경하면 다른 di 에서 문제 생기니까 금지 )
				bidx = by - 1; // blue 이동
				if (ry > by && bx == rx) { // by가 더 왼쪽에 있으니까 by먼저 이동시켜줘야함
					while (true) {
						if (bidx < 0) {
							bidx = 0;
							copyarr[bx][0] = 'B';
							break;
						} else if (copyarr[bx][bidx] == '#') {
							bidx++;
							copyarr[bx][bidx] = 'B';
							break;
						} else if (copyarr[bx][bidx] == 'O') {
							avail = false;
							answer = false;
							break;
						} else {
							bidx--;
						}
					}
					while (avail) {
						if (idx < 0) {
							idx = 0;
							copyarr[rx][0] = 'R';
							break;
						} else if (copyarr[rx][idx] == '#' || copyarr[rx][idx] == 'B') {
							idx++;
							copyarr[rx][idx] = 'R';
							break;
						} else if (copyarr[rx][idx] == 'O') {
							answer = true;
							break;
						} else {
							idx--;
						}
					}

				} else { // ry가 더 왼쪽에 있으니 괜찮습니다. ^^:

					while (true) {
						if (idx < 0) {
							idx = 0;
							copyarr[rx][0] = 'R';
							break;
						} else if (copyarr[rx][idx] == '#') {
							idx++;
							copyarr[rx][idx] = 'R';
							break;
						} else if (copyarr[rx][idx] == 'O') {
							answer = true;
							break;
						} else {
							idx--;
						}
					}

					while (true) {
						if (bidx < 0) {
							bidx = 0;
							copyarr[bx][0] = 'B';
							break;
						} else if (copyarr[bx][bidx] == '#' || copyarr[bx][bidx] == 'R') {
							bidx++;
							copyarr[bx][bidx] = 'B';
							break;
						} else if (copyarr[bx][bidx] == 'O') {
							avail = false;
							answer = false;
							break;
						} else {
							bidx--;
						}
					}
				}
				if (answer) {
					ans=true;
					break;
				} else if (!avail) {
					break;
				} else {
//					System.out.println(rx + " " + idx + " " + bx + " 좌  " + bidx);
					dfs(cnt + 1, copyarr, rx, idx, bx, bidx, di);

				}
				break;
			case 3:
				if (bd == 2 || bd == 3)
					break;
				idx = ry + 1; // red 이동 (rx변경하면 다른 di 에서 문제 생기니까 금지 )
				bidx = by + 1; // blue 이동
				if (ry < by && bx == rx) { // by가 더 오른쪽에 있으니까 by먼저 이동시켜줘야함
					while (true) {
						if (bidx == m) {
							bidx = m - 1;
							copyarr[bx][bidx] = 'B';
							break;
						} else if (copyarr[bx][bidx] == '#') {
							bidx--;
							copyarr[bx][bidx] = 'B';
//							System.out.println("# 을 만났어용 블루가 right ");
							break;
						} else if (copyarr[bx][bidx] == 'O') {
							avail = false;
							answer = false;
							break;
						} else {
							bidx++;
						}
					}
					while (avail) {
						if (idx == m) {
							idx = m - 1;
							copyarr[rx][idx] = 'R';
							break;
						} else if (copyarr[rx][idx] == '#' || copyarr[rx][idx] == 'B') {
							idx--;
							copyarr[rx][idx] = 'R';
							break;
						} else if (copyarr[rx][idx] == 'O') {
							answer = true;
							break;
						} else {
							idx++;
						}
					}

				} else { // ry가 더 오른쪽에 있으니 괜찮습니다. ^^:

					while (true) {
						if (idx == m) {
							idx = m - 1;
							copyarr[rx][idx] = 'B';
							break;
						} else if (copyarr[rx][idx] == '#') {
							idx--;
							copyarr[rx][idx] = 'R';
							break;
						} else if (copyarr[rx][idx] == 'O') {
							answer = true;
							break;
						} else {
							idx++;
						}
					}

					while (true) {
						if (bidx == m) {
							bidx = m - 1;
							copyarr[bx][bidx] = 'B';
							break;
						} else if (copyarr[bx][bidx] == '#' || copyarr[bx][bidx] == 'R') {
							bidx--;
							copyarr[bx][bidx] = 'B';
							break;
						} else if (copyarr[bx][bidx] == 'O') {
							avail = false;
							answer = false;
							break;
						} else {
							bidx++;
						}
					}
				}
				if (answer) {
					ans=true;
					break;
				} else if (!avail) {
					break;
				} else {
					dfs(cnt + 1, copyarr, rx, idx, bx, bidx, di);
				}
				break;
			}
		}
	}
}
