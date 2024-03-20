import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		long ans = 1;
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			long a = 1;
			if (x - t >= 1) {
				a += t;
			} else a += x - 1;
			
			if (w >= x + t) {
				a += t;
			} else a += w - x;
			
			long b = 1;
			if (y - t >= 1) {
				b += t;
			} else b += y - 1 ;
			
			if (h >= y + t) {
				b += t;
			} else b += h - y;
			
			ans *= (a * b) % 998244353;
			ans %= 998244353;
		}
		System.out.println(ans);
	}
}