class Solution {
    public int solution(String skill, String[] skill_trees) {
        int[] learn = new int[26]; // 선수과목기록  선수과목없다 = -1
        for (int i =0;i<26;i++){
            learn[i]=-1;
        }
        for(int i =1; i<skill.length();i++){
            int x = skill.charAt(i)-'A';
            int y = skill.charAt(i-1)-'A';
            learn[x]= y; // x를 배우려면 y를 배워야한다는 의미 ! 
            
        }
        int answer = skill_trees.length;
        for (int i =0; i<skill_trees.length;i++){
            int[] learned = new int [26]; // 배운 항목들 기록 .. 
            for(int j=0;j<skill_trees[i].length();j++){
                 int x = skill_trees[i].charAt(j)-'A';
                 
                 if(learn[x]!=-1 && learned[learn[x]]==0){ // 선수과목이 있고, 선수과목을 배우지 않았다면, 불가능 한 경우임
                     answer--;
                     // System.out.println(i+" "+ skill_trees[i].charAt(j));
                     break;
                 }
                 learned[x]=1;
                
                 
            }
        }
        return answer;
    }
}