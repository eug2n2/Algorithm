import java.io.*;
import java.util.*;

public class Main {
static int[][] map,dp;
static int m,n;
    static int[] rangeX = { -1, 0, 1, 0 };
    static int[] rangeY = { 0, 1, 0, -1 };
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m+1][n+1];
        for(int i =1; i <= m; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j =1; j <= n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[m+1][n+1]; // (x, y)에서 도착점으로 가는 경로의 개수
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(1,1));

    }

    public static int dfs(int x, int y) {
        if (x == m && y == n) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0; // 현재 위치에서 끝점까지 도달하는 경로의 개수를 0으로 초기화.
        for (int i = 0; i < 4; i++) {
            int dx = x + rangeX[i];
            int dy = y + rangeY[i];

            if (dx < 1 || dy < 1 || dx > m || dy > n) {
                continue;
            }

            if (map[x][y] > map[dx][dy]) { // 내리막길만 이용 가능
                dp[x][y] += dfs(dx, dy);
            }
        }

        return dp[x][y];
    }
}