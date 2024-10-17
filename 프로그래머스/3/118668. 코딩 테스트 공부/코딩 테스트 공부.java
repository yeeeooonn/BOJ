class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxA = alp;
        int maxC = cop;
        for(int i = 0; i < problems.length; i++) {
            if(problems[i][0] > maxA ) {
                maxA = problems[i][0];
            }
            if(problems[i][1] > maxC ) {
                maxC = problems[i][1];
            }
        } 
        
        //dp[i][j] : 알고력 i-1, 코딩력 j-1 을 만들 때 까지 최소 소요 시간
        int[][] dp = new int[maxA+1][maxC+1]; 
        
        for(int i = 0; i < maxA+1; i++) {
            for(int j = 0; j < maxC+1; j++) {
                dp[i][j] = 1_000_000;
            }
        }
        
        
        dp[alp][cop] = 0;
        for(int i = alp; i <= maxA; i++) {
            for(int j = cop; j <= maxC; j++) {
                
                //현재값, 왼쪽+1, 위쪽+1 중 가장 적은 값 선택
                if(i != 0 && j != 0) {
                    dp[i][j] = Math.min(dp[i][j], Math.min(dp[i-1][j]+1, dp[i][j-1]+1));
                }else if(i == 0 && j != 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1]+1);
                }else if(i != 0 && j == 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+1);
                }
                
                //현재 알고력, 코딩력으로 풀 수 있는 문제가 있다면 해당 dp위치에 값 갱신
                for(int k = 0; k<problems.length; k++) {
                    if(i < problems[k][0] || j < problems[k][1]) continue;
                    int maxX = Math.min(maxA, i+problems[k][2]);
                    int maxY = Math.min(maxC, j+problems[k][3]);
                    dp[maxX][maxY] = Math.min(dp[maxX][maxY], dp[i][j]+problems[k][4]);
                }
                
            }
            
        }

        
        return dp[maxA][maxC];
    }
}