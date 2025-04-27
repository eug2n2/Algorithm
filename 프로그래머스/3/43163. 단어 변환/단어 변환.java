class Solution {
    static boolean avail =false;
    static int answer;
    static int n, b;
    public int solution(String begin, String target, String[] words) {
        n= words.length;
        b= begin.length();
        answer=n;
        boolean[] visited = new boolean[n];
        dfs(begin,target,words, 0, visited);
        if(!avail) return 0;
        return answer;
    }
    //val: 변환중인 단계
    public void dfs(String str, String target, String[] words, int val, boolean[] visited){
        if(str.equals(target)){
            avail=true;
            answer= Math.min(answer,val);
            return;
        }
        if(answer<val){
            return;
        }
        for(int i =0;i<n;i++){
            if(visited[i]) continue;
            String tmp =words[i];
            int diff=0;
            for(int j=0;j<b;j++){
                if (str.charAt(j)==tmp.charAt(j)){
                    continue;
                }else{
                    if(diff==1){
                        diff++;
                        break;
                    }
                    diff++;
                }
            }
            
            if(diff==1){
                visited[i]=true;
                dfs(tmp, target, words,val+1,visited);
                visited[i]=false;
            }
            
        }
        return;
    }
}