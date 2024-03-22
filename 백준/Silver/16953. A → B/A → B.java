import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int ans = 1;
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		out: while (a != b) {
			if (b == a) {
				break out;
			} else if (a > b) {
				ans = -1;
				break out;
			}
			String str = Integer.toString(b);
			if (str.charAt(str.length() - 1) == '1') { // 한글자 빼기
				String newstr = str.substring(0, str.length() - 1);
				b = Integer.parseInt(newstr);
				ans++;
			}
			else if (b % 2 == 0) {
				b /= 2;
				ans++;
			} else {
				ans=-1;
				break;
			}

		}
		System.out.println(ans);
	}
}
