import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class marble {
	int cnt;
	char[][] map;
	int rx;
	int ry;
	int bx;
	int by;

	marble(int cnt, char[][] map, int rx, int ry, int bx, int by) {
		this.cnt = cnt;
		this.map = map;
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
	}
}

public class Main {
	static int ans;
	static int n;
	static int m;
	static int bluex, bluey, redx, redy;
	static char[][] map;
	static boolean[][][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		ans = Integer.MAX_VALUE;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[10][10][10][10];

		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'B') {
					bluex = i;
					bluey = j;
				} else if (map[i][j] == 'R') {
					redx = i;
					redy = j;
				}
			}
		}
		bfs();
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}

//bd: before direction
	public static void bfs() {
		Queue<marble>  pq = new ArrayDeque<>();
		pq.add(new marble(1, map, redx, redy, bluex, bluey));
		visited[redx][redy][bluex][bluey] = true;
		while (!pq.isEmpty()) {
			marble p = pq.poll(); 
			for (int di = 0; di < 4; di++) {
				char[][] copyarr = deepCopy(p.map);
				copyarr[p.rx][p.ry] = '.';
				copyarr[p.bx][p.by] = '.';
				
				boolean avail = true; // 파랑 구슬 들어가는지 안들어가는지 여부
				boolean answer = false; // 정답인가요?
				switch (di) {
				case 0: // 상 #이 닿을때까지 행을 줄여가며 이동하면된다
			
					int idx = p.rx - 1; // red 이동 (rx변경하면 다른 di 에서 문제 생기니까 금지 )
					int bidx = p.bx - 1; // blue 이동
					if (p.rx > p.bx && p.by == p.ry) { // bx가 더 위에 있으니까 bx먼저 이동시켜줘야함
						while (true) { // blue가 더 위에있으므로 blue구슬 먼저 처리할게용
							if (bidx < 0) {
								bidx = 0;
								copyarr[0][p.by] = 'B';
								break;
							} else if (copyarr[bidx][p.by] == '#') {
								bidx++;
								copyarr[bidx][p.by] = 'B';
								break;
							} else if (copyarr[bidx][p.by] == 'O') {
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
								copyarr[0][p.ry] = 'R';
								break;
							} else if (copyarr[idx][p.ry] == '#' || copyarr[idx][p.ry] == 'B') {
								idx++;
								copyarr[idx][p.ry] = 'R';
								break;
							} else if (copyarr[idx][p.ry] == 'O') {
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
								copyarr[0][p.ry] = 'R';
								break;
							} else if (copyarr[idx][p.ry] == '#') {
								idx++;
								copyarr[idx][p.ry] = 'R';
								break;
							} else if (copyarr[idx][p.ry] == 'O') {
								answer = true;
								break;
							} else {
								idx--;
							}
						}

						while (true) {
							if (bidx < 0) {
								bidx = 0;
								copyarr[0][p.by] = 'B';
								break;
							} else if (copyarr[bidx][p.by] == '#' || copyarr[bidx][p.by] == 'R') {
								bidx++;
								copyarr[bidx][p.by] = 'B';
								break;
							} else if (copyarr[bidx][p.by] == 'O') {
								avail = false;
								answer = false;
								break;
							} else {
								bidx--;
							}
						}
					}
					if (answer) {
						ans = Math.min(ans,p.cnt);
						break;
					} else if (!avail) {
						break;
					} else if (!visited[idx][p.ry][bidx][p.by]) {
						visited[idx][p.ry][bidx][p.by]=true;
						pq.add (new marble(p.cnt + 1, copyarr, idx, p.ry, bidx, p.by));
					}
					break;
				// 하
				case 1:
					idx = p.rx + 1;
					bidx =p.bx + 1;
					if (p.rx < p.bx && p.by == p.ry) { // bx가 더 아래 에 있으니까 bx먼저 이동시켜줘야함
						while (true) { // blue가 더 아래에있으므로 blue구슬 먼저 처리할게용
							if (bidx == n) {
								bidx = n - 1;
								copyarr[bidx][p.by] = 'B';
								break;
							} else if (copyarr[bidx][p.by] == '#') {
								bidx--;
								copyarr[bidx][p.by] = 'B';
								break;
							} else if (copyarr[bidx][p.by] == 'O') {
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
								copyarr[idx][p.ry] = 'R';
								break;
							} else if (copyarr[idx][p.ry] == '#' || copyarr[idx][p.ry] == 'B') {
								idx--;
								copyarr[idx][p.ry] = 'R';
								break;
							} else if (copyarr[idx][p.ry] == 'O') {
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
								copyarr[idx][p.ry] = 'R';
								break;
							} else if (copyarr[idx][p.ry] == '#') {
								idx--;
								copyarr[idx][p.ry] = 'R';
								break;
							} else if (copyarr[idx][p.ry] == 'O') {
								answer = true;
								break;
							} else {
								idx++;
							}
						}

						while (true) {
							if (bidx == n) {
								bidx = n - 1;
								copyarr[bidx][p.by] = 'B';
								break;
							} else if (copyarr[bidx][p.by] == '#' || copyarr[bidx][p.by] == 'R') {
								bidx--;
								copyarr[bidx][p.by] = 'B';
								break;
							} else if (copyarr[bidx][p.by] == 'O') {
								avail = false;
								answer = false;
								break;
							} else {
								bidx++;
							}
						}
					}
					if (answer) {
						ans = Math.min(ans,p.cnt);
						break;
					} else if (!avail) {
						break;
					} else if (!visited[idx][p.ry][bidx][p.by]) {
						visited[idx][p.ry][bidx][p.by]= true;
						pq.add(new marble(p.cnt + 1, copyarr, idx, p.ry, bidx, p.by));

					}
					break;
				case 2:
					idx = p.ry - 1; // red 이동 (rx변경하면 다른 di 에서 문제 생기니까 금지 )
					bidx = p.by - 1; // blue 이동
					if (p.ry > p.by && p.bx == p.rx) { // by가 더 왼쪽에 있으니까 by먼저 이동시켜줘야함
						while (true) {
							if (bidx < 0) {
								bidx = 0;
								copyarr[p.bx][0] = 'B';
								break;
							} else if (copyarr[p.bx][bidx] == '#') {
								bidx++;
								copyarr[p.bx][bidx] = 'B';
								break;
							} else if (copyarr[p.bx][bidx] == 'O') {
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
								copyarr[p.rx][0] = 'R';
								break;
							} else if (copyarr[p.rx][idx] == '#' || copyarr[p.rx][idx] == 'B') {
								idx++;
								copyarr[p.rx][idx] = 'R';
								break;
							} else if (copyarr[p.rx][idx] == 'O') {
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
								copyarr[p.rx][0] = 'R';
								break;
							} else if (copyarr[p.rx][idx] == '#') {
								idx++;
								copyarr[p.rx][idx] = 'R';
								break;
							} else if (copyarr[p.rx][idx] == 'O') {
								answer = true;
								break;
							} else {
								idx--;
							}
						}

						while (true) {
							if (bidx < 0) {
								bidx = 0;
								copyarr[p.bx][0] = 'B';
								break;
							} else if (copyarr[p.bx][bidx] == '#' || copyarr[p.bx][bidx] == 'R') {
								bidx++;
								copyarr[p.bx][bidx] = 'B';
								break;
							} else if (copyarr[p.bx][bidx] == 'O') {
								avail = false;
								answer = false;
								break;
							} else {
								bidx--;
							}
						}
					}
					if (answer) {
						ans = Math.min(ans,p.cnt);
						break;
					} else if (!avail) {
						break;
					} else if (!visited[p.rx][idx][p.bx][bidx]) {
						visited[p.rx][idx][p.bx][bidx]= true;
						pq.add(new marble(p.cnt + 1, copyarr, p.rx, idx, p.bx, bidx));

					}
					break;
				case 3:
					idx = p.ry + 1; // red 이동 (rx변경하면 다른 di 에서 문제 생기니까 금지 )
					bidx = p.by + 1; // blue 이동
					if (p.ry < p.by && p.bx == p.rx) { // by가 더 오른쪽에 있으니까 by먼저 이동시켜줘야함
						while (true) {
							if (bidx == m) {
								bidx = m - 1;
								copyarr[p.bx][bidx] = 'B';
								break;
							} else if (copyarr[p.bx][bidx] == '#') {
								bidx--;
								copyarr[p.bx][bidx] = 'B';
//							System.out.println("# 을 만났어용 블루가 right ");
								break;
							} else if (copyarr[p.bx][bidx] == 'O') {
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
								copyarr[p.rx][idx] = 'R';
								break;
							} else if (copyarr[p.rx][idx] == '#' || copyarr[p.rx][idx] == 'B') {
								idx--;
								copyarr[p.rx][idx] = 'R';
								break;
							} else if (copyarr[p.rx][idx] == 'O') {
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
								copyarr[p.rx][idx] = 'B';
								break;
							} else if (copyarr[p.rx][idx] == '#') {
								idx--;
								copyarr[p.rx][idx] = 'R';
								break;
							} else if (copyarr[p.rx][idx] == 'O') {
								answer = true;
								break;
							} else {
								idx++;
							}
						}
						while (true) {
							if (bidx == m) {
								bidx = m - 1;
								copyarr[p.bx][bidx] = 'B';
								break;
							} else if (copyarr[p.bx][bidx] == '#' || copyarr[p.bx][bidx] == 'R') {
								bidx--;
								copyarr[p.bx][bidx] = 'B';
								break;
							} else if (copyarr[p.bx][bidx] == 'O') {
								avail = false;
								answer = false;
								break;
							} else {
								bidx++;
							}
						}
					}
					if (answer) {
						ans = Math.min(ans,p.cnt);
						break;
					} else if (!avail) {
						break;
					} else if (!visited[p.rx][idx][p.bx][bidx]) {
						visited[p.rx][idx][p.bx][bidx]= true;
						pq.add(new marble(p.cnt + 1, copyarr, p.rx, idx,p.bx, bidx));					
					}
					break;
				}
			}
		}
	}
	public static char[][] deepCopy(char[][] original) {
	    if (original == null) return null;
	    
	    final char[][] result = new char[n][];
	    for (int i = 0; i <n; i++) {
	        result[i] = Arrays.copyOf(original[i], original[i].length);
	    }
	    return result;
	}

}
