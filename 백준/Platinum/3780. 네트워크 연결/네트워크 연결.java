import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int[] dist;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(bf.readLine());
			parent = new int[n + 1];
			dist = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				parent[i] = i;
			}
			int b = 0;
			out: while (true) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				char a = st.nextToken().charAt(0);

				switch (a) {
				case 'E':
					b = Integer.parseInt(st.nextToken());
//					System.out.println("find bumo");
					
					find(b);
					sb.append(dist[b]).append("\n");
					break;
				case 'O':
					break out;

				case 'I':
					b = Integer.parseInt(st.nextToken());
					int c = Integer.parseInt(st.nextToken());
					parent[b] = c; //센터는 한개니까
					dist[b] = Math.abs(b - c) % 1000;
//					System.out.println(dist[b]+ " I " + b);
					break;

				}
			}
		}
		System.out.println(sb);
	}

	public static int find(int x) {
		if(parent[x]==x) return x;
		
		int tmp = find(parent[x]);
		dist[x] += dist[parent[x]];
		parent[x] = tmp;
		
		return parent[x];
	}

}
