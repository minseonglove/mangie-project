package com.mangieproject.CustomBoard;

public class SongInfo implements Comparable<SongInfo>{
    public String name;
    public int category;

    SongInfo(String name, int category){
        this.name = name;
        this.category = category;
    }

    @Override
    public int compareTo(SongInfo o) {
        return this.name.compareTo(o.name);
    }
}
