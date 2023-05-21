import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();
		int b=sc.nextInt();
		char a[]=new char[36];
		
		for(int i=0;i<10;i++) {
			a[i]=(char) (i+'0');
		}
		for(int i=10;i<36;i++) {
			a[i]=(char) (i+'A'-10);
		}
		long result=0;
		String re="";
		while(n>0) {
			result=n%b;
			n=n/b;
			re=a[(int)result]+re;
		}
		System.out.print(re);
	}

}