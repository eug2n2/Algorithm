import java.util.*;
import java.io.*;
class Solution {
    static int count =0;
    static int[][] answer ;
    public int[][] solution(int n) {
        answer = new int[(int) Math.pow(2, n) - 1][2];
        move(n,1,3,2);
        return answer;
    }
    public void move(int num , int start, int end , int sub){
        if(num==1){
            answer[count][0]= start;
            answer[count++][1]=end;
            return;
        }
        move(num-1,start, sub, end);
        answer[count][0]= start;
        answer[count++][1]=end;
        move(num-1, sub, end , start);
    }
}