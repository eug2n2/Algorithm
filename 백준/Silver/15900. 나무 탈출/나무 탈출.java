import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        List<Integer>[] tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        int[] leaf = new int[n + 1];
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
            leaf[a]++;
            leaf[b]++;
        }
        leaf[1]=0;
        int count = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {1,0});
        boolean[] visited = new boolean[n + 1];
        while (!queue.isEmpty()) {
            int[] plist = queue.poll();
            int p=plist[0];
            visited[p] = true;
            if(leaf[p]==1){
                count+= plist[1];
                continue;
            }
            for (int j = 0; j < tree[p].size(); j++) {
                int num = tree[p].get(j);
                if (visited[num]) {
                    continue;
                }
                visited[num] = true;
                queue.add(new int[] {num, plist[1]+1});
            }

        }

        if (count % 2 == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }


    }
}