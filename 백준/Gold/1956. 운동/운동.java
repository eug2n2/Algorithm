import java.io.*;
import java.util.*;

public class Main {
    static int answer = Integer.MAX_VALUE;
    static int v;
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        dist = new int [v+1][v+1];
        for(int i =0;i<=v;i++){
            for(int j =0;j<=v;j++){
                dist[i][j]=-1;
            }
        }
        for(int i =0;i<e;i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b]=c;
        }
        for(int i =1; i<=v;i++){
            for(int j =1 ;j<=v;j++){
                for (int k =1;k<=v;k++){
                    if(dist[j][i]==-1 ||dist[i][k] ==-1){
                        continue;
                    }else if(dist[j][k]==-1){
                        dist[j][k]= dist[j][i]+dist[i][k];
                    }else{
                        dist[j][k] =Math.min(dist[j][k], dist[j][i]+dist[i][k]);
                    }
                }
            }
        }
        for(int i =1; i<v;i++){
            for (int j=i+1;j<=v;j++){
                if(dist[i][j]==-1 || dist[j][i]==-1) continue;
                answer =Math.min(dist[j][i]+dist[i][j],answer);
            }
        }
        if(answer ==Integer.MAX_VALUE){
            answer=-1;
        }
        System.out.println(answer);
    }

}