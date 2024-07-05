class Solution {
    public int solution(int n) {
        int answer = n-1;
        for(int i =2;i<=n;i++){
            
            out:for (int j =2; j<=Math.sqrt(i);j++){
                if(i%j==0){
                    answer--;
                    // System.out.println(i+" "+j);
                    break;
                }
            }
        }
        return answer;
    }
}