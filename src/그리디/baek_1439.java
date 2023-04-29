package 그리디;

import java.util.Scanner;

//문자열 뒤집기
public class baek_1439 {

    public static String str;
    public static int cnt0 = 0;
    public static int cnt1 = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();

        //첫 원소
        if (str.charAt(0) == '1') {
            cnt0 += 1;
        } else {
            cnt1 += 1;
        }

        //두 번째 원소부터
        for (int i = 0; i < str.length() - 1; i++) {
            //다음 수가 바뀌면
            if (str.charAt(i) != str.charAt(i + 1)) {
                if (str.charAt(i + 1) == '1') {
                    cnt0 += 1;
                } else {
                    cnt1 += 1;
                }
            }
        }

        System.out.println(Math.min(cnt0, cnt1));

    }

}
