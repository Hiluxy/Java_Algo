package 구현;

import java.util.Scanner;

//럭키 스트레이트
public class beak_18406 {
    public static String str;
    public static int right;
    public static int left;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        //왼쪽
        for(int i=0; i<str.length()/2;i++){
            left+=str.charAt(i)-'0';
        }
        //오른쪽
        for(int i=str.length()/2;i<str.length();i++){
            right+=str.charAt(i)-'0';
        }

        //확인
        if(left==right){
            System.out.println("LUCKY");
        }else{
            System.out.println("READY");
        }

    }


}
