import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int score1 = scores[0][0];
        int score2 = scores[0][1];
        
        Arrays.sort(scores, (a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }else {
                return b[0] - a[0];
            }
        });
        
        
        int answer = 1; //완호 등수
        
        int max = scores[0][1];
        for(int i = 0; i < scores.length; i++) {
            if(max > scores[i][1]) {
                if(score1 == scores[i][0] && score2 ==scores[i][1]) return -1; //완호가 인센티브 받지 못하는 경우
                continue;
            }
            max = Math.max(max, scores[i][1]);
            if((score1+score2) < scores[i][0] + scores[i][1]) answer++;
            
        }
        
        return answer;
    }
}