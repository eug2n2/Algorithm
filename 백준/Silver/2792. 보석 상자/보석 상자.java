import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n; // 아이들의 수
	static int m; // 색상의 수
	static int maxj;
	static int[] jewarly;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		maxj = 0;
		jewarly = new int[m];
		for (int i = 0; i < m; i++) {
			jewarly[i] = Integer.parseInt(bf.readLine());
			maxj = Math.max(maxj, jewarly[i]);
		}
		System.out.println(binary());
	}

	public static int binary() {
		int start =1;
		int end = maxj;
		int ans = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			int pcnt = 0; // 나눠준 사람수
			for (int i =0;i<m;i++) {
				pcnt+= jewarly[i]/mid;
				if(jewarly[i]%mid!=0) {
					pcnt++;
				}
			}
			if (pcnt <= n) {
				ans = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return ans;
	}

}
