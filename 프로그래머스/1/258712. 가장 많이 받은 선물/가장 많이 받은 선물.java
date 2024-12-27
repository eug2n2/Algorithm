import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;
        int g = gifts.length;
        HashMap<String, Integer> map = new HashMap<>();
        int[][] giftarr = new int[n][4]; // [0] :give [1]:get [2]:선물지수, [3]: 받는 선물 개수 
        
        int[][] arr = new int[n][n]; // [a][b]면 a가 b에게 준 선물의 개수 
        for(int i =0;i<n;i++){
            map.put(friends[i],i);
        }
        for(int i =0;i<g;i++){
            String bf = gifts[i];
            StringTokenizer st = new StringTokenizer(bf);
            String a = st.nextToken();
            String b= st.nextToken();
            int c= map.get(a);
            int d= map.get(b);
            arr[c][d]++;
            giftarr[c][0]++;
            giftarr[d][1]++;
        }
        for(int i =0;i<n;i++){
            giftarr[i][2]=giftarr[i][0]-giftarr[i][1];
            // System.out.println(giftarr[i][0] +" -"+ giftarr[i][1] +"="+giftarr[i][2]);
        }
        for(int i =0;i<n-1;i++){
            for(int j =i+1; j<n;j++){
                if(arr[i][j]==arr[j][i]){
                    if(giftarr[i][2]==giftarr[j][2]){
                        continue;
                    }else if(giftarr[i][2]>giftarr[j][2]){
                        giftarr[i][3]++;
                    }else{
                        giftarr[j][3]++;
                    }
                }else if (arr[i][j]>arr[j][i]){
                    giftarr[i][3]++;
                }else{
                    giftarr[j][3]++;
                }
            }
        }
        for(int i =0;i<n;i++){
            answer =Math.max(answer, giftarr[i][3]);
        }
        return answer;
    }
}