import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = Integer.MAX_VALUE;

        int[][] arr = new int[n][m];

        int[] index = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.sort(arr[i]);
        }
        while(true){
            int mintmp = Integer.MAX_VALUE;
            int minidx =0;
            int maxtmp = 0;
            for (int i = 0; i < n; i++) {

                int tmp = arr[i][index[i]];
                if(tmp<mintmp){
                    mintmp=tmp;
                    minidx =i;
                }
                if(tmp>maxtmp){
                    maxtmp=tmp;
                }

            }
            int atmp =maxtmp-mintmp;
            if(answer>atmp) {
                answer = atmp;
            }
            if(++index[minidx]==m){
                break;
            }
        }
        System.out.println(answer);

    }

}