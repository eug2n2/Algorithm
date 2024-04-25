import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Integer>[] graph = new ArrayList[n + m+ 1]; // 역과 하이퍼튜브를 같이 관리해주기 위함
		//아니면 a: n개 b: m개 사이즈의 인접리스트두개를 만들어서 관리해야한다.
		for (int i = 0; i <= n+m; i++) {
			graph[i] = new ArrayList<>();
		}
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			while (true) {
				int num = (Integer.parseInt(st.nextToken()));
				if(num==-1) {
					break;
				}
				graph[n+i+1].add(num); 
				graph[num].add(n+i+1); // n보다 크다면 튜브, n보다 같거나 작다면 역으로 구분짓는다해 
			}
		}
		int[] visited = new int[n + m+1]; // 방문이자 거리의 확인 수단으로 생각
		for (int i = 1; i <= n+m; i++) {
			visited[i] = Integer.MAX_VALUE;
		}
		st = new StringTokenizer(bf.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		int ans= Integer.MAX_VALUE;
		visited[start] = 0;
		queue.add(start);
	
		while (!queue.isEmpty()) {
			int p = queue.poll();
			if (p == end) {
				ans =visited[end]-1; // 1빼주는 이유 원래 노선도 하나 세고시작하니까...
				break;
			}
			for (int i = 0; i < graph[p].size(); i++) {
				int t = graph[p].get(i);
				if (visited[t] == Integer.MAX_VALUE ) {
					if(t<=n) visited[t] = visited[p];
					else visited[t] = visited[p] +1;
					queue.add(t);
				}
			}
		}
		if(ans==-1) ans=0;
		if(ans==Integer.MAX_VALUE) ans=-1;
		System.out.println(ans);

	}
	
}
