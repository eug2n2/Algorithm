
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
import java.util.Stack;
class Main {
    public static void main(String args[]) throws IOException {
    	
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
     // 입력 받은 숫자
        String stra = bf.readLine(); //크기 
        String strb = bf.readLine(); //크기 
        String[] alist = stra.split("");
        String[] blist = strb.split("");
        int[][]dp= new int[alist.length+1][blist.length+1];
        for (int i=0;i<=alist.length;i++) {
        	dp[i][0]=i; }

        for(int j=0;j<=blist.length;j++) {
            dp[0][j]=j;}
        		
        for (int i=1;i<=alist.length;i++) {
        	for(int j=1;j<=blist.length;j++) {
        		if(alist[i-1].equals(blist[j-1])) {
        			dp[i][j]=dp[i-1][j-1];
        		}
        		else {dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j], dp[i][j-1]))+1;
        
        			}
        		
        		}
        	}	
        System.out.println(dp[alist.length][blist.length]);
 
    }

    }

