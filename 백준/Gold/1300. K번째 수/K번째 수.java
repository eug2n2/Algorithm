import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());
		long start=1;
		long end = m;
		long ans=0; 
		while(start<=end) { 
			long cnt=0;
			long mid=(start+end)/2;
			for (int i=1;i<=n;i++) {
				cnt+=Math.min(n, mid/i);
			}
			if(m<=cnt) {
				ans=mid;
				end= mid-1;
			}else {
				start=mid+1;
			}
		}
		System.out.println(ans);
	}
}