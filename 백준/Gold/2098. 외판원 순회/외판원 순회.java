import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[][] dp;
	static int n;
	static int INF = 16000001;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());// 정점개수
		map = new int[n][n];
		dp = new int[n][1 << n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			Arrays.fill(dp[i], -1); 	// 이걸 안하면 진짜 거리가 0인거랑 방문안한거랑 구별이 안가용
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dfs(0, 1 << 0));
	}

	public static int dfs(int start, int visited) {
		if (visited == (1 << n) - 1) {
			if (map[start][0] == 0)
				return INF;
			return map[start][0];
		}

		if (dp[start][visited] != -1)
			return dp[start][visited]; // 또 계산 해줄 필요가 없다.
		
		dp[start][visited] = INF; // 방문처리 
		// 방문안한 도시 탐색
		for (int i = 1; i < n; i++) {
			// 갈 수없거나 이미 방문했다면 skip
			if (map[start][i] == 0 || (visited & (1 << i)) > 0)
				continue;
			dp[start][visited] = Math.min(dp[start][visited], (dfs(i, visited |(1 << i)) + map[start][i]));
		}
		return dp[start][visited];
	}
}
