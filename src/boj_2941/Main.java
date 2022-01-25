package boj_2941;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine(); //���ڿ� �Է¹ޱ�
        String copy1 = str; //���ڿ��� copy1�� ����
        int count = 0; //count: �� ���ĺ� ����
        
        for(int i = 0; i <str.length()-2; i++) { //���ڿ��� ��ȸ�ϸ鼭 3���� ũ�ξ�Ƽ�ƾ��ĺ� ã��
            String A = str.substring(i,i+3);
            if(A.equals("dz=")) {
            	copy1 = copy1.replace(A, " "); //"dz="�� �ش��ϴ� ���ڿ��� ã���� �������� �ٲ��ֱ� -> ������ ������ ���Ŀ� �������� �ι��ڿ������ҋ� ������
                count ++;
            }
        }
        
        String copy2 = copy1; // 3���ڰ� ���ŵ� ���ڿ��� copy2�� ����
        for(int i = 0; i <copy1.length()-1; i++) { //���ڿ��� ��ȸ�ϸ鼭 2���� ũ�ξ�Ƽ�ƾ��ĺ� ã��
        	String A = copy1.substring(i,i+2);
        	
        	if(A.equals("c=") || A.equals("c-") || A.equals("d-") || A.equals("lj") || A.equals("nj") || A.equals("s=") || A.equals("z=")) {
                copy2 = copy2.replace(A, " ");
                count ++;
            }
        }
        
        for(int i = 0; i< copy2.replaceAll("\\s", "").length(); i++) { //�������ڿ� ������������, �������� ī��Ʈ�ø���
            count ++;
        }

        br.close();
        bw.write(count+"");
        bw.flush();
        bw.close();
        
    }
}
