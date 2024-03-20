import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[] visited;static boolean[] selected;
	static int[] people;
	static List<Integer>[] arr ;
	static int ans =Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new ArrayList[n];
		selected = new boolean[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new ArrayList<>();
		}
		people = new int[n]; // 각 구의 인구수 
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i=0;i<n;i++) {
			people[i]=Integer.parseInt(st.nextToken());
		}
		for (int i=0;i<n;i++) {
			 st = new StringTokenizer(bf.readLine());
			 int c = Integer.parseInt(st.nextToken());
			 for (int j=0;j<c;j++) {
				 arr[i].add(Integer.parseInt(st.nextToken())-1); 
			 }
		}	

		divide(0);
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}

	private static void divide(int idx) { // 1. 선거구 나누기
		if (idx == n) {
			List<Integer> aList = new ArrayList<>();
			List<Integer> bList = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (selected[i])
					aList.add(i);
				else
					bList.add(i);
			}
			if (aList.size() == 0 || bList.size() == 0) // 한 지역에 몰빵 X
				return;
			
			if (check(aList) && check(bList)) { // 두 구역이 각각 연결되었는지 확인
				cal(); // 인구차 구하기
			}
			return;
		}

		selected[idx] = true;
		divide(idx + 1);
		selected[idx] = false;
		divide(idx + 1);

	}
	private static void cal() { // 3. 선거구의 인구 차 구하기
		// a구역 사람수
		int pA = 0, pB = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i])
				pA += people[i];
			else
				pB += people[i];
		}
		int diff = Math.abs(pA - pB);
		ans = Math.min(ans, diff);
	}
	private static boolean check(List<Integer> list) {

		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[n];
		visited[list.get(0)] = true;
		q.offer(list.get(0));
		
		int count = 1; // 방문한 지역 개수
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < arr[cur].size(); i++) {
				int y = arr[cur].get(i);
				if(list.contains(y) && !visited[y]) { // 선거구에 해당하고, 아직 미방문
					q.add(y);
					visited[y] = true;
					count ++;
				}
			}
		}
		if(count==list.size()) // 선거구에 해당하는 지역수와 방문한 지역수가 같은 경우
			return true;
		else
			return false;
	}
}
