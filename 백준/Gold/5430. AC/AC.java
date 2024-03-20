import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine()); // tc의수 
		for (int tc=0;tc<t;tc++) {
		String str=bf.readLine(); // 명령문 수행해야할 함수 
		int n=Integer.parseInt(bf.readLine()); // 리스트 원소의수 
		Deque<Integer> deque = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(bf.readLine(), "[,]" );
		int change =0;// 짝수면 정방향 , 홀수면역방향

		for(int k=0;k<n;k++){
			deque.add(Integer.parseInt(st.nextToken()));
		}
		
		out: for (int i=0;i<str.length();i++) { // char는 비교 ' 사용 
			if (str.charAt(i)=='D') {
				if(deque.isEmpty()) {
					System.out.println("error");
                    change=-1;
					break out;
				}else if(change%2==0) {
				deque.poll();
				} else {
					deque.pollLast();
				}
			}
			else {
				change++;
			}
		}	
		
		StringBuilder sb= new StringBuilder("[");
			while(change%2==0&&deque.size()>1) {
				sb.append(deque.poll()+",");
			}
			if(change%2==0&&deque.size()!=0) {
			sb.append(deque.poll());}
			while(change%2==1&&deque.size()>1) {
				sb.append(deque.pollLast()+",");
			}
			if(change%2==1&&deque.size()!=0) {
			sb.append(deque.pollLast());}
            sb.append("]");
            if(change>=0){
			System.out.println(sb);}
		}
	
	}
}
