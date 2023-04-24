package dfsbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_18352 {

    public static int n,m,k,x;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    //모든 도시에 대한 최단 거리
    public static int[] d=new int[300001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();
        // 그래피 및 최단 거리 테이블 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
            d[i] = -1;
        }

        //모든 도로 정보 입력
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        //출발 도시 까지 거리는 0
        d[x]=0;

        //bfs수행
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(x);
        while(!q.isEmpty()){
            int now =q.poll();
            //현재 now노드에서 이동할 수 있는 모든 도시 확인
            for(int i=0; i<graph.get(now).size();i++){
                int nextNode=graph.get(now).get(i);
                //방문하지 않은 노드
                if(d[nextNode]==-1){
                    //최단거리 갱신
                    d[nextNode]=d[now]+1;
                    q.offer(nextNode);
                }
            }
        }
        //최단거리 k인 모든 노드 번호를 오름차순으로 출력
        boolean check = false;
        for (int i=1;i<=n;i++){
            if(d[i]==k){
                System.out.println(i);
                check=true; //k거리노드가 존재
            }
        }

        //k거리 노드가 없음, -1출력
        if(!check)
            System.out.println(-1);

    }
}
