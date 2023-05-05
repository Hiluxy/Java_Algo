package 구현;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//봄버맨
public class Bomb {
    int x, y, time;
    static ArrayList<Bomb> bombs = new ArrayList<>();

    public Bomb(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }

    public static void installBomb(char[][] graph) {
        //비어있는 곳에 폭탄 설치
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == '.') {
                    bombs.add(new Bomb(i, j, 3));
                }
            }
        }
    }

    //폭탄이 상하좌우 터지는 함수
    public static void explodeBomb(Bomb bomb,char[][] graph) {
        // 현재 위치+상하좌우를 .으로 만든다.
        graph[bomb.x][bomb.y] = '.';

        // 상
        if (bomb.x - 1 >= 0) {
            graph[bomb.x - 1][bomb.y] = '.';
        }
        // 하
        if (bomb.x + 1 < graph.length) {
            graph[bomb.x + 1][bomb.y] = '.';
        }
        // 좌
        if (bomb.y - 1 >= 0) {
            graph[bomb.x][bomb.y - 1] = '.';
        }
        // 우
        if (bomb.y + 1 < graph[0].length) {
            graph[bomb.x][bomb.y + 1] = '.';
        }
        bombs.remove(bomb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int M = sc.nextInt();
        final int time = sc.nextInt();
        sc.nextLine();//줄바꿈 처리
        //2차원 그래프(채워져있음0, 비면1)
        char[][] graph = new char[N][M];

        // 2차원 리스트의 초기 폭탄위치 저장
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'O') {
                    bombs.add(new Bomb(i, j, 3));
                }
            }
        }

        //시간이 지남에 따라
        for (int i = 1; i <= time; i++) {
            //폭탄 시간 -1
            Iterator<Bomb> bombIterator = bombs.iterator();
            while (bombIterator.hasNext()) {
                Bomb bomb = bombIterator.next();
                bomb.time--;
                if (bomb.time == 0) {
                    //폭탄 터짐
                    explodeBomb(bomb, graph);
                }
            }
            //2초마다 폭탄 설치
            if (i % 2 == 0) {
                //폭탄설치
                installBomb(graph);
            }
        }
        //출력
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                System.out.print(graph[i][j]);
            }
        }
    }
}


