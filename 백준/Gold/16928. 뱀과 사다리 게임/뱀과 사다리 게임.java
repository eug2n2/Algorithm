import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken()); // 사다리
		int m = Integer.parseInt(st.nextToken()); // 뱀
		int[] visited = new int[101];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(1);// 1번 출발 ~
		int[] radder = new int[101];
		for (int i = 0; i < n+m; i++) {
			st = new StringTokenizer(bf.readLine());
			radder[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		while (visited[100] == 0) {
			int pts = queue.poll();
			int o = pts + 1;
			int tw = pts + 2;
			int th = pts + 3;
			int fo = pts + 4;
			int fi = pts + 5;
			int s = pts + 6;
		
			if (o == 100 || tw == 100 || th == 100 || fo == 100 || fi == 100 || s == 100) {
				visited[100] = visited[pts] + 1;
				break;
			}
		
			if (0<o&& o <100 && visited[o] == 0) {
				visited[o] = visited[pts] + 1;
				if (radder[o] == 0) {
					queue.add(o);
				} else if (0<radder[o] &&radder[o] <= 100 && visited[radder[o]] == 0) {
					visited[radder[o]] = visited[pts] + 1;
					queue.add(radder[o]);
				}
			}
			if (0<tw&&tw < 100 && visited[tw] == 0) {
				visited[tw] = visited[pts] + 1;
				if (radder[tw] == 0) {
					queue.add(tw);
				} else if (0<radder[tw] && radder[tw] <= 100  && visited[radder[tw]] == 0) {
					visited[radder[tw]] = visited[pts] + 1;
					queue.add(radder[tw]);
				}
			}
			if (0<th&&th < 100 && visited[th] == 0) {
				visited[th] = visited[pts] + 1;
				if (radder[th] == 0) {
					queue.add(th);
				} else if (0<radder[th] &&radder[th] <= 100 && visited[radder[th]] == 0) {
					visited[radder[th]] = visited[pts] + 1;
					queue.add(radder[th]);
				}
			}
			if (0<fo&&fo < 100 && visited[fo] == 0) {
				visited[fo] = visited[pts] + 1;
				if (radder[fo] == 0) {
					queue.add(fo);
				} else if (0<radder[fo]&&radder[fo] <= 100 && visited[radder[fo]] == 0) {
					visited[radder[fo]] = visited[pts] + 1;
					queue.add(radder[fo]);
				}
			}
			if (0<fi&&fi < 100 && visited[fi] == 0) {
				visited[fi] = visited[pts] + 1;
				if (radder[fi] == 0) {
					queue.add(fi);
				} else if (0<radder[fi]&&radder[fi] <= 100 && visited[radder[fi]] == 0) {
					visited[radder[fi]] = visited[pts] + 1;
					queue.add(radder[fi]);

				}
			}
			if (0<s&& s <100 && visited[s] == 0) {
				visited[s] = visited[pts] + 1;
				if (radder[s] == 0) {
					queue.add(s);
				} else if (0<radder[s]&&radder[s] <= 100 && visited[radder[s]] == 0 ) {
					visited[radder[s]] = visited[pts]+1 ;
					queue.add(radder[s]);

				}
			}
		}
		System.out.println(visited[100]);
	}

}