import java.util.*;
import java.io.*;

public class Main {
    static int[] pow ,rod;
    static int a, b, n, k;
    static long ans = 0;

    static void move(int size, int dstRod) {
        if (size <= 0) return;
        if (dstRod == rod[size]) { // 옮길 필요가 없음
            move(size - 1, dstRod);
            return;
        }

        int tmpRod = 6 - dstRod - rod[size]; // 남은 막대기 번호 구하기
        ans += pow[size - 1]; // 이동하는 경우의 수를 더해준다.
        ans %= 1000000;
        move(size - 1, tmpRod);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine());
        int[] numRod = new int[3];
        pow = new int[n+1];
        rod = new int[n+1]; // rod[i]: i 번째 디스크가 속한 막대기

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 3; i++) {
            a = Integer.parseInt(st.nextToken());
            numRod[i] = a;
        }

        // 거듭제곱을 1000000로 나눈 나머지 배열

        pow[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow[i] = (2 * pow[i - 1]) % 1000000; // 2^n % 1000000
        }

        for (int i = 0; i < 3; i++) {
            if (numRod[i] > 0) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < numRod[i]; j++) {
                    b = Integer.parseInt(st.nextToken());
                    rod[b] = i + 1; // b는 i+1 번째 막대기에 속해있다.
                    if (b == n) k = i + 1; // 마지막 번호가 속한 막대기에 디스크를 꽂는게 효율적이다.
                }
            }
        }

        move(n-1, k); 
        System.out.println(k);
        System.out.println(ans);

    }
}