class Solution {
    static int[] arr = new int[4];
    static String[] dict = {"RT","CF","JM","AN"};
    public String solution(String[] survey, int[] choices) {
        int n = survey.length;
        
        for (int i =0;i<n;i++){
            int score=choices[i];
            if(score==4){
               continue; // 점수가 0이니까 의미가 없음
           } else if(score >5){
               // 동의
               char tmp = survey[i].charAt(1);
               change(tmp,score-4 );
           }else{
                char tmp = survey[i].charAt(0);
                change(tmp, 4-score);
            }
        }
        String answer = "";
        
        for(int i =0;i<4;i++){
            if(arr[i]<=0){
                answer+=dict[i].charAt(0);
            }else{
                answer+=dict[i].charAt(1);
            }
        }
        return answer;
    }
    
    public void change(char c, int score){
       for (int i =0; i<4;i++){
           char tmp = dict[i].charAt(0);
           if(c==tmp){
               arr[i] -= score;
               return;
           }
           char tmp1 = dict[i].charAt(1);
           if(c==tmp1){
               arr[i] += score;
               return;
           }
       }
    }
}