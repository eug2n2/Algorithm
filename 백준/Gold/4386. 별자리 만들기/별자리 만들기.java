import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static double[] map;
	public static void union(int  x, int y) {
		x= find(x);
		y=find(y);
		if(x<y) parent[y]=x;
		else parent[x]=y;
	}
	public static int find(int x) {
		if(x==parent[x]) return x;
		else return parent[x] =find(parent[x]);
	}
	public static void kruskal (double[][]map) {
		double cost =0;
		for(int i =0; i<map.length;i++) {
			if(find((int)map[i][0])!= find((int)map[i][1])) {
				cost+= Math.sqrt(map[i][2]);
				union((int)map[i][0],(int)map[i][1]);
			}
		}
		System.out.println(Math.round(cost*100)/100.0);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		double [][] graph = new double[n][3]; 
		double[][] map = new double [(n-1)*(n)/2][3];
		 parent = new int [n];
		for (int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			graph[i][0]= Double.parseDouble(st.nextToken());
			graph[i][1]= Double.parseDouble(st.nextToken());
			graph[i][2] = i;
			
		}
		int idx=0;
		for (int i =0; i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				map[idx][0] = graph[i][2];
				map[idx][1] = graph[j][2];
				map[idx][2] = Math.pow(graph[i][0]-graph[j][0],2)+Math.pow(graph[i][1]-graph[j][1],2);
				idx++;
			}
		}
		Arrays.sort(map, (o1, o2) -> Double.compare(o1[2], o2[2]));
	
		for (int i=0; i<n;i++) {
			parent[i]=i;
		}
		kruskal(map);
		
	}
}
