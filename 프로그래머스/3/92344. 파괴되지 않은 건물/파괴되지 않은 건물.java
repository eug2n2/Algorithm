class Solution {
    static int m,n;
    public int solution(int[][] board, int[][] skill) {
        m = board.length;
        n= board[0].length;
        // 여기서 1을 추가해서 배열을 만드는 이유는 
        int[][] diff = new int[m+1][n+1];
        int answer = 0;
        int s = skill.length;
        for(int i =0;i<s;i++){
            int dtmp = skill[i][5];
            if( skill[i][0]==1){
                dtmp*=-1;
            } 
            int r1 = skill[i][1];
            int c1= skill[i][2];
            int r2 =skill[i][3];
            int c2 =skill[i][4];
            
            diff[r1][c1]+= dtmp;
            diff[r1][c2+1] -= dtmp;
            diff[r2+1][c1] -= dtmp;
            diff[r2+1][c2+1] +=dtmp;
        }
        // 열
        for (int i =0;i<m;i++){
            for(int j =1;j<n;j++){
                diff[i][j] += diff[i][j-1];
            }
        }
        // 행 
        for (int i =0;i<n;i++ ){
            for(int j =1;j<m;j++){
                diff[j][i] += diff[j-1][i]; 
            }
        }
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                board[i][j] +=diff[i][j];
                if(board[i][j]>=1){
                    answer++;
                }
            }
        }
        
        return answer;
    }
  
}