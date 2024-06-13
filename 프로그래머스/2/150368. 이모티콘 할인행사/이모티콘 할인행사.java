class Solution {
    static int m;
    static int n;
    static int[] answer; // 이모티콘 플러스 서비스 가입 수와 이모티콘 매출액
    static double[] discount = {0.4,0.3,0.2,0.1};
    
    public int[] solution(int[][] users, int[] emoticons) {
        n= users.length;
        m= emoticons.length;
        answer = new int[2];
    
        double[] val = new double[m];
        dfs(0,val,users,emoticons);
      
        return answer;
    }
    public void dfs (int x, double[] value, int[][]users, int[] emoticon){
        if(x==m){
            int[] a= cal(users,emoticon,value);
            // System.out.println(a[0]+ " dfs에서 갱신 "+a[1]);
            if(answer[0]>a[0]){
                return;
            }
            if(answer[0]==a[0] &&answer[1]>=a[1]){
                    return;
             }
            answer[0]=a[0];
            answer[1]=a[1];
                // System.out.println(answer[0]+ " dfs에서 갱신 "+answer[1]);
            
            return;
        }
        for(int k=0;k<4;k++){
            value[x]= discount[k];
            dfs(x+1,value,users,emoticon);
        }
    }
    public int[] cal(int[][] users,int[] emoticon,double[] discount){
        //  for(int j=0;j<m;j++){
        //      System.out.print((int)(discount[j]*100) +" ");
        //  }
        // System.out.println();
        // System.out.println("_________________________________");
        int[] emtmp =new int[2];
        for(int k=0;k<n;k++){
            int price=0;
            for(int j=0;j<m;j++){
                int discountmp =(int)(discount[j]*100);
                double tmp = 100- discountmp;
                
            // System.out.println(discountmp+ " "+k+ " "+j);
                if(users[k][0]<= discountmp){
            // System.out.println(users[k][0]+ " 구매 합니다 "+(int)(emoticon[j] *tmp));
                price+= (int)(emoticon[j] /100 *tmp);
                } 
            }
            // System.out.println(users[k][1]+ " 총결산 "+price);
            if(price>=users[k][1]){
                price=0;
                emtmp[0]++; // 임티플 사는게 이득 
            }else{
                emtmp[1] +=price;
            }
        }
        return emtmp;
    }
}