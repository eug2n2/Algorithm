import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1,0,0};
    static int n, m;
    static int[][] arr;
    static int viruscnt=0; // 퍼뜨려야할 바이러스 수
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n =Integer.parseInt(st.nextToken());
        m =Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j =0; j<n;j++){
                int tmp = Integer.parseInt(st.nextToken());
                arr[i][j] = tmp;
                if(tmp==0){
                    viruscnt++;
                }
            }
        }

        boolean[][] visited = new boolean[n][n];
        int[][] virus = new int[m][2];
        combination(0, 0, visited, virus);

        if (answer==Integer.MAX_VALUE) {
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }

    }
    public static void combination(int idx, int cnt, boolean[][] visited, int[][] virus) {
        if (cnt == m) {
            answer = Math.min(answer, bfs(virus));
            return;
        }
        if (idx >= n * n) {
            return;
        }

        int x = idx / n;
        int y = idx % n;

        // 해당 위치에 바이러스를 놓을 수 있는지 확인
        if (arr[x][y] == 2 && !visited[x][y]) {
            visited[x][y] = true;
            virus[cnt][0] = x;
            virus[cnt][1] = y;
            combination(idx + 1, cnt + 1, visited, virus);
            visited[x][y] = false;
        }

        combination(idx + 1, cnt, visited, virus);
    }
    public static int bfs ( int[][] virus){
        boolean[][] visited = new boolean[n][n];
        Deque<int[]> queue = new ArrayDeque<>();
        for(int i=0;i<m;i++){
           queue.add(new int[] {virus[i][0],virus[i][1]});
        }
        int cnt =0;
        int time =-1;
//        System.out.println("start ");
        while(!queue.isEmpty()){
            if(cnt==viruscnt){
                if(time==-1){
                    time=0;
                }
                break;
            }
            time++;

            int size =queue.size();
            for(int i=0;i<size;i++){
                int[] p =queue.poll();
                int x = p[0];
                int y = p[1];
//                System.out.println(x+" "+y);
                if(visited[x][y]==true){
                    continue;
                }
                if(arr[x][y]==0) {
                    cnt++;
                }
                visited[x][y]=true;
                for(int di =0; di<4;di++){
                    int nx = x+ dx[di];
                    int ny = y+ dy[di];
                    if(nx<0||ny<0||nx>=n||ny>=n||visited[nx][ny]==true||arr[nx][ny]==1){
                        continue;
                    }

                    queue.add(new int[] {nx,ny});
                }
            }
        }
//        System.out.println(viruscnt+" "+cnt+" "+time);
        if(viruscnt==cnt){
            return time;
        }
        return Integer.MAX_VALUE;
    }
}