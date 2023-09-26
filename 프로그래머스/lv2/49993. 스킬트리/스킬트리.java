class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        
        int[] arr = new int[27];
        for(int i = 0; i < skill.length(); i++) {
            char c = skill.charAt(i);
            arr[c-'A'] = i+1;
        }

        
        for(int i = 0; i <skill_trees.length; i++) {
            int max = 1;
            String str = skill_trees[i];
            
            for(int j = 0; j < str.length(); j++) {
                char cur = str.charAt(j);
                if(arr[cur-'A'] == max) {
                    max +=1;
                }
                if(arr[cur-'A'] > max) {
                    answer-=1;
                    break;
                }
            }
            
        }
        
        return answer;
    }
}