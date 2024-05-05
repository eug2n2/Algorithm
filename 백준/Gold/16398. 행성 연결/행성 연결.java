import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	public static void union(int x, int y) {
		x= find(x);
		y=find(y);
		if(x<y) parent[y]=x;
		else parent[x]=y;
	}
	public static int find(int x) {
		if(x==parent[x]) return x;
		return parent[x] =find(parent[x]);
	}
	public static void kruskal (int[][]graph) {
		long cost =0;
		for(int i =0; i<graph.length;i++) {
			if(find(graph[i][0])!= find(graph[i][1])) {
				cost+= graph[i][2];
				union(graph[i][0],graph[i][1]);
			}
		}
		System.out.println(cost);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		parent= new int[n+1];
		for(int i=0;i<=n;i++) {
			parent[i]=i;
		}
	
		int[][] graph = new int[n*n][3]; 
		for(int i=0;i<n;i++) {
		    StringTokenizer st = new StringTokenizer(bf.readLine());
		    for(int j=0;j<n;j++) {
                int w =Integer.parseInt(st.nextToken());
                if (i >= j) continue;
		    	int idx = i*n+ j;
		    	graph[idx][0]=i;
		    	graph[idx][1]=j;
		    	graph[idx][2]= w;
		    }
		}
		Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);
		kruskal(graph);
	}
}
