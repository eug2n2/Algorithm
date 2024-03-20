
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// The main method must be in a class named "Main".
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[n + 1][n + 1]; // 1부터 n까지의 합 저장 할 곳
	
	
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= n; j++) {
				int a =Integer.parseInt(st.nextToken());
				dp[i][j] = dp[i][j-1] + a; // 가로줄 별로 컬럼의 합을 저장하
				//dp[1][4] (1,1)~(1,4)까지 더했다는 의미 
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int s =0;s<m;s++) {
			st = new StringTokenizer(bf.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int nx = Integer.parseInt(st.nextToken());
			int ny = Integer.parseInt(st.nextToken());
			int answer =0;
			for (int i=sx; i<=nx;i++) {
				answer+=dp[i][ny]-dp[i][sy-1];
			}
			sb.append(answer).append("\n");
			
		}
		System.out.println(sb);
		
	}
}