
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	public static void main(String[] args)throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n =Integer.parseInt(st.nextToken());
		parent = new int [n+1];
		for (int i=1;i<=n;i++) {
			parent[i]=i;
		}
		int m =Integer.parseInt(st.nextToken()); // 파티수 
		st = new StringTokenizer(bf.readLine());
		int k =Integer.parseInt(st.nextToken()); // 진아사
		for (int i=0;i<k;i++) {
			parent[Integer.parseInt(st.nextToken())]=0;
		}
		
		List<Integer>[] partyList = new ArrayList[m];
		for(int i=0; i<m; i++) {
			partyList[i] = new ArrayList<>();
		}
		
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(bf.readLine());
			int p =Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			partyList[i].add(x);
			for (int j=1;j<p;j++) {
				int y = Integer.parseInt(st.nextToken());
				union(x,y);
				partyList[i].add(y);
			}
		}
		int cnt=0;
		for (int i=0;i<m;i++) {
			boolean flag = true;
			for(int num : partyList[i]) {
				if(find(num)==0) {
					flag =false;
					break;
				}
			}
			if(flag) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	static void union(int x, int y) {
		x= find(x);
		y= find(y);
		if(x<y) {
			parent[y]=x;
		} else {
			parent[x]=y;
		}
	}
	
	static int find(int x) {
		if (x==parent[x]) {
		return x;
		}else {
			return find(parent[x]);
		}
		
	}
}
