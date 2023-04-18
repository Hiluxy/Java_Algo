package 구현;

import java.util.Scanner;

public class A_FourSide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //n 입력받기
        int n = sc.nextInt();
        sc.nextLine();
        String[] plans = sc.nextLine().split(" ");
        int x=1; int y=1;

        //L,R,U,D에 따른 이동 방량
        int[] dx={0,0,-1,1};
        int[] dy={-1,1,0,0};
        char[] moveTypes={'L','R','U','D'};

        //입력받은 값 확인
        for(int i =0; i<plans.length;i++){
            char plan = plans[i].charAt(0);
            //이동 후 좌표 구하기
            int nx=-1,ny=-1;
            for(int j=0;j<4;j++){
                if(plan==moveTypes[j]){
                    nx=x+dx[j];
                    ny=y+dy[j];
                }
            }
            //공간 벗어나면 무시
            if(nx<1||ny<1||nx>n||ny>n) continue;
            //이동 반영
            x=nx;
            y=ny;
        }
        System.out.println(x+" "+y);

    }

}
