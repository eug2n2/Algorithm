import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
					return o1[0].compareTo(o2[0]); // 정렬기준: 시작시간 오름차순
			}
		});
        int n =book_time.length;
        PriorityQueue<Integer> end = new PriorityQueue<>();
        int answer = 0;
        for(int i =0;i<n;i++){
            String xhour = book_time[i][0].charAt(0)+ ""+book_time[i][0].charAt(1);
            String xmin = book_time[i][0].charAt(3)+ ""+book_time[i][0].charAt(4) ; 
            int x = Integer.parseInt(xhour)*60+ Integer.parseInt(xmin );
            String yhour = book_time[i][1].charAt(0)+ ""+book_time[i][1].charAt(1);
            String ymin= book_time[i][1].charAt(3)+ ""+book_time[i][1].charAt(4) ; 
            int y = Integer.parseInt(yhour)*60 +  Integer.parseInt(ymin)+10;
            
            if(!end.isEmpty() && x >= end.peek()){ // 끝나는 시간 + 청소시간보다 늦게 시작한 경우  
                end.poll(); // 시작시간 오름차순 정렬이니까 비효율적인 배치 고려 안해도 됨
                end.add(y); // 그 호텔의 끝나는 시간 갱신.. 
            }else{
                answer++;
                end.add(y);
            }
        }
        return answer;
    }
   
}