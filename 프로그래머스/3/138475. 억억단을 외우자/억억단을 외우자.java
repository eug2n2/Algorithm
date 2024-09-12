class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] divcnt = new int[e+1]; // 약수 
        int[] freq = new int[e+1]; // 범위 별 답 
        int maxdiv = e; // 현재 가장 많은 약수를 갖고 있는 수 
        
        for(int i = 1; i<= e; i++)
            divcnt[i] = 1;
        
        for(int i = 2;i<=e ; i++){
            for(int j = 1; ; j++){
                if(i * j > e) break;
                divcnt[i*j]++;
            }
        }
        
        for(int i = e; i>0; i--){
            if(divcnt[i] >= divcnt[maxdiv])
                maxdiv = i;
            freq[i] = maxdiv;
        }
      
        
        for(int i = 0; i<answer.length; i++)
            answer[i] = freq[starts[i]];
        
        return answer;
    }
}