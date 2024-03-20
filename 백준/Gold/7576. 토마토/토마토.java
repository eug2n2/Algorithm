import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<int []> queue = new ArrayDeque<>();
        int m = sc.nextInt();
        int n = sc.nextInt();
        int answer = 0;
        int size;
        int[][] map = new int[n][m];
        boolean tomato = false;
        
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }
      
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        
        while (!queue.isEmpty()) {
            size = queue.size();
            while (size != 0) {
                int[] p = queue.poll();
                for (int di = 0; di < 4; di++) {
                    int nx = p[0] + dx[di];
                    int ny = p[1] + dy[di];        
                    if (nx >= 0 && nx <n && ny >= 0 && ny < m) {
                        if (map[nx][ny] == 0) {
                            map[nx][ny] = 1;
                            queue.add(new int[]{nx, ny, p[2] + 1});
                            answer = p[2] + 1;
                        }
                    }
                }
                size--;
            }
        }

        out:  for(int ii=0;ii<n;ii++) {
     	   for(int jj=0;jj<m;jj++) {
     		   if(map[ii][jj]==0) {
     			   tomato=true;
     			   System.out.println(-1);
     			   
     			   break out;
     		   }
     	   }
        }
     if (! tomato) {
     	System.out.println(answer);
     }
     } 
   
    }
