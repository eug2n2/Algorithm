import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		System.out.println(moo(n));

	}

	public static String moo(int num) {
		int size=3;
        int index=0;
		int before =0;
		if (num==1) {
			return "m";
		} else if( num<=3) {
			return "o";

		} else {
			while(size<num) {
				index++;
				before=size; //이전 size저장 
				size= size * 2 + index +3;
				
			}
			if(size - before<num) {
				return moo(num-before-index-3);
			} else if (num== before+1) {
				return"m";
			}else {
				return "o";
			}
	}

}}
