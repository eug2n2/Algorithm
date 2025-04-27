class Solution {
    static int answer = 0;
    static int n;
    public int solution(int[] numbers, int target) {
        n= numbers.length;
        bfs(numbers,0,0,0,target);
        bfs(numbers,0,1,0,target);
        return answer;
    }
    // symbol :0 이면 + , 1 이면 -
    public void bfs (int[] numbers, int idx, int symbol, int val, int target){
        
        if(symbol==0){
            if(idx+1==n){
                if(target==val+numbers[idx]) answer++;
                return;
            }
            bfs(numbers,idx+1,0,val+numbers[idx],target);
            bfs(numbers,idx+1,1,val+numbers[idx],target);
        }else{
            if(idx+1==n){
                if(target==val-numbers[idx]) answer++;
                return;
            }
            bfs(numbers,idx+1,0,val-numbers[idx],target);
            bfs(numbers,idx+1,1,val-numbers[idx],target);
        }
    }
}