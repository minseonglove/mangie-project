package com.mangieproject.CustomBoard;

import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;

@Service
public class SongListService {
    private static final String THUMBNAIL_PATH = "mangie-vue/src/assets/img/thumbnails/";

    public SongInfo[][] getSongList(){
        final SongInfo[][] songList;
        File songDir = new File(THUMBNAIL_PATH);
        // dlc폴더 배열
        String[] dlcList = songDir.list();
        assert dlcList != null;
        final int dir_len = dlcList.length;
        // dlc별로 곡 이름, dlc을 넣을 배열
        songList = new SongInfo[dir_len+1][];
        // 곡 갯수
        int songCount = 0;
        for(int i = 1; i <= dir_len; i++){
            songDir = new File(THUMBNAIL_PATH+dlcList[i-1]);
            // 폴더 안에 든 곡 리스트를 가져와서 저장
            String[] list = songDir.list();
            assert list != null;
            final int LEN = list.length;
            // .jpg 때기
            for(int k = 0; k < LEN; k++)
                list[k] = list[k].split("\\.")[0];
            songList[i] = new SongInfo[LEN];
            for(int k = 0; k < LEN; k++)
                songList[i][k] = new SongInfo(list[k],i);
            songCount += list.length;
        }
        // 전체 곡 이름을 넣을 0번 배열 크기 할당
        songList[0] = new SongInfo[songCount];
        songCount = 0;
        for(int i = 1; i <= dir_len; i++){
            // 야무지게 넣는다
            for(SongInfo s : songList[i]){
                songList[0][songCount] = s;
                songCount++;
            }
        }
        Arrays.sort(songList[0]);
        return songList;
    }
}
