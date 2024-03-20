import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
        String str= bf.readLine();
        String[] slist = str.split("");
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>(); 
        String memo=""; 
        for (int i =0; i<str.length();i++) {
        	 char c = str.charAt(i);
        	if (c>=65) {
        		sb.append(c);
                if(0<i&&i+1<str.length()&& (slist[i+1].equals("*")||slist[i+1].equals("/"))){
                while(!(stack.isEmpty())) {
        			if((stack.peek().equals("/")||stack.peek().equals("*"))){
                    sb.append(stack.pop());}
                    else{ //(가 나온경우 
                        break;
                    }
        		}
                }
                else if(0<i&&i+1<str.length()&& (slist[i+1].equals("+")||slist[i+1].equals("-"))){
                while(!(stack.isEmpty())) {
        			if((stack.peek().equals("/")||stack.peek().equals("*"))){
                    sb.append(stack.pop());}
                    else if((stack.peek().equals("+")||stack.peek().equals("-"))) {
                        memo= memo+stack.pop();
                    }
                    else{ //(가 나온경우 
                        break;
                    }
        		}
                }
                sb.append(memo);
                memo="";
            }
        	else if(slist[i].equals(")")){
        		while((!(stack.isEmpty())&& !(stack.peek().equals("(")))) {
        			if((stack.peek().equals("/")||stack.peek().equals("*"))){
                    sb.append(stack.pop());}
                    else{
                        memo= memo+stack.pop();
                    }
        		}
                sb.append(memo);
                memo="";
        		stack.pop(); // (제거 
                while(!(stack.isEmpty())&& (stack.peek().equals("/")||stack.peek().equals("*"))) {
                    sb.append(stack.pop());}

        	}
            else {
        		stack.push(slist[i]);
        	}
        }
        while(!(stack.isEmpty())) {
			sb.append(stack.pop());
        }
        System.out.println(sb);
}
}