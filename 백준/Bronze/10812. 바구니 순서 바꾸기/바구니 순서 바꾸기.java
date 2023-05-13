import java.io.*;
  import java.util.StringTokenizer;

  public class Main {
      public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          StringTokenizer token = new StringTokenizer(br.readLine());

          int N = Integer.parseInt(token.nextToken()); //바구니 개수
          int M = Integer.parseInt(token.nextToken()); //회전 횟수

          int [] basket = new int[N]; //담을 바구니 배열

          int [] rotationBasket = new int[N]; //회전을 시킨 바구니 배열

          for(int i = 0; i < basket.length; i++){
              basket[i] = i+1; //바구니에 값 1~N 순서대로 담는다.
          }

          for(int r = 0; r < M; r++){ //회전 시킬 횟수만큼 반복
              token = new StringTokenizer(br.readLine());
              
              int i =  Integer.parseInt(token.nextToken())-1; //시작
              int j =  Integer.parseInt(token.nextToken())-1; //끝
              int k =  Integer.parseInt(token.nextToken())-1; //기준

              int i1 = i; 

             for(int b = 0; b < j-i+1; b++){ 
                  
                  if(k+b <= j){ 
                      rotationBasket[b+i] = basket[k+b];
                  }else{
                      rotationBasket[b+i] = basket[i1];
                      i1++; 
                  }
             }
             for(int b = 0; b < N; b++){
                 
                 if(rotationBasket[b] != 0){
                     basket[b] = rotationBasket[b];
                 }
             }

          }
          br.close();

          for(int i = 0; i < N; i++){ //rotationBasket.length = N
              bw.write(basket[i] + " ");
          }

          bw.flush();
          bw.close();

    }
}