import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int r, c, ans; 
    static char[][] array;
    static int[] dx = { -1, 0, 1 };
    static boolean ha;
    static boolean[][] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        ans = 0;// 최대 500만 이니까 long x
        array = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String str = bf.readLine();
            for (int j = 0; j < c; j++) {
                array[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
        	ha=false;
            dfs(i, 0);
            
        }

        System.out.println(ans);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        if (y == c - 1) {
            ha = true;
            ans++;
            return ;
        }

        int move = 0;
        for (int di = 0; di < 3; di++) {
            int nx = x + dx[di];
            int ny =y+1;
            if (boundary(nx, ny)) {
                move++;
                dfs(nx, ny);
                if (ha) return ;
               
            }
        }
        if (move == 0) {// 다음 열에서 파이프를 설치할 수 없는 경우
            return ;
        }
    }

    public static boolean boundary(int x, int y) {
        if (x < 0 || y < 0 || x >= r || y >= c || array[x][y] == 'x' || visited[x][y])
            return false;
        return true;
    }
}
