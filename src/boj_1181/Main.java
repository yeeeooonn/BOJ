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
            if(arr1.length() == arr2.length()) //���̰� ������ arr1�� arr2 ���ĺ��� ��
            	return arr1.compareTo(arr2);
            else //���̰� �ٸ��� arr1�� arr2 ���̷� ��
            	return Integer.compare(arr1.length(),arr2.length());
        });
        
        for(int i = 0; i<N-1; i++) { //���� �迭�� ���ؼ� ���� ������ ���
        	if(!arr[i].equals(arr[i+1])) {
        		 bw.write(arr[i]+"\n");
        	}
        }
        bw.write(arr[N-1]+"\n"); //�������迭 ���
        br.close();
        bw.flush();
        bw.close();
        
    }

}