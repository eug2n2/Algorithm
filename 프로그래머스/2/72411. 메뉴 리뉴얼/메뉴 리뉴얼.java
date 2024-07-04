import java.util.*;
class Solution {
    //코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열 course
    static String[] order;
    static PriorityQueue<String> pq;
    static  HashMap<String,Integer>[] map;
    public String[] solution(String[] orders, int[] course) {
        order =orders;
        int csize =course.length;
        map = new HashMap[csize];
        for (int i =0; i<csize;i++){
            map[i] = new HashMap<>();
        }
        pq = new PriorityQueue<>();
        for(int i=0;i<csize;i++){
            cook(course[i],i);
        }
        String[] answer = new String[pq.size()];
        int pqidx=0;
        while(!pq.isEmpty()){
            String str = pq.poll();
            answer[pqidx++] =  str;
        }
        
        return answer;
    }
    public static void cook(int cnt, int idx ){
       
        for(int i=0; i<order.length;i++){
            String str = order[i];
            if ( str.length()<cnt){ // 애초에 못만드니까 pass
                continue;
            }
            char[] chars = str.toCharArray();
        
            Arrays.sort(chars);
        
            String sortedStr = new String(chars);
            combination(cnt, 0, idx,0, sortedStr,"");
           
        }
        int max =2;
        Deque<String> queue  = new ArrayDeque<>();
        for (String key : map[idx].keySet()) {
            int mapcnt= map[idx].get(key);
            // System.out.println(mapcnt+" "+ key);
            if(mapcnt ==max){
                queue.add(key);
            }
            if(mapcnt>max){
                queue.clear();
                max = mapcnt;
                queue.add(key);
            }
        }
        while(!queue.isEmpty()){
            pq.add(queue.poll());
        }
        
    }
      public static void combination(int cnt, int val, int cidx, int idx, String str, String strtmp){
        
        if (cnt ==val){
            
            if (map[cidx].containsKey(strtmp)){
                    map[cidx].put(strtmp,map[cidx].get(strtmp)+1);
                }else{
                    map[cidx].put(strtmp,1);
                    }
            return;
        }
         if (idx ==str.length() ){
            return;
        }
        combination(cnt, val+1,cidx, idx+1, str,strtmp+str.charAt(idx));
        combination(cnt, val,cidx, idx+1, str,strtmp);
    }
}