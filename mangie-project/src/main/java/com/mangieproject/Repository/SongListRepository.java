package com.mangieproject.Repository;

import com.mangieproject.vo.SongListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface SongListRepository {
    ArrayList<SongListVo> findByCategory(@Param("category") String category);
}