import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Bar {
    int index;
    long height;

    Bar(int index, long height) {
        this.index = index;
        this.height = height;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;
            long answer = 0;
            Stack<Bar> stack = new Stack<>(); //index 관리
            for (int i = 0; i < N; i++) {
                long x = Long.parseLong(st.nextToken());
                int start = i;
                while (!stack.isEmpty()) {
                    Bar cur = stack.peek();
                    int index = cur.index;
                    long h = cur.height;
                    if (x < h) {
                        stack.pop();
                        answer = Math.max(answer, (i - index) * h);
                        start = cur.index;
                    } else {
                        break;
                    }
                }
                stack.push(new Bar(start, x));
            }
            while (!stack.isEmpty()) {
                Bar cur = stack.pop();
                answer = Math.max(answer, cur.height * (N - cur.index));
            }
            System.out.println(answer);
        }
    }

}
