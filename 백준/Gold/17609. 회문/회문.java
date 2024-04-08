import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t =Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<t;tc++) {
			String str =bf.readLine();
			int size =str.length()-1;
			int tmp = check(str,0,size,false);
			sb.append(tmp).append("\n");
		}
		System.out.println(sb);
	}
	public static int check(String str,int left, int right,boolean chance) {
		while(left<right) {
			if(str.charAt(left)==str.charAt(right)) {
				left++;
				right--;
			}else if(chance) {
				return 2;
			}else if(check(str,left,right-1,true)==1) {
				chance=true;
				right-=2;
				left++;
			}else if(check(str,left+1,right,true)==1) {
				chance =true;
				left+=2;
				right--;
			}else {
				return 2;
			}
		}
		if(chance) {
			return 1;
		}else {
			return 0;
		}
		
	}
}
