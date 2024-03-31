import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	 public static  ArrayList<Integer> nlist = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] a = new int[n+1];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			a[tmp] = i; // tmp 의 값은 i인덱스에 갖고있다.
		}
		st = new StringTokenizer(bf.readLine());
		nlist.add(a[Integer.parseInt(st.nextToken())]);
		for (int i = 1; i < n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			tmp = a[tmp];
			int lastindex = nlist.size()-1;
        	if(tmp>nlist.get(lastindex)) { // 최댓값보다 크다면 리스트에 추가 
        		nlist.add(tmp);
        	}else {
        		int end = BinarySearch(tmp);
        		nlist.set(end,tmp);
        	}
		}
		
		   System.out.println(nlist.size());
		
	}
	 public static int BinarySearch(int tmp) {
	    	int start =0;
	    	int ans =0;
	    	int end = nlist.size()-1;
	    	while(start<=end) {
	    		int mid =(start+end)/2;
	    		if (nlist.get(mid)>=tmp) {
	    			ans = mid;
	    			end= mid-1;
	    		} 
	    		else {
	    			start =mid+1;
	    		}
	    	}
	    	return ans;
	    }
}
