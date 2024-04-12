import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int standard  = 2*n+1;
		int msize = Integer.parseInt(bf.readLine());
		String M = bf.readLine();
		char ch[] = M.toCharArray();
		String before ="A";
		int[] count = new int[340000];
		int cidx=0;
		int tmp=0;
		for(int i=0;i<msize;i++) {
			if(ch[i]=='I' && (before=="A"||before=="O")) {
				before="I";
				tmp++;
			}else if(ch[i]=='O'&& before=="I") {
				tmp++;
				before="O";
			}else if(ch[i]=='I'&& before=="I") {
				if(tmp>=standard) {
					count[cidx++]= tmp;
				}
				tmp=1;
				before="I";
			}else if(ch[i]=='O'&& before=="O") {
				if(tmp>=standard) {
					count[cidx++]= tmp;
				}
				tmp=0;
				before="A";
			}
		}
		if(tmp>=standard) {
			count[cidx++]= tmp;
		}
		int ans=0;
		for(int i=0;i<cidx;i++) {
			ans+=(count[i]-standard)/2+1;
		}
		System.out.println(ans);
	}
}
