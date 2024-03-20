import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int t;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n= Integer.parseInt(bf.readLine());
			
			PriorityQueue<int[]> pq = new PriorityQueue<>(new TwoElementComparator()); 
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				pq.add(new int[]{a,b});
			}
			int tmp= n+1;
			int cnt=0;
			while(!pq.isEmpty()) {
				int[]p= pq.poll();
				if(p[1]<tmp) {
					cnt++;
					tmp= p[1];
				}
				if(tmp==1) {
					break;
				}
			}
			System.out.println(cnt);
		}
	}
}
class TwoElementComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        if (o1[0] != o2[0]) {
            return Integer.compare(o1[0], o2[0]);
        } else {
            return Integer.compare(o1[1], o2[1]);
        }
    }
}