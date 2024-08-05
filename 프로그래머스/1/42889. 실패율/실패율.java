import java.util.*;
import java.io.*;
class Apeach implements Comparable<Apeach>{
    double a;
    int b;
    public Apeach(double a, int b){
        this.a=a;
        this.b=b;
    }
    @Override
    public int compareTo(Apeach o){
        if(Double.compare(this.a,o.a)==0) return this.b-o.b;
        return Double.compare(o.a,this.a);
            
    }
}
class Solution {
    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        int people= stages.length; // 전체 사람 수 
        int m= stages.length;
        double[] lose  = new double[N+1]; // N 번 스테이지의 실패율이 담겨있음 
        int tmp =1;
        int challenge = 0; // 도전 중인 사람 수
        for(int i =0;i<m;i++){
            if (stages[i]>N){
                lose[tmp]= challenge;
                lose[tmp]/=people;
                break;
            }
            if(tmp==stages[i] ){
                challenge ++;
                
            }else{
                lose[tmp]= challenge;
                lose[tmp]/=people;
                people-= challenge;
                tmp= stages[i];
                challenge=1;
            }
            if(i==m-1){
                lose[tmp]= challenge;
                lose[tmp]/=people;
            }
            
        }
        PriorityQueue<Apeach> queue = new PriorityQueue<>();
		for(int i =1;i<=N;i++){
            queue.add(new Apeach(lose[i],i));
        }
        int[] answer = new int[N]; 
        int idx=0;
        while(!queue.isEmpty()){
            Apeach p = queue.poll();
            answer[idx++]= p.b;
        }
        
        return answer;
    }
}