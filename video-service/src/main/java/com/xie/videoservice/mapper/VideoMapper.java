package com.xie.videoservice.mapper;

import com.xie.videoservice.entity.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VideoMapper {
    @Select("select * from video where article_id = #{value}")
    public Video findByArticleId(Long articleId);
}
