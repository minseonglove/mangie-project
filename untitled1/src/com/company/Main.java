package com.company;

import java.util.PriorityQueue;

public class Main {

    public static class car implements Comparable<car>{
        int start;
        int end;
        car(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(car o) {
            return this.end - o.end;
        }
    }

    public static void main(String[] args) {
        int[][] routes = {{-20,15}, {-14,5}, {-20,-13}, {-5,-3}};
        int ans = solution(routes);
    }

    public static int solution(int[][] routes) {
        int answer = 0;
        int here = -30001;
        PriorityQueue<car> pq = new PriorityQueue<>();

        for(int[] i : routes)
            pq.add(new car(i[0], i[1]));
        while(!pq.isEmpty()) {
            car c = pq.poll();
            if(c.start > here){
                here = c.end;
                answer++;
            }
        }
        return answer;
    }
}
