import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int k=Integer.parseInt(bf.readLine()); // 지방의수 
		long [] nlist = new long[k];
		long max=0;
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i =0;i<k;i++) {
			nlist[i]=Long.parseLong(st.nextToken());
			if(nlist[i]>max) { //최댓값
				max =nlist[i];
			}
		}
		int n =Integer.parseInt(bf.readLine()); // 예산
		long min=1;
		long mid=0;
		while (min<=max) {
			mid = (max+min)/2;
			long count =0; // 예산총합 
			for (int i=0;i<k;i++ ) {
				if(nlist[i]<mid) {
					count+=nlist[i];
				}
				else {
					count+= mid;
				}
							}
		if(count>n) { //예산초과 
			max =mid-1;
		}
		else {
			min=mid+1;
		}
		
		}
		System.out.println(max);
	}


}
