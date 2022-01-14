package com.mangieproject.CustomBoard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongListController {
    private final SongInfo[][] songList;

    //곡 리스트 초기화
    SongListController(SongListService songListService){
        songList = songListService.getSongList();
        System.out.println("songList 초기화");
    }

    //Mono에 감쌀 필요가 있을까
    @GetMapping("/songlist")
    public SongInfo[][] getList(){
        System.out.println("songList를 가져왔어여");
        return songList;
    }
}