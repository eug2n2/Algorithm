import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(bf.readLine());

        long sum = 0;
        long xor = 0;

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());

            if (num == 1) {
                int x = Integer.parseInt(st.nextToken());
                sum += x;
                xor ^= x; 
            } else if (num == 2) {
                int x = Integer.parseInt(st.nextToken());
                sum -= x;
                xor ^= x;  // 1번 연산과 상쇄
            } else if (num == 3) {
                sb.append(sum).append("\n"); 
            } else if (num == 4) {
                sb.append(xor).append("\n");  
            }
        }

        System.out.print(sb);
    }
}
