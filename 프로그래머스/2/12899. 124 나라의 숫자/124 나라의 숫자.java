class Solution {
    public String solution(int n) {
        int[] change = {1,2,4};
        StringBuilder sb = new StringBuilder();
        
        while(n !=0) {
            n--;
            sb.append(change[n%3]);
            n = n/3;
        }
        
        return sb.reverse().toString();
    }
}