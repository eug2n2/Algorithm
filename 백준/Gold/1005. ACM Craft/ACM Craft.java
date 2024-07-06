import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited ;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		out: for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken()); // 건물 개수
			int k = Integer.parseInt(st.nextToken()); // 건설순서 규칙
			// 건물 당 건설에 걸리는 시간
			int[] arr = new int[n + 1];
			
			st = new StringTokenizer(bf.readLine());
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			visited = new boolean[n+1];
			int[] dp =new int[n+1];
			// x-> y 지어야함
			ArrayList<Integer>[] dir = new ArrayList[n+1];
			ArrayList<Integer>[] ready = new ArrayList[n+1];
			for(int i =1;i<=n;i++) {
				dir[i] = new ArrayList<>();
				ready[i]= new ArrayList<>();
				visited[i]=true;
			}
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(bf.readLine());
				int x = Integer.parseInt(st.nextToken()); // 건물 개수
				int y = Integer.parseInt(st.nextToken());
				dir[x].add(y);
				ready[y].add(x);
				visited[y]=false;
			}
			int w =Integer.parseInt(bf.readLine());
			Deque<Integer> queue = new ArrayDeque<>();
		
			for(int i =1;i<=n;i++) {
				if(visited[i]) {
					dp[i]=arr[i];
					for(int j =0 ;j<dir[i].size();j++) {
						queue.add(dir[i].get(j));
					}
					if ( i==w) {
						sb.append(arr[i]).append("\n");
						continue out;
					}
				}
			}
			while(!queue.isEmpty()) {
				int p = queue.poll();
				if(visited[p]) {
					continue;
				}
				int max =0;
				for (int i =0;i<ready[p].size();i++) {
					int tmp =ready[p].get(i);
					if(!visited[tmp]) {
						max =-1;
						break;
					}
					if(max<dp[tmp]) {
						max = dp[tmp];
					}
				}
			
				if(max==-1) {
					queue.add(p);
				}else {
					dp[p]=max+arr[p];
					visited[p]=true;
					if ( p==w) {
						sb.append(dp[p]).append("\n");
//						for(int i =1; i<=n;i++) {
//							System.out.println(dp[i] +" i "+ i );
//						}
						continue out;
					}
					for(int j =0 ;j<dir[p].size();j++) {
						queue.add(dir[p].get(j));
					}
					
				}
			}
			
		}
		System.out.println(sb);

	}
	
}
