import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent ;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n]; //0 부터 n − 1 까지 고유한 번호가 부여된 평면 상의 점 n 개가 주어짐
		for(int i=0;i<n;i++) {
			parent[i]=i;
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if(!union(x,y)) {
				System.out.println((i+1));
				return;
			}
		}

		System.out.println(0);
		
		
	}
	static int find(int a) {
		if(parent[a]==a) return a;
		return  parent[a] = find(parent[a]);
	}
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa==pb) return false;
		if(pa<pb) parent[pb]=pa;
		else parent[pa]=pb;
		return true;
	}
}