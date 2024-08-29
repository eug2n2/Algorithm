import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(bf.readLine());

        int cnt = 0;
        for (int i = 6; i >= 0; i--) {
            int stick = 1 << i;  // 2^i
            while (x >= stick) {
                x -= stick;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}