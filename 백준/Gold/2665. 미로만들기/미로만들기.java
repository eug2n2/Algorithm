import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0'; // 1 흰방 0 검은방
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerFirst(new int[]{0, 0});  // 시작방으로서 항상 흰 방임
        dist[0][0] = 0; 

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                int cost = dist[x][y] + (arr[nx][ny] == 0 ? 1 : 0);

                if (cost < dist[nx][ny]) {
                    dist[nx][ny] = cost;

                    if (arr[nx][ny] == 1) {
                        dq.offerFirst(new int[]{nx, ny}); 
                    } else {
                        dq.offerLast(new int[]{nx, ny}); 
                    }
                }
            }
        }

        System.out.println(dist[n-1][n-1]);
    }
}