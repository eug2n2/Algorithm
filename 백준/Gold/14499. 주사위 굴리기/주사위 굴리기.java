import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dice = new int[7];
    static int dx[] = {0,0,0,-1,1};
    static int dy[] = {0,1,-1,0,0};
    static int n, m;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n =Integer.parseInt(st.nextToken());
        m =Integer.parseInt(st.nextToken());
        int x =Integer.parseInt(st.nextToken());
        int y =Integer.parseInt(st.nextToken());
        int k =Integer.parseInt(st.nextToken()); // 명령 개수
        arr = new int[n][m];

        int idx =0;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j =0; j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<k;i++){
            int di = Integer.parseInt(st.nextToken());
            int nx = x +dx[di];
            int ny = y +dy[di];
            if( nx <0 || ny <0 || nx>=n || ny>=m ){ // 범위 초과
                continue;
            }
            x =nx;
            y = ny;
            move(x,y,di);
        }

    }

    static void move(int a, int b,int direction){
        int tmp =dice[1]; // 앞면
        switch (direction){
            case 1: // 동
                dice[1]=dice[3];
                dice[3]= dice[6];
                dice[6]=dice[4];
                dice[4]=tmp;
                break;
            case 2:
                dice[1]=dice[4];
                dice[4]= dice[6];
                dice[6]=dice[3];
                dice[3]=tmp;
                break;
            case 3:
                dice[1]=dice[2];
                dice[2]= dice[6];
                dice[6]=dice[5];
                dice[5]=tmp;
                break;
            case 4:
                dice[1]=dice[5];
                dice[5]= dice[6];
                dice[6]=dice[2];
                dice[2]=tmp;
                break;
        }
        if(arr[a][b] == 0) { // 뒷면
            arr[a][b] = dice[6];
        } else {
            dice[6] = arr[a][b];
            arr[a][b] =0;
        }
        System.out.println(dice[1]);
    }
}