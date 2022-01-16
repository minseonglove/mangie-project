package com.mangieproject.mapper;

import com.mangieproject.vo.SongListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface SongListMapper {
    ArrayList<SongListVo> selectCategory(@Param("category") String category);
}
