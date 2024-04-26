import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 0; t < tc; t++) {

			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
		
			int ans=n-1;
			for (int i = 0; i < m; i++) {
				bf.readLine();
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}