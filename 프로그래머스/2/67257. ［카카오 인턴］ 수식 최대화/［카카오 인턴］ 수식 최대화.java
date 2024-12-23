import java.util.*;
import java.io.*;

class Solution {
    static long answer;
    public long solution(String expression) {
        answer = 0;
        ArrayList<String> exp =  new ArrayList<>();
        String before ="";
        for (int i =0; i<expression.length() ;i++){
            char c =  expression.charAt(i);
            if( c=='-'|| c=='*' || c=='+'){
                exp.add(before);
                exp.add(String.valueOf(c));
                before="";
            }else{
                before+= c;
            }
            if(i==expression.length() -1){
                exp.add(before);
            }
        }
        int n = exp.size();
       
        // + 이 가장 우선순위 일때
        ArrayList<String> plus= cal(new ArrayList<>(exp),'+',1,n);
        // + > - > *
        ArrayList<String> plusmin = cal(new ArrayList<>(plus),'-',1,plus.size());
        ArrayList<String> plusminmul = cal(plusmin,'*',1,plusmin.size());
        long caltmp = Math.abs(Long.parseLong(plusminmul.get(0)));
        answer = Math.max(caltmp,answer);
        // + >*>-
        ArrayList<String> plusmul = cal(plus,'*',1,plus.size());
    
        ArrayList<String> plusmulmin = cal(plusmul,'-',1,plusmul.size());
        caltmp = Math.abs(Long.parseLong(plusmulmin.get(0)));
        answer = Math.max(caltmp,answer);
        
        // - 이 가장 우선순위 일때
        ArrayList<String> min= cal(new ArrayList<>(exp),'-',1,n);
       
        //  - > + > *
        ArrayList<String> minplus = cal(new ArrayList<>(min),'+',1,min.size());
        ArrayList<String> minplusmul = cal(minplus,'*',1,minplus.size());
        caltmp = Math.abs(Long.parseLong(minplusmul.get(0)));
        answer = Math.max(caltmp,answer);
        // ->*>+
        ArrayList<String> minmul = cal(min,'*',1,min.size());
        ArrayList<String> minmulplus = cal(minmul,'+',1,minmul.size());
        caltmp = Math.abs(Long.parseLong(minmulplus.get(0)));
        answer = Math.max(caltmp,answer);
        // * 이 가장 우선순위 일때
        ArrayList<String> mul= cal(exp,'*',1,n);

        // // *>- > + 
        ArrayList<String> mulmin = cal(new ArrayList<>(mul),'-',1,mul.size());
        ArrayList<String> mulminplus = cal(mulmin,'+',1,mulmin.size());
        caltmp = Math.abs(Long.parseLong(mulminplus.get(0)));
        answer = Math.max(caltmp,answer);
        // *>+>-
        ArrayList<String> mulplus = cal(mul,'+',1,mul.size());
        ArrayList<String> mulplusmin = cal(mulplus,'-',1,mulplus.size());
        caltmp = Math.abs(Long.parseLong(mulplusmin.get(0)));
        answer = Math.max(caltmp,answer);
        return answer;
    }
    public ArrayList<String> cal(ArrayList<String> expression, char operator, int idx , int n ){
        if(n==1 || idx ==n){
            return expression;
        }
        for(int i =idx;i<n;i+=2){
            System.out.println(expression +" "+ i+" "+n +" "+operator);
            if(i>=expression.size()){
                    System.out.println(expression +" "+ i+" "+n);
                    return expression;
                }
            char tmp = expression.get(i).charAt(0);
            if(tmp == operator){
                
                long a = Long.parseLong(expression.get(i-1));
                long b = Long.parseLong(expression.get(i+1));
                long val = calculator(a, b, operator);
                expression.set(i-1, ""+val);
                expression.remove(i);
                if( i +1 >=n){
                    System.out.println( "oou "+ a +" " +b +" "+tmp );
                    return expression;
                }
                expression.remove(i);// i+1 지우기.. (이미 앞에 것을 지웠으니..)
                
                n-=2;
                return cal(expression, operator, i,n);
            }
        }
        // 이제 계산 가능한 연산 부호가 없을 경우.. 
        return expression; 
    }
    
    public long calculator(long a, long b, char operator){
        switch(operator){
            case '+':
                return a+b;
            case '-':
                return a-b;
            default:
                return a*b;
        }
    }
}