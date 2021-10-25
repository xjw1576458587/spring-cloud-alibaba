package com.xie.articleservice.mapper;

import com.xie.articleservice.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper {
    @Select("select * from article where article_type <= #{value} order by create_time desc")
    public List<Article> list(int level);
}
