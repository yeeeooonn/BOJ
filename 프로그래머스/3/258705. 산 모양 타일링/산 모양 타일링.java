class Solution {
    public int solution(int n, int[] tops) {
        int MOD = 10007;
        int[][] dp = new int[n][2];
        //dp[i][0] = i번째 top까지 했을 때, 마지막이 3번째 마름모일 경우
        //dp[i][1] = i번째 top까지 했을 때, 마지막이 3번째 마름모가 아닐 경우
        dp[0][0] = 1; // 기본 초기값
        dp[0][1] = 2 + tops[0];
        
        for(int i = 1; i < n; i++) {
            //3번째 마름모로 끝나고 3번째 마름모로 다시 시작할 경우 -> 한가지
            //3번째 마름모로 안끝나고 3번째 마름모로 시작할 경우 -> 한가지
            dp[i][0] = (dp[i-1][0] + dp[i-1][1])%MOD;
            
            //3번째 마름모로 끝나고 3번째 마름모로 안시작할경우 -> top이 없으면 1가지, top이 있으면2가지
            //3번째 마름모로 안끝나고 3번째 마름모로 안시작할경우 -> top이 없으면 2가지, top이 있으면 3가지
            dp[i][1] = (dp[i-1][0] * (tops[i] +1))%MOD + (dp[i-1][1] * (tops[i]+2))%MOD;  
        }

        return (dp[n-1][0] + dp[n-1][1])%MOD;
    }
}