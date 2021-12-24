package com.company;

import java.util.PriorityQueue;

public class Main {

    public static final int[][] pos = { {0,-1}, {1,0}, {0,1}, {-1,0} };

    public static void main(String[] args) {
        String[] grid = {"R","R"};
        int[] result = solution(grid);
        for(int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }

    public static int[] solution(String[] grid) {
        int[] answer = {};
        int x, y, dir; // 0 왼 1 아래 2 오른 4 위 1더하기 3더하기
        int c_x=0, c_y=0, c_dir=0;
        int count = 0;
        boolean[][][] visit = new boolean[grid.length][grid[0].length()][4];
        char[][] arr = new char[grid.length][grid[0].length()];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < grid.length; i++)
            arr[i] = grid[i].toCharArray();

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                for(int k = 0; k < 4; k++){
                    if(!visit[i][j][k]){
                        count = 0;
                        x = j;
                        y = i;
                        dir = k;
                        c_x = j;
                        c_y = i;
                        c_dir = k;
                        do {
                            visit[c_y][c_x][c_dir] = true;
                            count++;
                            c_x = c_x + pos[c_dir][1];
                            c_y = c_y + pos[c_dir][0];

                            if(c_x == -1)
                                c_x = arr[0].length-1;
                            else if(c_x == arr[0].length)
                                c_x = 0;
                            if(c_y == -1)
                                c_y = arr.length-1;
                            else if(c_y == arr.length)
                                c_y = 0;

                            if(arr[c_y][c_x] == 'R')
                                c_dir = (c_dir + 3) % 4;
                            else if(arr[c_y][c_x] == 'L')
                                c_dir = (c_dir+1)%4;
                        } while(x != c_x || y != c_y || dir != c_dir);
                        System.out.println();
                        pq.offer(count);
                    }
                }
            }
        }
        answer = new int[pq.size()];
        for(int i = 0; i < answer.length; i++)
            answer[i] = pq.poll();
        return answer;
    }

}