import java.io.*;
import java.util.StringTokenizer;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken()); // 단원 개수
		int M = Integer.parseInt(st.nextToken()); // 공부 가능한 시간
		int[] dp = new int[M + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int k = Integer.parseInt(st.nextToken()); // 단원별 예상 공부시간
			int s = Integer.parseInt(st.nextToken()); // 단원별 배점
			for (int j = M; j >= k; j--) {
				dp[j] = Math.max(dp[j], dp[j - 1]);
				dp[j] = Math.max(dp[j], dp[j - k] + s);
			}
		}

		System.out.println(dp[M]);
	}
}
