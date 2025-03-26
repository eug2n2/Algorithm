class Solution {
    static int zero, one  ;
    static boolean[][] visited;
    public int[] solution(int[][] arr) {
        int n = arr.length;
        visited = new boolean[n][n]; // 압축 당함
        int interval = n;
        while(true){
            int zip =0; // 이번 턴 압축 한 개수 
            for(int i =0;i<n;i+=interval){
                for (int j =0; j<n;j+=interval){
                    if(visited[i][j]){
                       continue;
                    }
                    int tmp =cal(i,j,interval, arr);
                    zip++;
                    if(tmp==2){
                        continue;
                    }else if (tmp==1){
                        one++;
                    }else{
                        zero++;
                    }
                    
                    
                }
            }
            if(zip==0){ // 이미 압축됨
                break;
            }
            if(interval==1){
                break;
            }
            interval/=2;
        }
        int[] answer = {zero, one};
        return answer;
    }
    // 압축 안 되면 -1 , 0 압축 시 0 , 1 압축 시 1 
    public int cal(int xStart, int yStart, int interval,int[][] arr){
        int zeroCnt =0;
        int oneCnt=0;
        for (int i =xStart ;i< xStart+interval ; i++){
            for (int j = yStart ; j<yStart+ interval; j++){
                if(arr[i][j]==0){
                    zeroCnt++;
                }else{
                    oneCnt++;
                }
                if( zeroCnt!=0 && oneCnt!=0){
                    return 2; 
                }
            }
        }
        
        if (zeroCnt==0){
            change(xStart, yStart, interval, 1);
            return 1;
        }
        change(xStart, yStart, interval, 0);
        return 0;
    }
    
    public void change(int xStart, int yStart, int interval,int val){
        
        for (int i =xStart ;i< xStart+interval ; i++){
            for (int j = yStart ; j<yStart+ interval; j++){
                visited[i][j]=true;
            }
        }
        
    }
}