import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static List<Integer>[] friends;
    static int n ;
    static  boolean answer =false;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        friends = new ArrayList[n];
        for(int i =0;i<n;i++){
            friends[i]= new ArrayList<>();
        }
        int m = Integer.parseInt(st.nextToken());
        for (int i =0;i<m;i++){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            friends[x].add(y);
            friends[y].add(x);

        }
        for(int i =0;i<n;i++){
            boolean[] visited = new boolean[n];
            visited[i]=true;
            dfs(0,i,visited);
            if(answer){
                System.out.println(1);
                return;
            }

        }
        System.out.println(0);

    }
    static void dfs(int level, int x,boolean[] visited){
//        System.out.println(level+" "+ x);

        if(level==4){
            answer=true;
            return;
        }
        for(int i =0;i< friends[x].size();i++){
            int p = friends[x].get(i);
            if(visited[p]) continue;
            visited[p]=true;
            dfs(level+1,p,visited);
            visited[p]=false;
        }
        return;
    }


}