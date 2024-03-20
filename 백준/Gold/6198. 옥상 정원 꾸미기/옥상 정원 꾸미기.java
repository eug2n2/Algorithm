import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main
{
	public static void main(String args[]) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n= Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<Integer>();
		long answer =0L;

		for (int i =0;i<n;i++) {
			int height =Integer.parseInt(bf.readLine());
		
			while(!stack.isEmpty()) {
				if(stack.peek()<=height){
					stack.pop();
;				}
				else break;
			}
			answer+= stack.size();
			stack.push(height);
		}
		System.out.println(answer);
	}
}