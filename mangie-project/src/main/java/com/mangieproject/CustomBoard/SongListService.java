package com.mangieproject.CustomBoard;

import com.mangieproject.Repository.SongListRepository;
import com.mangieproject.vo.SongListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;

@Service
public class SongListService{

    private static final String[] SONG_CATEGORY = {"respect", "portable1", "portable2", "portable3", "trilogy",
                                                    "clazziquai", "blacksquare", "technika1", "technika2", "technika3",
                                                    "emotional", "vextension", "vextension2", "collaboration"};
    private final SongListRepository repository;

    @Autowired
    public SongListService(SongListRepository repository) {
        this.repository = repository;
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
    private ArrayList<SongListVo> selectCategory(String category){
        return repository.findByCategory(category);
    }
}