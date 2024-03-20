import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine()); // 숫자 정수
		int[][] nlist = new int[n + 1][2];
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			nlist[i][0] = Integer.parseInt(st.nextToken());
			nlist[i][1] = Integer.parseInt(st.nextToken());
		}
		int index = 1;
		int end = 0;
		int i=n;
		while (index >0) {
		
			if (nlist[i][0] + i - 1 > n) { // 일 불가
				i--;
				continue;
			} else {
				index--;
				dp[i] = nlist[i][1];
				end = i;
				
			}

		}

		for (int j = end-1; j >= 1; j--) {
			if (nlist[j][0] + j - 1 > n) { // 일 불가
				dp[j] =dp[j+1];
				continue;
			} else if( j+nlist[j][0]<=n) {
				dp[j] = Math.max(dp[j + 1], nlist[j][1] + dp[j + nlist[j][0]]);
			} else {
				dp[j]= Math.max(dp[j + 1], nlist[j][1]);
			}

		}

		System.out.println(dp[1]);
	}
}