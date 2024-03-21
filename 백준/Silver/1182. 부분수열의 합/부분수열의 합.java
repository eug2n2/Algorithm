import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static long[] arr;
	static int n;
	static ArrayList<Long> left;
	static ArrayList<Long> right;
	static int sum;
	static long ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken()); // 슛자 개수
		sum = Integer.parseInt(st.nextToken());
		if (sum == 0) {
			ans = -1; // 0 , 0 조합으로 하나 빼야 됨
		} else {
			ans = 0;
		}

		arr = new long[n];// 값을 저장
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			long num =  Long.parseLong(st.nextToken());
			arr[i] = num;
		}
		left = new ArrayList<>();
		right = new ArrayList<>();
		
		half(0, n / 2,0, left);
		half(n / 2, n,0, right);
		Collections.sort(left);
		Collections.sort(right);
		count();
		System.out.println(ans);
	}

	// 합을 세는 함수
	public static void half(int start, int end, long total, ArrayList<Long> array) {
		if (start ==end) {
			array.add(total);
			return;
		}
		half(start+1,end, total+ arr[start],array);
		half(start+1,end, total,array);
	}

	// 개수 세는 함수
	public static void count() {
		int leftidx = 0;
		int rightidx = right.size() - 1;
		while (leftidx < left.size() && rightidx >= 0) {
			long tmp = left.get(leftidx) + right.get(rightidx);
			if (tmp == sum) {
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
			} else if (tmp < sum) {
				leftidx++;
			} else {
				rightidx--;
			}
		}

	}
}