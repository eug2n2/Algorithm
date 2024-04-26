import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 0; t < tc; t++) {

			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parent= new int[n + 1];
			for (int i = 1; i <= n; i++) {
				parent[i] = i;
			}
			int ans=0;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				a= find(a);
				b= find(b);
				if(a!=b) {
					union(a,b);
					ans++;
				}	
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	public static int find(int x) {
		if(parent[x]==x) return x;
		return find(parent[x]);
	}
	
	public static void union(int x, int y) {
		if(x<y) parent[y]= x;
		else parent[x]= y;
	}
}