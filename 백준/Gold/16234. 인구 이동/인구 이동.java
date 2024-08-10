import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int l,n,r;
    static boolean ismove;
    static int[][]map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        l =Integer.parseInt(st.nextToken());
        r =Integer.parseInt(st.nextToken());
        map= new int[n][n];
        for(int i =0;i<n;i++){
            st =new StringTokenizer(bf.readLine());
            for(int j =0;j<n;j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        int day =0;
        while(true){
            ismove=false;
            visited = new boolean[n][n];
            for(int i =0;i<n;i++){
                for(int j =0;j<n;j++){
                    if(visited[i][j]) continue;
                    bfs(i,j);
                }
            }

            if(!ismove){
                break;
            }else{
                day++;
            }
        }
        System.out.println(day);
    }
    static void bfs (int x, int y ){
        int[] dx ={1,-1,0,0};
        int[] dy ={0,0,1,-1};
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {x,y});
        visited[x][y]=true;
        int sum =map[x][y];
        Deque<int[]> visqueue = new ArrayDeque<>();
        visqueue.add(new int[] {x,y});
        while(!queue.isEmpty()){
            int[] p = queue.poll();
            int a = p[0];
            int b=p[1];
            int val = map[a][b];
            for(int di =0; di<4;di++){
                int nx = a+dx[di];
                int ny = b+dy[di];
                if(nx<0|| ny<0|| nx>=n|| ny>=n||visited[nx][ny]){
                    continue;
                }
                int diff= Math.abs(map[nx][ny]-val);
                if(diff<l || diff>r) continue;
                visited[nx][ny]=true;
                ismove=true;
                sum+=map[nx][ny];
                visqueue.add(new int[] {nx,ny});
                queue.add(new int[] {nx,ny});
            }
        }

        int tmp = sum/ visqueue.size();
        while(!visqueue.isEmpty()){
            int[] p = visqueue.poll();
            map[p[0]][p[1]]=tmp;
        }
    }
}