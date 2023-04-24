package dfsbfs;

import java.lang.annotation.Target;
import java.util.*;

class Virus implements Comparable<Virus> {
    private int num;
    private int time;
    private int x;
    private int y;

    public Virus(int num, int time, int x, int y) {
        this.num = num;
        this.time = time;
        this.x = x;
        this.y = y;
    }

    public int getNum() {
        return this.num;
    }

    public int getTime() {
        return this.time;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    //정렬 기준: 번호 낮은 순서
    @Override
    public int compareTo(Virus otherVirus) {
        if (this.num < otherVirus.num) {
            return -1;
        }
        return 1;
    }
}


public class baek_18405 {

    public static int n, k, s, x, y;
    public static int[][] graph = new int[200][200];
    public static ArrayList<Virus> viruses = new ArrayList<Virus>();

    //바이러스 퍼져나가는 4방향
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //N,M공백 기준 입력
        n = sc.nextInt();
        k = sc.nextInt();

        //2차원 리스트 맵 정보 입력받음
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
                //바이러스 존재시 viruses에 삽입
                if (graph[i][j] != 0) {
                    viruses.add(new Virus(graph[i][j], 0, i, j));
                }
            }
        }
        //바이러스들 넘버기준 정렬
        Collections.sort(viruses);
        //바이러스들을 q에 넣는다
        Queue<Virus> q = new LinkedList<Virus>();
        for (int i = 0; i < viruses.size(); i++) {
            q.offer(viruses.get(i));
        }
        int endT = sc.nextInt();
        int targetX = sc.nextInt();
        int targetY = sc.nextInt();

        //BFS진행
        while (!q.isEmpty()) {
            Virus virus = q.poll();
            //끝나는 시간 까지만 반복
            if (virus.getTime() == endT) break;
            //현재 위치에서 상하좌우 확인
            for (int i = 0; i < 4; i++) {
                int nx = virus.getX() + dx[i];
                int ny = virus.getY() + dy[i];
                //해당위치 이동 가능한경우
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    //방문 안한 경우
                    if (graph[nx][ny] == 0) {
                        //바이러스 graph새기고, 큐에 넣기
                        graph[ny][nx] = virus.getNum();
                        q.offer(new Virus(virus.getNum(), virus.getTime() + 1, nx, ny));
                    }
                }
            }
        }

        System.out.println(graph[targetX - 1][targetY - 1]);
    }


}
