import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());// 행
		String str = bf.readLine();
		char[][] map = new char[5][n / 5]; // 디버깅 용 코드
		int[] col = new int[n / 5+1];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < n / 5; j++) {
				char signal = str.charAt(i * (n / 5) + j);
				if (signal == '#') {
					col[j]++;
					map[i][j] = '#';
				}

			}
		}
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		for (int j = 0; j < n / 5+1; j++) {
			if (col[j]!=0) {
				queue.add(col[j]);
			}
			if (col[j]==0) {
				if(queue.size()==1) {
					sb.append(1);
					queue.clear();
				}else if(queue.size()==3) {
					int a= queue.poll();
					int b = queue.poll();
					int c = queue.poll();
					if ( a==5 && b==2) {
						sb.append(0);
					}else if (a==3 && b==3) {
						sb.append(3);
					}else if (a==3 && b==1) {
						sb.append(4);
					}else if (a==5 && b==3 &&c==4) {
						sb.append(6);
					}else if (a==1) {
						sb.append(7);
					}else if (a==5 && b==3 &&c==5) {
						sb.append(8);
					}else if (a==4&& c==5) {
						sb.append(9);
					}else {
						if (map[1][j-1]=='#') {
							sb.append(2);
						}else {
							sb.append(5);
						}
					}
				}
			}
		}
		System.out.println(sb);
	}
}
