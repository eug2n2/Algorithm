import java.util.*;

class Solution {
    public String solution(String new_id) {
        // 1단계
        new_id = new_id.toLowerCase();
        
        //2단계
        StringBuilder sb = new StringBuilder(new_id);
        for(int i =new_id.length()-1;i>=0;i--){
            char c = new_id.charAt(i);
            if( c =='-'|| c=='_' || c=='.' || (c>='0' && c<='9') | (c>='a') &&(c<='z')){
                continue;
            }else{
                sb.deleteCharAt(i);
            }   
        }
        new_id = sb.toString();
        
        //3단계
        boolean before = false; //전에 문자가 . 인지 여부 
        for(int i =new_id.length()-1;i>=0;i--){
            char c= new_id.charAt(i);
            if(c!='.'){
                before =false;
                continue;
            }
            else if (!before){
                before=true;
            }else{
                sb.deleteCharAt(i);
            }
        }
        
        new_id = sb.toString();
    
        //4단계
        for(int i =0;i<new_id.length();i++){
            char c= new_id.charAt(i);
            if(c!='.'){
               break;
            }
            sb.deleteCharAt(i);
        }
        new_id = sb.toString();
        for(int i = new_id.length()-1;i>=0;i--){
            char c= new_id.charAt(i);
            if(c!='.'){
               break;
            }
            sb.deleteCharAt(i);
        }
        new_id = sb.toString();
        
       
        //5단계
        if(new_id.equals("")) new_id="a";
     // System.out.println("5: "+ new_id);
        
        //6단계
        if(new_id.length()>= 16 && new_id.charAt(14)!='.') new_id = new_id.substring(0,15);
        else if(new_id.length()>= 16 && new_id.charAt(14)=='.') new_id = new_id.substring(0,14);
   // System.out.println("6: "+ new_id);        
        // 7단계
        if( new_id.length()==1) {
            new_id += new_id + new_id;
            
        }else if (new_id.length()==2){
            new_id += new_id.substring(1,2);
        }
   // System.out.println("7: "+ new_id);   
        return new_id;
    }
}