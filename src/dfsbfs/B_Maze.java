package dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_Maze {
    public static int n,m;
    public static int[][] graph = new int[201][201];

    //이동할 방향 정의(상하좌우)
    public static int dx[]={-1,1,0,0};
    public static int dy[]={0,0,-1,1};

    public static int bfs(int x,int y){
        //큐 구현
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        //큐가 빌 때까지
        while (!q.isEmpty()){
            //큐에서 x,y뽑아
            Node node=q.poll();
            x= node.getX();
            y=node.getY();
            //뽑은 노드 기준 4방향 확인
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                //공간 벗어나면 무시
                if(nx<0||nx>=n||ny<0||ny>=m) continue;
                //벽(0)이면 무시
                if(graph[nx][ny]==0) continue;
                //처음 방문하고 갈 수 있는 길(1)이면 기록
                if(graph[nx][ny]==1){
                    graph[nx][ny]=graph[x][y]+1;
                    q.offer(new Node(nx,ny));//큐에 다음 노드를 넣는다
                }
            }
        }
        //출구까지 최단거리 반환
        return graph[n-1][m-1];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //N,M 공백 기준 입력
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 지우기

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        //결과 출력
        System.out.println(bfs(0,0));

    }

}

class Node{
    private int x;
    private int y;
    public Node(int x,int y){
        this.x=x;
        this.y=y;
    }
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}