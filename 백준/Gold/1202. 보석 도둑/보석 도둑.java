import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> ans = new PriorityQueue<>();
        PriorityQueue<int[]> dia = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1]- o1[1];
                }
                return o2[0]-o1[0];
            }
        });

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); // 가방 개수
        int[] bag = new int[k];

        int idx = k-1; // 가방 인덱스
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken()); // 무게
            int b = Integer.parseInt(st.nextToken()); // 가격
            dia.add(new int[] { a, b });
        }
        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(bag);
        out: while (!dia.isEmpty()) {
            int[] p = dia.poll();
          
            if (idx <0) {
                idx = 0;
            }
            if (p[0] <= bag[idx] && k > ans.size()) {
                ans.add(p[1]);
                idx--;
            } else if (p[0] <= bag[idx] && k <= ans.size() && ans.peek() < p[1]) {
                ans.poll();
                ans.add(p[1]);
                idx--;
            } else if(!ans.isEmpty()&& ans.peek() < p[1]) {//무게는 지금 가방에는 안 들어가, 기존 가방거 빼서 쓸게
                ans.poll();
                ans.add(p[1]);
            }

        }
        long score = 0;
        while (!ans.isEmpty()) {
            
            score += ans.poll();
        }
        System.out.println(score);
    }
}
