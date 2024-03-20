import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static String[][] map;
	static int value = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		n= Integer.parseInt(bf.readLine());
		
		map = new String[n][n];
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] =" ";
			}
		}
		star(0,n,0,n, n);
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void star(int xstart,int xend, int ystart, int yend, int size) {
		
		if (size == 1) {
			map[xstart][ystart]="*";
				
				
		} else {
			int length =size/ 3;
			star(xstart,xstart+length, ystart,ystart+length, size / 3);
			star(xstart,xstart+length, ystart+length,yend-length, size / 3);
			star(xstart,xstart+length, yend-length,yend, size / 3);
			star( xstart+length,xend-length, ystart,ystart+length, size / 3);
			star( xstart+length,xend-length, yend-length,yend, size / 3);
			star( xend-length,xend, ystart,ystart+length, size / 3);
			star(xend-length,xend,ystart+length,yend-length, size / 3);
			star(xend-length,xend, yend-length,yend, size / 3);
			
		}
	}
}
