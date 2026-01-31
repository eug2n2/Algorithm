import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edu implements Comparable<Edu> {
    int pay;
    int day;

    public Edu(int pay, int day) {
        this.pay = pay;
        this.day = day;
    }

    @Override
    public int compareTo(Edu o) {
        if (this.day == o.day) return o.pay - this.pay;
        else return this.day - o.day;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> ans = new PriorityQueue<>(); // pay 값 저장소
        PriorityQueue<Edu> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()); //pay
            int d = Integer.parseInt(st.nextToken()); //day
            pq.add(new Edu(p, d));

        }
        int daycount = 1;

        while (!pq.isEmpty()) {
            Edu ed = pq.poll();
            if (ed.day >= daycount) {
                ans.offer(ed.pay);
                daycount++;
            } else if (ans.peek() < ed.pay) {
                ans.poll();
                ans.offer(ed.pay);
            }

        }

        int answer = 0;
        while (!ans.isEmpty()) {
            answer += ans.poll();
        }
        System.out.println(answer);
    }


}
