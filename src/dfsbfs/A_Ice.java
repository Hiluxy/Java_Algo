package dfsbfs;

import java.util.Scanner;

public class A_Ice {
//    public static boolean[] visited = new boolean[9];
//    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
public static int n,m;
public static int[][] graph=new int[1000][1000];

    //DFS함수
    //한번 돌릴때마다 그위치와 연결된 0들->1로 바뀜, true
    public static boolean dfs(int x,int y){
        //범위 벗어나면 종료
        if(x<=-1||x>=n||y<=-1||y>=m){
            return false;//즉시 종료
        }
        //현재노드 방문하지 않았을때
        if(graph[x][y]==0) {
            //현재 노드 방문처리
            graph[x][y]=1;
            //상하좌우 재귀 호출
            dfs(x-1,y);
            dfs(x+1,y);
            dfs(x,y-1);
            dfs(x,y+1);
            return true;
        }
        //현재노드를 방문했다면 graph[x][y]==1
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //N,M공백 기준 입력
        n=sc.nextInt();
        m=sc.nextInt();
        sc.nextLine();//버퍼지우기

        //2차원 리스트 맵 정보 입력받음
        for(int i=0;i<n;i++){
            String str=sc.nextLine();
            for(int j=0;j<m;j++){
                graph[i][j]=str.charAt(j)-'0';
            }
        }

        //모든 노드 확인, 음료수 채우기
        int result=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dfs(i,j)){
                    result+=1;
                }
            }
        }
        System.out.println(result);

    }
}
