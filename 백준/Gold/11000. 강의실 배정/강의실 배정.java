import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine()); // item 개수
		TreeMap<Integer,Integer> treemap = new TreeMap<>(); // 끝나는시간과 개수 
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		for (int i = 0; i < n; i++) { // 무게와 가치가 주어진다.
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pq.add(new int[] { a, b });
		}
		int[] p  = pq.poll();
		treemap.put(p[1],1);
		int ans =1;
		while(!pq.isEmpty()) {
			 p  = pq.poll();
			 if(treemap.floorKey(p[0])==null) {
				 ans++;
				 if(treemap.get(p[1])==null) {
				 treemap.put(p[1],1);}
				 else {
					 treemap.put(p[1],treemap.get(p[1])+1);
				 }
			 } else{
				 int cnt =treemap.get(treemap.floorKey(p[0]));
				 if(cnt==1) {
				 treemap.remove(treemap.floorKey(p[0]));
				 }else {
				 treemap.put(treemap.floorKey(p[0]),cnt-1);
				 }
				 treemap.put(p[1], treemap.get(p[1])==null?1:(treemap.get(p[1])+1));
			 }
		}
		System.out.println(ans);
	}
}
