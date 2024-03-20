import java.util.PriorityQueue;
import java.util.Scanner;
class Main{
	
    public static void main(String args[]) throws Exception {
          Scanner sc = new Scanner(System.in);
          PriorityQueue<Long> pq = new PriorityQueue<Long>();
          int n=sc.nextInt();
          for(int i=0;i<n;i++) {
        	  pq.add(sc.nextLong());
          }
          
        long num =0;
//      정수 입력받는 반복문
          while(pq.size() > 1) {
        	  long a= pq.poll();
        	  long b= pq.poll();
        	  pq.add(a+b);
        	  num+=a+b;
          }
         System.out.println(num);
          }
      
}
  