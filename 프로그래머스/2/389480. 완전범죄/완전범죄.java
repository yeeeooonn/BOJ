import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
        
        int[][] dp = new int[info.length][121]; //dp[i][j] : i번째 물건일 때 B의값(흔적)이 j일 때의 A의 값(흔적)
        for(int i = 0; i < info.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[0][0] = info[0][0]; //첫 물건 B가 훔쳤을 경우
        dp[0][info[0][1]] = 0; //첫 물건 A가 훔쳤을 경우

        for(int i = 0; i < info.length-1; i++) {
            for(int j = 0; j < m; j++) { //B값이 m전까지만 봐도 됨(그 후는 답이 나올 수 없기 때문)
                if(dp[i][j] != Integer.MAX_VALUE) {
                    //다음 물건 A선택
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+info[i+1][0]);
                    
                    //다음 물건 B선택
                    dp[i+1][j+info[i+1][1]] = Math.min(dp[i+1][j+info[i+1][1]], dp[i][j]);
                    
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            if(dp[info.length-1][i] < n) {
                answer = Math.min(answer, dp[info.length-1][i]);
            }
        }
        
        if(answer == Integer.MAX_VALUE) return -1;
        else return answer;

    }
}