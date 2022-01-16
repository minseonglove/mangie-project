package com.mangieproject.CustomBoard;

import com.mangieproject.mapper.SongListMapper;
import com.mangieproject.vo.SongListVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Service
public class SongListService{

    public static final String[] SONG_CATEGORY = {"respect", "portable1", "portable2", "portable3", "trilogy",
                                                    "clazziquai", "blacksquare", "technika1", "technika2", "technika3",
                                                    "emotional", "vextension", "collaboration"};
    public final SongListMapper mapper;
    public SongListService(SongListMapper mapper) {
        this.mapper = mapper;
    }

    public ArrayList<ArrayList<SongListVo>> getSongList(){
        ArrayList<ArrayList<SongListVo>> songList = new ArrayList<>();
        for(int i = 0; i <= SONG_CATEGORY.length; i++)
            songList.add(new ArrayList<>());

        for (int i = 0; i < SONG_CATEGORY.length; i++) {
            ArrayList<SongListVo> list = selectCategory(SONG_CATEGORY[i]);
            songList.get(i+1).addAll(list);
            songList.get(0).addAll(list);
        }
        songList.get(0).sort(Comparator.comparing(SongListVo::getFile_name));
        return songList;
    }
    public ArrayList<SongListVo> selectCategory(String category){
        return mapper.selectCategory(category);
    }
}