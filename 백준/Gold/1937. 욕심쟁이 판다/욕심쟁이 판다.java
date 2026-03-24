import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map, dp;
    static int n, ans;
    // 상하좌우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int count;

    // count : 이동한 칸의 수
    public static void bfs(int i, int j, int[][] visited, int tmp) {
        count = Math.max(count, tmp);
        for (int k = 0; k < 4; k++) {
            if ((dp[i][j] & (1 << k)) == 0) {
                continue;
            }
            int di = dx[k] + i;
            int dj = dy[k] + j;
            if (visited[di][dj] == 0) {
                bfs(di, dj, visited, tmp + 1);
            } else {
                count = Math.max(count, tmp + visited[di][dj]);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        ans = 0; // 판다가 이동할 수 있는 최대 칸의 수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                pq.offer(new int[]{tmp, i, j});
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = map[i][j];
                for (int k = 0; k < 4; k++) {
                    int di = dx[k] + i;
                    int dj = dy[k] + j;

                    // 범위
                    if (di < 0 || dj < 0 || di >= n || dj >= n) {
                        continue;
                    }
                    if (tmp < map[di][dj]) {
                        dp[i][j] |= 1 << k;

                    }

                }
            }
        }
        int[][] visited = new int[n][n];
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[1];
            int j = cur[2];
            count = 0;
            bfs(i, j, visited, 1);
            visited[i][j] = count;
            ans = Math.max(ans, count);
        }

        System.out.println(ans);
    }
}
