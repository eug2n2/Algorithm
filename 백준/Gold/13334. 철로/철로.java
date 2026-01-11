import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.y == o.y) return this.x - o.x;
        return this.y - o.y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Point[] array = new Point[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int sp = Integer.parseInt(st.nextToken());
            int ep = Integer.parseInt(st.nextToken());
            if (sp > ep) {
                int tmp = ep;
                ep = sp;
                sp = tmp;
            }
            array[i] = new Point(sp, ep);
        }
        Arrays.sort(array);

        int ans = 0;
        int d = Integer.parseInt(bf.readLine());

        // 시작점
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Point p : array) {
            // 집과 사무실
            int start = p.x;
            int end = p.y;

            // 길이 d를 초과하면 애초에 불가능
            if (end - start > d) continue;

            pq.add(start);

            // L의 왼쪽 경계 벗어난 start점 제거
            while (!pq.isEmpty() && pq.peek() < end - d) {
                pq.poll();
            }

            ans = Math.max(ans, pq.size());
        }
        System.out.println(ans);
    }

}