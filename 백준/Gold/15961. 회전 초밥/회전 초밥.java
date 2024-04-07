import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int n, d, k, c;
	static int ans = 0;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> sushi = new HashMap<>(); // 먹은 초밥 저장

		arr = new int[n + k - 1];
		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(bf.readLine());
			arr[i] = tmp;
			if (i < k) {
				if (sushi.containsKey(tmp)) {
					sushi.put(tmp, sushi.get(tmp) + 1);
				} else {
					sushi.put(tmp, 1);
				}
			}
		}
		for (int i = 0; i < k - 1; i++) {
			arr[n + i] = arr[i];
		}
		
		ans = sushi.size();
		if (!sushi.containsKey(c))
			ans++;
		for (int i = k; i < n + k - 1; i++) {
			int find = arr[i - k];
			int now = arr[i];
			if (ans == k + 1)
				break;
			else if (find != arr[i]) {
				if (sushi.get(find) >= 2) {
					sushi.put(find, sushi.get(find) - 1);
				} else {
					sushi.remove(find);
				}

				if (sushi.containsKey(now)) {
					sushi.put(now, sushi.get(now) + 1);
				} else {
					sushi.put(now, 1);
				}
				int tmp =sushi.size();
				if (!sushi.containsKey(c)) {
					tmp++;
				}
				ans = Math.max(ans,tmp);
			}
		}
		System.out.println(ans);
	}
}
