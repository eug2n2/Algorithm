import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int n;
    static long x;
    static long[] dp, patty;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        dp = new long[n + 1];
        patty = new long[n + 1];
        dp[0] = 1;
        patty[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] * 2 + 3;
            patty[i] = patty[i - 1] * 2 + 1;
        }

        x = Long.parseLong(st.nextToken());
        System.out.println(dfs(n, x));
    }

    public static long dfs(int level, long x) {

        if (level == 0) return 1;
        if (x == 1) return 0; // level 0 이 아닌데, x=1 이라면 아래 빵

        long half = dp[level - 1] +2; // 중간 패티 위치

        if (x == half) return patty[level - 1] + 1;
        if (x < half) return dfs(level - 1, x - 1); // 아래쪽 절반 탐색
        return patty[level - 1] + 1 + dfs(level - 1, x - half); // 아래쪽 + 가운데 mid patty+ 위쪽 절반 탐색
    }
}