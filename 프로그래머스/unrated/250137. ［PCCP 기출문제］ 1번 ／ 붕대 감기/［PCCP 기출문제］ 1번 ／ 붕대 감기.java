class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int nextAttackTime = 0;
        int curTime = 1;
        int keepNum = 0;
        int maxHealth = health;
        
        while(true) {
            if(curTime == attacks[nextAttackTime][0]) {
                //공격시간 일 경우
                keepNum = 0;
                health -= attacks[nextAttackTime][1];
                nextAttackTime++;

                
                if(health <= 0){
                    //체력이 0 이하
                    break;
                }
                if(nextAttackTime == attacks.length) {
                    break;
                }
                
            }else {
                keepNum++;
                health += bandage[1]; //초당 회복량
                if(keepNum == bandage[0]) {
                    keepNum = 0;
                    health += bandage[2];
                }
                if(health > maxHealth) {
                    //체력 넘어가지 않도록
                    health = maxHealth;
                }
            }
            
            curTime++;
        }
        
        if(health <= 0){
            return -1;
        }
        return health;
    }
}