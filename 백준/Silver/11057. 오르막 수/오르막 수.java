import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        int mod = 10007;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] dp = new int[n + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {

                for(int k = 0; k <= j ; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= mod;
                }
            }
        }
        int answer =0;
        for (int i = 0; i < 10; i++) {
            answer+=dp[n][i];
            answer%=mod;
        }
        System.out.println(answer);
    }
}