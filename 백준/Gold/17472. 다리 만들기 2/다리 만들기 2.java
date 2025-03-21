import java.io.*;
import java.util.*;
class Bridge implements Comparable<Bridge> {
    int from;
    int to;
    int distance;

    public Bridge(int from, int to, int distance){
        this.from =from;
        this.to=to;
        this.distance= distance;
    }
    @Override
    public int compareTo(Bridge o){
        if(this.distance==o.distance){
            return this.from-o.from;
        }
        return this.distance-o.distance;
    }
}

public class Main {
    static int n, m;
    static int[][] map, island;
    static int[] parent;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        island = new int[n][m]; //0: 바다, 숫자는 섬의 번호
        int islandCnt =1; //섬 번호
        for(int i =0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            for (int j =0;j<m;j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        //섬의 번호 넘버링
        for(int i =0;i<n;i++){
            for (int j =0;j<m;j++){
                // 섬인데 방문안했다면..
                if(map[i][j]==1 && island[i][j]==0){
                    bfs(i,j,islandCnt);
                    islandCnt++;
                }
            }
        }

        PriorityQueue<Bridge> pq = new PriorityQueue<>();

        // 가로 다리
        for(int i =0;i<n;i++){
            boolean first = false;
            int[] memo = new int[2]; // 섬번호, j 좌표
            for (int j =0;j<m;j++){
                if(map[i][j]==1 && !first){
                    first =true;
                    memo[0]= island[i][j];
                    memo[1]=j;
                }else if (map[i][j]==1 && island[i][j]==memo[0]){
                    memo[1]=j;
                } else if (map[i][j]==1 && island[i][j]!=memo[0] ){ // 다른섬 ...
                    int distmp =j-memo[1]-1;
                    if(distmp>1){
                        pq.add(new Bridge(memo[0], island[i][j],distmp ));
                    }

                    memo[0]= island[i][j];
                    memo[1]=j;
                }
            }
        }

        // 세로 다리
        for (int j =0;j<m;j++){
            boolean first = false;
            int[] memo = new int[2]; // 섬번호, j 좌표
            for(int i =0;i<n;i++){
                if(map[i][j]==1 && !first){
                    first =true;
                    memo[0]= island[i][j];
                    memo[1]=i;
                }else if (map[i][j]==1 && island[i][j]==memo[0]){
                    memo[1]=i; // 같은 섬
                } else if (map[i][j]==1 && island[i][j]!=memo[0] ){ // 다른섬 ...
                    int distmp =i-memo[1]-1;
                    if(distmp>1){
                     pq.add(new Bridge(memo[0], island[i][j],distmp ));
                    }

                    memo[0]= island[i][j];
                    memo[1]=i;
                }
            }
        }

        // 다리들의 연결 여부를 파악하기 위해 유니온 파인드를 사용
        parent = new int[islandCnt];
        for(int i =1;i<islandCnt;i++){
            parent[i]=i;
        }

        int answer =0;
        while(!pq.isEmpty()){
            Bridge q = pq.poll();
            int a = q.from;
            int b =q.to;
            int d =q.distance;

            int fa = find(a);
            int fb = find(b);

            // 이미 연결되어있음
            if(fa==fb){
                continue;
            }else if (fa<fb){
                answer+=d;
                parent[fb]= fa;
            }else{
                answer+=d;
                parent[fa]=fb;
            }

        }
        boolean avail =true;
        for(int i =1;i<islandCnt;i++){
            if(parent[find(i)]!=1){
                avail=false;
                break;
            }
        }
        if(!avail){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
    }

    private static void bfs (int startX, int startY, int num){
        island[startX][startY] =num;

        for(int di=0; di<4;di++){
            int x =  startX +dx[di];
            int y = startY+dy[di];
            if(x<0 || y<0|| x>=n || y>=m ||map[x][y]==0 || island[x][y]!=0){
                continue;
            }
            bfs(x,y,num);
        }
    }

    private static int find(int v){
        if (v==parent[v]){
            return v;
        }
        return find(parent[v]);
    }

}