import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        Arrays.sort(targets, (a,b) -> {
           if(a[0] == b[0]) {
               return a[1] - b[1];
           }else {
               return a[0] - b[0];
           }
        });
        
        int answer = 0;
        if(targets.length == 1) {
            answer = 1;
        }
        
        int start = targets[0][0];
        int end = targets[0][1];
        for(int i = 1; i < targets.length; i++) {
            int curS = targets[i][0];
            int curE = targets[i][1];
            
            if(curS >= end) {
                answer++;
                start = curS;
                end = curE;
            }else {
                //지금까지 쌓아 온 범위 안에 있는 경우
                start = Math.max(start, curS);
                end = Math.min(end, curE);
            }
            
            if(i == targets.length-1) {
                answer++;
            }
            
        }
        
        
        return answer;
    }
}