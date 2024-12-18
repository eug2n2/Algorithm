import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int n = board.length;
        int m = moves.length;
        int answer = 0;
        Stack<Integer>[] boards = new Stack[n];
     
        for(int i =0;i<n;i++){
            boards[i] = new Stack<>();
            for (int j=n-1;j>=0;j--){
                int tmp =board[j][i];
                if(tmp==0){
                    break;
                }
                boards[i].push(tmp);
            }
        }
        
        for (int i=0;i<m;i++){
            int tmp = moves[i]-1;
            if(boards[tmp].isEmpty()){
                continue;
            }else{
                int btmp=boards[tmp].pop();
                if(stack.isEmpty()){
                    stack.push(btmp);
                }else{
                    if(stack.peek() == btmp){
                        stack.pop();
                        answer+=2;
                    }else{
                        stack.push(btmp);
                    }
                }
            }
        }
       
        return answer;
    }
}