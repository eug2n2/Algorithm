import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MOD = 10007;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][] array = new int[n][m];

        // 블록 정보 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int k = 0;
            while (st.hasMoreTokens()) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp <= h) {
                    array[i][k++] = tmp;
                }
            }
        }

        int[][] dp = new int[n + 1][h + 1];
        dp[0][0] = 1;  // 아무 블록도 사용하지 않고 높이 0을 만드는 경우의 수

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= h; j++) { // 높이가 j 인 블록 만드는 경우의 수 구하기 
                // 블록 사용하지않고 pass
                dp[i][j] = dp[i-1][j];
                // 블록 사용 
                for (int k = 0; k < m; k++) {
                    if (array[i-1][k] == 0) break;  
                    //높이가 j인 블록을 만들거라서 j보다 크면 넘어감
                    if (j < array[i-1][k]) continue;
                    
                    dp[i][j] = (dp[i][j] + dp[i-1][j - array[i-1][k]]) % MOD;
                }
            }
        }

        System.out.println(dp[n][h]);
    }
}
