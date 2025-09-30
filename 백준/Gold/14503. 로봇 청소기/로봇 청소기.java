import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); // 로봇 청소기가 바라보는 방향 (북, 동, 남, 서)

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 0: 빈칸, 1: 벽
            }
        }

        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 북, 동, 남, 서
        int ans = 0;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { r, c, d });
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dir = cur[2];

            if (map[x][y] == 0) { // 현재 위치가 빈칸이면
                map[x][y] = 2; // 청소
                ans++;
            }

            boolean cleaned = false; // 네 방향 중 청소할 곳이 있는지 확인
            for (int i = 0; i < 4; i++) {
                dir = (dir + 3) % 4; // 반 시계 방향 90도 회전
                int nx = x + directions[dir][0];
                int ny = y + directions[dir][1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
                    queue.add(new int[] { nx, ny, dir });
                    cleaned = true;
                    break;
                }
            }

            if (!cleaned) { // 네 방향 모두 청소가 되어있거나 벽인 경우
                int backDir = (dir + 2) % 4; // 후진
                int bx = x + directions[backDir][0];
                int by = y + directions[backDir][1];

                if (bx >= 0 && bx < n && by >= 0 && by < m && map[bx][by] !=1) { //  벽이 아니라면 
                    queue.add(new int[] { bx, by, dir }); // 후진
                } else {
                    break; // 후진도 못하는 경우 종료
                }
            }
        }
        System.out.println(ans);
    }
}
