class Solution {
    static int[] dr = {0, 0, 1, -1}; //오 왼 아 위 순
    static int[] dc = {1, -1, 0, 0};
    static int N,M,X,Y;
    static long answer;
    public long solution(int n, int m, int x, int y, int[][] queries) {

        int startX, endX , startY, endY ;
        startX = endX = x;
        startY = endY = y;
        
        for(int i = queries.length-1; i >= 0; i--) {
            int direction = queries[i][0];  // 이동 방향 (0: 오른쪽, 1: 왼쪽, 2: 위, 3: 아래)
            int moveDistance = queries[i][1];  // 이동 거리

            //y축 조정
            if (direction == 0 || direction == 1) {
                if (direction == 0) { // 왼쪽으로 이동 -> 리버스 : 오른쪽
                    if(startY != 0) startY += moveDistance;
                    endY = Math.min(m-1, endY + moveDistance);
                } else { // 오른쪽으로 이동 -> 리버스 :왼쪽
                    startY = Math.max(0, startY - moveDistance);
                    if(endY != m-1) endY -= moveDistance;
                }

                // 범위를 벗어난 경우
                if (startY >= m || endY < 0) return 0;
            } else if (direction == 2 || direction == 3) {
                if (direction == 2) { // 위로 이동 -> 리버스 : 아래 이동
                    if(startX != 0) startX += moveDistance;
                    endX = Math.min(n-1, endX + moveDistance);
                } else { // 아래로 이동
                    startX = Math.max(0, startX - moveDistance);
                    if(endX != n-1) endX -= moveDistance;
                }

                // 범위를 벗어난 경우
                if (startX >= n || endX < 0) return 0;
            }
            
        }
        
        // 가능한 좌표 범위의 크기를 계산 (가로 * 세로)
        return (long)(endX - startX + 1) * (long)(endY - startY + 1);
    }
}