import java.util.*;

class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[] diagonalx = {1,1,-1,-1};
    static int[] diagonaly = {-1,1,1,-1};
    public int[] solution(String[][] places) {
        int[] answer = new int [5];
        for(int k =0 ;k<5;k++){
            char[][] arr = new char[5][5];
            Queue<int[]> que = new ArrayDeque<>();
            for(int j=0;j<5;j++){
                String p= places[k][j];
                for(int i =0;i<5;i++){
                    char c = p.charAt(i);
                    arr[i][j] =c;
                    if(c=='P'){
                        que.add(new int[] {i,j});
                    }
                }
            }
            answer[k]= dfs(arr,que);
        }
        return answer;
    }
    
    public int dfs(char[][] arr, Queue<int[]> que){
        while(!que.isEmpty()){
            int[] q = que.poll();
            int x = q[0];
            int y =q[1];
            for(int di =0; di<4;di++){
                int sx = diagonalx[di]+x;
                int sy = diagonaly[di]+y;
                if(sx<0 || sy<0 || sx>=5 ||sy>=5) continue;
                if(arr[sx][y]=='X' && arr[x][sy]=='X') continue;
                if(arr[sx][sy]=='P') return 0;
            }
            for(int di =0; di<4;di++){
                int sx = dx[di]+x;
                int sy = dy[di]+y;
                int tx = dx[di]*2+x;
                int ty = dy[di]*2+y;
                if(sx<0 || sy<0 || sx>=5 ||sy>=5) continue;
                if(arr[sx][sy]=='P') return 0;
                if(tx<0 || ty<0 || tx>=5 ||ty>=5) continue;
                //칸막이가 적용 되는 경우
                if(arr[sx][sy]=='X' && arr[tx][ty]=='P') continue;
                if(arr[tx][ty]=='P') return 0;
            }
        }
        return 1;
    }
}