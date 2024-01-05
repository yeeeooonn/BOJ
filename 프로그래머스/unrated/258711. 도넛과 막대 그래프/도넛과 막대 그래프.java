class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        //정점 개수 찾기
        int edgeNum = 0;
        for(int i = 0; i < edges.length; i++) {
            if(edges[i][0] > edgeNum) {
                edgeNum = edges[i][0];
            }
            if(edges[i][1] > edgeNum) {
                edgeNum = edges[i][1];
            }
        }
        
        System.out.println(edgeNum);
            
        //받은 정점 정보, 준 정점 정보 저장
        int[][] info = new int[edgeNum+1][2];
        for(int i = 0; i < edges.length; i++) {
            info[edges[i][0]][1]++; //준 정점
            info[edges[i][1]][0]++; //받은 정점
        }
        
        
        //특징을 찾는다.
        //줄수있는게 없는 정점을 만나면 -> 막대
        //2개이상 받으면 -> 8자
        //나머지 -> 도넛

        for(int i = 1; i <= edgeNum; i++) {
            if(info[i][0] == 0 && info[i][1] >=2) {
                answer[0] = i;
            }else if(info[i][1] == 0) {
                answer[2]++; //막대 증가
            }else if(info[i][0] >= 2 && info[i][1] >= 2) {
                answer[3]++; //8자 증가
            }
        }
        
        answer[1] = info[answer[0]][1] - answer[2] - answer[3];
        
        return answer;
    }
}