import java.util.*;

class Main {
    static Queue<int[]> queue = new LinkedList<>(); // 가로 세로 현재까지 cnt
    static int n, m;
    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 가로
        m = sc.nextInt(); // 세로
        map = new int[n][m];
        visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String[] strArr = sc.next().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        visited[0][0][0] = true;
        queue.add(new int[]{0, 0, 1, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int x = p[0], y = p[1], cnt = p[2], punch = p[3];
            if (x == n - 1 && y == m - 1) {
                System.out.println(cnt);
                return;
            }

            search(x, y, cnt, punch);
        }

        System.out.println(-1);
    }

    public static void search(int i, int j, int cnt, int punch) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            // 범위 확인
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                // 현재 위치가 1이고 방문하지 않은 경우
                if (map[nx][ny] == 0) {
                    if (punch == 0 && !visited[nx][ny][0]) { // 지금까지 벽 안 부순 경우
                        visited[nx][ny][0] = true;
                        queue.add(new int[]{nx, ny, cnt + 1, 0});
                    } else if (punch == 1 && !visited[nx][ny][1]) {// 지금까지 벽 부순 적 있음
                        visited[nx][ny][1] = true;
                        queue.add(new int[]{nx, ny, cnt + 1, 1});
                    }
                } else if (punch == 0) {
                    visited[nx][ny][1] = true;
                    queue.add(new int[]{nx, ny, cnt + 1, 1});
                } // 지금까지 벽 안 부순 경우 부술 거야.
            }
        }
    }
}
