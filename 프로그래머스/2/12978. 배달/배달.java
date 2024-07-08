class Solution {
    static int answer=1;
    static int n,k; 
    static int[][] roads ;
    public int solution(int N, int[][] road, int K) {
        n=N;
        k=K;
        roads = new int[N+1][N+1];
        for (int i =0;i<road.length;i++){
            if(roads[road[i][0]][road[i][1]]==0 ){
                roads[road[i][0]][road[i][1]]= road[i][2];
                roads[road[i][1]][road[i][0]]= road[i][2];
                }else if(roads[road[i][0]][road[i][1]]>road[i][2] ){ // 여러개가 있을시 
                 roads[road[i][0]][road[i][1]]= road[i][2];
                roads[road[i][1]][road[i][0]]= road[i][2];
            }
        }
       
        int[] visited = new int[N+1]; // 최단거리저장
        for(int i =2;i<=n;i++){
            visited[i]=-1;
        }
        dfs(1,visited,0);
       

        return answer;
    }
    public static void dfs(int x,int[]visited, int cost){
     
        for(int i=2;i<=n;i++){
             // System.out.println(x +" "+i+" "+ roads[x][i]);
            if( (visited[i] !=-1 && visited[i] <(roads[x][i]+cost))|| roads[x][i]==0){
                continue ; // 이미 방문 or 길이 없다.
            }
            
            if (roads[x][i]+cost<=k){
                if(visited[i]==-1){
                    answer++;
                }
                visited[i]=roads[x][i]+cost; // 거리 갱신
            
             
                dfs(i,visited,roads[x][i]+cost);
            }
        }
    }
}