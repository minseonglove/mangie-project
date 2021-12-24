package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<Character, String> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            String str = sc.nextLine().replaceAll(" ", "");
            map.put(str.charAt(0), str.substring(1));
        }
        first('A');
        sb.append("\n");
        second('A');
        sb.append("\n");
        third('A');
        System.out.print(sb);
    }
    static void first(char c){
        String s = map.get(c);
        sb.append(c);
        if(s.charAt(0) != '.')
            first(s.charAt(0));
        if(s.charAt(1) != '.')
            first(s.charAt(1));
    }
    static void second(char c){
        String s = map.get(c);
        if(s.charAt(0) != '.')
            second(s.charAt(0));
        sb.append(c);
        if(s.charAt(1) != '.')
            second(s.charAt(1));
    }
    static void third(char c){
        String s = map.get(c);
        if(s.charAt(0) != '.')
            third(s.charAt(0));
        if(s.charAt(1) != '.')
            third(s.charAt(1));
        sb.append(c);
    }
}
