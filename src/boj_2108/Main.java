package boj_2108;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int check[] = new int[8001]; //최빈값 구하기 위한 배열_ -4000~4000 까지 8001개
        
        double sum = 0;
        int mid = Math.round(N/2); //중앙값 자리
        
        for(int i =0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            check[arr[i]+4000]++; //arr1값+4000을 해서 arr2의 카운트를 늘림
        }

        Arrays.sort(arr); //배열 정렬
        
        bw.write(Math.round(sum/N)+"\n"); //산술평균
        bw.write(arr[mid]+"\n"); //중앙값
        bw.write(manny(arr, check)+"\n"); //최빈값
        bw.write(arr[N-1] - arr[0] +""); //범위
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    static int manny(int[] arr, int[]check) { //최빈값 구하는 함수
        int max = 0;
        List<Integer> list = new ArrayList<>(); //최빈값 구하기 위한 리스트
        
        for(int i = 0; i<8001; i++) { //최빈값 수가 몇인지 체크(max값)
           if(max < check[i]) {
               max = check[i];
           }
        }
        for(int i = 0; i<8001; i++) {
            if(check[i] == max)
                list.add(i-4000); //+4000 해줬던거 다시 빼주기
        }
        if(list.size()==1) { //최빈값이 하나 인경우
            return list.get(0); //0번째 인덱스 리턴
        } else { //최빈값이 두개 이상인경우
            Collections.sort(list); //정렬 후,
            return list.get(1); //1번째 인덱스 리턴(두번째로 작은 수)
        } 
        
    }
}