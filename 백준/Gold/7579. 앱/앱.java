import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] cost = new int[n + 1];
		int sum =0;
		int[] memory = new int[n + 1];
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= n; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 10001;
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			sum+=cost[i];
		}
		long[][] dp = new long[n + 1][sum+1]; // memory가 담겨야함
		
		for (int i = 1; i <= n; i++) {
			int costmp = cost[i];
			for (int j = 0; j <= sum; j++) {
				if (j - costmp < 0) {
					dp[i][j] = dp[i - 1][j];
				} else {
					long one = memory[i];
					long tmp = dp[i - 1][j - costmp] + memory[i];
					if (((costmp!=0 && dp[i - 1][j - costmp] != 0)|| costmp ==0 )) {
						dp[i][j] = Math.max(tmp, dp[i - 1][j]);
					
					} else if (dp[i - 1][j - costmp] == 0) {
						dp[i][j] = dp[i - 1][j];
						if(j==costmp) {
							dp[i][j]=Math.max(dp[i][j],one);
						}
					}
				}
				if(dp[i][j]>=m) {
					ans =Math.min(ans, j);
				}
			}
		}
		System.out.println(ans);

	}

}