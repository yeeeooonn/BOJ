import java.util.*;

class Solution {
    static int row;
    static int answer;
    static int[][] dp;
    static List<Integer> list;
    int solution(int[][] land) {
        answer = 0;
        row = land.length;
        
        dp = new int[row][4];
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        
        for(int i = 1; i < row; i ++) {
            
            for(int j = 0; j < 4; j++) {
                if(j == 0) {
                    dp[i][j] = land[i][j] + Math.max(Math.max(dp[i-1][1], dp[i-1][2]),dp[i-1][3]);
                }
                if(j == 1) {
                    dp[i][j] = land[i][j] + Math.max(Math.max(dp[i-1][0], dp[i-1][2]),dp[i-1][3]);
                }
                if(j == 2) {
                    dp[i][j] = land[i][j] + Math.max(Math.max(dp[i-1][1], dp[i-1][0]),dp[i-1][3]);
                }
                if(j == 3) {
                    dp[i][j] = land[i][j] + Math.max(Math.max(dp[i-1][1], dp[i-1][2]),dp[i-1][0]);
                }
                
            }
            
        }

        return  Math.max(Math.max(dp[row-1][0], dp[row-1][1]),Math.max(dp[row-1][2], dp[row-1][3]));
    }
    
}