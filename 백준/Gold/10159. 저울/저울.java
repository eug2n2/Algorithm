import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][]arr;
	static boolean[] visited;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());

		 arr = new int[n + 1][n + 1]; // arr[a][b] 라면 a>b는 의미 

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			visited = new boolean[n+1];
			cnt =0;
			visited[i]= true;
			findsmall(i);
			findbig(i);
			int tmp = n-1-cnt; // 자기자신 -1
			sb.append(tmp).append("\n");
		}
		System.out.println(sb);
	}
// x보다 작은 것 찾기
	public static void findsmall( int x ) {
		for(int i=1;i<=n;i++) {
			if(!visited[i] && arr[i][x] ==1) {
				visited[i] =true;
				cnt++;
				findsmall(i);
			}
		
		}
	}
// x보다 큰 것 찾기
	public static void findbig( int x ) {
		for(int i=1;i<=n;i++) {
			if(!visited[i] && arr[x][i] ==1) {
				visited[i] =true;
				cnt++;
				findbig(i);
			}
		}
	}
}
