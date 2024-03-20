import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		else return parent[x] =find(parent[x]);
	}
	public static void kruskal (int[][]graph) {
		int cost =0;
		int max =0;
		for(int i =0; i<graph.length;i++) {
			if(find(graph[i][0])!= find(graph[i][1])) {
				cost+= graph[i][2];
				max =graph[i][2];
				
				union(graph[i][0],graph[i][1]);
			}
		}
		cost-=max;
		System.out.println(cost);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int [][] graph = new int[e][3]; 
		 parent = new int[v+1];
		for (int i=0;i<e;i++) {
			 st = new StringTokenizer(bf.readLine());
			graph[i][0]= Integer.parseInt(st.nextToken());
			graph[i][1]= Integer.parseInt(st.nextToken());
			graph[i][2]= Integer.parseInt(st.nextToken());
		}
		Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);
		for (int i=1; i<=v;i++) {
			parent[i]=i;
		}
		kruskal(graph);
		
	}
}
