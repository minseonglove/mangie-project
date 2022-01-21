package com.mangieproject.CustomBoard;

import com.mangieproject.vo.SongListVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Slf4j
@RestController
public class SongListController {
    private final ArrayList<ArrayList<SongListVo>> songList;

    //곡 리스트 초기화
    SongListController(SongListService songListService){
        songList = songListService.getSongList();
        log.info("song-list 초기화");
    }

    @GetMapping("/song-list")
    public ArrayList<ArrayList<SongListVo>> getList(){
        log.info("song-list 가져왔어여");
        return songList;
    }
}