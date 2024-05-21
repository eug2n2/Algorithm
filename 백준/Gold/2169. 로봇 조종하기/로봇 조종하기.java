import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] graph = new int[n+1][m+1];
		int[][] sum = new int[n+1][m+1];
		
		int[] dx = { 1, 0, 0 }; // 위로 올라갈 수없다.
		int[] dy = { 0, -1, 1, };
		int ans = 0;
		for (int i = 1; i <=n; i++) {
			st = new StringTokenizer(bf.readLine());
			
			for (int j = 1; j <= m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sum[1][1] =graph[1][1];
		//위로 못 올라가니까 첫 행은 왼->오로 이동하는 방법밖에 없다...
		for(int i=2;i<=m;i++) {
			sum[1][i] = sum[1][i-1]+ graph[1][i];
		}
		// 보통 dp 는 i, j 는 서 ( i, j-1 ), 동 ( i, j+1 ), 북 ( i-1, j ) 중 최솟값을 선택하는 경우가많음(최단경로구하려고)
		//근데 여기서는 max값 을구하기위해 오 -> 왼 인 경우도 고려해줘야한다.... (왼쪽이 가능해짐에따라 난이도가 올라감 눈물...)
		// tmp없이는 오가 안 구해졌는데 왼을 구하려니 말이안됨..
		int[][] tmp = new int [2][m+2];
	    for(int i = 2; i <= n; i++) { // 아래로가는즁
            
	    	tmp[0][0] = sum[i-1][1]; 
	    	// 왼 - > 오 
            for(int j = 1; j <=m; j++) {
            	tmp[0][j] = Math.max(tmp[0][j-1], sum[i-1][j])+ graph[i][j];
            }
            //오 -> 왼
            tmp[1][m+1] = sum[i-1][m];
            for(int j = m; j >= 1; j--) {
            	tmp[1][j] = Math.max(tmp[1][j+1], sum[i-1][j]) + graph[i][j];
            }
             
            for(int j = 1; j <= m; j++) {
            	sum[i][j] = Math.max(tmp[0][j], tmp[1][j]);
            }
        }
        System.out.println(sum[n][m]);
		
		
		
	}

}