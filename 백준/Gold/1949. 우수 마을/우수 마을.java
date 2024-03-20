import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static List<Integer>[] graph;
	static int n;
	static int max;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine()); // 슛자 개수
		arr = new int[n+1];// 값을 저장 
		dp= new int[n+1][2]; // 누적된 ans를 저장
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] =num;
		}
		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		int start =0;
		for (int i = 1; i <= n; i++) {
			if(graph[i].size()==1) {
				start=i;
				break;
			}
		}
		boolean[] visited = new boolean[n + 1];
		visited[start]= true;
		dfs(visited,start);
		System.out.println(Math.max(dp[start][0], dp[start][1]));
	}
	
	public static void dfs(boolean[]visited,int start) {
		for (int i=0; i<graph[start].size();i++) {
			int num= graph[start].get(i);
			if(!visited[num]) {
				visited[num]=true;
				dfs(visited,num);
				dp[start][0] += Math.max(dp[num][0], dp[num][1]);// start의 노드를 포함하지않는다. 
				dp[start][1] +=dp[num][0]; //start의 노드를 포함하니까, 그다음 노드는 무조건 포함하지않아야합니다.
			}
		}
		//자식 없을 수도있으니까 여기에
		dp[start][1]+= arr[start];
	}

}