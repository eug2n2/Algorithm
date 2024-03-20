import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int p;
        for (int i=0;i<n;i++){
            String str = br.readLine();
            if (str.contains("push")) {
                String intstr = str.replaceAll("[^0-9]", "");
                stack.push(Integer.parseInt(intstr));
            } else if (str.equals("top")) {
                if (!stack.isEmpty()) {
                    p = stack.peek();
                    sb.append(p).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
            }else if (str.equals("pop")) {
                if (!stack.isEmpty()) {
                    p = stack.pop();
                    sb.append(p).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
            } else if (str.equals("empty")) {
                if (!stack.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append("1").append("\n");
                }
            } else if (str.equals("size")) {
                p = stack.size();
                sb.append(p).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}