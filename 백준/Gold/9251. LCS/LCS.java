import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String a = bf.readLine();
		char[] ac = a.toCharArray();
		String b= bf.readLine();
		char[] bc = b.toCharArray();
		int asize = a.length();
		int bsize = b.length();
		int[][]dp = new int[asize+1][bsize+1];
		for (int i=1;i<=asize;i++) {
			for (int j=1; j<=bsize ; j++) {
				if(ac[i-1]==bc[j-1]) dp[i][j]= dp[i-1][j-1]+1;
				else  dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		System.out.println(dp[asize][bsize]);
	}
}
