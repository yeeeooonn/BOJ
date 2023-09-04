import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>(); //출력 리스트
        Map<String,Integer> map = new HashMap<>();
        
        //A~Z 맵에 넣기
        for(int i = 'A'; i <= 'Z'; i ++) {
            map.put(String.valueOf((char)i), i-64);
        }
        int number = 27; //Z다음값
        
        for(int i = 0; i < msg.length(); i++) {
            //없는 문자열까지 찾기
            System.out.println("i====>"+i);
            String str = String.valueOf(msg.charAt(i));
            
            for(int j = i+1; j < msg.length(); j++) {
                str+= msg.charAt(j);
                if(map.get(str) == null) {
                    map.put(str, number++);
                    break;
                }
                i++;
            }
            String str1 = str.substring(0,str.length()-1);
            System.out.println(str1);
            if(i != msg.length()-1 && !str1.equals("")) {
                System.out.println("여기 ---> "+str1);
                list.add(map.get(str1));
            }
            
            if(i == msg.length()-1 && !str.equals("")) {
                list.add(map.get(str));
            }
            
            
            // if(i == msg.length()-1 && !str.equals("")) {
            //     //마지막 글자가 한글자
            //     list.add(map.get(str));
            // }
            
            System.out.println(str1.length()-1);
            // i+= (str1.length()-1);
            
        }

        
        int[] answer = new int[list.size()];
        for(int i = 0; i<list.size(); i ++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}