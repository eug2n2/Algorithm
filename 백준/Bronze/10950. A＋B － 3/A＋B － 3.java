import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(bf.readLine());
 
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
			sb.append('\n');
		}
 
		System.out.println(sb);
	}
}