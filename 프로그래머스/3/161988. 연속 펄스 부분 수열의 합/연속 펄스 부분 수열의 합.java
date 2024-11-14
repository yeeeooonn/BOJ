class Solution {
    static long[][] dp;
    public long solution(int[] sequence) {
        
        //1,-1,1 수열
        long answer = Math.max(sequence[0], sequence[0]*-1);
        
        dp = new long[sequence.length][2];
        dp[0][0] = sequence[0]; //dp[i][0] -> 1,-1,1,-1 펄스수열
        dp[0][1] = sequence[0]*-1; //dp[i][1] -> -1,-1,1 펄스수열
        
        for(int i = 1; i < sequence.length; i++) {
            if(i%2 == 0) {
                dp[i][0] = Math.max(dp[i-1][0] + sequence[i], sequence[i]);
                dp[i][1] = Math.max(dp[i-1][1] + sequence[i]*-1, sequence[i]*-1);
            }else {
                dp[i][0] = Math.max(dp[i-1][0] + sequence[i]*-1, sequence[i]*-1);
                dp[i][1] = Math.max(dp[i-1][1] + sequence[i], sequence[i]);
            }
            answer = Math.max(answer, dp[i][0]);
            answer = Math.max(answer, dp[i][1]);
            
        }
        
        
        return answer;
    }
}