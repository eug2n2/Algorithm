import java.io.*;
import java.util.*;
class Planet implements Comparable<Planet> {
    int distance;
    int point; // 출발점
    boolean[] vis;
    int cnt;  // 방문한 점 개수

    public Planet(int distance, int point, boolean[] vis, int cnt){
        this.distance= distance;
        this.point= point;
        this.vis=vis;
        this.cnt= cnt;
    }

    @Override
    public int compareTo(Planet o) {
        if(o.distance==this.distance){
            return o.cnt-this.cnt;
        }
        return  this.distance- o.distance;
    }

    @Override
    public String toString() {
        return "point: " + this.point + " dist: " + this.distance + " cnt: " + this.cnt;
    }


}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); // 출발점

        int[][] arr = new int[n][n];
        for (int i =0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j =0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int q =0;q<n;q++){
            for (int i = 0; i<n;i++ ){
                for (int j =0;j<n;j++){
                    if(i==j) continue;
                    arr[i][j] = Math.min(arr[i][j], (arr[i][q]+arr[q][j]));
                }
            }
        }
        int answer =Integer.MAX_VALUE;
        boolean[] visited = new boolean[n];
        PriorityQueue<Planet> pq = new PriorityQueue<>();
        pq.add(new Planet(0,k,visited,0));

        while(!pq.isEmpty()){
            Planet p = pq.poll();
//            System.out.println(p);
            int po=p.point;
            int d= p.distance;
            int c=p.cnt;
            boolean[] v =p.vis;
            v[po]=true;
            c++;
            if(c==n){
                answer = d;
                break;
            }
            for (int i =0;i<n;i++){
                if(v[i]) continue;
                pq.add(new Planet(d+arr[po][i], i, Arrays.copyOf(v, v.length), c));
            }
        }
        System.out.println(answer);
    }
}