import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        HashMap<String, Integer> user = new HashMap<>();
        HashSet<Integer>[] set = new HashSet[n]; // 신고 한 사람들
        for(int i =0;i<n;i++){
            user.put(id_list[i],i);
            set[i] = new HashSet<>();
        }
        
        int m = report.length;
        for(int i =0;i<m;i++){
            String s = report[i];
            StringTokenizer st = new StringTokenizer(s);
            String a = st.nextToken();
            String b= st.nextToken();
            int a1= user.get(a);
            int b1 = user.get(b);
            set[b1].add(a1);
        }
        int[] answer = new int[n];
        for (int i =0;i<n;i++){
            if(set[i].size()>=k){
                for(int t: set[i]){
                    answer[t]++;
                }
            }
        }
        
        return answer;
    }
}