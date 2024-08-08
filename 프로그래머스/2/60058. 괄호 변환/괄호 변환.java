import java.util.*;
import java.io.*;

class Solution {
    public String solution(String p) {
        if(p.equals("")){
            return "";
        }
        int size = p.length();
        int left =0;
        int right =0;
        int idx =0;
        for(int i=0; i<size;i++){
            char c = p.charAt(i);
            if(c=='('){
                left++;
            }else{
                right++;
            }
            if(left==right){
                idx = i;
                break;
            }
        }
        String u = p.substring(0, idx + 1);
        String v = p.substring(idx + 1);
        if(isCorrect(u)){
            return u+ solution(v);
        }
        return "(" + solution(v) + ")" + reverse(u);
    }
     public boolean isCorrect(String u) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            // 닫는 괄호가 더 많아지면 올바른 괄호 문자열이 아님
            if (right > left) {
                return false;
            }
        }
        return true;
    }

    public String reverse(String u) {
        StringBuilder sb = new StringBuilder();
        // 첫 번째와 마지막 문자 제거
        for (int i = 1; i < u.length() - 1; i++) {
            // 나머지 문자열의 괄호 방향 뒤집기
            if (u.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }
}