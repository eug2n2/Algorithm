import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[n + 1]; 
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true; // 초기값 true 설정 (0과 1 제외)
        }

        for (int i = 2; i * i <= n; i++) {
            if(!isPrime[i]) continue;
            
            for (int j = i * i; j <= n; j += i) { 
                isPrime[j] = false; // i의 배수는 소수가 아님
            }
            
        }

        for (int i = m; i <= n; i++) {
            if (isPrime[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }
}
