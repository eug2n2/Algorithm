import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][][] map;
	static int r;
	static int c;
	static int time;
	static int uax = 0; // 위쪽 공청의 x좌표
	static int uay = 0;
	static int dax = 0; // 아래쪽 공청
	static int day = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		time = Integer.parseInt(st.nextToken());
		map = new int[time + 1][r][c];

		boolean fill = false;
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < c; j++) {
				map[0][i][j] = Integer.parseInt(st.nextToken());
				if (map[0][i][j] == -1 && !fill) {
					uax = i;
					dax = i + 1;
					fill = true;
				}
			}
		}
		dust(0);
		int ans =0;
		for(int i = 0; i < r; i++) {
			for(int j=0;j<c;j++) {
				ans+=map[time][i][j];
			}
		}
	     
		System.out.println(ans+2);//공기청정기도 미세먼지양으로 더해줬으니까 처리 
	}

	public static void dust(int cnt) {
		if (cnt == time) {
			return;
		}
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[cnt][i][j] > 0) {
					int d = 0; // 확산한 방향
					for (int di = 0; di < 4; di++) {
						int nx = i + dx[di];
						int ny = j + dy[di];
						if (nx >= 0 && ny >= 0 && nx < r && ny < c && map[0][nx][ny] != -1) {
							d++;
							map[cnt + 1][nx][ny] += map[cnt][i][j] / 5;
						}
					}
					if (d > 0) {
						map[cnt + 1][i][j] -= d * (int)( map[cnt][i][j] / 5);
					}
				}
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[cnt + 1][i][j] = map[cnt + 1][i][j] + map[cnt][i][j];
			}
		}
		upclean(cnt);
		downclean(cnt);
		dust(cnt + 1);
	}

	public static void upclean(int cnt ) {
		int[][] copy = new int [r][c];
		for(int i = 0; i < r; i++) {
			copy[i] = map[cnt+1][i].clone();
		}
		map[cnt+1][uax][1]=0;
		for (int j = 1; j < c-1; j++) {
			map[cnt+1][uax][j+1]=copy[uax][j];
		}
		
		for (int i = uax; i >=1; i--) {
			map[cnt+1][i-1][c-1]=copy[i][c-1];
		}
		for (int j = c-1; j >=1; j--) {
			map[cnt+1][0][j-1]=copy[0][j];
		}
		for (int i = 0; i <uax -1; i++) {
			map[cnt+1][i+1][0]=copy[i][0];
		}
			
	}
	public static void downclean(int cnt ) {
		int[][] copy = new int [r][c];
		
		for(int i = 0; i < r; i++) {
			copy[i] = map[cnt+1][i].clone();
		}
		map[cnt+1][dax][1]=0;
		for (int j = 1; j < c-1; j++) {
			map[cnt+1][dax][j+1]=copy[dax][j];
		}
		
		for (int i = dax; i <r-1; i++) {
			map[cnt+1][i+1][c-1]=copy[i][c-1];
		}
		for (int j = c-1; j >=1; j--) {
			map[cnt+1][r-1][j-1]=copy[r-1][j];
		}
		for (int i = r-1; i >dax +1; i--) {
			map[cnt+1][i-1][0]=copy[i][0];
		}
		
	}

}
