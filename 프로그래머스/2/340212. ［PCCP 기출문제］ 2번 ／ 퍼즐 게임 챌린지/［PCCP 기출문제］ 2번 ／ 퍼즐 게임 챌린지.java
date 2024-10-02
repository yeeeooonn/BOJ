class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 1;
        int end = 100_000;
        
        while(start<end) {
            int mid = (start+end)/2;
            long time = 0;
            for(int i = 0; i < diffs.length; i++) {
                if(diffs[i] <= mid) {
                    time += times[i];
                }else {
                    time += ((diffs[i]-mid)*(times[i-1] + times[i]) + times[i]);
                }
            }
            
            if(limit < time) {
                start = mid+1;
            }else {
                end = mid;
            }
            
        }
          
        return start;
    }
}