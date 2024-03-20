
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][]dice;
	static int ans =0;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());// dice개수
		dice = new int[n ][6];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			dfs(0,i,0);
		}
		System.out.println(ans);

	}
	public static void dfs (int sum,int bottom, int cnt ) {
		 int pair = paircheck(bottom);
	        int s = -1;
	        //옆면의 최대값 구하기
	        for(int i=0;i<6;i++){
	            if(i == pair || i == bottom)
	                continue;
	            s = Math.max(s, dice[cnt][i]);
	        }
	        sum+=s;
	     if( cnt == n-1) {
	    	 ans =Math.max(ans, sum);
	    	 return;
	     }
	     for(int i=0;i<6;i++){
	            if(dice[cnt][pair] == dice[cnt+1][i]){
	                dfs(sum, i, cnt+1);
	                break;
	            }
	        }
	     
	}
	 //마주보는 면 인덱스 구하는 함수
    static int paircheck(int n){
        if(n == 0)
            return 5;
        else if(n == 1)
            return 3;
        else if(n == 2)
            return 4;
        else if(n == 3)
            return 1;
        else if(n == 4)
            return 2;
        else
            return 0;
    }
}