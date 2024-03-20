import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<int []> queue = new ArrayDeque<>();
        int m = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();
        int answer = 0;
        int size;
        int[][][] map = new int[n][m][h+1];
        boolean tomato = false;
        for (int k = 1; k <=h; k++) { 
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < m; j++) {
                map[i][j][k] = sc.nextInt();
                if (map[i][j][k] == 1) {
                    queue.add(new int[]{i, j, k,0});
                }
            }
        	}
        }
      
        int[] dx = { 1, -1, 0, 0, 0,0 };
        int[] dy = { 0, 0, -1, 1, 0,0 };
        int[] dh = { 0, 0, 0,0,1,-1 };
        while (!queue.isEmpty()) {
            size = queue.size();
            while (size != 0) {
                int[] p = queue.poll();
                for (int di = 0; di < 6; di++) {
                    int nx = p[0] + dx[di];
                    int ny = p[1] + dy[di];  
                    int nh = p[2] + dh[di];
                    if (nx >= 0 && nx <n && ny >= 0 && ny < m&& nh >=1&& nh <= h) {
                        if (map[nx][ny][nh] == 0) {
                            map[nx][ny][nh] = 1;
                            queue.add(new int[]{nx, ny, nh, p[3] + 1});
                            answer = p[3] + 1;
                        }
                    }
                }
                size--;
            }
        }

        out:  for(int ii=0;ii<n;ii++) {
     	   for(int jj=0;jj<m;jj++) {
     		  for(int kk=1;kk<=h;kk++) {
     		   if(map[ii][jj][kk]==0) {
     			   tomato=true;
     			   System.out.println(-1);
     			   
     			   break out;
     		   }
     	   }
        }
        }
     if (! tomato) {
     	System.out.println(answer);
     }
     } 
    }
