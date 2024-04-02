import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int bridges;
	static int bridgee;
	static int n,m;
	static int[] parent;
	static Node[] graph; 
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken()); // 섬 개수 
		m = Integer.parseInt(st.nextToken());
		graph = new Node[m];
 		int minweight = Integer.MAX_VALUE;
		int maxweight = 0;
		parent= new int[n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[i] = new Node(a,b,c); 
			minweight = Math.min(c, minweight);
			maxweight = Math.max(maxweight, c);
		}
		Arrays.sort(graph);
	
		st = new StringTokenizer(bf.readLine());
		bridges = Integer.parseInt(st.nextToken());
		bridgee = Integer.parseInt(st.nextToken());
		int ans = binearySearch(minweight, maxweight);
		System.out.println(ans);

	}


	public static int binearySearch(int minweight, int maxweight) {
		int start = minweight;
		int end = maxweight;
		int ans = 0;
		while (start <= end) {
			for(int i=1;i<=n;i++) {
				parent[i] =i;
			}
			int mid = (start + end) / 2;
		
			unionbridge(mid);
			if (find(bridgee)==find(bridges)) {
				ans = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return ans;
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return;
		
		if(x <= y) parent[y] = x;
		else parent[x] = y;
	}
	public static void unionbridge(int mid) {
		for(int i=m-1;i>=0;i--) {
			if( graph[i].nval<mid) {
				break;
			}
			union(graph[i].nstart,graph[i].nend);
		}
	}
    // find 연산
	public static int find(int x) {
		if(parent[x] == x) return x;
		return find(parent[x]);
	}
    
}

class Node implements Comparable<Node>{
	int nstart ;
	int nend;
	int nval;
	Node(int nstart, int nend, int nval){
		this.nstart= nstart;
		this.nend = nend;
		this.nval = nval;
	}
	@Override
	public int compareTo(Node o) {
		return this.nval -o.nval;
	}
}

