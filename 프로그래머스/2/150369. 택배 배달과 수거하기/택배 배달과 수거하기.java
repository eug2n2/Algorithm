class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int idx=n-1;
        while(idx>=0){
            int box =0;
            int index =idx; // 배달 인덱스
          
            while(index>=0){
                if(box+deliveries[index]<=cap){
                    box+=deliveries[index];
                    deliveries[index]=0;
                    index--;
                } else {
                   deliveries[index]-=(cap-box);
                   box=cap;
                   break;
                }
            }
            int sidx=idx;
            int suger =0;
            while(sidx>=0){
                if(suger+pickups[sidx]<=cap){
                    suger+=pickups[sidx];
                    pickups[sidx]=0;
                    sidx--;
                } else{
                   pickups[sidx]-=(cap-suger);
                   suger=cap;
                   break;
                }
            }
            if(box>0||suger>0){
                answer+=(idx+1)*2;;
            }
            idx = Math.max(sidx,index);
            
        }

        return answer;
    }
}