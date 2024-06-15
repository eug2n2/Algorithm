import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine()); // vip 수
		boolean[] visited = new boolean[n + 2];
		for (int i = 0; i < m; i++) {
			int a = Integer.parseInt(bf.readLine());
			visited[a] = true;
			visited[a+1]=true; // vip석은 아니지만 선택권 업기는 매한가지... ;; 
		}
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <=n; i++) {
			if (visited[i]) {
				dp[i] = dp[i - 1];
			} else {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
		}
		System.out.println(dp[n]);
	}
}
