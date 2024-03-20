import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());// 행
		for (int tc = 0; tc < t; tc++) {
//		boolean[][] map = new boolean [1000][1000];
			String str = bf.readLine();
			int di = 0; // 0 상 1하 2좌 3우
			int[] dx = { -1, 1, 0, 0 };
			int[] dy = { 0, 0, -1, 1 };
			int x = 500;
			int y = 500;
			int rmax = 500;
			int rmin = 500;
			int cmax = 500;
			int cmin = 500;
			for (int i = 0; i < str.length(); i++) {
				char com = str.charAt(i);
				if (com == 'F') {
					x += dx[di];
					y += dy[di];
					rmax = Math.max(rmax, x);
					cmax = Math.max(cmax, y);
					rmin = Math.min(rmin, x);
					cmin = Math.min(cmin, y);
				} else if (com == 'B') {
					if (di == 0 || di == 2) {
						x += dx[di + 1];
						y += dy[di + 1];
					} else {
						x += dx[di - 1];
						y += dy[di - 1];
					}
					rmax = Math.max(rmax, x);
					cmax = Math.max(cmax, y);
					rmin = Math.min(rmin, x);
					cmin = Math.min(cmin, y);
				} else if (com == 'L') {
					if (di == 0 || di == 1) {
						di += 2;
					} else if (di == 2) {
						di = 1;
					} else if (di == 3) {
						di = 0;
					}
				} else {
					if (di == 0) {
						di = 3;
					} else if (di == 2) {
						di = 0;
					} else if (di == 3) {
						di = 1;
					} else {
						di = 2;
					}
				}
			}
			System.out.println((rmax-rmin)*(cmax-cmin));
		}
	}
}
