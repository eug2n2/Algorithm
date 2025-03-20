import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] zero;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static HashMap<Integer, Integer> zeroMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        zero = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = bf.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        // 모든 0 영역 찾기
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (zero[i][j] == 0 && map[i][j] == 0) {
                    int count = bfs(i, j, num); // bfs로 함수를 빼지않는다면 (0,0) 부터 계속 적절한 i,j를 찾는것을 반복해야 함: 비효율
                    zeroMap.put(num, count);
                    num++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    sb.append(0);
                    continue;
                }

                HashSet<Integer> set = new HashSet<>();
                for (int di = 0; di < 4; di++) {
                    int nx = i + dx[di];
                    int ny = j + dy[di];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] != 0) {
                        continue;
                    }

                    set.add(zero[nx][ny]);
                }

                int sum = 1; // 자기 자신
                for (int area : set) {
                    sum += zeroMap.get(area);
                }

                sb.append(sum % 10);
            }
            System.out.println(sb);
        }
    }

    static int bfs(int startX, int startY, int num) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startX, startY});
        zero[startX][startY] = num;

        int count = 1;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0];
            int y = arr[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] != 0 || zero[nx][ny] != 0) {
                    continue;
                }

                zero[nx][ny] = num;
                queue.add(new int[]{nx, ny});
                count++;
            }
        }

        return count;
    }
}