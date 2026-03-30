import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Edge implements Comparable<Edge> {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return o.w - this.w; // 내림차순
        }
    }

    static class Query implements Comparable<Query> {
        int k, v, idx;

        Query(int k, int v, int idx) {
            this.k = k;
            this.v = v;
            this.idx = idx;
        }

        @Override
        public int compareTo(Query o) {
            return o.k - this.k; // 내림차순
        }
    }

    static int[] parent, size;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return;
        }
        size[a] += size[b];
        parent[b] = a;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[n - 1];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int qq = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(p, qq, r);
        }

        Query[] queries = new Query[q];

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            queries[i] = new Query(k, v, i);
        }

        Arrays.sort(edges);
        Arrays.sort(queries);

        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int[] answer = new int[q];
        int edgeIdx = 0;

        for (Query query : queries) {

            // k이상 간선으로 그래프 만듦
            while (edgeIdx < n - 1 && edges[edgeIdx].w >= query.k) {
                union(edges[edgeIdx].u, edges[edgeIdx].v);
                edgeIdx++;
            }

            answer[query.idx] = size[find(query.v)] - 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            sb.append(answer[i]).append('\n');
        }

        System.out.print(sb);
    }
}