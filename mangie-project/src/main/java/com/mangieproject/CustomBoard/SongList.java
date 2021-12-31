package com.mangieproject.CustomBoard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Arrays;

@RestController
public class SongList {

    @GetMapping("/songlist")
    public SongInfo[][] getList(){
        File f = new File("mangie-vue/src/assets/img/thumbnails");
        // dlc폴더 배열
        String[] dlcList = f.list();
        int dirLen = dlcList.length;
        // dlc별로 곡 이름, dlc을 넣을 배열
        SongInfo[][] songList = new SongInfo[dirLen+1][];
        // 곡 갯수
        int songCount = 0;
        for(int i = 1; i <= dirLen; i++){
            f = new File("mangie-vue/src/assets/img/thumbnails/"+dlcList[i-1]);
            // 폴더 안에 든 곡 리스트를 가져와서 저장
            String[] list = f.list();
            int len = list.length;
            // .jpg 때기
            for(int k = 0; k < len; k++)
                list[k] = list[k].split("\\.")[0];
            songList[i] = new SongInfo[len];
            for(int k = 0; k < len; k++)
                songList[i][k] = new SongInfo(list[k],i);
            songCount += list.length;
        }
        // 전체 곡 이름을 넣을 0번 배열 크기 할당
        songList[0] = new SongInfo[songCount];
        songCount = 0;
        for(int i = 1; i <= dirLen; i++){
            // 야무지게 넣는다
            for(SongInfo s : songList[i]){
                songList[0][songCount] = s;
                songCount++;
            }
        }
        Arrays.sort(songList[0]);
        System.out.println("songList를 가져왔어여");
        return songList;
    }
}
