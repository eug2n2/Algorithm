import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static boolean[] visited;
	static int n;
	static int[] lotto;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n == 0) {
				break;
			} else {
				lotto = new int[n];
				visited = new boolean[n];
				for (int i = 0; i < n; i++) {
					lotto[i] = Integer.parseInt(st.nextToken());
				}
				sb = new StringBuilder();
				combination(0,0);
				System.out.println(sb);
			}
		}
	}

	public static void combination(int cnt,int start) {
		if (cnt == 6) {
			for( int j=0;j<n;j++) {
				if(visited[j]) {
					sb.append(lotto[j]+" ");
				}
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				combination(cnt + 1,i+1);
				visited[i] = false;
			}
		}
	
	}
}
