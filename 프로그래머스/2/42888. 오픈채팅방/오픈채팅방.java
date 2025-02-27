import java.io.*;
import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        // userid, nickname
        HashMap<String, String> map = new HashMap<>();
        
        int n = record.length;
        int cnt = n; // change 빼고 enter, leave 개수 
        for (int i =0;i<n;i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            String s = st.nextToken();
            if(s.equals("Leave")){
                continue;
            }
            if(s.equals("Change")){
                cnt--;
            }
            String id = st.nextToken();
            String nickname =st.nextToken();
            map.put(id, nickname);
        }
        String[] answer = new String[cnt];
        int num =0;
        for (int i =0;i<n;i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            String c= st.nextToken();
            if ( c.equals("Change")){
                continue;
            }
            String id = st.nextToken();
            String nickname= map.get(id);
            if ( c.equals("Enter")){
                nickname+="님이 들어왔습니다.";
            } else if ( c.equals("Leave")){
                nickname+="님이 나갔습니다.";
            } 
            answer[num++]=nickname;
            
        }

        return answer;
    }
}