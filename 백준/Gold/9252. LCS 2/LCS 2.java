import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String a = bf.readLine();
		char[] ac = a.toCharArray();
		String b = bf.readLine();
		char[] bc = b.toCharArray();
		int asize = a.length();
		int bsize = b.length();
		int[][] dp = new int[asize + 1][bsize + 1];
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= asize; i++) {
			for (int j = 1; j <= bsize; j++) {
				if (ac[i - 1] == bc[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					if (dp[i - 1][j] < dp[i][j - 1]) {
						dp[i][j] = dp[i][j - 1];
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
			}
		}
		// 경로 역추적
		Stack<Character> stack = new Stack<>();
		int i = asize;
		int j = bsize;
		while (i > 0 && j > 0) {
			if (i == 0 || j == 0)
				break; // 도달완료
			if (dp[i][j] == dp[i - 1][j]) {
				i--;
			} else if (dp[i][j] == dp[i][j - 1]) {
				j--;
			} else { //문자열 두개 위치 같음 
				stack.push(a.charAt(i - 1));
				i--;
				j--;
			}
		}
		
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(dp[asize][bsize]);
		System.out.println(sb);
	}
}
