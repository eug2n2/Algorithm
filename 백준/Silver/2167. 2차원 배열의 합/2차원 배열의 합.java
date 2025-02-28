import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int[][] arr = new int[n+1][m+1];
        for (int i =1;i<=n;i++){
            st = new StringTokenizer(bf.readLine());
            for (int j =1; j<=m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i =1;i<=n;i++){
            for (int j=2;j<=m;j++){
                arr[i][j] += arr[i][j-1];
            }
        }

        for (int i =1;i<=m;i++){
            for (int j=2;j<=n;j++){
                arr[j][i] += arr[j-1][i];
            }
        }


        int k = Integer.parseInt(bf.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(bf.readLine());

            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int val = arr[r2][c2] - arr[r1-1][c2] - arr[r2][c1-1] + arr[r1-1][c1-1];
            sb.append(val).append("\n");
        }
        System.out.println(sb);

    }
}