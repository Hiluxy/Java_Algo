package 구현;

import java.util.Scanner;

public class B_Time {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //n 입력받기
        int n = sc.nextInt();
        sc.nextLine();
        int cnt=0;

        //시간 loop
        for(int i=0;i<=n;i++){
            for(int j=0;j<60;j++){
                for(int k=0;k<60;k++){
                    String time=String.valueOf(i)+j+k;

                    //time안에 3이 포함되면 카운트
                    if(time.indexOf("3")>-1){
                        cnt ++;
                    }
                }
            }
        }

        System.out.println(cnt);


    }

}
