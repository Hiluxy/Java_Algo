package 구현;

import java.util.Scanner;
//4 4
//1 1 0
//1 1 1 1
//1 0 0 1
//1 1 0 1
//1 1 1 1
public class D_Game {

    public static int n, m, x, y, direction;
    //방문 위치 저장하는 맵, 0으로 초기화
    public static int[][] d = new int[50][50];
    //전체 맵 정보
    public static int[][] arr = new int[50][50];

    //북동남서 정의
    public static int dx[] = {-1, 0, 1, 0};
    public static int dy[] = {0, 1, 0, -1};

    //왼쪽으로 도는 메서드 (방향:3,2,1,0)
    public static void turn_left() {
        direction -= 1;
        if (direction == -1) direction = 3;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        //n,m 공백 기준 입력받음 (4 4)
        n=sc.nextInt();
        m=sc.nextInt();

        //캐릭터의 x,y,방향 입력받음 (1 1 0)
        x=sc.nextInt();
        y=sc.nextInt();
        direction=sc.nextInt();
        d[x][y]=1; //현재좌표 방문처리

        //맵 정보 입력받음
        // 1 1 1 1
        ////1 0 0 1
        ////1 1 0 1
        ////1 1 1 1
        for (int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }


        //시뮬레이션
        int cnt=1;
        int turn_time=0;
        while (true){
            //캐릭터 회전하며 탐
            turn_left();
            int nx=x+dx[direction];
            int ny=y+dy[direction];
            //가보지 않은 칸&장애물 없음 -> 이동
            if(d[nx][ny]==0&&d[nx][ny]==0){
                d[nx][ny]=1;//방문처리
                //이동
                x=nx;
                y=ny;
                cnt+=1;
                turn_time=0;
                continue;
            }
            //가봤음 or장애물 ->한번 더 회전
            else turn_time+=1;
            //넷 다 못감 -> 뒤로 갈수있는지 탐색
            if(turn_time==4){
                nx=x-dx[direction];
                ny=y-dy[direction];
                //장애물 없음 ->이동
                if(arr[nx][ny]==0){
                    x=nx;
                    y=ny;
                }
                //장애물 있음 -> 끝
                else break;
                turn_time=0;
            }
        }
        System.out.println(cnt);

    }

}
