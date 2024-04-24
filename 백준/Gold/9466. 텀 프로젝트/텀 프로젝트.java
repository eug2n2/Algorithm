import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < tc; t++) {
			int n = Integer.parseInt(bf.readLine());
			parent = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				parent[i] = i;
			}
			int ans = n;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int i = 1; i <= n; i++) {
				int num = Integer.parseInt(st.nextToken());
				if (i == num) {
					ans--;
					parent[i]=0;
				} else if(parent[num]==0) {
					parent[i]=0;
					continue;
				}else {
					int a = find(i);
					int b = find(num);
//					System.out.println(a+": "+b+" "+i+" "+num);
					if (a != b) {
						union(i, num);
					} else {
						
						int son = 2;
						int p = parent[num];
//						System.out.println(num+" "+p);
						while (true) {
							if (p == i) {
								break;
							} else {
								son++;
								p = parent[p];
							}
						}
						p = num;
//						System.out.println(a+" a"+ p);
//						System.out.println("i번째 잉"+ i);
//						for(int ii=1;ii<=n;ii++) {
//							System.out.print(parent[ii]+" ");
//						}
//						System.out.println("_)_");
						while (true) {
							if(p==a|| p ==0) {
								break;
							}
							int tmppi = parent[p];
							parent[p] =0;
							p= tmppi;
						}
//						System.out.println("i번째 잉"+ i);
//						for(int ii=1;ii<=n;ii++) {
//							System.out.print(parent[ii]+" ");
//						}
//						System.out.println();
						ans -= son;
					}
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

	public static int find(int a) {
		if (a == parent[a])
			return a;
		return find(parent[a]);
	}

	public static void union(int a, int b) {
		
		parent[a] = b;
		
	}
}
