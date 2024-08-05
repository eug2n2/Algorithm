import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(bf.readLine());
        long answer =0;
        long[][] list = new long[n][2];
        for(int i =0;i<n;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }
        long x1= list[0][0];
        long y1= list[0][1];
        for(int i =1; i<n-1 ;i++){
            long x2 =list[i][0];
            long x3 = list[i+1][0];
            long y2= list[i][1];
            long y3 =list[i+1][1];
            long tmp= x1*y2+ x2*y3+ x3*y1 -x2*y1 -x3*y2-x1*y3;
            answer+=tmp;
        }
        answer = Math.abs(answer);
        if(answer % 2 == 0) {
            System.out.println(answer/2+".0");
        }else
            System.out.println(answer/2+".5");
    }
}