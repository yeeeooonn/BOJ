package boj_2588;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int a = Integer.parseInt(br.readLine());
        String b = br.readLine();
        
        char[] B = b.toCharArray();
       
        
        System.out.println(a*((B[2])-'0'));
        System.out.println(a*((B[1])-'0'));
        System.out.println(a*((B[0])-'0'));
        System.out.println(a*Integer.parseInt(b));
    }
}