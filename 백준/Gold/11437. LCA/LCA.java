import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static int[] depth; // 깊이 저장 배열
	static int[][] parent; // 부모 배열 저장 (자기자신 번호, depth)
	static int height = 0, n;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(bf.readLine());
        StringTokenizer st;
		// 최대 높이 구하기
        for(int i=1;i<=n;i*=2)
            height++;
		parent = new int[n + 1][height];
		depth = new int[n + 1];
		for (int i = 0; i <= n; i++)
			tree.add(new ArrayList<>());

		// 트리 정보 저장하기
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		setTree(1, 1, 0); // 트리 형태 구성 및 높이 설정
		parentInit(); // 점화식을 통해 부모 노드 DP 구성
		int M = Integer.parseInt(bf.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(LCA(a, b) + "\n");
		}
		bw.flush(); // 결과 출력
		bw.close();
		bf.close();
	}

	// 트리의 형태를 만드는 재귀 함수
	static void setTree(int c, int d, int p) {
		depth[c] = d;
		parent[c][0] = p;
		for (int next : tree.get(c)) {
			if (next == p)
				continue;
			setTree(next, d + 1, c);// 자식 노드들 탐색!
		}
	}

	// 부모 노드에 대한 DP 점화식을 이용하여 구성하는 함수
	static void parentInit() {
		for (int i = 1; i < height; i++) {
			for (int j = 1; j <= n; j++) {
				parent[j][i] = parent[parent[j][i - 1]][i - 1];
			}
		}
	}

	static int LCA(int a, int b) {
		int ah = depth[a];
		int bh = depth[b];
		// a의 깊이가 항상 크다고 설정
		if (ah < bh) {
			int tmp = b;
			b = a;
			a = tmp;
		}
		// 두노드의 깊이가 다르면 같게한다.=>이분탐색을 사용함
		for (int i = height - 1; i >= 0; i--) {
			if (Math.pow(2, i) <= depth[a] - depth[b])
				a = parent[a][i];
		}
		// => 이제 두노드의 깊이가 같은 상황 비교해주면된다.
		// 공통 조상 노드를 이미 가진 경우
		if (a == b)
			return a;
		// 동시에 부모찾기
		for (int i = height - 1; i >= 0; i--) {
			if (parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		// 결과적으로 a와 b는 최소 공통 조상의 첫 번째 자식들로 바뀜
		return parent[a][0];
	}
}
