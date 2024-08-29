import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int size = jobs.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        int time= 0;
        int idx =0;
        while (idx < size && jobs[idx][0] <= time) {
                pq.offer(jobs[idx++]);
        }
            
        int sum =0;
        int cnt =0;   
        while(cnt<size){
      
            // System.out.println(sum);   
            while (idx < size && jobs[idx][0] <= time) {
                pq.offer(jobs[idx++]);
            }
        
            if (pq.isEmpty())  {
				time = jobs[idx][0];
            
            }else{
                int[] p =pq.poll();
                time+=p[1];
                cnt++;
                sum +=(time-p[0]);
            }
            
		}
        
        return sum/size;
    }
}