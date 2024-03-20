
import java.util.*;
import java.awt.Point;
import java.lang.*;
import java.io.*;

class Main {
    static int tmp;
    public static void main(String[] args) throws IOException {
        Queue<Point> queue = new LinkedList<Point>(); // 배추좌표 들어갈 큐 
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(bf.readLine());
            int n= Integer.parseInt(st.nextToken()); //가로
            int m = Integer.parseInt(st.nextToken()); //세로
            int[][] graph = new int [n][m];
            int[][] visited = new int[n][m];
            int keep =0; //인접해있는 배추가있는지 여부 
            int ans =0;
            int cnt=0;
            int sx=-1;
            int sy =-1;
            for (int i=0;i<n;i++){
                String str= bf.readLine();
                String[] arr = str.split(" ");
                for (int j=0;j<m;j++){
                    graph[i][j]=Integer.parseInt(arr[j]); 
                    if(graph[i][j]==1){
                        queue.add(new Point(i,j));
                    }
                }
            }
        
            while (!queue.isEmpty()) {
                Point p= queue.poll();
                if (graph[p.x][p.y]==1 &&visited[p.x][p.y]==0){
                    tmp=1;
                    cnt++;
                    visited[p.x][p.y]=1;
                    visited=search(graph,visited,queue,p.x,p.y,n,m); 
                    }  
                ans = Math.max(ans,tmp);
                tmp=0;
                }
                System.out.println(cnt);
                System.out.println(ans);
      
        }

     public static int[][] search( int[][] graph, int[][] visited,  Queue<Point> queue, int i, int j, int n, int m) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for (int k = 0; k < 4; k++) {
            int nx =i+ dx[k];
            int ny = j + dy[k];
    
            // 범위 확인
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                // 현재 위치가 1이고 방문하지 않은 경우
                if (graph[nx][ny] == 1 && visited[nx][ny] == 0) { //인접배추가 있고, 방문안한 배추일경우 
                    visited[nx][ny]=1;
                    visited=search(graph,visited,queue,nx,ny,n,m);
                    tmp++;
                }
            }
        }
        return visited; // 인접한 위치 중에 조건을 만족하는 것이 없으면 false 반환
    }
 }