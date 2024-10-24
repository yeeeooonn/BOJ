class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        //1사분면의 값을 구한 후 4를 곱한다. -> 1부터시작(0부터 하면 겹치는 구간이 있게된다.)
        for( int i = 1; i <= r2 ; i++){
            double y2 = Math.sqrt(Math.pow(r2,2) - Math.pow(i,2));
            double y1 = Math.sqrt(Math.pow(r1,2) - Math.pow(i,2));
            answer += ( (long)y2 - (long)Math.ceil(y1) + 1);
        }
        answer *= 4;
        
        return answer;
    }
}