import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int d;
	static ArrayList<Node> oven;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		d =Integer.parseInt(st.nextToken()); //오븐의 깊이 
		int n = Integer.parseInt(st.nextToken());
		oven  = new ArrayList<>();
		st = new StringTokenizer(bf.readLine());
		int bd =Integer.MAX_VALUE;
		for (int i =d-1;i>=0;i--) {
			int tmp=Integer.parseInt(st.nextToken());
			bd= Math.min(tmp, bd);
			oven.add(new Node( bd, i));
		}
		Collections.reverse(oven);
		boolean avail = true;
		int ans =0;
		int di=0;
		st = new StringTokenizer(bf.readLine());
		for (int i =0;i<n;i++) {
			int pizza =Integer.parseInt(st.nextToken()); 
			if( di>=d && pizza>oven.get(d-1).plen) {
				avail =false;
				System.out.println(0);
				break;
			}else {
				di = binearySearch(pizza,di);
				if(di ==Integer.MAX_VALUE) {
					avail =false;
					System.out.println(0);
					break;
				}
				ans =Math.max(ans,oven.get(di).idx);
				di++;
			}
		}
		if(avail) System.out.println(d-ans);
		
	} 
	public static int binearySearch(int target,int di) {
		int start=di  ;
		int end = oven.size()-1;
		int answer= Integer.MAX_VALUE;
		while(start<=end) {
			int mid= (start+end)/2;
			if(oven.get(mid).plen>= target) {
				answer =mid;
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		return answer;
	}
}
	class Node implements Comparable<Node> {
	    int plen;
	    int idx;

	    public Node(int plen, int idx) {
	        this.plen = plen;
	        this.idx = idx;
	    }

	    public int compareTo(Node o) {
	        if (o.plen == this.plen) return this.idx - o.idx;
	        return this.plen - o.plen;
	    }
	}

