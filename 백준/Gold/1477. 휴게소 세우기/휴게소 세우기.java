import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n; // 현재 휴게소 개수
	static int m, l; // 더 지으려는 휴게소의 수 / 고속도로 길이
	static int maxdiff;
	static int[] doro;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		doro = new int[n];
		if (n != 0) {
			st = new StringTokenizer(bf.readLine());
		}
		for (int i = 0; i < n; i++) {
			doro[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(doro);
		System.out.println(binary());
	}

	public static int binary() {
		int start = 1;
		int end = l;
		int ans = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			
			int pcnt = 0; // 추가한 도로개수
			int size = 1;
			while (n != 0 && size * mid < doro[0]) {
				pcnt++;
				size++;
			}
			for (int i = 1; i < n; i++) {
				int diff = doro[i] - doro[i - 1] - 1;
				pcnt += diff / mid;
			}
			size = 1;
			while (n != 0 && doro[n - 1] + size * mid < l) {
				pcnt++;
				size++;
			}
			if (n == 0) {
				int diff = l - 1;
				pcnt += diff / mid;
			}
			if (pcnt <= m) {
				ans = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return ans;
	}

}
