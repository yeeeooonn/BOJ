import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int clone[] = new int[N]; //복제 배열
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        
        for(int i = 0; i<N; i++) {
            arr[i] = clone[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(clone);
        
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int count =0;
        
        for(int i = 0; i<clone.length; i++) {
            if(!hmap.containsKey(clone[i])) //중복없이
            	hmap.put(clone[i], count++); //정렬된 배열 순으로 값을 넣고 카운트 증가
        }
        for(int i =0; i<N; i++) {
        	bw.write(hmap.get(arr[i])+" "); //기존 배열값을 해시맵의 키값으로 사용해서 카운트 출력
        }
        
        br.close();
        
        bw.flush();
        bw.close();
    }
}