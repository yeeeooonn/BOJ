import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static Map<String,Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        
        for(int i = 0; i < orders.length; i++) {
            //orders배열 원소 하나당 subset돌림
            
            int size = orders[i].length();
            
            //sort해서 진행
            String sortOrder = getSort(orders[i]);
            
            String str = "";
            
            subset(sortOrder, str, size, 0);
            
            
        }

        //리스트 만들어서 map 정렬해서 넣음
        List<String> list = map.keySet().stream().sorted((c1, c2) -> Integer.compare(map.get(c2), map.get(c1))).collect(Collectors.toList());
        
        //결과값 반환할 리스트
        List<String> result = new ArrayList<>();
        
        
        for(int i = 0; i < course.length; i++) {
            int cou = course[i];
            int max = 0;
            
            for(String s : list) {
                if(cou == s.length() && map.get(s) > 1) {
                    
                    if(max > map.get(s)) {
                        break;
                    }
                    
                    max = map.get(s);
                    result.add(s);
                    
                }
            }
        }

        //정렬해서 반환
        return result.stream().sorted().toArray(String[]::new);
    }
    String getSort(String order) {
        char[] charArray = order.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
        
    }
    
    void subset(String order, String str, int size, int depth) {
        if(size == depth) {
            if(str.length() < 2) return;
            if(map.containsKey(str)) {
                int count = map.get(str);
                map.put(str, count+1);
            }else {
                map.put(str,1);
            }
            return;
        }
        
        subset(order,str,size,depth+1);
        subset(order,str+order.charAt(depth),size,depth+1);
        
    }
}