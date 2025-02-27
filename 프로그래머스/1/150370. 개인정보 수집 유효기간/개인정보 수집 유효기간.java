import java.io.*;
import java.util.*;

class Solution {
    static int[] todaydate= new int[3]; // 연 월 일 
    public int[] solution(String today, String[] terms, String[] privacies) {
        StringTokenizer st = new StringTokenizer(today,".");
        
        for(int i =0;i<3;i++){
            todaydate[i]= Integer.parseInt(st.nextToken());
        }
        
        
        int t = terms.length;
        HashMap<String, Integer> termap=  new HashMap<>();
        for (int i =0;i<t;i++){
            String tmp = terms[i];
            st = new StringTokenizer(tmp);
            termap.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        int n = privacies.length;
        boolean[] trash = new boolean[n]; // 파기 여부 
        int answercnt= 0; // 파기해야하는 개인정보의 개수 
        
        for ( int i =0;i<n;i++){
            String sp = privacies[i];
            st = new StringTokenizer(sp);
            String currentDate = st.nextToken();
            String type= st.nextToken();
            int month= termap.get(type);
            int[] addedDate = addDate(currentDate,month );
            if(!compareDate(addedDate)){
                continue;
            }else{
                trash[i]=true;
                answercnt++;
            }
        }
        int[] answer = new int[answercnt];
        int num=0;
        for(int i =0;i<n;i++){
            if(trash[i]){
                answer[num++]= i+1;
            }
        }
        return answer;
    }
    
    public int[] addDate(String date, int m){
        StringTokenizer st = new StringTokenizer(date,".");
        int[] currentdate= new int[3]; 
        for(int i =0;i<3;i++){
            currentdate[i]= Integer.parseInt(st.nextToken());
        }
        int[] tmp = new int[3];
        if (currentdate[2]==1){
            tmp[2] = 28;
            int s= currentdate[1]+m-1;
            tmp[1]= s%12;
            tmp[0]= currentdate[0]+s/12;
        }else{
            tmp[2] = currentdate[2]-1;
            int s= currentdate[1]+m;
            
            tmp[1]= s%12;
            tmp[0]= currentdate[0]+s/12;
            
        }
        if(tmp[1]==0){ //12월이 0월로 처리되므로 
            tmp[1]=12;
            tmp[0]--;
        }
        return tmp;
    }
    
    public boolean compareDate(int[] date){
        
        for(int i =0;i<3;i++){
            if(todaydate[i]>date[i]){
                return true;
            }else if ( todaydate[i]<date[i]){
                return false; 
            }
            
        }
        return false; // 만료일자와 오늘의 날짜가 같다면 보관
        
    }
}