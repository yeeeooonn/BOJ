import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,K;
    static int[][] A;
    static int[][] nut; //현재 양분 배열
    static int[][] dieNut; //죽은 양분 배열(여름에 추가)
    static Deque<T>[][] tree; //위치 별 나무 기록(나이 순)

    static int dr[] = {-1,-1,-1,0,0,1,1,1};//8방향
    static int dc[] = {-1,0,1,-1,1,-1,0,1};
    static class T implements Comparable<T>{
        int age;

        public T(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(T o) {
            return Integer.compare(this.age, o.age);
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        nut = new int[N][N];
        tree = new Deque[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                nut[i][j] = 5;
                tree[i][j] = new LinkedList<>();
            }
        }

        //나무 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            tree[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1].offer(new T(Integer.parseInt(st.nextToken())));
        }

        for (int y = 0; y < K; y++) {
            //봄
            dieNut = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(tree[i][j].size() > 0) {
                        //나무가 있다면 양분먹고 자라기 or 죽기
                        int size = tree[i][j].size();
                        for (int k = 0; k < size; k++) {
                            T cur = tree[i][j].poll();
                            if(cur.age <= nut[i][j]) {
                                //양분 먹고 성장 가능
                                nut[i][j] -= cur.age;
                                tree[i][j].offer(new T(cur.age+1));

                            }else {
                                //양분이 될 나무들 값을 저장해둔다.
                                dieNut[i][j] += cur.age / 2;
                            }

                        }

                    }

                }
            }

            //여름
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    nut[i][j] += dieNut[i][j];
                }
            }

            
            //가을
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(tree[i][j].size() > 0) {
                        //나무가 있다면 5의 배수인지 확인 후 번식
                        int size = tree[i][j].size();
                        for (int k = 0; k < size; k++) {
                            T cur = tree[i][j].poll();
                            tree[i][j].offer(cur);
                            if(cur.age%5 ==0) {
                                //5의 배수이면 번식
                                for (int d = 0; d < 8; d++) {
                                    int cr = i+dr[d];
                                    int cc = j+dc[d];
                                    if(check(cr,cc)) {
                                        tree[cr][cc].offerFirst(new T(1));
                                    }

                                }

                            }
                        }

                    }
                }
            }

            //겨울
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    nut[i][j] += A[i][j];
                }
            }

        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count += tree[i][j].size();
            }
        }
        System.out.println(count);


    }
    static boolean check(int nr, int nc) {
        return nr>=0 && nr<N && nc>=0 && nc<N;
    }
}