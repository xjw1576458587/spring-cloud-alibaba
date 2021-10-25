package com.xie.articleservice.mapper;

import com.xie.articleservice.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ArticleMapperTest {
    @Resource
    private ArticleMapper articleMapper;
    @Test
    public void testList(){
        List<Article> list = articleMapper.list(1);
        for(Article article:list){
            System.out.println(article.getTitle());
        }
    }
}