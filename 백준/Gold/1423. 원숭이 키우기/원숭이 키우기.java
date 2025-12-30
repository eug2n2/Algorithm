import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		
		int[] counts = new int[n ];
		int[] power = new int[n ];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0 ; i < n ; i++) {
			counts[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		for(int i = 0 ; i < n ; i++) {
			power[i] = Integer.parseInt(st.nextToken());
		}
		
		int d = Integer.parseInt(bf.readLine());
		
		long base = 0;
		for(int i = 0 ; i < n ; i++) {
			base += (long) counts[i] * power[i];
			counts[i] = Math.min(d, counts[i]);
		}
		
		long[] dp = new long[d + 1];
		
		for(int i = 0 ; i < n ; i++) { // level stat point 
			while(counts[i] > 0) {
				for(int j = d ; j >= 0 ; j--) { 
					for(int k = i + 1 ; k < n && k + j - i <= d ; k++) { // level end point
						dp[j + k - i] = Math.max(dp[j + k - i], dp[j] + power[k] - power[i]);
					}
				}
				counts[i]--;
			}
		}
		
		bw.write((base + dp[d]) + "\n");
		
		bf.close();
		bw.flush();
		bw.close();
	}
}

// greedy로 해결할시, 문제점: level 6이 오르고 힘 13, level 4 가 오르고 8 이 있음 
// d=6  일때는 13이 답이고 d=8이면 16이 답인데 그걸 모름