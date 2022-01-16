package com.mangieproject.vo;

import lombok.Data;

@Data
public class SongListVo {
    public String file_name;
    public String song_name;
    public String bpm;
    public String artist;
    public String category;
}