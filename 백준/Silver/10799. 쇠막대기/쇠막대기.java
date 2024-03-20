import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        String str = br.readLine();
        int result = 1;
        List<String> slist = new ArrayList<>(Arrays.asList(str.split("")));
        stack.add("(");

        for (int i = 1; i < slist.size(); i++) {
            if (slist.get(i).equals("(")) {
                stack.add("(");
                result +=1;
            } else if (slist.get(i).equals(")") && (slist.get(i - 1).equals("("))) {
                stack.pop();
                result-=1;
                result += stack.size(); // 레이저 발견
               
            } else {
                stack.pop();
            }
        }

        System.out.println(result);
    }
}
