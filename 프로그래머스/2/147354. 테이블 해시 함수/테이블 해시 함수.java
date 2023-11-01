import java.util.*;

class Solution {
    static int N;
    
    class Data implements Comparable<Data> {
        int[] cols;
        
        public Data(int[] cols) {
            this.cols = cols;
        }
        
        @Override
        public int compareTo(Data d) {
            if(d.cols[N-1] == this.cols[N-1]) {
                return Integer.compare(d.cols[0], this.cols[0]);
            }
            return Integer.compare(this.cols[N-1], d.cols[N-1]);
        }
    }
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        N = col;
            
        ArrayList<Data> database = new ArrayList<>();
        
        for(int i = 0; i < data.length; i++) {
            database.add(new Data(data[i]));
        }
        
        Collections.sort(database);
        
        int[] si = new int[row_end-row_begin+1];
        
        for(int i = row_begin-1; i < row_end; i++) {
            int[] cur = database.get(i).cols;
            int sum = 0;
            
            for(int j = 0; j < cur.length; j++) {
                sum += (cur[j] % (i+1));
            }
            
            si[i-row_begin+1] = sum;
        }
        
        answer = si[0];
        
        for(int i = 1; i < si.length; i++) {
            answer = answer^si[i];
        }
        
        return answer;
    }
}