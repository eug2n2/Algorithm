import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());

		long[] arr = new long[n + 2];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		if (b <= c) { // b<=c라면 그냥 사는게 이득임
			long sum = 0;
			for (long num : arr) {
				sum += num;
			}
			System.out.println(sum * b);
			return;
		}
		long ans = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] > 0) {
				if (arr[i + 1] > arr[i + 2]) {
					// 차는 무조건 남겨둘거니까
					long a = Math.min(arr[i], arr[i + 1] - arr[i + 2]);
					ans += (b + c) * a;
					arr[i] -= a;
					arr[i + 1] -= a;

					long tmp = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
					ans += (b + 2 * c) * tmp;
					arr[i] -= tmp;
					arr[i + 1] -= tmp;
					arr[i + 2] -= tmp;
				} else { // 최대한 많이제거
					long tmp = Math.min(arr[i], arr[i + 1]);
					ans += (b + 2 * c) * tmp;
					arr[i] -= tmp;
					arr[i + 1] -= tmp;
					arr[i + 2] -= tmp;

					long a = Math.min(arr[i], arr[i + 1]);
					ans += (b + c) * a;
					arr[i] -= a;
					arr[i + 1] -= a;
				}
				ans += b * arr[i];
			}
		}
		System.out.println(ans);
	}
}
