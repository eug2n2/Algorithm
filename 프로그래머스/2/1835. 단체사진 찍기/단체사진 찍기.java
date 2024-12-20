import java.util.*;
class Numrule{
    boolean ruleexist; // 규칙 존재의 유무 
    HashSet<Integer> set; // 가능한 간격의 집합
    public Numrule(boolean ruleexist,HashSet<Integer> set){
        this.ruleexist=ruleexist;
        this.set= set;
    }
}
class Solution {
    static int answer;
    static Numrule[][] rule;
    public int solution(int n, String[] data) {
        answer = 0;
        HashSet<Integer> tmpset = new HashSet<>(); // 모든 간격의 기본 세팅값 (0-6)
        rule = new Numrule[8][8]; 
        for (int i =0;i<=6;i++){
            tmpset.add(i);
        }
        for (int i =0;i<8;i++){
            for(int j =0;j<8;j++){
                rule[i][j] = new Numrule(false, new HashSet<>(tmpset));
            }
        }
        for(int i =0;i<n;i++){
            String str = data[i];
            char f1= str.charAt(0); //프렌즈
            char s1= str.charAt(2); // 상대방
            char t1= str.charAt(3); // 등호
            //프렌즈와 상대방을 숫자로 대체해서 인덱싱
            int f= change(f1); 
            int s = change(s1);
            int interval= str.charAt(4)-'0'; // 간격
            rule[f][s].ruleexist= true;
            rule[s][f].ruleexist= true;
            Queue<Integer> quetmp= new ArrayDeque<>(); // 제거할 간격(범위에 어긋난다면 그 간격을 제거한다. ex >2 면 0,1,2를 제거 )
            if(t1=='='){
                for( int setnum : rule[f][s].set){
                    if(setnum!=interval){
                        quetmp.add(setnum);
                    }
                }
                while(!quetmp.isEmpty()){
                    rule[f][s].set.remove(quetmp.poll());
                }
                // 가능한 간격이 없다면, 불가능한 케이스이므로 리턴
                if( rule[f][s].set.size()==0) return 0; 
                rule[s][f].set = new HashSet<>(rule[f][s].set);
            }else if (t1 =='<'){
                for( int setnum : rule[f][s].set){
                    if(setnum>=interval){
                        quetmp.add(setnum);
                    }
                }
                while(!quetmp.isEmpty()){
                    rule[f][s].set.remove(quetmp.poll());
                }
                if( rule[f][s].set.size()==0) return 0; 
                rule[s][f].set =  new HashSet<>(rule[f][s].set);
            }else{ // >
                for( int setnum : rule[f][s].set){
                    if(setnum<=interval){
                        quetmp.add(setnum);
                    }
                }
                while(!quetmp.isEmpty()){
                    rule[f][s].set.remove(quetmp.poll());
                }
                if(rule[f][s].set.size()==0) return 0;
                rule[s][f].set =  new HashSet<>(rule[f][s].set);
            }
        }
        HashMap<Integer, Integer> positionMap = new HashMap<>();
        boolean[] visited = new boolean[8];
        dfs(positionMap,0,visited); 
        return answer;
    }
    
   public void dfs(Map<Integer, Integer> positionMap, int idx, boolean[] visited) {
    if (idx == 8) { // 모든 위치를 배치한 경우
        if (isValid(positionMap)) { // 규칙 검증 추가
            answer++;
        }
        return;
    }

    for (int i = 0; i < 8; i++) {
        if (visited[i]) continue; // 이미 배치한 프렌즈는 pass

        positionMap.put(i, idx); // i번 친구를 idx 위치에 배치
        visited[i] = true;

        dfs(positionMap, idx + 1, visited);

        positionMap.remove(i); // 백트래킹: 위치 정보 제거
        visited[i] = false;
    }
}

// 규칙 검증 메서드 (HashMap 사용)
public boolean isValid(Map<Integer, Integer> positionMap) {
    for (int i = 0; i < 7; i++) {
        for (int j = i + 1; j < 8; j++) {
            if (!rule[i][j].ruleexist) continue; // 규칙이 없다면 패스
            int distance = Math.abs(positionMap.get(i) - positionMap.get(j)) - 1; // 두 위치 간 거리 계산
            if (!rule[i][j].set.contains(distance)) return false; // 규칙에 어긋난다면 false 반환
        }
    }
    return true; // 모든 규칙을 만족하면 true 반환
}
    
    // 프렌즈를 숫자로 바꿔주는 함수 
    public int change(char c){
        switch(c){
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'F':
                return 2;
            case 'J':
                return 3;
            case 'M':
                return 4;
            case 'N':
                return 5;
            case 'R':
                return 6;
            case 'T':
                return 7;
            default:
                return -1;
        }
    }
}