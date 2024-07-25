import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int[][] dp = new int[str.length()+1][3]; // 문자열 중 자릿수 / (일, 십의 자리 유무 )/ 그 숫자
        int mod =1000000;
        dp[0][0]=1;

        for(int i =1;i<=str.length();i++){
            int c= str.charAt(i-1)-'0';
            dp[i][2]=c;
            int tmp = dp[i-1][2]*10 + c;
            if(c!=0 && tmp>=10 && tmp <=26){
                dp[i][0] = (dp[i-1][0]+ dp[i-1][1])%mod;
            }else if ( c!=0){
                dp[i][0]=dp[i-1][0]%mod;
            }else if ( c==0 && tmp <=20&& tmp>0){
                dp[i][0] = dp[i-1][1]%mod;
            }else{
                System.out.println(0);
                return;
            }

            dp[i][1] = dp[i-1][0] %mod;
        }
        System.out.println(dp[str.length()][0]); // 마지막자리는 십의자리로 쓰일 수가 없음 ㅎ
    }
}