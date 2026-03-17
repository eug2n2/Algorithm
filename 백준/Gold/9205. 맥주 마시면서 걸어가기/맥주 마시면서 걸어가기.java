import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine()); // 맥주를 파는 편의점의 개수

            int[][] cu = new int[n][3]; // 편의점 좌표리스트
            StringTokenizer st = new StringTokenizer(br.readLine());
            int hx = Integer.parseInt(st.nextToken()) + 32768;
            int hy = Integer.parseInt(st.nextToken()) + 32768;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                // home
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                // -32768 ≤ x, y ≤ 32767
                cu[i][0] = x + 32768;
                cu[i][1] = y + 32768;
            }
            // festival(end)
            st = new StringTokenizer(br.readLine());
            int fx = Integer.parseInt(st.nextToken()) + 32768;
            int fy = Integer.parseInt(st.nextToken()) + 32768;

            boolean success = false;
            Queue<int[]> que = new ArrayDeque<>();
            que.add(new int[]{hx, hy});
            out:
            while (!que.isEmpty()) {
                int[] arr = que.poll();
                int sx = arr[0];
                int sy = arr[1];
                int enddist = Math.abs(fx - sx) + Math.abs(fy - sy);
                if (enddist <= 1000) {
                    success = true;
                    break out;
                }

                for (int j = 0; j < n; j++) {
                    if (cu[j][2] == 1) {
                        continue;
                    }
                    int tx = cu[j][0];
                    int ty = cu[j][1];

                    int dist = Math.abs(sx - tx) + Math.abs(sy - ty);

                    if (dist <= 1000) {
                        cu[j][2] = 1;
                        que.add(new int[]{tx, ty});
                    }
                }
            }
            if (success) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }
}
