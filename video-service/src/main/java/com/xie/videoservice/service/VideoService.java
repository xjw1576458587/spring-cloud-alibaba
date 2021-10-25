package com.xie.videoservice.service;

import com.xie.videoservice.entity.Video;
import com.xie.videoservice.mapper.VideoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class VideoService {
    @Resource
    private VideoMapper videoMapper;

    public Video findByArticleId(Long articleId){
        return videoMapper.findByArticleId(articleId);
    }
}
