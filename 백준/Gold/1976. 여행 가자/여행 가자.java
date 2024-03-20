import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		parent = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	
		String ans ="YES";
		for (int i = 1; i <= n; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				int g = Integer.parseInt(st.nextToken());
				if(g==1) {
				union(i,j);
				}
			}
		}	
		StringTokenizer st= new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		for(int j=1;j<m;j++) {
			int g = Integer.parseInt(st.nextToken());
			if(find(start)!=find(g)) {
				ans ="NO";
				break;
			} else {
				start=  g;
			}
		}

		System.out.println(ans);
	}

	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x > y) {
			parent[x] = y;
		} else if(x<y) {
			parent[y] =x;
		}
	}

}