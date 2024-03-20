import java.util.*;
import java.awt.Point;
import java.io.*;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Main
{
	public static void main(String args[]) throws IOException {
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n= Integer.parseInt(st.nextToken());
		int p =Integer.parseInt(st.nextToken());
		ArrayList<Stack<Integer>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new Stack<>());
        }

		int answer=0;

		for (int i =1;i<=n;i++) {
			
			st = new StringTokenizer(bf.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());

			if (arr.get(a).isEmpty()) {
				answer++;
				arr.get(a).push(b);
			} else if ((arr.get(a).peek()<b)) {
				answer++;
				arr.get(a).push(b);
			}
			else if(arr.get(a).peek()==b) {
				continue;
			}
			
			else {
				 while(!(arr.get(a).isEmpty())&&arr.get(a).peek()>b) {
					 arr.get(a).pop();
					 answer++; //떼기 
				} 
				 if(!(arr.get(a).isEmpty())&&arr.get(a).peek()==b) {
					 continue;
				 }
				 else {
					 answer++; // 붙이기
					 arr.get(a).push(b);
			}
		}

	}
		System.out.println(answer);
	}
}