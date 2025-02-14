import java.util.*;
class Solution {
    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;
    public String solution(String s) {
        String [] split = s.split(" ");
        for(String cur : split){
            int check = Integer.parseInt(cur);
            MIN = Math.min(MIN, check);
            MAX = Math.max(MAX, check);
        }
        return MIN + " " + MAX;
    }
}
