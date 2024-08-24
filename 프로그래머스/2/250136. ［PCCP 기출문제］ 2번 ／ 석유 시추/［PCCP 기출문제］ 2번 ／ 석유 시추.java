import java.util.*;

class Solution {
    static int n, m; // 가로 세로 
    static int[] oil; // 열 별 덩어리 개수 
 
    public int solution(int[][] land) {
    
        n = land.length;
        m = land[0].length;
        oil = new int[m]; 

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && visited[i][j] == false) {
                    bfs(land, visited, i, j); // 덩어리 탐색 
                }
            }
        }

        int answer =0;
        for (int i = 0; i < m; i++) {
            if(answer<oil[i]){
                answer =oil[i];
            }
        }
        System.out.println(answer);
        return answer;
    }

    public void bfs(int[][] land, boolean[][] visited, int a, int b) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{a, b});
        visited[a][b] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int count = 1;
        // 석유 덩어리가 있는 열 위치 저장
        Set<Integer> set = new HashSet<>();

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x =p[0];
            int y =p[1];
            set.add(y);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!checkRange(nx, ny)) {
                    continue;
                }

                // 석유가 있거나 방문 안 했거나
                if (land[nx][ny] == 1 && visited[nx][ny] == false) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    count += 1;
                }
            }
        }

        for (int index : set) {
            oil[index] += count;
        }
    }

    public boolean checkRange(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        return true;
    }
}