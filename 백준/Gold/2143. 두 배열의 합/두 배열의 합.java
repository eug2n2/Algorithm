import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int t;
	static long ans;
	static ArrayList<Long> left;
	static ArrayList<Long> right;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(bf.readLine());
		ans =0L;
//		if (t == 0) {
//			ans = -1; // 0 , 0 조합으로 하나 빼야 됨
//		}
		
		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}
		int m = Integer.parseInt(bf.readLine());
		int[] arr1 = new int[m];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr1[i] = num;
		}
		
		left = new ArrayList<>();
		right = new ArrayList<>();
		for(int i=0 ; i<n;i++) {
			long chogi = arr[i]; //초기값
			left.add(chogi);
			for(int j=i+1; j<n;j++ ) {
				chogi+= arr[j];
				left.add(chogi);
			}
		}
		
		for(int i=0 ; i<m;i++) {
			long chogi = arr1[i]; //초기값
			right.add(chogi);
			for(int j=i+1; j<m;j++ ) {
				chogi+= arr1[j];
				right.add(chogi);
			}
		}
		Collections.sort(left);
		Collections.sort(right);
		count();
		System.out.println(ans);
	}
	
	public static void count() {
		int leftidx = 0; 
		int rightidx = right.size() - 1;
		while (leftidx < left.size() && rightidx >= 0) {
			long tmp = left.get(leftidx) + right.get(rightidx);
			if (tmp == t) {
				long cnt1 = 0;
				long cnt2 = 0;
				long a = left.get(leftidx);
				long b =  right.get(rightidx);
				while (leftidx < left.size() && left.get(leftidx) == a) {
					cnt1++;
					leftidx++;

				}
				while (rightidx >= 0 && right.get(rightidx) ==b) {
					cnt2++;
					rightidx--;
					
				}
				ans += cnt1 * cnt2;
			} else if (tmp < t) {
				leftidx++;
			} else {
				rightidx--;
			}
		}

	}
}
