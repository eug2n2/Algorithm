import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int k;
	static int[][] map;
	static int[][]cal;
	static int ans = Integer.MAX_VALUE;
	static boolean[] visited ;
	static int[][] nlist;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map =new int[n][m];
		k = Integer.parseInt(st.nextToken());
		cal= new int[k][3];
		nlist= new int[k][3];
		visited = new boolean[k];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());// 변경하지마 
			}
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			cal[i] =new int[] {r,c,s};
		}
		dfs(0);
		System.out.println(ans);
	}

	public static void dfs(int cnt) {
		if(cnt==k) {
			int[][] newmap = new int[n][m];
			for (int i = 0; i < n; i++) {
				newmap[i] = map[i].clone();
			}
			for (int i = 0; i < k; i++) {
				newmap=spin( nlist[i][0],nlist[i][1],nlist[i][2],newmap);
			}
			for (int i = 0; i < n; i++) {
				int tmp=0;
				for(int j=0;j<m;j++) {
					tmp += newmap[i][j];
				}
				ans = Math.min(ans, tmp);
			}
			return;
		}
		for (int i = 0; i < k; i++) {
			if(!visited[i]) {
				visited[i]=true;
				nlist[cnt]= cal[i];
				dfs(cnt+1);
				visited[i]=false;
			}
		}
	}
	public static int[][] spin(int r, int c, int s,int[][]amap) {
		int[][] newmap = new int[n][m];
		for (int i = 0; i < n; i++) {
			newmap[i] = amap[i].clone();
		}
		while (s >= 1) {
			for (int j = c - s+1; j <= c + s; j++) {
				newmap[r-s][j] = amap[r-s][j-1];
			}
			for (int i = r - s+1; i <= r + s; i++) {
				newmap[i][c+s]= amap[i-1][c+s];
			}
			for (int j = c - s; j < c + s; j++) {
			newmap[r+s][j] = amap[r+s][j+1];
			}
			for (int i = r - s; i < r + s; i++) {
				newmap[i][c-s]= amap[i+1][c-s];
			}
			s--;
		}
		return newmap;
	}

}
