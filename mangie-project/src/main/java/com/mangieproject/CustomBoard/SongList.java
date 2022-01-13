package com.mangieproject.CustomBoard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Arrays;

@RestController
public class SongList {
    private final SongInfo[][] SONG_LIST;
    //썸네일 경로
    private static final String THUMBNAIL_PATH = "mangie-vue/src/assets/img/thumbnails/";
    //곡 리스트 초기화
    SongList(){
        File f = new File(THUMBNAIL_PATH);
        // dlc폴더 배열
        String[] dlcList = f.list();
        assert dlcList != null;
        final int DIR_LEN = dlcList.length;
        // dlc별로 곡 이름, dlc을 넣을 배열
        SONG_LIST = new SongInfo[DIR_LEN+1][];
        // 곡 갯수
        int songCount = 0;
        for(int i = 1; i <= DIR_LEN; i++){
            f = new File(THUMBNAIL_PATH+dlcList[i-1]);
            // 폴더 안에 든 곡 리스트를 가져와서 저장
            String[] list = f.list();
            assert list != null;
            final int LEN = list.length;
            // .jpg 때기
            for(int k = 0; k < LEN; k++)
                list[k] = list[k].split("\\.")[0];
            SONG_LIST[i] = new SongInfo[LEN];
            for(int k = 0; k < LEN; k++)
                SONG_LIST[i][k] = new SongInfo(list[k],i);
            songCount += list.length;
        }
        // 전체 곡 이름을 넣을 0번 배열 크기 할당
        SONG_LIST[0] = new SongInfo[songCount];
        songCount = 0;
        for(int i = 1; i <= DIR_LEN; i++){
            // 야무지게 넣는다
            for(SongInfo s : SONG_LIST[i]){
                SONG_LIST[0][songCount] = s;
                songCount++;
            }
        }
        Arrays.sort(SONG_LIST[0]);
        System.out.println("songList 초기화");
    }

    //Mono에 감쌀 필요가 있을까
    @GetMapping("/songlist")
    public SongInfo[][] getList(){
        System.out.println("songList를 가져왔어여");
        return SONG_LIST;
    }
}