import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m =sc.nextInt();
        int[] dp= new int[n+1]; //1부터 n까지의 합 저장 할 곳 
        int [] nlist =new int[n];
        nlist[0]=sc.nextInt();
        dp[1]=nlist[0];
        for (int i =1;i<n;i++){
            nlist[i]=sc.nextInt();
            dp[i+1]=dp[i]+nlist[i];
        }
       
        for (int j=0;j<m;j++){
            int a= sc.nextInt();
            int b =sc.nextInt();
            System.out.println(dp[b]-dp[a-1]);
        }
    }
}