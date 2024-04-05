import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[] arr = new int[n];
			int[] brr = new int[m];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < m; i++) {
				brr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			Arrays.sort(brr);

			int ans = 0;
			int left = 0;
			int right = arr.length - 1;
			for (int i = 0; i < m; i++) {
				
				while (left<=right ) {
					if(brr[i]>=arr[left]) left++;
					else {
						ans+= arr.length-left;
						break;
					}
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

}
