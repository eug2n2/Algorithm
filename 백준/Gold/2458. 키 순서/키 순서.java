import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n+1][n+1];

		int[] comparison= new int[n+1];
		for (int k = 0; k < m; k++) {
			 st = new StringTokenizer(bf.readLine());
			int i=Integer.parseInt(st.nextToken());
			int j =Integer.parseInt(st.nextToken());
			arr[i][j] = 1;
			comparison[i]++;
			comparison[j]++;
		}
		int ans =0;
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(arr[i][j]==1 || i==j) continue;
					if (arr[i][k] >0 && arr[k][j]>0) {
//						System.out.println("i "+i+ " j "+ j+ " k "+ k);
				
						arr[i][j]= 1;
						comparison[i]++;
						comparison[j]++;
					}
				}
				
			}
		}
		for(int i=1;i<=n;i++) {
//			System.out.println(i+" "+ comparison[i]);
			if(comparison[i]==n-1) {
				ans++;
			}
		}
		System.out.println(ans);
		
	}

}