import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] numbers;
    static int[] operators = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        numbers = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(numbers[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int result, int idx) {
        if (idx == n) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                switch (i) {
                    case 0: dfs(result + numbers[idx], idx + 1); break;
                    case 1: dfs(result - numbers[idx], idx + 1); break;
                    case 2: dfs(result * numbers[idx], idx + 1); break;
                    case 3: dfs(result / numbers[idx], idx + 1); break;
                }
                operators[i]++;
            }
        }
    }
}