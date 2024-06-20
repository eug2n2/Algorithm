class Solution {
    static int[] answer;
    static boolean win ;
    static int diff =0 ;
    //어피치 n발 후 라이언 n발 쏩니다잉 
    // 어피치가 맞힌 과녁점수(10-0점) 의 개수 배열 : info (길이:11)
    //return 값: 라이언의 과녁점수 배열 , 못 이기면(= 비기거나 질 경우) [-1] return
    // 라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지 일 경우, 가장 낮은 점수를 더 많이 맞힌 경우를 return 해주세요.
    public int[] solution(int n, int[] info) {
        answer = new int[11];
        int[] lose = {-1};
        win =false;
        int[] array = new int[11];
        dfs(n, 10, array,info);
        if(!win){
            return lose;
        }
        return answer;
    }
    public void dfs(int x, int score, int[] rion ,int[] appeach){
        if (score ==0 || x==0){
            rion[10]= x;
            x=0;
            cal(appeach, rion);
            return;
        }
        for(int i=0; i<=x;i++){
            rion[10-score]= i;
            dfs((x-i), (score-1), rion, appeach );
            rion[10-score]=0;
        }
    }
    
    public boolean cal (int[] a, int[]b){
        int as = 0; // 어피치 점수
        int bs = 0; // 라이언 점수
        for(int i=0;i<10;i++){
            if(a[i]==0 && b[i]==0){
                continue;
            }
            if( a[i]>=b[i]){
                as+= 10-i;
            }else{
                bs+=10-i;
            }
        }
        int tmp =bs-as;
        if(as>=bs){
            return false;
        }else{
            win= true;
            if(diff<tmp){
                diff = tmp;
                for(int i=0;i<11;i++){
                    answer[i]=b[i];
                }
            }else if(diff==tmp){
                for(int i=10;i>=0;i--){
                    if(answer[i]>b[i]){
                        break;
                    }else if( answer[i]==b[i]){
                        continue;
                    }else{
                         for(int j=0;j<11;j++){
                             answer[j]=b[j];
                         }
                        break;
                    }
                    
                }
            }
            
            return true;
        }
    }
}