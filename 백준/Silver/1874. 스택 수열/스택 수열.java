import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>(); // 스택만들기
        int n = Integer.parseInt(br.readLine());
        int[] visited = new int[n+1];
        int num;
        boolean avail= true;
        int start= Integer.parseInt(br.readLine()); // 첫번째 입력수? 
        for (int i=1;i<=start;i++){
            stack.push(i);
            sb.append("+\n");
            visited[i]=1;
        }
        stack.pop(); //첫번째 입력수 pop
        sb.append("-\n");
        visited[start]=2;
        out: for (int i=0;i<n-1;i++){
            num= Integer.parseInt(br.readLine());
            if (start<num) {
                for(int k=start+1;k<=num;k++){
                if(visited[k]==0){
                stack.push(k);
                sb.append("+\n");
                visited[k]=1;}
                }
                start=num;
            if (visited[num]==1){
                stack.pop();
                sb.append("-\n");
                visited[num]=2;}
            else{
                avail =false;
                break out;
                }
            } else {
               
                for(int k=start;k>num;k--){
                    if(visited[k]==1){
                    stack.pop();
                     sb.append("-\n");
                    visited[k]=2;// 넣고 뺐다
                    }       
                }
                start=num;
                if (visited[num]==1){
                stack.pop();
                sb.append("-\n");
                visited[num]=2;
                }
                else{
                avail =false;
                break out;
                }
        
            }
        }
        if(!avail){
         System.out.println("NO");
        }
        else{
        System.out.println(sb);
        } 
    }
}
