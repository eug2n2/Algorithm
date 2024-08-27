import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] people, int limit) {
        Deque<Integer> que = new ArrayDeque<>();
        int n = people.length;
        Arrays.sort(people);
        for(int i =0;i<n;i++){
            que.addLast(people[i]);
        }
        int answer = 0;
        
        while(!que.isEmpty()){
            int p = que.removeLast();
            if(!que.isEmpty()){
                int q= que.getFirst();
                if(p+q<=limit){
                    que.removeFirst();
                }
            }
               answer++;
        }
        
  
        return answer;
    }
}