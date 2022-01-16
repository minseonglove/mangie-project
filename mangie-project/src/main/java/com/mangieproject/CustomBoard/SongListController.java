package com.mangieproject.CustomBoard;

import com.mangieproject.vo.SongListVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SongListController {
    private final ArrayList<ArrayList<SongListVo>> songList;

    //곡 리스트 초기화
    SongListController(SongListService songListService){
        songList = songListService.getSongList();
        System.out.println("songList 초기화");
    }

    @GetMapping("/songlist")
    public ArrayList<ArrayList<SongListVo>> getList(){
        System.out.println("songList를 가져왔어여");
        return songList;
    }
}