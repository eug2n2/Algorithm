import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.replace("{","");
        s = s.replace("}","");
        StringTokenizer st= new StringTokenizer(s,",");
        HashMap <Integer,Integer> map = new HashMap<>();
        int max= 1;
        while (st.hasMoreTokens()){
            Integer num = Integer.parseInt(st.nextToken());
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                int tmp= map.get(num)+1;
                map.put(num, tmp);
                max= Math.max(tmp, max);
            }
        }
        int[] answer = new int[max];
        for(int i:map.keySet()){
            int num = map.get(i);
            answer [ max- num]=i;
        }
        
        return answer;
    }
}