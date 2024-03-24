import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int k;
	static int weight[];
	static int value[];
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken()); // item 개수
		k = Integer.parseInt(st.nextToken()); // 버틸 수있는 무게 
		weight = new int [n];
		value = new int[n];
		dp = new int[n][k+1];
		for (int i =0;i<n;i++) { // 무게와 가치가 주어진다. 
			st = new StringTokenizer(bf.readLine());
			weight[i] =Integer.parseInt(st.nextToken());
			value[i] =Integer.parseInt(st.nextToken());
		}
		System.out.println(put(0,0));
	}
	public static int put(int i, int w) {
		if(i==n) return 0;
		if(dp[i][w]>0) return dp[i][w]; // 이미 탐색완료했으니 반환함
		int a=0; //현재 담은거 
		if(w+weight[i]<=k) a = value[i]+ put(i+1, weight[i]+w);
		int b = put(i+1,w); // 지금거 안넣음
		return dp[i][w] =Math.max(a, b);
	}
}
