import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        int sx=0;
        int sy=0;
        int[] dx ={-1 ,0,0,1};
        int[] dy ={0,-1,1,0};
        for (int i =0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j =0; j<n;j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j]=num;
                if(num==9){
                    sx=i;
                    sy=j;
                    map[i][j]=0;// 지나갈 수 있도록 변경 .
                }
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sx,sy});
        int size =2;
        int time =0;
        int eatfish=0;//먹은 물고기수
        while(!queue.isEmpty()){
            int[] p = queue.poll();
            int x= p[0];
            int y=p[1];
//            System.out.println(" origin "+ x +" "+y+ " "+time);
            PriorityQueue<int[]> move = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2){
                    if(o1[2]==o2[2]){
                        if(o1[0]==o2[0]){
                            return o1[1]-o2[1];
                        }
                        return o1[0]-o2[0];
                    }
                    return o1[2]-o2[2];
                }
            });
            move.add(new int[]{x,y,0}); // 마지막은 거리 (시간)
            boolean[][]visited = new boolean[n][n];
            visited[x][y]=true;
            boolean avail=false;
            move: while(!move.isEmpty()){
                int[] mp= move.poll();
                int mx=mp[0];
                int my =mp[1];
                int mdist= mp[2];
//                System.out.println("move  "+ mx+" "+my+" "+mdist);
                if(map[mx][my]<size && map[mx][my]!=0){
                    eatfish++;
                    if(eatfish==size){
                        size++;
                        eatfish=0;
                    }
                    map[mx][my]=0;
                    time+=mdist;
                    queue.add(new int[]{mx,my});
                    avail=true;
                    break move;
                }
                for(int di=0;di<4;di++){
                    int nx= mx+dx[di];
                    int ny = my+dy[di];
                    if(nx<0||ny<0||nx>=n||ny>=n){
                        continue;
                    }
                    if(map[nx][ny]>size|| visited[nx][ny]){
                        continue;
                    }
                    visited[nx][ny]=true;
                    move.add(new int[]{nx,ny,mdist+1});

                }
            }
            if(!avail){
                System.out.println(time);
                return;
            }

        }
    }


}