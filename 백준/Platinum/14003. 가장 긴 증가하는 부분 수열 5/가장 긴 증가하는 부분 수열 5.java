import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
	static int[] lis;
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine()); // 크기
		int[] arr = new int[n];
		// 길이
		int[] dp = new int[n];
		// 각 숫자의 수열

		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		lis = new int[n+1];  // 길이가 len인 부분수열들의 마지막 값 중 최솟값
		lis[0] = -1000000001;//가장 작은 숫자가 -10억이니까 
		int idx=0;
		int len = 0; // 가장 긴 길이 저장 
		for (int i = 0; i < n; i++) {
			if(arr[i] > lis[len]) {
				dp[i] = ++len;
				lis[len] =arr[i];
			}else {
				idx = binarySearch(0, len, arr[i]); // lis 배열 중 최솟값을 기준으로 위치를 탐색
				lis[idx] = arr[i];
				dp[i] = idx;
			}

		}
		StringBuilder sb = new StringBuilder();
		sb.append(len+"\n");
		
		Stack<Integer> s = new Stack<>();
		for(int i=n-1; i>=0; i--) {
			if(dp[i] == len) {
				s.push(arr[i]);
				len--;
			}
		}
		
		while(!s.isEmpty()) {
			sb.append(s.pop()+" ");
		}
		System.out.println(sb.toString());

	}
	  
		static int binarySearch(int left, int right, int key) {
			int mid =0;
			while(left < right) {
				mid = (left+right)/2;
				
				if(lis[mid] < key) {
					left = mid+1;
				}else {
					right = mid;
				}
			}
			return right;
		}
}