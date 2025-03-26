class Solution {
    public int solution(int[][] triangle) {
        int t = triangle.length;
        int[][] dp = new int[t][t];
        for(int i=0;i<t;i++){
            dp[t-1][i]=triangle[t-1][i];
        }
        for(int i=t-2;i>=0;i--){
            for(int j =0;j<=i;j++){
                dp[i][j] =Math.max(dp[i+1][j],dp[i+1][j+1])+triangle[i][j];
            }
        }
        int answer = 0;
        for(int i=0;i<t;i++){
            answer= Math.max(dp[0][i],answer);
        }
        return answer;
    }
}