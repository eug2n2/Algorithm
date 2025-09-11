import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 수열의 길이
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer,Integer> map = new HashMap<>();
        long answer = 0;
        int r =0;
        for(int l=0; l<N;l++){
            while(r<N){
                int k = arr[r];
                if(!map.containsKey(k)){
                    map.put(k,1);
                    r++;
                }else{
                    break;
                }
            }

            answer += r-l;

            int ar =arr[l];
            int tmp = map.get(ar);
            if(tmp==1){
                map.remove(ar);
            }else{
                map.put(ar, tmp+1);
            }
        }

        System.out.println(answer);
    }
}