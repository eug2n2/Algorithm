class Solution {
    static boolean[][] visited;
    static int numberOfArea, maxSizeOfOneArea ,currentArea;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
       
        
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                int val =picture[i][j];
                if(visited[i][j]|| val==0){
                    continue;
                }
                currentArea=0;
                numberOfArea++;
                dfs(m,n, picture, val, i, j);
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, currentArea);
                
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    // a: 탐색 시작하는 위치
    public void dfs(int m, int n, int[][] picture, int val, int a ,int b) {
        for(int di =0; di<4;di++){
            int cx = a + dx[di];
            int cy = b + dy[di];
            if(cx<0||cy<0|| cx>=m ||cy>=n ||visited[cx][cy]|| picture[cx][cy]!=val){
                continue;
            }
            visited[cx][cy]=true;
            currentArea++;
            dfs(m,n,picture,val, cx,cy);
        }
    }
}