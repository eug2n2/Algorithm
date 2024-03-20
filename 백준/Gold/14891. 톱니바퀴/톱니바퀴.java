import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int score = 0;
		int[][] arr = new int[4][8];
		int[] idx = new int[4];
		for (int i = 0; i < 4; i++) {
			String str = bf.readLine();
			for (int j = 0; j < 8; j++) { // N0 S0
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		int n = Integer.parseInt(bf.readLine());
		int[][] command = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 2; j++) {
				command[i][j] = Integer.parseInt(st.nextToken());
			}
			if (command[i][1] == 1) { // 시계방향
				int num = command[i][0];
				Queue<Integer> queue = new LinkedList<>();
				while (num < 4 && arr[num - 1][(idx[num - 1] + 2) % 8] != arr[num][(idx[num] + 6) % 8]) {
					queue.add(num);
					num++;
				}
				num = command[i][0];
				while (num > 1 && arr[num - 1][(idx[num - 1] + 6) % 8] != arr[num - 2][(idx[num - 2] + 2) % 8]) {
					queue.add(num - 2);
					num--;
				}
				num = command[i][0];
				while (!queue.isEmpty()) {
					int p = queue.poll();
					if (Math.abs(num - 1 - p) % 2 == 1) {
						idx[p] += 1;
					} else {
						idx[p] += 7;
					}
				}
				idx[command[i][0] - 1] += 7;
			} else if (command[i][1] == -1) { // 반시계방향
				int num = command[i][0];
				Queue<Integer> queue = new LinkedList<>();
				while (num < 4 && arr[num - 1][(idx[num - 1] + 2) % 8] != arr[num][(idx[num] + 6) % 8]) {
					queue.add(num);
					num++;
				}
				num = command[i][0];
				while (num > 1 && arr[num - 1][(idx[num - 1] + 6) % 8] != arr[num - 2][(idx[num - 2] + 2) % 8]) {
					queue.add(num - 2);
					num--;
				}
				num = command[i][0];
				while (!queue.isEmpty()) {
					int p = queue.poll();
					if (Math.abs(num - 1 - p) % 2 == 1) {
						idx[p] += 7;
					} else {
						idx[p] += 1;
					}
				}
				idx[command[i][0] - 1] += 1;
			}
		}
		if (arr[0][idx[0] % 8] == 1) {
			score += 1;
		}
		if (arr[1][idx[1] % 8] == 1) {
			score += 2;
		}
		if (arr[2][idx[2] % 8] == 1) {
			score += 4;
		}
		if (arr[3][idx[3] % 8] == 1) {
			score += 8;
		}
		System.out.println(score);
	}

}
