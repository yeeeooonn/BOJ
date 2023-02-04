package boj_1181;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        String arr[] = new String[N];
        
        for(int i = 0; i<N; i++) {
            arr[i] =br.readLine();
        }
        
        Arrays.sort(arr,(arr1,arr2) -> {
            if(arr1.length() == arr2.length()) //길이가 같으면 arr1과 arr2 알파벳순 비교
            	return arr1.compareTo(arr2);
            else //길이가 다르면 arr1과 arr2 길이로 비교
            	return Integer.compare(arr1.length(),arr2.length());
        });
        
        for(int i = 0; i<N-1; i++) { //이후 배열과 비교해서 같지 않으면 출력
        	if(!arr[i].equals(arr[i+1])) {
        		 bw.write(arr[i]+"\n");
        	}
        }
        bw.write(arr[N-1]+"\n"); //마지막배열 출력
        br.close();
        bw.flush();
        bw.close();
        
    }

}