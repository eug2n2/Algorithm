import java.io.*;
import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
       
        int size = n;
        
        int c = cmd.length;
        Stack<Integer> recentidx = new Stack<>();
    
        for (int i =0;i<c;i++){
            StringTokenizer st = new StringTokenizer(cmd[i]);
            String sc = st.nextToken();
            if(sc.equals("D")){
                int tmp = Integer.parseInt(st.nextToken());
                k+= tmp;
                
            }else if (sc.equals("U")){
                int tmp = Integer.parseInt(st.nextToken());
                k-= tmp;

            }else if (sc.equals("C")){
                recentidx.add(k);
                if(k == size-1){
                    k--;
                }
                size--;
            }else{
                size++;
                int itmp=recentidx.pop();
                if(itmp<=k){
                    k++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<size;i++){
            sb.append('O');
        }
        while(!recentidx.isEmpty()){
            sb.insert(recentidx.pop(),"X");
        }
        String answer =sb.toString();
        return answer;
    }
}