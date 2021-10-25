package com.xie.articleservice.service;

import com.xie.articleservice.entity.Article;
import com.xie.articleservice.entity.Video;
import com.xie.articleservice.feignclient.VideoFeignClient;
import com.xie.articleservice.mapper.ArticleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private VideoFeignClient videoFeignClient;

    /**
     * 如果是VIP会员,可以查看所有普通文章与精选文章
     * 如果是普通会员,只能查看所有普通文章
     * @return
     */
    public List<Article> list(){

        List<Article> list = articleMapper.list(1);
        for(Article article : list){
            article.setVideo(videoFeignClient.findByArticleId(article.getArticleId()).getData());
        }
        return list;
    }
}
