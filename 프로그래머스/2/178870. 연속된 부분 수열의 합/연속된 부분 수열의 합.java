import java.util.*;

class Solution {
    private class E implements Comparable<E>{
        int left, right, size;

        public E(int left, int right) {
            this.left = left;
            this.right = right;
            this.size = right - left;
        }

        @Override
        public int compareTo(E e) {
            if(this.size == e.size){
                return this.left - e.left;
            }
            return this.size - e.size;
        }
    }
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int partitionSum = sequence[0]; // 부분 수열의 합

        int n = sequence.length;

        List<E> subs = new ArrayList<>();
        while (true){
            if(partitionSum == k){
                subs.add(new E(left, right));
            }
            if(left == n && right == n) break;

            if(partitionSum <= k && right < n){
                right++;
                if(right < n) partitionSum += sequence[right];
            } else {
                if(left < n) partitionSum -= sequence[left];
                left++;
            }
        }

        subs.sort(E::compareTo);

        return new int[]{subs.get(0).left, subs.get(0).right};
    }
}