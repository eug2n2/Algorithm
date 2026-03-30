import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // (10만이하)
        // 시간복잡도 O(nlogn) 까지
        int m = Integer.parseInt(st.nextToken());
        int[] ground = new int[n + 1];
        int[] prefixSum = new int[n + 2];
        //  연병장 높이

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ground[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            prefixSum[a] += k;
            prefixSum[b + 1] -= k;
        }
        for (int i = 1; i <= n; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            ground[i] += prefixSum[i + 1];
            sb.append(ground[i] + " ");
        }
        System.out.println(sb);
    }
}