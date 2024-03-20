import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int m;
	static int n;
	static int[] nlist;
	static char[] clist;
	static String str;
	static int ans;
	static Stack<Integer> stack; // 가장 최근에 괄호 사용한 인덱스 기록
	static boolean[] visited;
	static boolean[] gob;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		str = bf.readLine();
		nlist = new int[(n - 1) / 2 + 1]; // 숫자 배열
		clist = new char[(n - 1) / 2]; // 연산자 배열
		nlist[0] = str.charAt(0) - '0';
		for (int i = 1; i < n; i += 2) {
			clist[i / 2] = str.charAt(i);
			nlist[(i + 1) / 2] = str.charAt(i + 1) - '0';
		}
		ans = Integer.MIN_VALUE; // 정답
		visited = new boolean[n]; // 백트래킹때 사용
		cal(); // 괄호 없이 있는 경우를 ans의 초기로 설정
		for (int i = 1; i < (n + 3) / 4; i++) {
			stack = new Stack<>();
			m = i; // 괄호개수
			dfs(0);
		}
		System.out.println(ans);

	}

	public static void dfs(int cnt) {
		if (cnt == m) {
			cal();
			return;
		}
		for (int i =1; i < n; i += 2) {
			if (stack.isEmpty() || i - stack.peek() > 2) {
				visited[i] = true;
				stack.add(i);
				dfs(cnt + 1);
				visited[i] = false;
				stack.pop();
			}

		}

	}

	public static void cal() {// 계산함수
		nlist = new int[(n - 1) / 2 + 1]; // 한번 더 초기화
		gob = new boolean[(n - 1) / 2 + 1];
		clist = new char[(n - 1) / 2];
		nlist[0] = str.charAt(0) - '0';
		for (int i = 1; i < n; i += 2) {
			clist[i / 2] = str.charAt(i);
			nlist[(i + 1) / 2] = str.charAt(i + 1) - '0';
		}
		for (int i = 1; i < n; i += 2) { // 괄호먼저 처리
			if (visited[i]) {
				if (clist[(i - 1) / 2] == '*') {
					gob[(i - 1) / 2+1] = true;
					nlist[(i - 1) / 2] *= nlist[(i - 1) / 2 + 1];
					nlist[(i - 1) / 2 + 1] = 0;
					clist[(i - 1) / 2] = '^';
				} else if (clist[(i - 1) / 2] == '+') {
					nlist[(i - 1) / 2] += nlist[(i - 1) / 2 + 1];
					nlist[(i - 1) / 2 + 1] = 0;
					gob[(i - 1) / 2+1] = true;
					clist[(i - 1) / 2] = '^';
				} else if (clist[(i - 1) / 2] == '-') {
					nlist[(i - 1) / 2] -= nlist[(i - 1) / 2 + 1];
					nlist[(i - 1) / 2 + 1] = 0;
					gob[(i - 1) / 2+1] = true;
					clist[(i - 1) / 2] = '^';
				}
			}
		}
		for (int i = 0; i < (n - 1) / 2; i++) {
			if (clist[i] == '*') {
				int idx = i;
				while (idx >= 1) {// 앞에있는 수가 0 이아닐때까지 찾고, 거기에 곱함
					if (nlist[idx] != 0) {
						break;
					} else if (nlist[idx] == 0 && gob[idx]) {
						idx--;
					} else {
						break;
					}
				}
				gob[i+1] = true;
				nlist[idx] *= nlist[i + 1];
				nlist[i + 1] = 0;
				clist[i] = '^';

			}
		}
	
		int total = nlist[0];
		for (int i = 0; i < (n - 1) / 2; i++) {
			if (clist[i] == '+') {
				total += nlist[i + 1];
			} else if (clist[i] == '-') {
				total -= nlist[i + 1];
			}
		}
		
		ans = Math.max(ans, total);
	}

}
