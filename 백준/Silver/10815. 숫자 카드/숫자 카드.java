import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        int[] nlist = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            nlist[i] = Integer.parseInt(st.nextToken());			
            int num = nlist[i];						
            boolean find = false;			
            if(Arrays.binarySearch(arr, num) >= 0) {				
                find = true;				
                sb.append(1).append(" ");			}						
            if(!find) sb.append(0).append(" ");		}				
        System.out.println(sb);

    }
}
