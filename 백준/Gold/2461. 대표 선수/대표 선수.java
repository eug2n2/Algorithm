import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = Integer.MAX_VALUE;
        int max = 0;
        int[][] arr = new int[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a ,b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr[i]);
            max =Math.max(max,arr[i][0]);
            pq.offer(new int[]{arr[i][0], i, 0});
        }

        while(true){
            int[] q = pq.poll();
            int min = q[0];
            int ntmp = q[1];
            int mtmp =q[2];

            int atmp =max-min;
            if(answer>atmp) {
                answer = atmp;
            }
            if(mtmp+1==m){
                break;
            }
            int next = arr[ntmp][mtmp+1];
            pq.add(new int[] {next, ntmp, mtmp+1});
            if(next>max){
                max = next;
            }
        }
        System.out.println(answer);

    }

}