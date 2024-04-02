import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long ans;
	static int ans1;
	static int ans2;
	static int ans3;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}
		ans = 3000000001L;
		Arrays.sort(arr);
		ans1 = 0;
		ans2 = 0;
		ans3 = 0;
		for (int i = 0; i < n - 2; i++) {
			if (ans != 0) {
				binarySearch(arr, i);
			}
		}
		System.out.println(ans1 + " " + ans2 + " " + ans3);

	}

	private static void binarySearch(int[] arr, int start) {
		int l = start + 1;
		int r = arr.length - 1;
		while (l < r) {
			long sum =(long)arr[start] + arr[l] + arr[r];
			if (Math.abs(sum) < Math.abs(ans)) {
				
				ans = sum;
				ans1 = arr[start];
				ans2 = arr[l];
				ans3 = arr[r];
			}
			if (sum == 0)
				break;
			if (sum > 0)
				r--;
			else
				l++;
		}
	}
}
