class Solution {
    public int solution(int m, int n, int[][] puddles) {
 
        int p = puddles.length;
        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];
        for(int i =0;i<p;i++){
            int x= puddles[i][0]-1;
            int y =puddles[i][1]-1;
            map[y][x]=-1;
        }
        for(int i=0;i<n;i++){
            if(map[i][0]==-1) break;
            dp[i][0]=1;
        }
        for(int i=1;i<m;i++){
            if(map[0][i]==-1) break;
            dp[0][i]=1;
        }
        
        
        for(int i=1 ; i<n;i++){
            for(int j =1;j<m;j++){
                if(map[i][j]==-1){
                    continue;
                }
                dp[i][j]= (dp[i-1][j]+dp[i][j-1])%1000000007;
            }
        }
        return  dp[n-1][m-1];
    }
}