import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static boolean[][][] visited;
	static boolean[] ansvisited;
	static int asize, bsize, csize;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		asize = Integer.parseInt(st.nextToken());
		bsize = Integer.parseInt(st.nextToken());
		csize = Integer.parseInt(st.nextToken());
		visited = new boolean[asize + 1][bsize + 1][csize + 1];
		ansvisited = new boolean[csize + 1];
		dfs(0, 0, csize);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < csize + 1; i++) {
			if (ansvisited[i])
				sb.append(i).append(" ");

		}
		System.out.println(sb);
	}

	public static void dfs(int a, int b, int c) {
		if (a == 0 && !ansvisited[c]) {
			ansvisited[c] = true;
			visited[a][b][c] = true;
		} else if (a != 0) {
			if (a + b <= bsize && !visited[0][a + b][c]) {
				visited[0][a + b][c] = true;
				dfs(0, a + b, c);
			}
			if (a + b > bsize && b < bsize && !visited[a - (bsize - b)][bsize][c]) {
				visited[a - (bsize - b)][bsize][c] = true;
				dfs(a - (bsize - b), bsize, c);
			}
			if (a + c <= csize && !visited[0][b][a + c]) {
				visited[0][b][a + c] = true;
				dfs(0, b, a + c);
			}
		}
		if (b != 0) {
			if (b + a <= asize && !visited[a + b][0][c]) {
				visited[a + b][0][c] = true;
				dfs(a + b, 0, c);
			}
			if (b + a > asize && a < asize && !visited[asize][b - (asize - a)][c]) {
				visited[asize][b - (asize - a)][c] = true;
				dfs(asize, b - (asize - a), c);
			}
			if (b + c <= csize && !visited[a][0][b + c]) {
				visited[a][0][b + c] = true;
				dfs(a, 0, b + c);
			}
		}
		if (c != 0) {
			if (a + c <= asize && !visited[a + c][b][0]) {
				visited[a + c][b][0] = true;
				dfs(a + c, b, 0);
			}
			if (a + c > asize && a < asize && !visited[asize][b][c - (asize - a)]) {
				visited[asize][b][c - (asize - a)] = true;
				dfs(asize, b, c - (asize - a));
			}
			if (b + c <= bsize && !visited[0][b][a + c]) {
				visited[0][b][a + c] = true;
				dfs(0, b, a + c);
			}
			if (b+c>bsize && b < bsize && !visited[a][bsize][c - (bsize - b)]) {
				visited[a][bsize][c - (bsize - b)] = true;
				dfs(a, bsize, c - (bsize - b));
			}
		}

	}
}