import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken()); // 땅 nxn
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] vitamin = new int[n][n];
		int[][] winter = new int[n][n];
		Deque<Integer>[][] age = new ArrayDeque[n][n];
		int ans = m; // 초기 나무의 개수는 m

		// 겨울에 추가되는 양분 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				winter[i][j] = Integer.parseInt(st.nextToken());
				vitamin[i][j] = 5; // 처음 양분은 모든 칸에 5만큼 들어있다고 설정
				age[i][j] = new ArrayDeque<>(); // deque를 사용한다면, 정렬을 한번도 하지 않아도 동일한 결과를 낼 수 있음
			}
		}

		// 한 구역에 처음 심어지는 나무는 최대 1개로 제한되니까 문제없다.
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1; // 땅 nxn
			int y = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			age[x][y].add(z);
		}
        Deque<Integer> tmp = new ArrayDeque<>();
		int[][] di = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

		// k년 동안 반복
		for (int year = 0; year < k; year++) {
			// 봄
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int tmpvitamin =0;
					tmp = new ArrayDeque<>();
					// 죽은 나무 처리
					while(!age[i][j].isEmpty()) {
						int currentAge = age[i][j].pollFirst();
						if (vitamin[i][j] < currentAge) {
							// 양분 부족으로 죽는 나무 처리
							tmpvitamin += (currentAge / 2); // 여름
//							System.out.println(currentAge+ " "+ (currentAge / 2) );
							ans--; // 나무 개수 감소

						} else {
							// 양분 먹고 나이 추가
							vitamin[i][j] -= currentAge;
							tmp.add(currentAge + 1); // 나이를 증가시킨 나무를 다시 추가
							
						}
					}
					vitamin[i][j]+= tmpvitamin;
					age[i][j] = tmp;
				}
			}

			// 가을, 겨울
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					vitamin[i][j] += winter[i][j]; // 가을에 양분을 안 건들이니까, 겨울 양분 추가
					for (int val : age[i][j]) {
						if (val % 5 != 0) {
							continue;
						}
//						System.out.println(val);
						// 나이가 5의 배수인 경우 8방향으로 나무 심기
						for (int p = 0; p < 8; p++) {
							int dx = i + di[p][0];
							int dy = j + di[p][1];

							if (dx >= 0 && dy >= 0 && dx < n && dy < n) {
								age[dx][dy].addFirst(1); // 1살 나무 심기
				
								ans++; // 나무 개수 증가
							}
						}

					}
				}
			}

		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum += age[i][j].size();
			}
		}
		// 남아 있는 나무의 수 출력
		System.out.println(sum);
	}
}
