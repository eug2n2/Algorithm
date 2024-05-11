import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());
		int[][] arr = new int[n+1][n+1];

		for (int k = 0; k < m; k++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int i=Integer.parseInt(st.nextToken());
			int j =Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			if( arr[i][j]==0 ||(arr[i][j]!=0 && arr[i][j]>w)) arr[i][j] = w;
			
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (arr[i][k] >0 && arr[k][j]>0) {
//						System.out.println("i "+i+ " j "+ j+ " k "+ k);
						if(i==j) continue;
						int cost =arr[i][k]+arr[k][j];
						if(arr[i][j]==0) {
							arr[i][j]= cost;
//							System.out.println("change0");
						}else if(arr[i][j]!=0 && arr[i][j]>cost){
							arr[i][j]=cost;
//							System.out.println("change");
						}
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}