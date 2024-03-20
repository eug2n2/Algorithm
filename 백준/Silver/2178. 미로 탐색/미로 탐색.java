import java.util.*;
import java.awt.Point;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Queue<Point> queue = new LinkedList<Point>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 가로
        int m = sc.nextInt(); // 세로
        int[][] map = new int[n][m];
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] strArr = sc.next().split("");                    
            for (int j = 0; j < m; j++) {
                visited[i][j]=10001; // 방문안했다의 의미가 10001 , 방문과 거리의 역할을 동시에
                map[i][j] = Integer.parseInt(strArr[j]);
    
            }
        }
        visited [0][0]=1;
        queue.add(new Point(0,0));
        while (!queue.isEmpty()) {
            Point p= queue.poll();
            visited=search(map,visited,queue,p.x,p.y,n,m);
        }  
                
        System.out.println(visited[n-1][m-1]);
        }   
        public static int[][] search( int[][] map, int[][] visited,  Queue<Point> queue, int i, int j, int n, int m) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
    
        for (int k = 0; k < 4; k++) {
            int nx =i+ dx[k];
            int ny = j + dy[k];
    
            // 범위 확인
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                // 현재 위치가 1이고 방문하지 않은 경우
                if (map[nx][ny] == 1 && visited[nx][ny]==10001) {
                    visited[nx][ny]=Math.min(visited[i][j]+1,visited[nx][ny]);
                    queue.add(new Point(nx,ny));
                }
            }
        }
        return visited;
    }
 }