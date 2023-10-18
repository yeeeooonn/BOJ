class Solution {
    static int answer0;
    static int answer1;
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        answer0 = 0;
        answer1 = 0;
        
        int length = arr.length;
        
        System.out.println(length);
        
        d(arr, 0, 0, length);
        
        answer[0] = answer0;
        answer[1] = answer1;
        return answer;
    }
    public void d(int[][] arr, int n, int r, int length) {
        int firstNum = arr[n][r];
        if(check(firstNum, arr, n, r, length) || length == 1){
            if(firstNum == 0) {
                answer0++;
            }else {
                answer1++;
            }
            return;
        }

        int half = length/2;

        //왼쪽위
        d(arr, n,r,length/2);
        //오른쪽위
        d(arr, n,r+half,length/2);
        //왼쪽아래
        d(arr, n+half,r,length/2);
        //오른쪽아래
        d(arr, n+half,r+half,length/2);
        
    }
    
    public boolean check(int num, int[][] arr, int n, int r, int length) {
        for(int i = n; i < n+length; i++ ) {
            for(int j = r; j< r+length; j++) {
                if(num != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}