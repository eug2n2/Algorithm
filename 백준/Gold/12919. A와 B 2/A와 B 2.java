import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
		String a = bf.readLine();
		String b = bf.readLine();
		
		System.out.println(dfs(a,b));
	}

	static int dfs(String a, String b) {
		if (a.length() == b.length()) {
			if (a.equals(b)) {
				return 1;
			}
			return 0;
		}
		int ans = 0;
		if (b.charAt(0) == 'B') {
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < b.length(); i++) {
				sb.append(b.charAt(i));
			}
			String reversed = sb.reverse().toString();
			ans += dfs(a, reversed);
		}
		if (b.charAt(b.length() - 1) == 'A') {
			ans += dfs(a, b.substring(0, b.length() - 1));
		}
		if(ans>=1) return 1;
		return 0;
	}

}