import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        }
        );

        List<int[]>[] map= new ArrayList[n+1];
        for(int i=1; i<=n;i++){
            map[i]= new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[x].add(new int[]{y,cost});
            map[y].add( new int[] {x,cost});

        }
        pq.add(new int[]{1, 0});
        boolean[] visited = new boolean[n + 1];
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int x = p[0];
            int cost = p[1];
            if (visited[x]) {
                continue;
            }
            visited[x] = true;
            if (x == n) {
                System.out.println(cost);
                return;
            }
            for (int i = 0; i <map[x].size(); i++) {
                int[] tmp =map[x].get(i);

                if (visited[tmp[0]] ||tmp[1] == -1) continue;
                pq.add(new int[]{tmp[0], cost + tmp[1]});
            }
        }
    }

}