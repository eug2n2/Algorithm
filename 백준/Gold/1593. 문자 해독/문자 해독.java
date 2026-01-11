import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int g = Integer.parseInt(st.nextToken());       // w 길이
        int lengths = Integer.parseInt(st.nextToken()); // s 길이

        String w = br.readLine();
        String s = br.readLine();

        int[] need = new int[52]; // w 빈도
        int[] have = new int[52]; // 현재 윈도우 빈도

        // w 빈도
        for (int i = 0; i < g; i++) {
            need[idx(w.charAt(i))]++;
        }

        // s빈도
        for (int i = 0; i < g; i++) {
            have[idx(s.charAt(i))]++;
        }

        int ans = 0;

        if (same(need, have)) ans++;

        for (int i = g; i < lengths; i++) {
            // 들어오는 문자
            have[idx(s.charAt(i))]++;

            // 나가는 문자
            have[idx(s.charAt(i - g))]--;

            if (same(need, have)) ans++;
        }

        System.out.println(ans);
    }

    static int idx(char c) {
        if (c >= 'A' && c <= 'Z') return c - 'A';
        return c - 'a' + 26;
    }

    static boolean same(int[] a, int[] b) {
        for (int i = 0; i < 52; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
