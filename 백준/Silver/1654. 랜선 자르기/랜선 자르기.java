import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int k=Integer.parseInt(st.nextToken()); //랜선개수 
		int n =Integer.parseInt(st.nextToken()); // 이만큼 만들어야돼
		long [] nlist = new long[n];
		long max=0;
		for (int i =0;i<k;i++) {
			nlist[i]=Long.parseLong(bf.readLine());
			if(nlist[i]>max) { //최댓값
				max =nlist[i];
			}
		}
		long min=1;
		long mid=0;
		while (min<=max) {
			mid = (max+min)/2;
			long count =0; // 막대기 개수 
			for (int i=0;i<n;i++ ) {
				count+= nlist[i]/mid;
			}
		if(count<n) {
			max =mid-1;
		}
		else {
			min=mid+1;
		}
		
		}
		System.out.println(max);
	}


}
