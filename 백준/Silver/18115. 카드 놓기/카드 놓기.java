import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Queue<Integer> q = new ArrayDeque<>();
        for(int i =n;i>=1;i--){
            q.add(i);
        }
        int[] card = new int[n];
        int idx =0; // 1번째 빈자리
        int idx2= 1;// 2번째 빈자리
        int idx3=n-1; // 마지막 빈자리
        for(int i =0 ; i<n;i++){
            int m = Integer.parseInt(st.nextToken());
            switch(m){
                case 1:
                    card[idx]= q.poll();
                    break;
                case 2:
                    card[idx2]=q.poll();
                    break;

                case 3:
                    card[idx3]= q.poll();
//                    System.out.println(card[idx3]+" "+idx3 +" i "+i);
                    break;
            }
            while (idx < n) {
                if(card[idx]!=0){
                    idx++;
                }else{
                    break;
                }
            }

            while (idx2 < n) {
                if(idx2==idx || card[idx2]!=0){
                    idx2++;
                }else{
                    break;
                }
            }
            while (idx3 >=0) {
                if( card[idx3]!=0){
                    idx3--;
                }else{
                    break;
                }
            }
            }
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<n;i++){
            sb.append(card[i]+" ");
        }
        System.out.println(sb);
        }

}