package boj_2884;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        
        
        if(b>= 45)
            System.out.print(a+" "+(b-45));
        else if(a==0)
            System.out.print(23+" "+(b+15));
        else
            System.out.print((a-1)+" "+(b+15));
        
    }
}