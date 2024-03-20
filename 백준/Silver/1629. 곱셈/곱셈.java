import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        long result = fpow(a, b);
        System.out.println(result);
    }

    public static long fpow(long num, long n) {
        if (n == 1) {
            return num%c ;
        } else {
            long x = fpow(num, n / 2);
            if (n % 2 == 0) {
                return x * x %c;
            } else {
                return (x * x %c )*num%c; // 처음에 %c안하면 long범위 초과 
            }
        }
    }
}
