

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//dfs풀이 
public class Main {
	static int n;
	static int min;
	static int max;
	static String[][] star;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		min = n - 1;
		max = n - 1;
		star = new String[n][2 * n - 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2 * n - 1; j++) {
				star[i][j] = " ";
			}
		}
		StringBuilder sb = new StringBuilder();
		dfs(0, n - 1,n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= 2 * (n - 1); j++) {
				if (!star[i][j].equals("*")) {
					sb.append(" ");
				} else {
					sb.append(star[i][j]);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int x, int y, int size) {
		if(size==3) {
		star[x][y] = "*";
		star[x + 1][y - 1] = "*";
		star[x + 1][y + 1] = "*";
		for (int i = y - 2; i <= y + 2; i++) {
			star[x + 2][i] = "*";
		}
		return;}
		else {
			dfs(x,y,size/2);
			dfs(x+size/2,y-size/2,size/2);
			dfs(x+size/2,y+size/2,size/2);
		}
		

	}

}
