import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {
   
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        // 정수 입력받는 반복문
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt((st.nextToken()));
        }
        int[] nlist = Arrays.copyOf(arr,n);
        Arrays.sort(arr);
        arr = Arrays.stream(arr).distinct().toArray(); 
        HashMap<Integer,Integer> dar = new HashMap<Integer,Integer>();
        for (int i=arr.length-1;i>=0;i--) {
            dar.put(arr[i],i);
        }

        for (int i=0;i<n;i++) {
        
        	nlist[i]=dar.get(nlist[i]);}
        
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nlist[i]+" ");
        }

        System.out.print(sb);
    }
}
