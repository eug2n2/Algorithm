import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n=Integer.parseInt(st.nextToken()); // 행의수 
		int m=Integer.parseInt(st.nextToken()); // 열개수 
		int r=Integer.parseInt(st.nextToken()); // 연산의수 
		int [][] map = new int[n][m];


		for (int i =0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(bf.readLine());
		for (int t=0;t<r;t++) {
			int a= Integer.parseInt(st.nextToken());
			n=map.length;
			m=map[0].length;
			if(a==1) {
				for (int j =0;j<m;j++) {
					for (int i=0;i<n/2;i++) {
						int tmp=map[i][j];
						map[i][j]=map[n-1-i][j];
						map[n-1-i][j]=tmp;
					}
				}
			} else if (a==2) {
				for (int i =0;i<n;i++) {
					for (int j=0;j<m/2;j++) {
						int tmp=map[i][j];
						map[i][j]=map[i][m-1-j];
						map[i][m-1-j]=tmp;
					}
				}
			} else if (a==3) {
				int[][] newmap= new int[m][n];
				for (int i =0;i<m;i++) {
					for (int j =0;j<n;j++) {
						newmap[i][j]= map[n-1-j][i];
					
					}
				}
				map= newmap;
			} else if (a==4) {
				int[][] newmap= new int[m][n];
				for (int i =0;i<m;i++) {
					for (int j =0;j<n;j++) {
						newmap[i][j]= map[j][m-1-i];
					
					}
				}
				map= newmap;
			} else if(a==5) {
				int[][] newmap= new int[n][m];
				for (int i =0;i<n/2;i++) { //1그룹 
					for (int j =0;j<m/2;j++) {
						newmap[i][j+m/2]= map[i][j];
					}
				}
				for (int i =0;i<n/2;i++) { //2그룹 
					for (int j =m/2;j<m;j++) {
						newmap[i+n/2][j]= map[i][j];
					}
				}
				for (int i =n/2;i<n;i++) { //3그룹 
					for (int j =m/2;j<m;j++) {
						newmap[i][j-m/2]= map[i][j];
					}
				}
				for (int i =n/2;i<n;i++) { //4그룹 
					for (int j =0;j<m/2;j++) {
						newmap[i-n/2][j]= map[i][j];
					}
				}
				map= newmap;
			} else {
				int[][] newmap= new int[n][m];
				for (int i =0;i<n/2;i++) { //1그룹 
					for (int j =0;j<m/2;j++) {
						newmap[i+n/2][j]= map[i][j];
					}
				}
				for (int i =0;i<n/2;i++) { //2그룹 
					for (int j =m/2;j<m;j++) {
						newmap[i][j-m/2]= map[i][j];
					}
				}
				for (int i =n/2;i<n;i++) { //3그룹 
					for (int j =m/2;j<m;j++) {
						newmap[i-n/2][j]= map[i][j];
					}
				}
				for (int i =n/2;i<n;i++) { //4그룹 
					for (int j =0;j<m/2;j++) {
						newmap[i][j+m/2]= map[i][j];
					}
				}
				map= newmap;
				
			}
			
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length-1;j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append(map[i][map[0].length-1]+"\n");
		}
		System.out.println(sb);
	}
}
