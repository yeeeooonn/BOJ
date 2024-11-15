import java.util.*;

class Solution {
    static int[][] dp;
    static int INF = Integer.MAX_VALUE - 10000;
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        temperature += 10;
        t1 += 10;
        t2 += 10;
        
        dp = new int[onboard.length][51];
        
        for(int i = 0; i < onboard.length; i++) {
            Arrays.fill(dp[i], INF);
        }
        
        dp[0][temperature] = 0;
        
        for(int i = 0; i < onboard.length-1; i++) {
            
            for(int j = 0; j <= 50; j++) {
                if(onboard[i] == 1 && (j < t1 || t2 < j)) continue;
                
                //에어컨 ON
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+b);
                if(j >= 1) dp[i+1][j-1] = Math.min(dp[i+1][j-1], dp[i][j] + a);
                if(j < 50) dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j] + a);
                
                
                //에어컨OFF
                if(j == temperature) {
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]);
                }
                if(j < temperature && j < 50) {
                    dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j]);
                }
                if(j > temperature && j >=1) {
                    dp[i+1][j-1] = Math.min(dp[i+1][j-1], dp[i][j]);
                }
                
            }
            
        }
        
        int min = INF;
        
        for(int i = 0; i <= 50; i++) {
            if(onboard[onboard.length-1] == 1 && (i<t1 || t2<i)) continue;
            min = Math.min(min, dp[onboard.length-1][i]);
        }
        
        
        return min;
    }
    
}