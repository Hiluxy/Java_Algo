package 구현;

import java.util.Scanner;

public class C_Chess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //나이트 위치
        String inputData = sc.nextLine();
        int x = inputData.charAt(1) - '0';
        int y = inputData.charAt(0) - 'a' + 1;

        //나이트 이동 방향 정의
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        //8가지 방향에서 이동 가능한지
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            //이동위치
            int next_x = x + dx[i];
            int next_y = y + dy[i];
            //이동가능하면 카운트 증가
            if (next_x >= 1 && next_x <= 8 && next_y >= 1 && next_y <= 8)
                cnt += 1;

        }
        System.out.println(cnt);


    }
}
