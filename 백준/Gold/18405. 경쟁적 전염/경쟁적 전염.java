import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<int []> queue = new ArrayDeque<>();
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) { 
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
        }
        int s = sc.nextInt(); 
        int a = sc.nextInt();
        int b = sc.nextInt();
        for(int v =0; v<=k;v++){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] ==v) {
                        queue.add(new int[]{i, j,v});
                    }
                }
             }
        }
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        while (map[a - 1][b - 1]==0&&s!=0) {
                s--;
                int cnt =queue.size();
                while(cnt!=0){
                    int[] p = queue.poll();
                    for (int di = 0; di< 4; di++) {
                        int nx = p[0] + dx[di];
                        int ny = p[1] + dy[di];        
                       if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if (map[nx][ny] == 0) {
                            map[nx][ny] = p[2];
                            queue.add(new int[]{nx,ny,p[2]});
                        }
                    }
                    }
                    cnt--;
                }
             
            }
           System.out.println(map[a-1][b-1]);
        }
    }
